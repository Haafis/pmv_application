var VehicleRegistraionDetailsTable;
var CreatedServiceTicketTable;
$(document).ready(function() {
 $('#id').val(0);
    VehicleRegistraionDetailsTable = $('#VehicleRegistraionDetailsTable').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/getAllvehicleDetails",
            "type": "POST",
            "dataType": "json",
            "contentType": "application/json",
            "data": function(d) {
                return JSON.stringify(d);
            }
        },
        "columns": [{
                "data": null,
                "title": "Serial Number",
                "width": "5%"
            },
            {
                "data": "plateNo",
                "title": "Plate No",
                "width": "20%"
            },
            {
                "data": "model",
                "title": "Car Model",
                "width": "20%"
            },
            {
                "data": "manufacturingYear",
                "title": "Manufacturing Year",
                "width": "20%"
            },
            {
                "data": "upcomingServiceDate",
                "title": "Upcoming Service Date",
                "width": "20%"
            },
            {
                "data": "driverinformation",
                "title": "Driver Information",
                "width": "20%"
            },
            {
                "data": null,
                "title": "Actions",
                "width": "20%",
                "render": function(data, type, row, meta) {
                    return '<button class="btn btn-primary btn-sm btn-flat" onclick="CreateServiceTicket(' + row.vehicleid + ')">Create Service Ticket</button>';
                }
            }
        ],
        "columnDefs": [{
            "targets": 0,
            "render": function(data, type, row, meta) {
                var displayIndex = meta.row + meta.settings._iDisplayStart + 1;
                return displayIndex;
            }
        }]
    });

     CreatedServiceTicketTable = $('#CreatedServiceTicketTable').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/getAllServiceTicketDetails",
            "type": "POST",
            "dataType": "json",
            "contentType": "application/json",
            "data": function(d) {
                return JSON.stringify(d);
            }
        },
        "columns": [{
                "data": null,
                "title": "Serial Number",
                "width": "5%"
            },
            {
                "data": "vehicleid",
                "title": "vehicle id",
                "width": "20%"
            },
            {
                "data": "lastServiceMileage",
                "title": "Last Service Mileage",
                "width": "20%"
            },
            {
                "data": "serviceDescription",
                "title": "Service Description",
                "width": "20%"
            },
            {
                "data": "serviceCost",
                "title": "Service Cost",
                "width": "20%"
            },
            {
                "data": "upcomingServiceDate",
                "title": "Upcoming Service Date",
                "width": "20%"
            },
            {
                 "data": "serviceEngineerName",
                  "title": "Service Engineer Name",
                  "width": "20%"
                        },
            {
                "data": null,
                "title": "Actions",
                "width": "20%",
                "render": function(data, type, row, meta) {
                    return '<button class="btn btn-primary btn-sm btn-flat" onclick="EditserviceTicket(' + row.id + ')">Edit</button>' +
                        '<button class="btn btn-danger btn-sm" style="background-color: red; color: white;" onclick="DeleteserviceTicket(' + row.id + ')">Delete</button>';
                }
            }
        ],
        "columnDefs": [{
            "targets": 0,
            "render": function(data, type, row, meta) {
                var displayIndex = meta.row + meta.settings._iDisplayStart + 1;
                return displayIndex;
            }
        }]
    });
});

function CreateServiceTicket(id) {
   window.open('CreateServiceTicket?id=' + id);
}


function submitServiceTicket() {

    var lastServiceMileage = $('#lastServiceMileage').val();
    var lastServiceDate = $('#lastServiceDate').val();
    var serviceDescription = $('#serviceDescription').val();
    var serviceCost = $('#serviceCost').val();
    var upcomingServiceDate = $('#upcomingServiceDate').val();
    var serviceEngineerName = $('#serviceEngineerName').val();
    var id = $('#id').val();

    if (lastServiceMileage === "") {
        alert("Please Enter last Service Mileage");
        return false;
    }
    if (lastServiceDate === "") {
        alert("Please Select lastServiceDate");
        return false;
    }
    if (serviceDescription === "") {
        alert("Please Enter Service Description");
        return false;
    }
    if (serviceCost === "") {
        alert("Please Enter Service Cost");
        return false;
    }
    if (upcomingServiceDate === "") {
        alert("Please Select Upcoming Service Date");
        return false;
    }
    if (serviceEngineerName === "") {
        alert("Please Enter Service Engineer Name");
        return false;
    }

    var serviceTicketData = {
        id: id,
        vehicleid: idValue,
        lastServiceMileage: lastServiceMileage,
        lastServiceDate: lastServiceDate,
        serviceDescription: serviceDescription,
        serviceCost: serviceCost,
        upcomingServiceDate: upcomingServiceDate,
        serviceEngineerName: serviceEngineerName
    };

    var jsonData = JSON.stringify(serviceTicketData);

    $.ajax({
        type: "POST",
        url: "/submit",
        contentType: "application/json",
        data: jsonData,
        success: function(response) {
            alert("Service ticket submitted successfully");
              window.location.href = 'ServiceTicket';
        },
        error: function(xhr, status, error) {
            console.error(xhr.responseText);
            alert("Error occurred while submitting service ticket");
            window.location.href = 'ServiceTicket';

        }
    });
}



function EditserviceTicket(id) {
$('#id').val(id);
    $.ajax({
        type: "GET",
        url: "/getserviceTicketByID",
        contentType: "application/json",
        data: { id: id },
        success: function(response) {
        console.log(response);
            $("#lastServiceMileage").val(response.lastServiceMileage);
                        var lastServiceDate = new Date(response.lastServiceDate);
                        var formattedDate = lastServiceDate.toISOString().split('T')[0];
                        $("#lastServiceDate").val(formattedDate);
            $("#serviceDescription").val(response.serviceDescription);

            $("#serviceCost").val(response.serviceCost);
                                     var upcomingServiceDate = new Date(response.upcomingServiceDate);
                                     var formattedDate = upcomingServiceDate.toISOString().split('T')[0];
                                     $("#upcomingServiceDate").val(formattedDate);
                                     $("#serviceEngineerName").val(response.serviceEngineerName);
        },
        error: function(xhr, status, error) {
            console.error(xhr.responseText);
        }
    });
}

function DeleteserviceTicket(id) {
    $.ajax({
        type: "DELETE",
        url: "/deleteserviceTicketByID",
        data: { id: id },
        success: function(serverMessageDto) {
            if (serverMessageDto.successFlag == 1) {
                alert("Delete successfully");
              window.location.href = 'ServiceTicket';
            } else {
                alert("Delete unsuccessful");
             window.location.href = 'ServiceTicket';
            }
        },
        error: function(xhr, status, error) {
            console.error(xhr.responseText);

        }
    });
}