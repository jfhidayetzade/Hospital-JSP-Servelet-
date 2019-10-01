package web;

import az.java.hospital.dao.*;
import az.java.hospital.dao.imple.*;
import az.java.hospital.model.*;
import az.java.hospital.service.*;
import az.java.hospital.service.imple.*;

import javax.print.Doc;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "hospital", urlPatterns = "/cs")
public class ControlServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            processRequest(request,response);
    }

    protected void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       PrintWriter writer=response.getWriter();
       String action = null;
        String address=null;
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        PatientDao patientDao=new PatientDaoImple();
        PatientService patientService=new PatientServiceImple(patientDao);

        DoctorDao doctorDao=new DoctorDaoImple();
        DoctorService doctorService=new DoctorServiceImple(doctorDao);

        SorenessDao sorenessDao=new SorenessDaoImple();
        SorenessService sorenessService=new SorenessServiceImple(sorenessDao);

        TreatmentDao treatmentDao=new TreatmentDaoImple();
        TreatmentService treatmentService=new TreatmentServiceImple(treatmentDao);

        PaymentDao paymentDao = new PaymentDaoImple();
        PaymentService paymentService = new PaymentServiceImple(paymentDao);
        if(request.getParameter("action")!=null){
            action=request.getParameter("action");
        }

        try{
            if(action.equalsIgnoreCase("getPatientList")){
                List<Patient> patients=patientService.patientList();
                request.setAttribute("patientList",patients);
                address="WEB-INF/pages/patientList.jsp";

            }else if(action.equalsIgnoreCase("addPatient")){
                String name=request.getParameter("name");
                String surname=request.getParameter("surname");
                String gender=request.getParameter("gender");
                String dob=request.getParameter("dob");
                String email=request.getParameter("email");
                String adress=request.getParameter("address");
                Patient patient=new Patient();
                patient.setName(name);
                patient.setSurname(surname);
                patient.setGender(gender);
                patient.setDob(df.parse(dob));
                patient.setEmailAdress(email);
                patient.setAddress(adress);
                boolean isAdded=patientService.addPatient(patient);
                response.setContentType("text/html");
                if(isAdded){
                    writer.write("successfully");
                }else{
                    writer.write("failed");
                }

            }else if(action.equalsIgnoreCase("editPatient")){
                Long patientId=Long.parseLong(request.getParameter("patientId"));
                Patient patient = patientService.getPatientById(patientId);
                request.setAttribute("patient",patient);
                address="WEB-INF/edit/editPatient.jsp";
            }else if(action.equalsIgnoreCase("updatePatient")){
                String name=request.getParameter("name");
                String surname=request.getParameter("surname");
                String gender=request.getParameter("gender");
                String dob=request.getParameter("dob");
                String email=request.getParameter("email");
                String adress=request.getParameter("address");
                Long patientId=Long.parseLong(request.getParameter("patientId"));
                Patient patient=new Patient();
                patient.setName(name);
                patient.setSurname(surname);
                patient.setGender(gender);
                patient.setDob(df.parse(dob));
                patient.setEmailAdress(email);
                patient.setAddress(adress);
                boolean isUpdate = patientService.updatePatient(patient,patientId);
                if(isUpdate){
                    writer.write("success");
                }else {
                    writer.write("failed");
                }
            }else if(action.equalsIgnoreCase("searchPatient")){
                String keyword=request.getParameter("keyword");
                List<Patient> patients = patientService.searchPatient(keyword);
                request.setAttribute("patientList",patients);
                address="WEB-INF/pages/patientList.jsp";
            }else if(action.equalsIgnoreCase("getDoctorList")){
                List<Doctor> doctors=doctorService.doctors();
                request.setAttribute("doctorList",doctors);
                address="WEB-INF/pages/doctorList.jsp";
            }else if (action.equalsIgnoreCase("getSorenessList")){
                List<Soreness> sorenessList=sorenessService.sorenessList();
                request.setAttribute("sorenessList",sorenessList);
                address="WEB-INF/pages/sorenessList.jsp";
            }else if(action.equalsIgnoreCase("getTreatmentList")){
                List<Treatment> treatments=treatmentService.getTreatmentList();
                List<Soreness> sorenessList=sorenessService.sorenessList();
                List<Doctor> doctorList=doctorService.doctors();
                request.setAttribute("treatmentList", treatments);
                request.setAttribute("sorenessList",sorenessList);
                request.setAttribute("doctorList",doctorList);
                address="WEB-INF/pages/treatmentList.jsp";
            }else if (action.equalsIgnoreCase("newTreatment")){
                List<Patient> patients=patientService.patientList();
                List<Doctor> doctors=doctorService.doctors();
                List<Soreness> sorenessList=sorenessService.sorenessList();
                request.setAttribute("patientList", patients);
                request.setAttribute("doctorList",doctors);
                request.setAttribute("sorenessList",sorenessList);
                address="WEB-INF/pages/newTreatment.jsp";
            }else if(action.equalsIgnoreCase("addTreatment")){
                Long patientId=Long.parseLong(request.getParameter("patientCombo"));
                Long doctorId=Long.parseLong(request.getParameter("doctorCombo"));
                Long sorenessId=Long.parseLong(request.getParameter("sorenessCombo"));
                Treatment treatment=new Treatment();
                Patient patient=new Patient();
                patient.setId(patientId);
                Doctor doctor=new Doctor();
                doctor.setId(doctorId);
                Soreness soreness=new Soreness();
                soreness.setId(sorenessId);
                treatment.setPatient(patient);
                treatment.setDoctor(doctor);
                treatment.setSoreness(soreness);
                boolean isAdded=treatmentService.addTreatment(treatment);
                if(isAdded){
                    writer.write("succesfully");
                }else{
                    writer.write("failed");
                }
            }else if(action.equalsIgnoreCase("deleteTreatment")){
                Long treatmentId=Long.parseLong(request.getParameter("treatmentId"));
                boolean deleteTreatment = treatmentService.deleteTreatment(treatmentId);
                response.setContentType("text/html");
                if(deleteTreatment){
                    writer.write("success");
                }else {
                    writer.write("failed");
                }
            }else if(action.equalsIgnoreCase("searchTreatment")){
                String keyword=request.getParameter("keyword");
                List<Treatment> treatments = treatmentService.seacrhTreatmentData(keyword);
                request.setAttribute("treatmentList",treatments);
                address="WEB-INF/pages/treatmentList.jsp";
            }else if(action.equalsIgnoreCase("addDoctor")){
                String name=request.getParameter("name");
                String surname=request.getParameter("surname");
                String task=request.getParameter("task");
                String department=request.getParameter("department");
                Doctor doctor=new Doctor();
                doctor.setName(name);
                doctor.setSurname(surname);
                doctor.setTask(task);
                doctor.setDepartament(department);
                boolean isAdded=doctorService.addDoctor(doctor);
                response.setContentType("text/html");
                if(isAdded){
                    writer.write("successfully");
                }else{
                    writer.write("failed");
                }

            }else if(action.equalsIgnoreCase("editDoctor")){
                Long doctorId=Long.parseLong(request.getParameter("doctorId"));
                Doctor doctor = doctorService.getDoctorById(doctorId);
                request.setAttribute("doctor",doctor);
                address="WEB-INF/edit/editDoctor.jsp";
            }else if(action.equalsIgnoreCase("updateDoctor")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String task = request.getParameter("task");
                String department = request.getParameter("departament");
                Long doctorId = Long.parseLong(request.getParameter("doctorId"));
                Doctor doctor = new Doctor();
                doctor.setName(name);
                doctor.setSurname(surname);
                doctor.setTask(task);
                doctor.setDepartament(department);
                boolean isUpdate = doctorService.updateDoctor(doctor, doctorId);
                response.setContentType("text/html");
                if (isUpdate) {
                    writer.write("successfully");
                } else {
                    writer.write("failed");
                }
            }else if (action.equalsIgnoreCase("deleteDoctor")){
                Long doctorId=Long.parseLong(request.getParameter("doctorId"));
                boolean isDelete = doctorService.deleteDoctor(doctorId);
                response.setContentType("text/html");
                if (isDelete){
                    writer.write("success");
                }else {
                    writer.write("failed");
                }

            }else if(action.equalsIgnoreCase("searchDoctor")){
                String keyword=request.getParameter("keyword");
                List<Doctor> doctors = doctorService.searchDoctor(keyword);
                request.setAttribute("doctorList",doctors);
                address="WEB-INF/pages/doctorList.jsp";
            }else if (action.equalsIgnoreCase("deletePatient")){
                Long patientId=Long.parseLong(request.getParameter("patientId"));
                boolean isDelete = patientService.deletePatient(patientId);
                response.setContentType("text/html");
                if (isDelete){
                    writer.write("success");
                }else {
                    writer.write("failed");
                }

            }else if(action.equalsIgnoreCase("addSoreness")){
                String diagonis=request.getParameter("diagonis");
                String medicines=request.getParameter("medicines");
                Soreness soreness=new Soreness();
                soreness.setDiagonis(diagonis);
                soreness.setMedicines(medicines);
                boolean isAdded=sorenessService.addSoreness(soreness);
                response.setContentType("text/html");
                if(isAdded){
                    writer.write("successfully");
                }else{
                    writer.write("failed");
                }

            }else if(action.equalsIgnoreCase("editSoreness")){
                Long sorenessId=Long.parseLong(request.getParameter("sorenessId"));
                Soreness soreness = sorenessService.getSorenessById(sorenessId);
                request.setAttribute("soreness",soreness);
                address="WEB-INF/edit/editSoreness.jsp";
            }else if(action.equalsIgnoreCase("updateSoreness")) {
                String diagonis = request.getParameter("diagonis");
                String medicines = request.getParameter("medicines");
                Long sorenessId = Long.parseLong(request.getParameter("sorenessId"));
                Soreness soreness = new Soreness();
                soreness.setDiagonis(diagonis);
                soreness.setMedicines(medicines);
                boolean isUpdate = sorenessService.updateSoreness(soreness, sorenessId);
                response.setContentType("text/html");
                if (isUpdate) {
                    writer.write("successfully");
                } else {
                    writer.write("failed");
                }
            }else if (action.equalsIgnoreCase("deleteSoreness")){
                Long sorenessId=Long.parseLong(request.getParameter("sorenessId"));
                boolean isDelete = sorenessService.deleteSoreness(sorenessId);
                response.setContentType("text/html");
                if (isDelete){
                    writer.write("success");
                }else {
                    writer.write("failed");
                }

            }else if(action.equalsIgnoreCase("searchSoreness")){
                String keyword=request.getParameter("keyword");
                List<Soreness> sorenesses = sorenessService.searchSoreness(keyword);
                request.setAttribute("sorenessList",sorenesses);
                address="WEB-INF/pages/sorenessList.jsp";
            }else if(action.equalsIgnoreCase("editTreatment")){
                Long treatmentId=Long.parseLong(request.getParameter("treatmentId"));
                List<Patient> patients=patientService.patientList();
                List<Doctor> doctors=doctorService.doctors();
                List<Soreness> sorenessList=sorenessService.sorenessList();
                request.setAttribute("a",patients);
                request.setAttribute("doctorList", doctors);
                request.setAttribute("sorenessList", sorenessList);
                Treatment treatment=treatmentService.getTreatmentById(treatmentId);
                request.setAttribute("treatment",treatment);
                address="WEB-INF/edit/editTreatment.jsp";
            }else if(action.equalsIgnoreCase("updateTreatment")){
                Long patientId=Long.parseLong(request.getParameter("patientCombo"));
                Long doctorId=Long.parseLong(request.getParameter("doctorCombo"));
                Long sorenessId=Long.parseLong(request.getParameter("sorenessCombo"));
                Long treatmentId=Long.parseLong(request.getParameter("treatmentId"));
                Treatment treatment=new Treatment();
                Patient patient=new Patient();
                patient.setId(patientId);
                treatment.setPatient(patient);
                Doctor doctor=new Doctor();
                doctor.setId(doctorId);
                treatment.setDoctor(doctor);
                Soreness soreness=new Soreness();
                soreness.setId(sorenessId);
                treatment.setSoreness(soreness);
                boolean isUpdate=treatmentService.updateTreatment(treatment,treatmentId);
                response.setContentType("text/html");
                if(isUpdate){
                    writer.write("successfully");
                }else {
                    writer.write("failed");
                }
            }else if(action.equalsIgnoreCase("getDoctorComboSorenessById")){
                Long sorenessId = Long.parseLong(request.getParameter("sorenessId"));
                List<Doctor> doctorList = doctorService.getDoctorComboSorenessById(sorenessId);
                request.setAttribute("doctorList",doctorList);
                address="WEB-INF/pages/doctorCombo.jsp";
            }else if (action.equalsIgnoreCase("advanceSearchTreatment")){
                Long sorenessId=Long.parseLong(request.getParameter("sorenessId"));
                Long doctorId=Long.parseLong(request.getParameter("doctorId"));
                String beginDate=request.getParameter("beginDate");
                String endDate=request.getParameter("endDate");
                AdvanceSearch advanceSearch = new AdvanceSearch();
                advanceSearch.setSorenessId(sorenessId);
                advanceSearch.setDoctorId(doctorId);
                advanceSearch.setBeginDate(beginDate);
                advanceSearch.setEndDate(endDate);
                List<Treatment> treatmentList = treatmentService.advanceSearchTreatment(advanceSearch);
                request.setAttribute("treatmentList",treatmentList);
                address="WEB-INF/pages/treatmentData.jsp";
            }else if(action.equalsIgnoreCase("getPaymentList")){
                List<Payment> payments= paymentService.getPaymentList();
                request.setAttribute("paymentList", payments);
                address="WEB-INF/pages/paymentList.jsp";

            }else if (action.equalsIgnoreCase("addPayment")){
                Long patientId=Long.parseLong(request.getParameter("patientCombo"));
                Long doctorId=Long.parseLong(request.getParameter("doctorCombo"));
                Long sorenessId=Long.parseLong(request.getParameter("sorenessCombo"));
                String date=request.getParameter("date");
                Long amount=Long.parseLong(request.getParameter("amount"));
                Payment payment = new Payment();
                Patient patient=new Patient();
                patient.setId(patientId);
                Doctor doctor=new Doctor();
                doctor.setId(doctorId);
                Soreness soreness = new Soreness();
                soreness.setId(sorenessId);
                payment.setPatient(patient);
                payment.setDoctor(doctor);
                payment.setSoreness(soreness);
                payment.setDate(df.parse(date));
                payment.setAmount(amount);
                List<Payment> payments=paymentService.getPaymentList();
                response.setContentType("text/html");
                boolean isAdded=paymentService.addPayment(payment);
                if (isAdded){
                    writer.write("success");
                } else {
                    writer.write("failed");
                }
            }
            if(address!=null){
                RequestDispatcher requestDispatcher=request.getRequestDispatcher(address);
                requestDispatcher.forward(request,response);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
