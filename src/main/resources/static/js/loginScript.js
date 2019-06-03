


$('#btnLogIn').click(function () {

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
            $('.POST-test').append(data.userName);
            
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(JSON.stringify("textStatus: " + textStatus));
        }
    });
});


// Denna funkar. Hämtar en String:
$('#btnLogIn').click(function () {
    $.ajax({
        url: "http://localhost:8080/testGet"
    }).then(function (data) {
        console.log("Inne i funktionen - testGet");
        $('.GET-test').append(data);
    });
});


// Denna funkar. Hämtar en Json:
$('#btnLogIn').click(function () {
    $.ajax({
        url: "http://localhost:8080/testGetJson"
    }).then(function (data) {
        console.log("Inne i funktionen - testGetJson" + JSON.stringify(data));
        $('.GETJson-test').append(data.userName);
    });
});

