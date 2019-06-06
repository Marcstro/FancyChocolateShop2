$('#btnLogIn').click(function () {
    $.ajax({
        //url: 'http://localhost:8080/test',
        url: '/login',
        // Kan skriva 'type' i stället för method
        method: 'POST',
        // Nedan, datat vi skickar till servern
        data: JSON.stringify({"userName": $('#userName').val(), "password": $('#password').val()}),
        // -- we're letting the server know ahead of time what type of content we're sending
        contentType: "application/json",
        // -- berättar vilken typ av data vi får tillbaka
        dataType: 'json',
        async: false,

        //Finns inte personen är data3 null och en hamnar i error som skriver ut ett felmeddelande
        success: function (data3) {
            console.log("Inne i success!" + JSON.stringify(data3));
            $('.POST-test').empty();
            $('.POST-test').append("Successfully logged in!");

            //OBS OBS 
            //HERE WE ADD THE CODE
            //TO ACCEPT THE PERSON OBJECT THAT WAS SENT BECAUSE HE LOGGED IN CORRECTLY
            //TODO
            sessionStorage.setItem("loggedInPerson", JSON.stringify(data3));

            if (data3.admin === true) {
                window.open("/admin", "_self");
            } else {
                window.open("/products", "_self");
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $('.POST-test').empty();
            $('.POST-test').append("No that's either incorrect name or password!");
            document.querySelector(".errorMessage").innerHTML = "Felaktigt användarnamn eller lösen!";
            console.log(JSON.stringify("textStatus: " + textStatus));
        }
    });
});

//kanske behover dom har igen, tog bort for enkelheterns skull
//
//// Denna funkar. Hämtar en String:
//$('#btnLogIn').click(function () {
//    $.ajax({
//        url: "http://localhost:8080/testGet"
//    }).then(function (data) {
//        console.log("Inne 2i funktionen - testGet");
//        $('.GET-test').append(data);
//    });
//});
//
//
//// Denna funkar. Hämtar en Json:
//$('#btnLogIn').click(function () {
//    $.ajax({
//        url: "http://localhost:8080/testGetJson"
//    }).then(function (data2) {
//        console.log("Inne 3i funktionen - testGetJson" + JSON.stringify(data2));
//        $('.GETJson-test').append(data2.userName);
//    });
//});

