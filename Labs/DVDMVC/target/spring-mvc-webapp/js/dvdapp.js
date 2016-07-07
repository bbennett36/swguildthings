/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    $('#create-submit').on("click", function (e) {

        e.preventDefault();


        var DvdData = JSON.stringify({
            title: $("#title-input").val(),
            releaseDate: $("#release-date-input").val(),
            mPAA: $("#mpaa-input").val(),
            directorsName: $("#directors-name-input").val(),
            studio: $("#studio-input").val(),
            note: $("#note-input").val()

        });

        $.ajax({
            url: contextRoot + "/dvd/",
            type: "POST",
            data: DvdData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data, status) {

                console.log(data);

                var tableRow = buildDvdRow(data);

                $('#dvd-table').append($(tableRow));

                $("#title-input").val("");
                $("#release-date-input").val("");
                $("#mpaa-input").val("");
                $("#directors-name-input").val("");
                $("#studio-input").val("");
                $("#note-input").val("");


            },
            error: function (data, status) {
                
                var errors = data.responseJSON.errors;

                $.each(errors, function (index, error) {

                    $("#add-dvd-validation-errors").append(error.fieldName + ": " + error.message + "<br />");

                });
            }

        });


//        alert("after ajax");

    });
    $(document).on('click', '.delete-link', function (e) {
        e.preventDefault();

        var dvdId = $(e.target).data('dvd-id');

        $.ajax({
            type: "DELETE",
            url: contextRoot + "/dvd/" + dvdId,
            success: function (data, status) {
                $('#dvd-row-' + dvdId).remove();
            },
            error: function (data, status) {
                alert('error');
            }


        });


    });


    $('#showContactModal').on('show.bs.modal', function (e) {
        var link = $(e.relatedTarget);

        var dvdId = link.data('dvd-id');

        $.ajax({
            url: contextRoot + "/dvd/" + dvdId,
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $("#dvd-title").text(data.title);
                $("#dvd-rd").text(data.releaseDate);
                $("#dvd-mpaa").text(data.mPAA);
                $("#dvd-directors-name").text(data.directorsName);
                $("#dvd-studio").text(data.studio);
                $("#dvd-notes").text(data.note);
            },
            error: function (data, status) {
                alert('error in show');
            }

        });

    });

    $('#editContactModal').on('show.bs.modal', function (e) {
        var link = $(e.relatedTarget);

        var dvdId = link.data('dvd-id');

        $.ajax({
            url: contextRoot + "/dvd/" + dvdId,
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $('#edit-id').val(data.id);
                $("#edit-dvd-title").val(data.title);
                $("#edit-dvd-rd").val(data.releaseDate);
                $("#edit-dvd-mpaa").val(data.mPAA);
                $("#edit-dvd-directors-name").val(data.directorsName);
                $("#edit-dvd-studio").val(data.studio);
                $("#edit-dvd-notes").val(data.note);

            },
            error: function (data, status) {
                alert('error edit contact modal');
            }

        });

    });

    $("#edit-dvd-button").on('click', function (e) {


        e.preventDefault();

        var dvdData = JSON.stringify({
            id: $('#edit-id').val(),
            title: $("#edit-dvd-title").val(),
            releaseDate: $("#edit-dvd-rd").val(),
            mPAA: $("#edit-dvd-mpaa").val(),
            directorsName: $("#edit-dvd-directors-name").val(),
            studio: $("#edit-dvd-studio").val(),
            note: $("#edit-dvd-notes").val()

        });

        $.ajax({
            url: contextRoot + "/dvd/",
            type: "PUT",
            data: dvdData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data, status) {

                $('#editContactModal').modal('hide');

                var tableRow = buildContactRow(data);

                $('dvd-row-' + data.id).replaceWith($(tableRow));


            },
            error: function (data, status) {
                alert("error dvd button");
            }

        });


    });




    function buildDvdRow(data) {

        return "<tr id='dvd-row-" + data.id + "'>  \n\
                <td><a data-contact-id='" + data.id + "' data-toggle='modal' data-target='#showContactModal'>" + data.title + "</a></td>  \n\
                <td> <a data-contact-id='" + data.id + "' data-toggle='modal' data-target='#editAddreessModal'>Edit</a>  </td>   \n\
                <td> <a data-contact-id='" + data.id + "' class='delete-link'>Delete</a>  </td>   \n\
                </tr>  ";


    }

}
);