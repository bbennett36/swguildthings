/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {


    $('#create-submit').on("click", function (e) {

        e.preventDefault();


        var OrderData = JSON.stringify({
            name: $("#name-input").val(),
            date: $("#date-input").val(),
            state: $("#state-input").val(),
            product: $("#product-input").val(),
            area: $("#area-input").val()

        });

        $.ajax({
            url: contextRoot + "/order/",
            type: "POST",
            data: OrderData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data, status) {

                console.log(data);

                var tableRow = buildOrderRow(data);

                $('#order-table').append($(tableRow));

                $("#name-input").val("");
                $("#date-input").val("");
                $("#area-input").val("");


            },
            error: function (data, status) {

                var errors = data.responseJSON.errors;

                $.each(errors, function (index, error) {

                    $("#add-flooring-validation-errors").append(error.fieldName + ": " + error.message + "<br />");

                });
            }

        });


//        alert("after ajax");

    });
    $(document).on('click', '.delete-link', function (e) {
        e.preventDefault();

        var orderId = $(e.target).data('order-id');

        $.ajax({
            type: "DELETE",
            url: contextRoot + "/order/" + orderId,
            success: function (data, status) {
                $('#order-row-' + orderId).remove();
            },
            error: function (data, status) {
                alert(' delete error');
            }


        });


    });


    $('#showContactModal').on('show.bs.modal', function (e) {
        var link = $(e.relatedTarget);

        var orderId = link.data('order-id');

        $.ajax({
            url: contextRoot + "/order/" + orderId,
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $("#order-name").text(data.name);
                $("#order-state").text(data.state);
                $("#order-tax").text(data.tax);
                $("#order-date").text(data.date);
                $("#order-product").text(data.product);
                $("#order-area").text(data.area);
                $("#order-lc").text(data.laborCost);
                $("#order-lcs").text(data.laborCostSqf);
                $("#order-mc").text(data.materialCost);
                $("#order-mcs").text(data.matCostSqf);
                $("#order-tt").text(data.taxTotal);
                $("#order-total").text(data.total);

            },
            error: function (data, status) {
                alert('error in show');
            }

        });

    });

    $('#editContactModal').on('show.bs.modal', function (e) {
        var link = $(e.relatedTarget);

        var orderId = link.data('order-id');

        $.ajax({
            url: contextRoot + "/order/" + orderId,
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $('#edit-id').val(data.id);
                $("#edit-order-name").val(data.name);
                $("#edit-order-date").val(data.date);
                $("#edit-order-state").val(data.state);
                $("#edit-order-product").val(data.product);
                $("#edit-order-area").val(data.area);

            },
            error: function (data, status) {
                alert('error edit contact modal');
            }

        });

    });

    $("#edit-order-button").on('click', function (e) {


        e.preventDefault();

        var orderData = JSON.stringify({
            id: $('#edit-id').val(),
            name: $("#edit-order-name").val(),
            date: $("#edit-order-date").val(),
            state: $("#edit-order-state").val(),
            product: $("#edit-order-product").val(),
            area: $("#edit-order-area").val()

        });

        $.ajax({
            url: contextRoot + "/order/",
            type: "PUT",
            data: orderData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data, status) {

                $('#editContactModal').modal('hide');

                var tableRow = buildOrderRow(data);

                $('order-row-' + data.id).replaceWith($(tableRow));


            },
            error: function (data, status) {
                var errors = data.responseJSON.errors;

                $.each(errors, function (index, error) {

                    $("#add-flooring-validation-errors").append(error.fieldName + ": " + error.message + "<br />");

                });
            }

        });


    });




    function buildOrderRow(data) {

        return "<tr id='order-row-" + data.id + "'>  \n\
                <td><a data-order-id='" + data.id + "' data-toggle='modal' data-target='#showContactModal'>" + data.id + "</a></td>  \n\
                <td> " + data.name + "</td>    \n\
                <td> " + data.date + "</td>    \n\
                <td> <a data-order-id='" + data.id + "' data-toggle='modal' data-target='#editAddreessModal'>Edit</a>  </td>   \n\
                <td> <a data-order-id='" + data.id + "' class='delete-link'>Delete</a>  </td>   \n\
                </tr>  ";


    }

    //Product JS

    $(document).on('click', '.delete-link2', function (e) {
        e.preventDefault();

        var productId = $(e.target).data('product-id');

        $.ajax({
            type: "DELETE",
            url: contextRoot + "/adminC/" + productId,
            success: function (data, status) {
                $('#product-row-' + productId).remove();
            },
            error: function (data, status) {
                alert(' delete error');
            }


        });


    });

    $('#product-submit').on("click", function (e) {

        e.preventDefault();


        var productData = JSON.stringify({
            productType: $("#p-type-input").val(),
            matCostSqf: $("#p-mcs-input").val(),
            laborCostSqf: $("#p-lcs-input").val()

        });

        $.ajax({
            url: contextRoot + "/adminC/",
            type: "POST",
            data: productData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data, status) {

                console.log(data);

                var tableRow = buildProductRow(data);

                $('#product-table').append($(tableRow));

                $("#p-type-input").val("");
                $("#p-mcs-input").val("");
                $("#p-lcs-input").val("");


            },
            error: function (data, status) {
                var errors2 = data.responseJSON.errors;

                $.each(errors2, function (index, error) {

                    $("#add-flooring-validation-errors2").append(error.fieldName + ": " + error.message + "<br />");

                });
            }

        });


//        alert("after ajax");

    });

    $('#showProductModal').on('show.bs.modal', function (e) {
        var link = $(e.relatedTarget);

        var productId = link.data('product-id');

        $.ajax({
            url: contextRoot + "/adminC/" + productId,
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $("#product-type").text(data.productType);
                $("#product-mcs").text(data.matCostSqf);
                $("#product-lcs").text(data.laborCostSqf);


            },
            error: function (data, status) {
                alert('error in show');
            }

        });

    });

    $('#editProductModal').on('show.bs.modal', function (e) {
        var link = $(e.relatedTarget);

        var productId = link.data('product-id');

        $.ajax({
            url: contextRoot + "/adminC/" + productId,
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $('#edit-id2').val(data.id);
                $("#edit-p-type").val(data.productType);
                $("#edit-p-mcs").val(data.matCostSqf);
                $("#edit-p-lcs").val(data.laborCostSqf);

            },
            error: function (data, status) {
                alert('error edit product modal');
            }

        });

    });

    $("#edit-product-button").on('click', function (e) {


        e.preventDefault();

        var productData = JSON.stringify({
            id: $('#edit-id2').val(),
            productType: $("#edit-p-type").val(),
            matCostSqf: $("#edit-p-mcs").val(),
            laborCostSqf: $("#edit-p-lcs").val()

        });

        $.ajax({
            url: contextRoot + "/order/p",
            type: "PUT",
            data: productData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data, status) {

                $('#editProductModal').modal('hide');

                var tableRow = buildProductRow(data);

                $('product-row-' + data.id).replaceWith($(tableRow));


            },
            error: function (data, status) {
                alert("error product button");
            }

        });


    });




    function buildProductRow(data) {

        return "<tr id='product-row-" + data.id + "'>  \n\
                <td><a data-product-id='" + data.id + "' data-toggle='modal' data-target='#showProductModal'>" + data.productType + "</a></td>  \n\
                <td> " + data.matCostSqf + "</td>    \n\
                <td> " + data.laborCostSqf + "</td>    \n\
                <td> <a data-product-id='" + data.id + "' data-toggle='modal' data-target='#editProductModal'>Edit</a>  </td>   \n\
                <td> <a data-product-id='" + data.id + "' class='delete-link2'>Delete</a>  </td>   \n\
                </tr>  ";


    }




    //Tax JS

    $(document).on('click', '.delete-link3', function (e) {
        e.preventDefault();

        var taxId = $(e.target).data('tax-id');

        $.ajax({
            type: "DELETE",
            url: contextRoot + "/adminC/t" + taxId,
            success: function (data, status) {
                $('#tax-row-' + taxId).remove();
            },
            error: function (data, status) {
                alert(' delete error');
            }


        });


    });

    $('#tax-submit').on("click", function (e) {

        e.preventDefault();


        var taxData = JSON.stringify({
            state: $("#t-state-input").val(),
            taxRate: $("#t-rate-input").val()

        });

        $.ajax({
            url: contextRoot + "/adminC/t",
            type: "POST",
            data: taxData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data, status) {

                console.log(data);

                var tableRow = buildTaxRow(data);

                $('#tax-table').append($(tableRow));


                $("#t-state-input").val("");
                $("#t-rate-input").val("");


            },
            error: function (data, status) {
                 var errors3 = data.responseJSON.errors;

                $.each(errors3, function (index, error) {

                    $("#add-flooring-validation-errors3").append(error.fieldName + ": " + error.message + "<br />");

                });
            }

        });


//        alert("after ajax");

    });

    $('#showTaxModal').on('show.bs.modal', function (e) {
        var link = $(e.relatedTarget);

        var taxId = link.data('tax-id');

        $.ajax({
            url: contextRoot + "/adminC/t" + taxId,
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $("#state-name").text(data.state);
                $("#state-rate").text(data.taxRate);


            },
            error: function (data, status) {
                alert('error in show');
            }

        });

    });

    $('#editTaxModal').on('show.bs.modal', function (e) {
        var link = $(e.relatedTarget);

        var taxId = link.data('tax-id');

        $.ajax({
            url: contextRoot + "/adminC/t" + taxId,
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $('#edit-id3').val(data.id);
                $("#edit-state").val(data.state);
                $("#edit-rate").val(data.taxRate);

            },
            error: function (data, status) {
                alert('error edit product modal');
            }

        });

    });

    $("#edit-tax-button").on('click', function (e) {


        e.preventDefault();

        var taxData = JSON.stringify({
            id: $('#edit-id3').val(),
            state: $("#edit-state").val(),
            taxRate: $("#edit-rate").val()

        });

        $.ajax({
            url: contextRoot + "/order/t",
            type: "PUT",
            data: taxData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data, status) {

                $('#editTaxModal').modal('hide');

                var tableRow = buildTaxRow(data);

                $('tax-row-' + data.id).replaceWith($(tableRow));


            },
            error: function (data, status) {
                alert("error product button");
            }

        });


    });

    function buildTaxRow(data) {

        return "<tr id='tax-row-" + data.id + "'>  \n\
                <td><a data-tax-id='" + data.id + "' data-toggle='modal' data-target='#showTaxModal'>" + data.state + "</a></td>  \n\
                <td> " + data.taxRate + "</td>    \n\
                <td> <a data-tax-id='" + data.id + "' data-toggle='modal' data-target='#editTaxModal'>Edit</a>  </td>   \n\
                <td> <a data-tax-id='" + data.id + "' class='delete-link2'>Delete</a>  </td>   \n\
                </tr>  ";


    }

}
);