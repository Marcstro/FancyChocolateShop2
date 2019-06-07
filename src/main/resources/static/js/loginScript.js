$('#btnLogIn').click(function () {
    $.ajax({
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
            $('.POST-test').empty();
            $('.POST-test').append("Successfully logged in!");
            
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