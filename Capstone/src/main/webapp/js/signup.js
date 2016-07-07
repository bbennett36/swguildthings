/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//$(document).ready(function () {

//    $("#signUp").on("click", function (e) {
//        e.preventDefault();
//
//        var userData = JSON.stringify({
//            category: $("#newCategory").val()
//        });
//
//        console.log(categoryData);
//
//        $.ajax({
//            url: contextRoot + "/login/createUser",
//            type: "POST",
//            data: userData,
//            dataType: "json",
//            beforeSend: function (xhr) {
//                xhr.setRequestHeader("Accept", "application/json");
//                xhr.setRequestHeader("Content-type", "application/json");
//            },
//            success: function (data, status) {
//                console.log(data);
//
//                var categoryRow = buildCategoryRow(data);
//                $("#activePostTbody").append($(categoryRow));
//
////                $("#category").val("");
//                $('#createCategoryModal').modal('hide');
//
//
//            },
//            error: function (data, status) {
//
////                $("#warnPostTitle").empty();
////
////                var errors = data.responseJSON.errors;
////
////                $.each(errors, function (index, error) {
////
////                    console.log(error.fieldName + ": " + error.message);
////
////                    switch (error.fieldName) {
////                        case "category":
////                            $("#warnPostTitle").append(error.message);
////                            $("#newCategory").addClass("inputError");
////                            break;
////                        default:
////                            break;
////                    }
////                });
//            }
//        });
//
//    });
//});