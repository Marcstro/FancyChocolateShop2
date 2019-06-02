


$('#btnLogIn').click(function () {
    console.log("Här1");
    test = JSON.stringify({"userName": $('#userName').val(), "password": $('#password').val()});
    console.log("test: " + test);

    $.ajax({
        url: 'http://localhost:8080/test',
        // Kan skriva 'type' i stället för method
        method: 'POST',
        // Nedan, datat vi skickar till servern
        data: JSON.stringify({"userName": $('#userName').val(), "password": $('#password').val()}),
        // -- we're letting the server know ahead of time what type of content we're sending
        contentType: "application/json",
        // -- berättar vilken typ av data vi får tillbaka
        dataType: 'json',
        async: false,
        success: function (data) {
            
            console.log("Inne i success!" + JSON.stringify(data));
            $('#POST-test').append(data.userName);
            // $('#POST-test').empty().append(data.toString());
            // $('#POST-test').html(JSON.stringify(data)); // Skapat tagg för att testa
            
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(JSON.stringify("textStatus: " + textStatus));
        }
    });
});


// Denna funkar:
$('#btnLogIn').click(function () {
    $.ajax({
        url: "http://localhost:8080/testGet"
    }).then(function (data) {
        console.log("Inne i funktionen - testGet");
        $('.GET-test').append(data);
    });
});



function checkUserLogin() {

}



// ActionListener till knapp
//var btn = document.querySelector("#btnNewAccount")
//btn.addEventListener("click", showRegistration)


//function showRegistration(){
//    url = "/registration/";
//    $.get(url, function(response){
//       console.log("result för getStockInfo: " + JSON.stringify(response[0]));
//       return response;
//    })
//}


//$(document).ready(function() {
//    $.ajax({
//        url: "http:localhost:8080/greeting"
//    }).then(function(data) {
//       $('.greeting-id').append(data.id);
//       $('.greeting-content').append(data.content);
//    });
//});