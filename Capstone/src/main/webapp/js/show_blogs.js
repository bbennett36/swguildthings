/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    $("#submitComment").on("click", function (e) {

        e.preventDefault();


        var commentData = JSON.stringify({
            comment: $("#comment").val(),
            blogPostId: $("#blogId").val()
        });

//        console.log(commentData);

        $.ajax({
            url: contextRoot + "/blogpost/c",
            type: "POST",
            data: commentData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {
                console.log(data);

                $('#btnCommentCollapse').modal('hide');
                comment: $("#comment").val("");

                var commentRow = buildCommentRow(data);
                $("#showComments").append($(commentRow));

            },
            error: function (data, status) {

            }
        });
    });
    function buildCommentRow(data) {

        return "<tr id='category-row-" + data.id + "'>  \n\
                <td> " + data.userName + "</td>    \n\
                <td> " + data.comment + "</td>    \n\
                <td> " + data.commentDate + "</td>    \n\
                </tr>  ";
    }
});