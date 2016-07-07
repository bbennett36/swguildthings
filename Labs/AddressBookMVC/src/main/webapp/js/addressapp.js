/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $('#create-submit').on("click", function (e) {

        e.preventDefault();

        var addressData = JSON.stringify({
            firstName: $("#first-name-input").val(),
            lastName: $("#last-name-input").val(),
            streetNumber: $("#street-num-input").val(),
            streetName: $("#street-name-input").val(),
            city: $("#city-input").val(),
            state: $("#state-input").val(),
            zip: $("#zip-input").val()

        });

        $.ajax({
            url: contextRoot + "/address/",
            type: "POST",
            data: addressData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data, status) {

                console.log(data);

                var tableRow = buildAddressRow(data);

                $('#address-table').append($(tableRow));

                $("#first-name-input").val("");
                $("#last-name-input").val("");
                $("#street-num-input").val("");
                $("#street-name-input").val("");
                $("#city-input").val("");
                $("#state-input").val("");
                $("#zip-input").val("");



            },
            error: function (data, status) {

                var errors = data.responseJSON.errors;

                $.each(errors, function (index, error) {

                    $("#add-address-validation-errors").append(error.fieldName + ": " + error.message + "<br />");

                });
            }

        });



    });

    $(document).on('click', '.delete-link', function (e) {
        e.preventDefault();

        var addressId = $(e.target).data('address-id');

        $.ajax({
            type: "DELETE",
            url: contextRoot + "/address/" + addressId,
            success: function (data, status) {
                $('#address-row-' + addressId).remove();
            },
            error: function (data, status) {
                alert(' delete error');
            }


        });


    });

    $('#showContactModal').on('show.bs.modal', function (e) {
        var link = $(e.relatedTarget);

        var addressId = link.data('address-id');

        $.ajax({
            url: contextRoot + "/address/" + addressId,
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $('#edit-id').val(data.id);
                $("#address-first-name").text(data.firstName);
                $("#address-last-name").text(data.lastName);
                $("#address-street-num").text(data.streetNumber);
                $("#address-street-name").text(data.streetName);
                $("#address-city").text(data.city);
                $("#address-state").text(data.state);
                $("#address-zip").text(data.zip);

            },
            error: function (data, status) {
                alert('error in show');
            }

        });

    });

    $('#editContactModal').on('show.bs.modal', function (e) {
        var link = $(e.relatedTarget);

        var addressId = link.data('address-id');

        $.ajax({
            url: contextRoot + "/address/" + addressId,
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $("#edit-address-first-name").val(data.firstName);
                $("#edit-address-last-name").val(data.lastName);
                $("#edit-address-street-num").val(data.streetNumber);
                $("#edit-address-street-name").val(data.streetName);
                $("#edit-address-city").val(data.city);
                $("#edit-address-state").val(data.state);
                $("#edit-address-zip").val(data.zip);
                $('#edit-id').val(data.id);
            },
            error: function (data, status) {
                alert('error edit contact modal');
            }

        });

    });

    $("#edit-address-button").on('click', function (e) {


        e.preventDefault();

        var addressData = JSON.stringify({
            id: $('#edit-id').val(),
            firstName: $("#edit-address-first-name").val(),
            lastName: $("#edit-address-last-name").val(),
            streetNumber: $("#edit-address-street-num").val(),
            streetName: $("#edit-address-street-name").val(),
            city: $("#edit-address-city").val(),
            state: $("#edit-address-state").val(),
            zip: $("#edit-address-zip").val()

        });

        $.ajax({
            url: contextRoot + "/address/",
            type: "PUT",
            data: addressData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data, status) {

                $('#editContactModal').modal('hide');

                var tableRow = buildAddressRow(data);

                $('#address-row-' + data.id).replaceWith($(tableRow));


            },
            error: function (data, status) {
                alert("error edit button");
            }

        });


    });

    function buildAddressRow(data) {

        return "<tr id='address-row-" + data.id + "'>  \n\
                <td><a data-address-id='" + data.id + "' data-toggle='modal' data-target='#showContactModal'>" + data.firstName + "</a></td>  \n\
                <td> " + data.lastName + "</td>    \n\
                <td> " + data.city + "</td>    \n\
                <td> " + data.state + "</td>    \n\
                <td> " + data.zip + "</td>    \n\
                <td> <a data-address-id='" + data.id + "' data-toggle='modal' data-target='#editAddreessModal'>Edit</a>  </td>   \n\
                <td> <a data-address-id='" + data.id + "' class='delete-link'>Delete</a>  </td>   \n\
                </tr>  ";


    }

}
);

