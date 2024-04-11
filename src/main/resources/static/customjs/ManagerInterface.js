var ManagerInterfaceTable;
$(document).ready(function() {
     ManagerInterfaceTable = $('#ManagerInterfaceTable').DataTable({
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
                "title": "Car Model",
                "width": "20%"
            },
            {
                "data": "model",
                "title": "Number of Services (Last Month)",
                "width": "20%"
            },
            {
                "data": "manufacturingYear",
                "title": "Last Service Date",
                "width": "20%"
            },
            {
                "data": "upcomingServiceDate",
                "title": "Cost",
                "width": "20%"
            },
            {
                "data": "driverinformation",
                "title": "Mileage",
                "width": "20%"
            },
            {
                "data": null,
                "title": "Actions",
                "width": "20%",
                "render": function(data, type, row, meta) {
                    return '' +
                        '<button class="btn btn-danger btn-sm" style="background-color: red; color: white;" onclick="DeleteServiceVehicleList(' + row.vehicleid + ')">Delete</button>';
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

function DeleteServiceVehicleList(vehicleid) {
    $.ajax({
        type: "DELETE",
        url: "/deleteVehicleDetailsByID",
        data: { vehicleid: vehicleid },
        success: function(serverMessageDto) {
            if (serverMessageDto.successFlag == 1) {
                alert("Delete successfully");
               window.location.href = 'ManagerInterface';
            } else {
                alert("Delete unsuccessful");
                window.location.href = 'ManagerInterface';
            }

        },
        error: function(xhr, status, error) {
            console.error(xhr.responseText);
        }
    });
}