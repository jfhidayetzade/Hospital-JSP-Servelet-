var globBtnId='';
var globPatientId=0;
var globDoctorId=0;
var globSoreness=0;
var globTreatmentId=0;

$(function () {
    $('body').layout({applyDemoStyles: true});
    $('.ui-layout-center, .ui-layout-north').css('background', '#0843');

    $('#patientDataBtnId').click(function () {
        getPatientList();
    });

    $('#doctorDataBtnId').click(function () {
        getDoctorList();
    });

    $('#sorenessDataBtnId').click(function () {
        getSorenessList();
    });

    $('.btnDesing').click(function () {
        globBtnId=$(this).attr('id');
    })


    $('#newBtnId').click(function () {

        switch (globBtnId){
            case 'patientDataBtnId':
                $('#newPatientId').load('view/newPatientList.jsp',function () {
                    $(this).dialog('open');
                });
                break;

            case 'doctorDataBtnId':
                $('#newDoctortId').load('view/newDoctor.jsp',function () {
                    $(this).dialog('open');
                })
                break;

            case 'sorenessDataBtnId':
                $('#newSorenessId').load('view/newSoreness.jsp',function () {
                    $(this).dialog('open');
                })
                break;

            case 'treatmentDataBtnId':
                $('#newTreatmentId').load('cs?action=newTreatment',function () {
                    $(this).dialog('open');
                })
                break;

            case 'employeDataBtnId':

                break;

            case 'paymentDataBtnId':
                $('#newPaymentId').load('cs?action=newPayment',function () {
                    $(this).dialog('open');
                })
                break;

            default:
                alert('Please select menu!!!')
                break;
        }
    });

    $('#newPatientId').dialog({
        height: 400,
        width: 400,
        title: 'New Patient',
        autoOpen: false,
        buttons: {
            "Save": function () {
                addPatient();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close')
            }
        }

    });

    $('#')

    $('#newDoctortId').dialog({
        height: 400,
        width: 400,
        title: 'New Doctor',
        autoOpen: false,
        buttons: {
            "Save": function () {
                addDoctor();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close')
            }
        }

    });

    $('#newSorenessId').dialog({
        height: 400,
        width: 400,
        title: 'New Soreness',
        autoOpen: false,
        buttons: {
            "Save": function () {
                addSoreness();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close')
            }
        }

    });

    $('#editPatientId').dialog({
           width:400,
           height:400,
           title:'Update Patient',
           autoOpen:false,
           buttons: {
               "Update": function () {
                   updatePatient();
                   $(this).dialog('close');
               },
               "Close": function () {
                   $(this).dialog('close');
               }
           }

    });

    $('#editSorenessId').dialog({
        width:400,
        height:400,
        title:'Update Soreness',
        autoOpen:false,
        buttons: {
            "Update": function () {
                updateSoreness();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }

    });



    $('#newTreatmentId').dialog({
        height: 400,
        width: 400,
        title: 'New Treatment',
        autoOpen: false,
        buttons: {
            "Save": function () {
                addTreatment();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close')
            }
        }

    });

    $('#newPaymentId').dialog({
        height: 400,
        width: 400,
        title: 'New Payment',
        autoOpen: false,
        buttons: {
            "Save": function () {
                addPayment();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close')
            }
        }

    });

    $('#editDoctorDialogId').dialog({
            height: 400,
            width: 400,
            title: 'edit Doctor',
            autoOpen: false,
            buttons: {
                "Update": function () {
                    updateDoctor();
                    $(this).dialog('close');
                },
                "Close": function () {
                    $(this).dialog('close')
                }
            }

    });

    $('#editTreatmentDialogId').dialog({
        height: 400,
        width: 400,
        title: 'Update Treatment',
        autoOpen: false,
        buttons: {
            "Update": function () {
                updateTreatment();
                $(this).dialog('close')
            },
            "Close": function () {
                $(this).dialog('close')
            }
        }
    })


    $('#keyworId').keyup(function () {
        var keyword=$('#keyworId').val()
        switch (globBtnId) {
            case 'patientDataBtnId':
                searchPatientData(keyword);
                break;

            case 'doctorDataBtnId':
                searchDoctorData(keyword);
                break;

            case 'sorenessDataBtnId':
                searchSorenessData(keyword);
                break;

            case 'treatmentDataBtnId':
                searchTreatmentData(keyword);
                break;

            case 'employeDataBtnId':

                break;

            case 'paymentDataBtnId':

                break;

            default:
                alert('Please select menu!!!');
                break;
        }
    });
    })






function getPatientList() {
    $.ajax({
        url:'cs?action=getPatientList',
        type:'GET',
        dataType: 'html',
        success: function (data) {
            $('.ui-layout-center').html(data)
        }
    })
}


function getDoctorList() {
    $.ajax({
        url:'cs?action=getDoctorList',
        type:'GET',
        dataType:'html',
        success: function (data) {
            $('.ui-layout-center').html(data)
        }
    })
}

function getSorenessList() {
    $.ajax({
        url: 'cs?action=getSorenessList',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('.ui-layout-center').html(data)
        }
    })
}
function addPatient() {
    var name=$('#nameId').val();
    var surname=$ ('#surnameId').val();
    var gender=$ ('#genderId').val();
    var dob=$ ('#dobId').val();
    var email=$ ('#emailId').val();
    var address=$ ('#addressId').val();

    var data = {
        name: name,
        surname: surname,
        gender: gender,
        dob: dob,
        email: email,
        address: address


    }

    $.ajax({
        url: 'cs?action=addPatient',
        type: 'POST',
        data: data ,
        dataType: 'text',
        success: function (data) {
            if(data=='successfully'){
                alert('Patient has been succesfully added!')
                getPatientList();
            }else{
                alert('Problem!!! Patient has not been successfully added!')
            }
        }
    })

}

function addDoctor() {
    var name=$('#nameD').val();
    var surname=$ ('#surnameD').val();
    var task=$ ('#task').val();
    var department=$ ('#department').val();


    var data = {
        name: name,
        surname: surname,
        task: task,
        department: department,
    }

    $.ajax({
        url: 'cs?action=addDoctor',
        type: 'POST',
        data: data ,
        dataType: 'text',
        success: function (data) {
            if(data=='successfully'){
                alert('Doctor has been succesfully added!')
                getDoctorList();
            }else{
                alert('Problem!!! Doctor has not been successfully added!')
            }
        }
    })

}

function addSoreness() {
    var diagonis=$('#diagonisId').val();
    var medicines=$ ('#medicinesId').val();

    var data = {
        diagonis: diagonis,
        medicines: medicines,

            }

    $.ajax({
        url: 'cs?action=addSoreness',
        type: 'POST',
        data: data ,
        dataType: 'text',
        success: function (data) {
            if(data=='successfully'){
                alert('Soreness has been succesfully added!')
                getSorenessList();
            }else{
                alert('Problem!!! Soreness has not been successfully added!')
            }
        }
    })

}

function getTreatmentList() {
    $.ajax({
        url: 'cs?action=getTreatmentList',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('.ui-layout-center').html(data)
        }
    })
}

$(function () {
    $('#treatmentDataBtnId').click(function () {
        getTreatmentList();
    });

    $('#paymentDataBtnId').click(function () {
        getPaymentList();
    })
});
function getPaymentList() {
    $.ajax({
        url:'cs?action=getPaymentList',
        type:'GET',
        dataType:'html',
        success: function (data) {
            $('.ui-layout-center').html(data);
        }
    })
}
function addTreatment() {

    var patientCombo  = $('#patientComboId').val();
    var doctorCombo   = $ ('#doctorComboId').val();
    var sorenessCombo = $('#sorenessComboId').val();

    var data = {
        patientCombo:patientCombo,
        doctorCombo:doctorCombo,
        sorenessCombo:sorenessCombo

    };

    $.ajax({
        url: 'cs?action=addTreatment',
        type: 'POST',
        data: data ,
        dataType: 'text',
        success: function (data) {
            if(data=='succesfully'){
                alert('Treatment has been succesfully added!')
                getTreatmentList();
            }else{
                alert('Problem!!! Treatment has not been successfully added!')
            }
        }
    })


}

function addPayment() {

    var patientCombo  = $('#patientComboId').val();
    var doctorCombo   = $ ('#doctorComboId').val();
    var sorenessCombo = $('#sorenessComboId').val();
    var patient

    var data = {
        patientCombo:patientCombo,
        doctorCombo:doctorCombo,
        sorenessCombo:sorenessCombo

    };

    $.ajax({
        url: 'cs?action=addTreatment',
        type: 'POST',
        data: data ,
        dataType: 'text',
        success: function (data) {
            if(data=='succesfully'){
                alert('Treatment has been succesfully added!')
                getTreatmentList();
            }else{
                alert('Problem!!! Treatment has not been successfully added!')
            }
        }
    })


}
function editDoctor(doctorId) {
    globDoctorId=doctorId;
    $.ajax({
        url: 'cs?action=editDoctor',
        type: 'GET',
        dataType:'html',
        data: 'doctorId='+doctorId,
        success: function (data) {
            $('#editDoctorDialogId').html(data);
            $('#editDoctorDialogId').dialog('open');

        }
    })
}



function updateDoctor() {
    var name=$('#nameIdDU').val();
    var surname=$ ('#surnameIdDU').val();
    var task=$ ('#taskDU').val();
    var departament=$ ('#departmentDU').val();


    var data = {
        name: name,
        surname: surname,
        task: task,
        departament:departament,
        doctorId:globDoctorId



    }

    $.ajax({
        url: 'cs?action=updateDoctor',
        type: 'POST',
        data: data ,
        dataType: 'text',
        success: function (data) {
            if(data=='successfully'){
                alert('Doctor has been succesfully updated!')
                getDoctorList();
            }else{
                alert('Problem!!! Doctor has not been successfully updated!')
            }
        }
    })

}

function editPatient(patientId) {
        globPatientId=patientId
    $.ajax({
        url:'cs?action=editPatient',
        type:'GET',
        dataType:'html',
        data: 'patientId='+patientId,
        success: function (data) {
            $('#editPatientId').html(data);
            $('#editPatientId').dialog('open')
        }
    })
};

function updatePatient() {
    var name=$('#nameIdpU').val();
    var surname=$('#surnameIdpU').val();
    var gender=$('#genderpIdU').val();
    var dob=$('#dobIdpU').val();
    var email=$('#emailIdpU').val();
    var address=$('#addressIdpU').val();

    var data = {
        name:name,
        surname:surname,
        gender:gender,
        dob:dob,
        email:email,
        address:address,
        patientId:globPatientId
    }

    $.ajax({
        url:'cs?action=updatePatient',
        type:'POST',
        dataType: 'text',
        data: data,
        success: function (data) {
            if(data=='success'){
                alert('Patient has been successfully is updated!')
                getPatientList();
            }else {
                alert('Problem!!! Patient has been not successfully is updated')
            }
        }
    })
}

function deletePatient(patientId) {
    var isdelete = confirm("Are you sure");

    if(isdelete){
        $.ajax({
            url: 'cs?action=deletePatient',
            type: 'POST',
            data: 'patientId='+patientId ,
            dataType: 'text',
            success: function (data) {
                if(data=='success'){
                    alert('Patient has been succesfully deleted!')
                    getPatientList();
                }else{
                    alert('Problem!!! Patient has not been successfully deleted!')
                }
            }
        })
    }

};

function deleteDoctor(doctorId) {
    var isdelete = confirm("Are you sure");

    if(isdelete){
        $.ajax({
            url: 'cs?action=deleteDoctor',
            type: 'POST',
            data: 'doctorId='+doctorId ,
            dataType: 'text',
            success: function (data) {
                if(data=='success'){
                    alert('Doctor has been succesfully deleted!')
                    getDoctorList();
                }else{
                    alert('Problem!!! Doctor has not been successfully deleted!')
                }
            }
        })
    }

}

function editSoreness(sorenessId) {
    globSoreness=sorenessId
    $.ajax({
        url:'cs?action=editSoreness',
        type:'GET',
        dataType:'html',
        data: 'sorenessId='+sorenessId,
        success: function (data) {
            $('#editSorenessId').html(data);
            $('#editSorenessId').dialog('open')
        }
    })
};

function updateSoreness() {
    var diagonis=$('#diagonisU').val();
    var medicines=$('#medicinesU').val();

    var data = {
        diagonis:diagonis,
        medicines:medicines,
        sorenessId:globSoreness
    }

    $.ajax({
        url:'cs?action=updateSoreness',
        type:'POST',
        dataType: 'text',
        data: data,
        success: function (data) {
            if(data=='successfully'){
                alert('Soreness has been successfully is updated!')
                getSorenessList();
            }else {
                alert('Problem!!! Soreness has been not successfully is updated')
            }
        }
    })
};

function deleteSoreness(sorenessId) {
    var isdelete = confirm("Are you sure");

    if(isdelete){
        $.ajax({
            url: 'cs?action=deleteSoreness',
            type: 'POST',
            data: 'sorenessId='+sorenessId ,
            dataType: 'text',
            success: function (data) {
                if(data=='success'){
                    alert('Soreness has been succesfully deleted!')
                    getSorenessList();
                }else{
                    alert('Problem!!! Soreness has not been successfully deleted!')
                }
            }
        })
    }

}

function editTreatment(treatmentId) {
    globTreatmentId=treatmentId;
    $.ajax({
        url: 'cs?action=editTreatment',
        type: 'GET',
        dataType:'html',
        data: 'treatmentId='+treatmentId,
        success: function (data) {
            $('#editTreatmentDialogId').html(data);
            $('#editTreatmentDialogId').dialog('open');

        }
    })
}


function updateTreatment() {

    var patientCombo=$('#patientComboEditId').val();
    var doctorCombo=$('#doctorComboEditId').val();
    var sorenessCombo=$('#sorenessComboEditId').val();

    var data = {
        patientCombo:patientCombo,
        doctorCombo:doctorCombo,
        sorenessCombo:sorenessCombo,
        treatmentId:globTreatmentId
    }

    $.ajax({
        url: 'cs?action=updateTreatment',
        type: 'GET',
        data: data,
        dataType: 'text',
        success: function (data) {
            if(data=="successfully"){
                alert('Treatment has been successfully is updated!')
                getTreatmentList();
            } else {
                alert('Problem!!! Treatment has been not successfully is updated!')
            }
        }
    })

}

function deleteTreatment(treatmentId) {
    var isDelete=confirm('Are you sure')

    if(isDelete){
        $.ajax({
            url:'cs?action=deleteTreatment',
            type: 'POST',
            dataType: 'text',
            data: 'treatmentId='+treatmentId,
            success: function (data) {
                if(data='success'){
                    alert('Treatment has been successfully is deleted');
                    getTreatmentList();
                }else {
                    alert('Problem !!! Treatment has been not successfully is deleted!')
                }
            }
        })
    }
}


/*SIMPLE SEARCH*/

function simpleSearch() {
    var keyword=$('#keyworId').val()
    switch (globBtnId){
        case 'patientDataBtnId':
            searchPatientData(keyword);
            break;

        case 'doctorDataBtnId':
            searchDoctorData(keyword);
            break;

        case 'sorenessDataBtnId':
            searchSorenessData(keyword);
            break;

        case 'treatmentDataBtnId':
            searchTreatmentData(keyword);
            break;

        case 'employeDataBtnId':

            break;

        case 'paymentDataBtnId':

            break;

        default:
            alert('Please select menu!!!');
            break;
    }


}

function searchPatientData(keyword) {
    $.ajax({
        url: 'cs?action=searchPatient',
        type: 'GET',
        dataType: 'html',
        data: 'keyword='+keyword,
        success: function (data) {
            $('.ui-layout-center').html(data);
        }
    })
};

function searchDoctorData(keyword) {
    $.ajax({
        url: 'cs?action=searchDoctor',
        type: 'GET',
        dataType: 'html',
        data: 'keyword='+keyword,
        success: function (data) {
            $('.ui-layout-center').html(data);
        }
    })
};

function searchSorenessData(keyword) {
    $.ajax({
        url: 'cs?action=searchSoreness',
        type: 'GET',
        dataType: 'html',
        data: 'keyword='+keyword,
        success: function (data) {
            $('.ui-layout-center').html(data);
        }
    })
};

function searchTreatmentData(keyword) {
    $.ajax({
        url: 'cs?action=searchTreatment',
        type:'GET',
        dataType:'html',
        data: 'keyword='+keyword,
        success: function (data) {
            $('.ui-layout-center').html(data);

        }
    })
}

function getDoctorComboSorenessById(sorenessId) {
    $.ajax({
        url: 'cs?action=getDoctorComboSorenessById',
        type: 'GET',
        dataType: 'html',
        data: 'sorenessId='+sorenessId,
        success: function (data) {
            $('#advDoctorComboId').html(data);
        }
        
    })
};

function advanceSearchTreatment() {
    var sorenessId=$('#advSorenessComboId').val();
    var doctorId= $('#advDoctorComboId').val();
    var beginDate=$('#advBeginDateId').val();
    var endDate = $('#advEndDateId').val();

    var data = {
        sorenessId: sorenessId,
        doctorId: doctorId,
        beginDate:beginDate,
        endDate:endDate
    }

    $.ajax({
        url:'cs?action=advanceSearchTreatment',
        type:'GET',
        dataType:'html',
        data:data,
        success: function (data) {
            $('#treatmentDivId').html(data)
        }
    })
}





