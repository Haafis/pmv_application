var DriverInterfacetable;
$(document).ready(function() {


     DriverInterfacetable = $('#DriverInterfacetable').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/getAllvehicleServiceDetails",
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
                "title": "	Cost",
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

