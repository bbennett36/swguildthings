/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $("#submitCreateUser").on("click", function (e) {

        e.preventDefault();

        var roleIdList = new Array();
        $("#bootstrap-duallistbox-selected-list_availableRoles option").each(function () {
            roleIdList.push($(this).val());
        });

        console.log(roleIdList);

        var userData = JSON.stringify({
            username: $("#newUsername").val(),
            firstName: $("#newUserFirstName").val(),
            lastName: $("#newUserLastName").val(),
            email: $("#newUserEmail").val(),
            password: $("#newUserPassword").val(),
            roleIdList: roleIdList
        });

        console.log(userData);

        $.ajax({
            url: contextRoot + "/userroles/",
            type: "POST",
            data: userData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {
                console.log("UserData: " + data);

                $("#newUsername").val("");
                $("#newUserFirstName").val("");
                $("#newUserLastName").val("");
                $("#newUserEmail").val("");
                $("#newUserPassword").val("");
                $("#newUserConfirmPassword").val("");

                setValuesForCreateUserModal(data);
                $("#createUserModal").modal();
            },
            error: function (data, status) {

                $("#warnUsername").empty();
                $("#warnUserFirstName").empty();
                $("#warnUserLastName").empty();
                $("#warnUserEmail").empty();
                $("#warnUserPassword").empty();
                $("#warnConfirmPassword").empty();

                var errors = data.responseJSON.errors;

                $.each(errors, function (index, error) {

                    console.log(error.fieldName + ": " + error.message);

                    switch (error.fieldName) {
                        case "username":
                            $("#warnUsername").append(error.message);
                            $("#newUsername").addClass("inputError");
                            break;
                        case "firstName":
                            $("#warnUserFirstName").append(error.message);
                            $("#newUserFirstName").addClass("inputError");
                            break;
                        case "lastName":
                            $("#warnUserLastName").append(error.message);
                            $("#newUserLastName").addClass("inputError");
                            break;
                        case "email":
                            $("#warnUserEmail").append(error.message);
                            $("#newUserEmail").addClass("inputError");
                            break;
                        case "password":
                            $("#warnUserPassword").append(error.message);
                            $("#newUserPassword").addClass("inputError");
                            break;
                        case "expirationDate":
                            $("#warnConfirmPassword").append(error.message);
                            $("#newUserConfirmPassword").addClass("inputError");
                            break;
                        default:
                            break;
                    }
                });
            }
        });
    });
    
    $("#submitUpdateUser").on("click", function (e) {
        
        e.preventDefault();
        var userId = $("#editUserId").val();

        var userData = JSON.stringify({
            id: userId,
            username: $("#editUsername").val(),
            firstName: $("#editUserFirstName").val(),
            lastName: $("#editUserLastName").val(),
            email: $("#editUserEmail").val()            
        });

        console.log(userData);

        $.ajax({
            url: contextRoot + "/userroles/",
            type: "PUT",
            data: userData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {
                console.log("UserData: " + data);

                $("#newUsername").val("");
                $("#newUserFirstName").val("");
                $("#newUserLastName").val("");
                $("#newUserEmail").val("");
                $("#newUserPassword").val("");
                $("#newUserConfirmPassword").val("");

                setValuesForCreateUserModal(data);
                $("#createUserModal").modal();
            },
            error: function (data, status) {
            
            }
        });
    });

    $('#showUserModal').on('show.bs.modal', function (e) {

        var link = $(e.relatedTarget);
        var userId = link.data("userid");

        $.ajax({
            url: contextRoot + "/userroles/user/" + userId,
            type: "GET",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success: function (data, status) {
                setValuesForShowUserModal(data);
                console.log(data);
            },
            error: function (data, status) {

            }
        });
    });

    $('[name=availableRoles]').bootstrapDualListbox();

    function setValuesForCreateUserModal(data) {
        $("#createUserId").text(data.id);
        $("#createUserFirstName").text(data.firstName);
        $("#createUserLastName").text(data.lastName);
        $("#createUserEmail").text(data.email);

        if (data.userRoles != null) {
            for (var i = 0; i < data.userRoles.length; i++) {
                var strRoleData = "<div>" + data.userRoles[i].role + "</div>";
                $("#tdRoles").append(strRoleData);
            }
        }
    }

    function setValuesForShowUserModal(data) {
        $("#userId").text(data.id);
        $("#userName").text(data.username);
        $("#userFirstName").text(data.firstName);
        $("#userLastName").text(data.lastName);
        $("#userEmail").text(data.email);

        if (data.userRoles != null) {
            for (var i = 0; i < data.userRoles.length; i++) {
                var strRoleData = "<div>" + data.userRoles[i].role + "</div>";
                $("#tdUserRoles").append(strRoleData);
            }
        }
    }
});


