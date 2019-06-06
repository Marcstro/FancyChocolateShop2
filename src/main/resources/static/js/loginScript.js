


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
        success: function (data3) {
            if(!$.trim(data3) || !(data3) || data3 === undefined){
                
                //EDIT HUGE FROM MARCUS
                //THIS POINT IS NEVER REACHED
                //data3 cant be null apparently
                //instead if you type wrong pw or username
                //you get to the error catcher 
                
                console.log("Wrong password or username1!");
                $('.POST-test').empty();
                $('.POST-test').append("No that's either incorrect name or password!marcustest21");
            }
            else{
            console.log("Inne 1i success!" + JSON.stringify(data3));
            //$('#VisaMedelande').append("testarmarc");//text("");
            //$('#VisaMedelande').text($("testarmarc").val());
            $('.POST-test').empty();
            $('.POST-test').append("Successfully logged in!");
            
            //OBS OBS 
            //HERE WE ADD THE CODE
            //TO ACCEPT THE PERSON OBJECT THAT WAS SENT BECAUSE HE LOGGED IN CORRECTLY
            //TODO
            sessionStorage.setItem("loggedInPerson", JSON.stringify(data3));
            console.log("Nu loggade " + sessionStorage.getItem("loggedInPerson") + " in");
            }
            
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $('.POST-test').empty();
            $('.POST-test').append("No that's either incorrect name or password!");
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

