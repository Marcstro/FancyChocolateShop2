/* 
 * Javautveckling 2018
 * marcus was here
 */

//$('#btnLogIn').click(function () {
//
//    $.ajax({
//        url: 'http://localhost:8080/test',
//        // Kan skriva 'type' i stället för method
//        method: 'POST',
//        // Nedan, datat vi skickar till servern
//        data: JSON.stringify({"userName": $('#userName').val(), "password": $('#password').val()}),
//        // -- we're letting the server know ahead of time what type of content we're sending
//        contentType: "application/json",
//        // -- berättar vilken typ av data vi får tillbaka
//        dataType: 'json',
//        async: false,
//        success: function (data) {
//            console.log("Inne 1i success!" + JSON.stringify(data));
//            $('.POST-test').append(data.userName);
//            
//        },
//        error: function (jqXHR, textStatus, errorThrown) {
//            console.log(JSON.stringify("textStatus: " + textStatus));
//        }
//    });
//});

$('#btnLogIn').click(function () {
    var helnamn = $('#firstName').val() + " " + $('#lastName').val();
    $.ajax({
        url: '/registration',
        method: 'POST',             
            //data: JSON.stringify({"name": $('#firstName').val()}),
            
            data: JSON.stringify({"name": helnamn, 
                "userName": $('#username').val(),
                "password": $('#password').val(),
                "address": $('#address').val(),
            }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            
            success: function(registration){
                $('.GETJson-test').append("Added data03");
                if(registration.correct) {
                    //$('.result-message').empty().append("The result is correct! Congratulations!");
                    console.log("registrationscript.js fungerade");
                    $('.GETJson-test').append("Added data01");
                } else {
                   // $('.result-message').empty().append("Ooops that's not correct! But keep trying!");
                   console.log("registrationscript.js fungerade");
                   $('.GETJson-test').append("Added data02");
                }
            }
        });

    });
//    
//$('#btnNewAccount').click(function () {
//    $.ajax({
//        url: '/registration',
//        method: 'POST',             
//            //data: JSON.stringify({"name": $('#firstName').val()}),
//            data: JSON.stringify({"name": $('#firstName').val()}),
//            contentType: "application/json; charset=utf-8",
//            dataType: "json",
//            async: false,
//            
//            success: function(registration){
//                $('.GETJson-test').append("Added data03");
//                if(registration.correct) {
//                    //$('.result-message').empty().append("The result is correct! Congratulations!");
//                    console.log("registrationscript.js fungerade");
//                    $('.GETJson-test').append("Added data01");
//                } else {
//                   // $('.result-message').empty().append("Ooops that's not correct! But keep trying!");
//                   console.log("registrationscript.js fungerade");
//                   $('.GETJson-test').append("Added data02");
//                }
//            }
//        });
//
//    });
//


//
//$(document).ready(function() {
//    //$('#btnLogIn').click(function () {
//
//    //updateMultiplication();
//console.log("steg1 naddes");
//    $("#attempt-form").submit(function( event ) {
//console.log("Steg2 naddes");
//        // Don't submit the form normally
//        event.preventDefault();
//
//        // Get some values from elements on the page
////        var namnet = $('')
////        var a = $('firstName').text()();
////        //var b = $('.multiplication-b').text();
////        var $form = $( this ),
////            attempt = $form.find( "input[name='result-attempt']" ).val(),
////            userAlias = $form.find( "input[name='user-alias']" ).val();
////
////        // Compose the data in the format that the API is expecting
////        var data = { user: { alias: userAlias}, multiplication: {factorA: a, factorB: b}, resultAttempt: attempt};
//
//        // Send the data using post
//        $.ajax({
//            url: '/registration',
//            type: 'POST',
//            data: JSON.stringify({"userName": $('#firstName').val()}),
//            contentType: "application/json; charset=utf-8",
//            dataType: "json",
//            async: false,
//            success: function(data){
//                if(result.correct) {
//                    //$('.result-message').empty().append("The result is correct! Congratulations!");
//                    console.log("registrationscript.js fungerade");
//                } else {
//                   // $('.result-message').empty().append("Ooops that's not correct! But keep trying!");
//                   console.log("registrationscript.js fungerade");
//                }
//            }
//        });
//
//       // updateMultiplication();
//    });
//});
//
//$('#btnLogIn').click(function () {
//  console.log("steg3 naddes");  
//  $.ajax({
//        url: 'http://localhost:8080/test',
//        // Kan skriva 'type' i stället för method
//        method: 'POST',
//        // Nedan, datat vi skickar till servern
//        data: JSON.stringify({"userName": $('#userName').val(), "password": $('#password').val()}),
//        // -- we're letting the server know ahead of time what type of content we're sending
//        contentType: "application/json",
//        // -- berättar vilken typ av data vi får tillbaka
//        dataType: 'json',
//        async: false,
//        success: function (data) {
//            console.log("Inne 1i success!" + JSON.stringify(data));
//            $('.POST-test').append(data.userName);
//            
//        },
//        error: function (jqXHR, textStatus, errorThrown) {
//            console.log(JSON.stringify("textStatus: " + textStatus));
//        }
//    });
//});
//btnNewAccount
//
//$('#btnNewAccount').click(function () {
//    console.log("steg4 naddes"); 
//    $.ajax({
//        url: 'http://localhost:8080/test',
//        // Kan skriva 'type' i stället för method
//        method: 'POST',
//        // Nedan, datat vi skickar till servern
//        data: JSON.stringify({"userName": $('#userName').val(), "password": $('#password').val()}),
//        // -- we're letting the server know ahead of time what type of content we're sending
//        contentType: "application/json",
//        // -- berättar vilken typ av data vi får tillbaka
//        dataType: 'json',
//        async: false,
//        success: function (data) {
//            console.log("Inne 1i success!" + JSON.stringify(data));
//            $('.POST-test').append(data.userName);
//            
//        },
//        error: function (jqXHR, textStatus, errorThrown) {
//            console.log(JSON.stringify("textStatus: " + textStatus));
//        }
//    });
//    });
