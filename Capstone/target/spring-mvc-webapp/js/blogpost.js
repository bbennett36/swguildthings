/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $(".submitCreateSave").on("click", function (e) {

        e.preventDefault();                

        //Save the tinyMCE textarea
        tinyMCE.triggerSave();        
        var strBody = tinyMCE.activeEditor.getContent();
        
        var hashtagList = setHashtagList(strBody);
        
        var statusId = 2;
        if (this.id == "submitCreatePublish") {
            statusId = 1;
        }

        var blogpostData = JSON.stringify({
            title: $("#newPostTitle").val(),
            body: $("#newPostBody").val(),
            categoryId: $("#newCategory").val(),
            startDate: $("#newPostStartDate").val(),
            expirationDate: $("#newPostExpirationDate").val(),
            statusId: statusId,
            authorId: $("#newBlogpostAuthor").val(),
            hashtagList: hashtagList,
            creationDate: "2016-06-22"
        });

        console.log(blogpostData);

        $.ajax({
            url: contextRoot + "/blogpost/",
            type: "POST",
            data: blogpostData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {
                console.log(data);

                $("#newPostTitle").val("");
                $("#newCategory").val("");
                tinyMCE.activeEditor.setContent("");
                $("#newPostStartDate").val("");
                $("#newPostExpirationDate").val("");

                setValuesForCreateModal(data);
                $("#showCreateBlogpostModal").modal();
            },
            error: function (data, status) {

                $("#warnPostTitle").empty();
                $("#warnPostCategory").empty();
                $("#warnPostBody").empty();
                $("#warnPostStartDate").empty();
                $("#warnPostExpirationDate").empty();

                var errors = data.responseJSON.errors;

                $.each(errors, function (index, error) {

                    console.log(error.fieldName + ": " + error.message);

                    switch (error.fieldName) {
                        case "title":
                            $("#warnPostTitle").append(error.message);
                            $("#newPostTitle").addClass("inputError");
                            break;
                        case "category":
                            $("#warnPostCategory").append(error.message);
                            $("#newCategory").addClass("inputError");
                            break;
                        case "body":
                            $("#warnPostBody").append(error.message);
                            $("#newPostBody").addClass("inputError");
                            break;
                        case "startDate":
                            $("#warnPostStartDate").append(error.message);
                            $("#newPostStartDate").addClass("inputError");
                            break;
                        case "expirationDate":
                            $("#warnPostExpirationDate").append(error.message);
                            $("#newPostExpirationDate").addClass("inputError");
                            break;
                        default:
                            break;
                    }
                });
            }
        });
    });

    $("#submitEditSave").on('click', function (e) {

        e.preventDefault();

        //Save the tinyMCE textarea
        tinyMCE.triggerSave();

        console.log(tinyMCE.activeEditor.getContent());
        var strBody = tinyMCE.activeEditor.getContent();

        var hashtagList = strBody.match(/(^|\s)(#[a-z\d-]+)/ig);
        console.log(hashtagList);

        var newHashtagList = new Array();
        if (hashtagList !== null) {
            for (var i = 0; i < hashtagList.length; i++) {
                var strHashtag = hashtagList[i].replace(" #", "");
                newHashtagList.push(strHashtag);
            }
        }

        var blogpostData = JSON.stringify({
            id: $("#edit-id").val(),
            title: $("#editPostTitle").val(),
            body: $("#editPostBody").val(),
            categoryName: $("#editCategory").val(),
            startDate: $("#editPostStartDate").val(),
            expirationDate: $("#editPostExpirationDate").val(),
            status: $("#editStatus").val(),            
            hashtagList: hashtagList            
        });

        console.log(blogpostData);

        $.ajax({
            url: contextRoot + "/blogpost/",
            type: "PUT",
            data: blogpostData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data, status) {

//                var categoryRow = buildCategoryRow(data);
//
//                $('category-row-' + data.id).replaceWith($(categoryRow));

                $("#editPostTitle").val("");
                $("#editCategory").val("");
                tinyMCE.activeEditor.setContent("");
                $("#editPostStartDate").val("");
                $("#editPostExpirationDate").val("");

                setValuesForCreateModal(data);
                $("#showCreateBlogpostModal").modal();



            },
            error: function (data, status) {
                var errors = data.responseJSON.errors;

                $.each(errors, function (index, error) {

                    $("#add-flooring-validation-errors").append(error.fieldName + ": " + error.message + "<br />");

                });
            }

        });


    });

    $(".showPostModal").on("click", function (e) {
        var blogpostId = $(e.target).data("publishpost");

        $.ajax({
            url: contextRoot + "/blogpost/retrieve/" + blogpostId,
            type: "GET",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success: function (data, status) {
                $("#showPublishBlogpostModal").modal();
                setValuesForShowModal(data);
            },
            error: function (data, status) {

            }
        });
    });

    $("#btnPublishPost").on("click", function (e) {

        e.preventDefault();
        //var blogpostId = $(e.target).data("publishpost");
        var blogpostId = $("#blogpostId").text();
        console.log(blogpostId);

        var blogpostData = JSON.stringify({
            id: $("#blogpostId").text(),
            title: $("#blogpostTitle").text()
        });

        $.ajax({
            url: contextRoot + "/blogpost/publish/",
            type: "PUT",
            data: blogpostData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {
                console.log(data);

                var publishedBlogpostRow = buildBlogpostRow(data);
                $("#activePostTbody").append(publishedBlogpostRow);
                $("#blogpostRow-" + blogpostId).remove();

                $("#showPublishBlogpostModal").modal("hide");
            },
            error: function (data, status) {
                var errors = data.responseJSON.errors;
            }
        });
    });

    $(".showArchiveModal").on("click", function (e) {
        var blogpostId = $(e.target).data("archivepost");

        $.ajax({
            url: contextRoot + "/blogpost/retrieve/" + blogpostId,
            type: "GET",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success: function (data, status) {
                $("#showArchiveBlogpostModal").modal();
                setValuesForArchiveModal(data);
            },
            error: function (data, status) {

            }
        });
    });

    $("#btnArchivePost").on("click", function (e) {

        e.preventDefault();

        var blogpostId = $("#archiveBlogpostId").text();
        console.log("Archiving: " + blogpostId);

        var blogpostData = JSON.stringify({
            id: $("#archiveBlogpostId").text(),
            title: $("#archiveBlogpostTitle").text()
        });

        $.ajax({
            url: contextRoot + "/blogpost/archive/",
            type: "PUT",
            data: blogpostData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {
                console.log(data);

                var publishedBlogpostRow = buildBlogpostRow(data);
                $("#archivedPostTbody").append(publishedBlogpostRow);
                $("#blogpostRow-" + blogpostId).remove();

                $("#showArchiveBlogpostModal").modal("hide");
            },
            error: function (data, status) {
                var errors = data.responseJSON.errors;
            }
        });
    });

    function buildBlogpostRow(data) {

        return "<tr id='blogpostRow-" + data.id + "'>  \n\
                    <td> " + data.title + "</td>    \n\
                    <td>" + data.creationDate + "</td>    \n\
                </tr>";
    }

    function setValuesForShowModal(data) {
        $("#blogpostId").text(data.id);
        $("#blogpostTitle").text(data.title);
        $("#blogpostBody").text(data.title);
    }

    function setValuesForArchiveModal(data) {
        $("#archiveBlogpostId").text(data.id);
        $("#archiveBlogpostTitle").text(data.title);
        $("#archiveBlogpostBody").text(data.title);
    }

    function setValuesForCreateModal(data) {
        $("#createBlogpostId").text(data.id);
        $("#createBlogpostTitle").text(data.title);
        $("#createBlogpostBody").text(data.bodyd);
        $("#createBlogpostAuthor").text(data.author.id);
        $("#createBlogpostCreationDate").text(data.creationDate);
    }
    
    function setHashtagList(strBody) {
        var hashtagList = strBody.match(/(^|\s)(#[a-z\d-]+)/ig);
        console.log(hashtagList);

        var newHashtagList = new Array();
        
        if (hashtagList != null) {
            for (var i = 0; i < hashtagList.length; i++) {
                var strHashtag = hashtagList[i].replace(" #", "");
                newHashtagList.push(strHashtag);
            }
        }
        
        return newHashtagList;
    }

    tinymce.init({
        selector: ".tinyMceBody",
        plugins: [
            "advlist autolink lists link image charmap print preview anchor",
            "searchreplace visualblocks code fullscreen",
            "insertdatetime media table contextmenu paste jbimages"

        ],
        toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image jbimages",
        relative_urls: false
    });
});


