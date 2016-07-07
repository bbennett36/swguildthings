/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {   
    
    $("#openQuoteModal").on("click", function () {



        $("#createQuoteModal").modal();
    });

    $("#submitQuote").on("click", function (e) {
        e.preventDefault();

        var quoteData = JSON.stringify({
            firstName: $("#fName").val(),
            lastName: $("#lName").val(),
            email: $("#email").val(),
            selectedMake: $("#makes").val(),
            selectedModel: $("#models").val(),
            year: $("#year").val(),
            description: $("#desc").val()
        });

        console.log(quoteData);

        $.ajax({
            url: contextRoot + "/quote/create",
            type: "POST",
            data: quoteData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {
                console.log(data);

                $("#createQuoteModal").modal('hide');
                $("#myModal").modal();


//                var categoryRow = buildCategoryRow(data);
//                $("#activePostTbody").append($(categoryRow));
//
////                $("#category").val("");
//                $('#createCategoryModal').modal('hide');


            },
            error: function (data, status) {

//                $("#warnPostTitle").empty();
//
//                var errors = data.responseJSON.errors;
//
//                $.each(errors, function (index, error) {
//
//                    console.log(error.fieldName + ": " + error.message);
//
//                    switch (error.fieldName) {
//                        case "category":
//                            $("#warnPostTitle").append(error.message);
//                            $("#newCategory").addClass("inputError");
//                            break;
//                        default:
//                            break;
//                    }
//                });
            }
        });

    });


    var makesDiv = $("#makes");
    var modelsDiv = $("#models");
    $.ajax({
        type: "GET",
        url: "https://api.edmunds.com/api/vehicle/v2/makes?fmt=json&api_key=czhvz3kxx292388aq44m6ykw&state=new&view=full",
        dataType: 'json',
        success: function (makes, models) {
            console.log(makes);
            var output = "<select>";
            for (var i in makes.makes) {
                output += "<option>" + makes.makes[i].name + "</option>";
            }
            output += "</select>";
            makesDiv.html(output);


            var output2 = "<select>";

            for (var j in makes.makes[i].models) {
                output2 += "<option>" + makes.makes[i].models[j].name + "</option>";
            }
            output2 += "</select>";
            modelsDiv.html(output2);
        },
        error: function (data, status) {
        }
    });



});