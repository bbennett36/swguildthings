/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $("#btnCreateCategory").on("click", function () {

        $("#createCategoryModal").modal();
    });

    $("#submitCategory").on("click", function (e) {
        e.preventDefault();

        var categoryData = JSON.stringify({
            category: $("#newCategory").val()
        });

        console.log(categoryData);

        $.ajax({
            url: contextRoot + "/category/",
            type: "POST",
            data: categoryData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {
                console.log(data);

                var categoryRow = buildCategoryRow(data);
                $("#activePostTbody").append($(categoryRow));

//                $("#category").val("");
                $('#createCategoryModal').modal('hide');


            },
            error: function (data, status) {

                $("#warnPostTitle").empty();

                var errors = data.responseJSON.errors;

                $.each(errors, function (index, error) {

                    console.log(error.fieldName + ": " + error.message);

                    switch (error.fieldName) {
                        case "category":
                            $("#warnPostTitle").append(error.message);
                            $("#newCategory").addClass("inputError");
                            break;
                        default:
                            break;
                    }
                });
            }
        });
    });
    
    $(document).on('click', '.delete-link', function (e) {
        e.preventDefault();

        var categoryId = $(e.target).data('category-id');

        $.ajax({
            type: "DELETE",
            url: contextRoot + "/category/" + categoryId,
            success: function (data, status) {
                $('#category-row-' + categoryId).remove();
            },
            error: function (data, status) {
                alert(' delete error');
            }


        });


    });
    
    $('#editCategoryModal').on('show.bs.modal', function (e) {
        var link = $(e.relatedTarget);

        var categoryId = link.data('category-id');

        $.ajax({
            url: contextRoot + "/category/" + categoryId,
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success: function (data, status) {
                $('#edit-id').val(data.id);
                $("#edit-category").val(data.category);

            },
            error: function (data, status) {
                alert('error edit category modal');
            }

        });

    });

    $("#submitCategoryEdit").on('click', function (e) {

        e.preventDefault();

        var categoryData = JSON.stringify({
            id: $('#edit-id').val(),
            category: $("#edit-category").val()
        });

        $.ajax({
            url: contextRoot + "/category/",
            type: "PUT",
            data: categoryData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data, status) {

                $('#editCategoryModal').modal('hide');                
                var categoryRow = buildCategoryRow(data);                
                window.location.reload();

            },
            error: function (data, status) {
                var errors = data.responseJSON.errors;

                $.each(errors, function (index, error) {

                    $("#add-flooring-validation-errors").append(error.fieldName + ": " + error.message + "<br />");

                });
            }

        });


    });


    function buildCategoryRow(data) {

        return "<tr id='category-row-" + data.id + "'>  \n\
                <td> " + data.category + "</td>    \n\
                <td> <a data-product-id='" + data.id + "' data-toggle='modal' data-target='#editProductModal'>Edit</a>  </td>   \n\
                <td> <a data-product-id='" + data.id + "' class='delete-link2'>Delete</a>  </td>   \n\
                </tr>  ";
//        
//         <tr id="category-row-${c.id}">
//                                <td>${c.name}</td>
//                                <td><a data-order-id="${c.id}" data-toggle="modal" data-target="#editContactModal">Edit</a></td>
//                                <td><a data-order-id="${c.id}" class="delete-link">Delete</a></td>
//                            </tr>


    }

});



