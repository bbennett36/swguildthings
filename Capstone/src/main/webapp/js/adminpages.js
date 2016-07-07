/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    $('#submitCreateNewAdminPage').on('click', function (e) {

        e.preventDefault();
        tinyMCE.triggerSave();
        var adminPageData = JSON.stringify({
            pageName: $('#newPageName').val(),            
            pageBody: $('#newPageBody').val(),
            statusId: $('#pageStatus').val()

        });
        $.ajax({
            url: contextRoot + "/adminpages/",
            type: "POST",
            data: adminPageData,
            dataType: 'json',
            beforeSend: function (xhr) {

                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {

                console.log(data);
                var tableRow = buildAdminPagesRow(data);
                $('#activePostTbody').append($(tableRow));
                $('#draftAdminPageTbody').append($(tableRow));
                $('#archivedPostTbody').append($(tableRow));
                $('#newPageName').val('');
                $('#newSequence').val('');
                $('#newPageBody').val('');
                tinyMCE.activeEditor.setContent('');
                $('#printPageAdded').html("Static Page Added.");
                window.location = contextRoot + "/adminpages/pages";
            },
            error: function (data, status) {
//                alert("error");


//                console.log(data.errors)
                $('#warnPageName').empty();
                $('#warnPageSequence').empty();
                $('#warnPageBody').empty();
                var errors = data.responseJSON.errors;
                $.each(errors, function (index, error) {
//                    console.log(error);
//                    $('#add-dvd-validation-errors').append(error.fieldName+": "+error.message+"<br/>");

                    switch (error.fieldName) {

                        case "pageName":
                            $('#warnPageName').append(error.message);
                            break;
                        case "sequence":
                            $('#warnPageSequence').append(error.message);
                            break;
                        case "pageBody":
                            $('#warnPageBody').append(error.message);
                            break;
                        default:
                            break;
                    }
                });
            }
        });
    });
    
    $('#edit-adminpage-button').on("click", function (e) {
        e.preventDefault();
        tinyMCE.triggerSave();
        var adminPageEditData = JSON.stringify({
            id: $('#edit-id').val(),
            pageName: $('#edit-page-name').val(),
            sequence: $('#edit-page-sequence').val(),
            pageBody: $('#edit-page-body').val(),
            authorId: $('#edit-author-id').val(),
            statusId: $('#edit-page-status').val()

        });
        $.ajax({
            url: contextRoot + "/adminpages/",
            type: "PUT",
            data: adminPageEditData,
            dataType: 'json',
            beforeSend: function (xhr) {

                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {

                window.location = contextRoot + "/adminpages/pages";
                var tableRow = buildAdminPagesRow(data);
                console.log(data);
            },
            error: function (data, status) {
                //alert("error");
                $('#warnEditPageName').empty();
                $('#warnEditPageSequence').empty();
                $('#warnEditPageBody').empty();
                var errors = data.responseJSON.errors;
                $.each(errors, function (index, error) {
//                    console.log(error);
//                    $('#add-dvd-validation-errors').append(error.fieldName+": "+error.message+"<br/>");

                    switch (error.fieldName) {

                        case "pageName":
                            $('#warnEditPageName').append(error.message);
                            break;
                        case "sequence":
                            $('#warnEditPageSequence').append(error.message);
                            break;
                        case "pageBody":
                            $('#warnEditPageBody').append(error.message);
                            break;
                        default:
                            break;
                    }


                });
            }


        });
        //alert("alert after ajax."); 
    });
    
    $("#submitOrderAdminpages").on("click", function (e) {
        e.preventDefault();
        
        var intSequence = 0;
        var rowCount = $('#activePostTbody').children('tr').length;        
        
        $('#activePostTbody > tr').each(function() {
           var objRow = $(this);
           pageId = $(objRow).attr("id");
           pageId = pageId.substring(pageId.length - 1);           
           
            intSequence++;
           
            var adminPageData = JSON.stringify({
                id: pageId,
                sequence: intSequence});
                
            $.ajax({
                url: contextRoot + "/adminpages/orderpages",
                type: "PUT",
                data: adminPageData,
                dataType: 'json',
                beforeSend: function (xhr) {

                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-type", "application/json");                    
                    
                },
                success: function (data, status) {
                    //window.location = contextRoot + "/adminpages/pages";                    
                    console.log(data);
                },
                error: function (data, status) {
                    
                }
            });            
        });
        
        if (intSequence == rowCount) {
            window.location.reload();
        }
    });

    $('#showAdminpageModal').on('show.bs.modal', function(e) {
        
        var link = $(e.relatedTarget);
        var pageId = link.data("pageid");
        console.log("Get: " + pageId);
        
        $.ajax({
            url: contextRoot + "/adminpages/retrieve/" + pageId,
            type: "GET",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success: function (data, status) {                
                setValuesForShowPageModal(data);
                console.log(data);
            },
            error: function (data, status) {
                alert("Error retrieving Page: " + pageId);
            }
        });
    });

    function buildAdminPagesRow(data) {

        return "<tr id='adminpage-" + data.id + "'>  \n\
                    <td>" + data.pageName + "</td>    \n\
                    <td>" + data.creationDate + "</td>    \n\
                    <td>" + data.status.blogStatus + "</td>    \n\
                </tr>";
    }
    
    function setValuesForShowPageModal(data) {
        $("#pageId").text(data.id);
        $("#pageTitle").text(data.pageName);
        $("#pageStatus").text(data.status.blogStatus);
        $("#pageCreationDate").text(data.creationDate);
        $("#pageAuthor").text(data.author.username);
        $("#pageLastModifiedDate").text(data.lastModifiedDate);
        //$("#pageLastModifiedBy").text(data.lastModifiedBy);
    }

    $(function() {
        $("#activePostTbody").sortable( {
            containment: "parent",
            cursor: "move"
        });
    }); 

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