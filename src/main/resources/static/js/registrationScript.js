$('#btnLogIn').click(function () {
    var helnamn = $('#firstName').val() + " " + $('#lastName').val();
    $.ajax({
        url: '/registration',
        method: 'POST',
        data: JSON.stringify({
            "name": helnamn,
            "userName": $('#username').val(),
            "password": $('#password').val(),
            "address": $('#address').val(),
        }),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        async: false,

        success: function (registration) {
            $('.GETJson-test').append("Added data03");
            if (registration.correct) {
                $('.GETJson-test').append("Added data01");
            } else {
                $('.GETJson-test').append("Added data02");
            }
        }
    });
});