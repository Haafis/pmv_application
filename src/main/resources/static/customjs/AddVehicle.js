var masterTable;
$(document).ready(function() {
     $('#vehicleid').val(0);
     masterTable = $('#masterTable').DataTable({
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
                    return '<button class="btn btn-primary btn-sm btn-flat" onclick="EditVehicle(' + row.vehicleid + ')">Edit</button>' +
                        '<button class="btn btn-danger btn-sm" style="background-color: red; color: white;" onclick="DeleteVehicle(' + row.vehicleid + ')">Delete</button>';
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



function AddVehicle() {
    var plateNo = $('#plateNo').val();
    var model = $('#model').val();
    var manufacturingYear = $('#manufacturingYear').val();
    var upcomingServiceDate = $('#upcomingServiceDate').val();
    var driverInfo = $('#driverInfo').val();
    var vehicleid = $('#vehicleid').val();


if (plateNo === "") {
    alert("Please Enter plate No");
    return false;
}
if (model === "") {
    alert("Please Enter model");
    return false;
}
if (manufacturingYear === "") {
    alert("Please Enter Manufacturing Year");
    return false;
}
if (upcomingServiceDate === "") {
    alert("Please Selcet Upcoming Service Date");
    return false;
}
if (driverInfo === "") {
    alert("Please Enter Driver Information");
    return false;
}
    var vehicleData = {
        vehicleid: vehicleid,
        plateNo: plateNo,
        model: model,
        manufacturingYear: manufacturingYear,
        upcomingServiceDate: upcomingServiceDate,
        driverinformation: driverInfo
    };

    var jsonData = JSON.stringify(vehicleData);

    $.ajax({
        type: "POST",
        url: "/addVehicleDetails",
        contentType: "application/json",
        data: jsonData,
        success: function(response) {
            alert(response);
              window.location.href = 'AddVehicle';
        },
        error: function(xhr, status, error) {
            console.error(xhr.responseText);
            window.location.href = 'AddVehicle';
        }
    });
}




function EditVehicle(vehicleid) {
     $('#vehicleid').val(vehicleid);
    $.ajax({
        type: "GET",
        url: "/getVehicleDetailsByID",
        contentType: "application/json",
        data: { vehicleid: vehicleid },
        success: function(response) {
            $("#plateNo").val(response.plateNo);
            $("#model").val(response.model);
            $("#manufacturingYear").val(response.manufacturingYear);
            var upcomingServiceDate = new Date(response.upcomingServiceDate);
            var formattedDate = upcomingServiceDate.toISOString().split('T')[0];
            $("#upcomingServiceDate").val(formattedDate);
            $("#driverInfo").val(response.driverinformation);
        },
        error: function(xhr, status, error) {
            console.error(xhr.responseText);
        }
    });
}

function DeleteVehicle(vehicleid) {
    $.ajax({
        type: "DELETE",
        url: "/deleteVehicleDetailsByID",
        data: { vehicleid: vehicleid }, // Send as URL-encoded parameters
        success: function(serverMessageDto) {
            if (serverMessageDto.successFlag == 1) {
                alert("Delete successfully");
               window.location.href = 'AddVehicle';
            } else {
                alert("Delete unsuccessful");
                window.location.href = 'AddVehicle';
            }

        },
        error: function(xhr, status, error) {
            console.error(xhr.responseText);
              window.location.href = 'AddVehicle';
        }
    });
}

