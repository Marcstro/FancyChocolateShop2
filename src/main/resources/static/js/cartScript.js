

var productsInCart = [];

$(document).ready(function () {
    getCart();
});


// ANVÄNDS INTE, VA?
function getCustomer() {
    var person = JSON.parse(sessionStorage.getItem("loggedInPerson"));
    // console.log("personFromStorage: " + JSON.stringify(person));
}

function getCart() {
    productsInCart.length = 0;
    for (i = 0; i < sessionStorage.length; i++) {
        var keyName = sessionStorage.key(i);
        var obj = JSON.parse(sessionStorage.getItem(keyName));
        console.log(i + ". key(index): " + sessionStorage.key(i));
        
        if (keyName !== "loggedInPerson"){
            productsInCart.push(obj);
            console.log(i + ". Obj som läggs till: " + sessionStorage.key(i));
        }

    }
    getProducts();
}


function getProducts() {
    var ProductHTML = `<table class="highlight cartItems"><thead>
                            <tr class="row">
                                <th class="cartColumnChocolate">Choklad</th>
                                <th class="cartColumn">Pris</th>
                                <th class="cartColumn">Antal</th>
                                <th class="cartColumn"></th>
                            </tr>
                        </thead>
                        <tbody>`;
    var counter = 0;

    productsInCart.map((x, i) => {
        ProductHTML += `<tr class="row">
                            <td class="cartColumnChocolate"><p>${x.name}</p></td>
                            <td class="cartColumn"><p>${x.price}</p></td>
                            <td class="cartColumn"><p>${x.amount}</p></td>
                            <td class="cartColumn"><a class="pink lighten-5 black-text btn removeButton" id="1" onClick="addEventListenerRemove(${counter})">Ta bort</a></td>
                        </tr>`;
        counter++;
        // console.log("length_in_map2: " + productsInCart.length);
    });

    ProductHTML += `</tbody></table>`;

    var totalSum = 0;
    productsInCart.map(x => {
        totalSum += x.price * x.amount;
    });

    var discount = 0;
    var sumToPay = totalSum;
    if (true) {
        discount = 10;
        sumToPay = (totalSum * 0.9).toFixed(2);
    }

    totalSum = (totalSum).toFixed(2);

    ProductHTML += `<table>
                        <thead>
                            <tr class="row">
                                <td class="cartColumnChocolate"><p class="titleText">Totalsumma</p></td>
                                <td class="cartColumn"><p class="titleText">Rabatt</p></td>
                                <td class="cartColumn"><p class="titleText">Att betala</p></td>
                                <td class="cartColumn"></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="row">
                                <td class="cartColumnChocolate"><p>${totalSum}kr</p></td>
                                <td class="cartColumn"><p>${discount}%</p></td>
                                <td class="cartColumn"><p>${sumToPay}kr</p></td>
                                <td class="cartColumn"><a class="pink lighten-5 black-text btn removeButton" id="1" onClick="thankYou()">Köp</a></td>
                            </tr>
                        </tbody>
                    </table>`;

    document.querySelector(".collapsible").innerHTML += ProductHTML;
}

function addEventListenerRemove(counter, x) {
    
    // Ta reda på vilket obj som hör ihop med counter.
    var objToDelete = productsInCart[counter];
    var nameOnObjToDelete = objToDelete.name;
    console.log("nameOnObjToDelete: " + nameOnObjToDelete);
    
    // Hålla reda på om chokladobjektet tagits bort
    var chocolateRemoved = false;
    // Matcha namnet på produkten med ett nyckelvärde i sessionStorage
    for (i = 0; i < sessionStorage.length; i++) {
        var keyNameToRemove = sessionStorage.key(i);
        var objToRemove = JSON.parse(sessionStorage.getItem(keyNameToRemove));
        
        if (!chocolateRemoved && keyNameToRemove !== "loggedInPerson"){
            // Kolla att värdet inte är null
            if (objToRemove !== null){
                var nameOnSessionObjChocolate = objToRemove.name;
                console.log("nameOnSessionObjChocolate: " + nameOnSessionObjChocolate);
                // Överensstämmer namnen? Ta bort objektet.
                if (nameOnObjToDelete === nameOnSessionObjChocolate){
                    sessionStorage.removeItem(keyNameToRemove);
                    console.log("key on removed chocolate: " + keyNameToRemove);
                    chocolateRemoved = true;
                }
            }
        }
    }
    // Tömma elementet som ska fyllas. Denna funkar.
    $('.collapsible').empty();
    // Fylla på element och choklader igen
    getCart();  
}

function thankYou() {
    
    // console.log(sessionStorage.getItem("loggedInPerson"));
    var a =1;
    if(sessionStorage.getItem("loggedInPerson")){
        a++;
    }
    //if(sessionStorage.getItem("loggedInPerson") !== null || sessionStorage.getItem("loggedInPerson") !== undefined ){
     if(a>1){   
    // console.log("Du har korrekt kommit in i thankYou, som ar kop-funktionen");
    document.querySelector(".collapsible").innerHTML = "";
    document.querySelector(".thankYou").innerHTML = 
                `<div class="row">
                    <div class="col s12 m8 offset-m3 l8 offset-l3 xl8 offset-xl3">
                        <p class="dreamyFont3">Tack för ditt köp! Välkommen åter!</p>
                    </div>
                </div>`;
    console.log("Nu handlade " + sessionStorage.getItem("loggedInPerson") + "!");
    
    
    var choklader = [];

    for (i = 0; i < sessionStorage.length; i++) {
          var obj = JSON.parse(sessionStorage.getItem("products" + i));
          if (obj !== null && !obj.hasOwnProperty('userName')){
              choklader.push(obj);
          }
    }
    
    $.ajax({
        url: '/purchase',
        method: 'POST',             
            //data: JSON.stringify({"name": $('#firstName').val()}),
            
            data: JSON.stringify({
                "person": JSON.parse(sessionStorage.getItem("loggedInPerson")), 
                "chocolates": choklader,
            }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            
            success: function(kopet){
                $('.GETJson-test').append("Added data03");
                if(kopet.correct) {
                    //$('.result-message').empty().append("The result is correct! Congratulations!");
                    console.log("registrationscript.js fungerade");
                    console.log("du kom in i success: worked");
                    //$('.GETJson-test').append("Added data01");
                     logOut();
                } else {
                   // $('.result-message').empty().append("Ooops that's not correct! But keep trying!");
                   console.log("registrationscript.js fungerade");
                   console.log("du kom in i success: else");
                   
                   logOut();
                   //$('.GETJson-test').append("Added data02");
                }
                //HERE WE NEED TO CLEAR CART
            }
        });
    }
    else{
        console.log("OBS ingen inloggad person!");
    }
}

function logOut(){
    sessionStorage.setItem("loggedInPerson",null);
    sessionStorage.clear();
}

function updateAmount(counter) {
    productsInCart[counter].amount;
}
