
//var productsInCart = [{chocolate:{name:"Chokladtryffel", price:100}, amount:10}, 
//                        {chocolate:{name:"Praliner", price:265}, amount:2}, 
//                        {chocolate:{name:"Chokladägg", price:120}, amount:4}, 
//                        {chocolate:{name:"Chokladhäst", price:673}, amount:8}];

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
    for (i = 0; i < sessionStorage.length; i++) {
        var obj = JSON.parse(sessionStorage.getItem("products" + i));
        if (obj !== null){
            productsInCart.push(obj);
        }
//        console.log("getCart: " + sessionStorage.getItem("products"+i));
//        console.log("getCart_productsInCart: " + productsInCart[i]);
        console.log("getCart, length: " + productsInCart.length);
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
        console.log("length_in_map2: " + productsInCart.length);
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

function addEventListenerRemove(counter) {
    // productsInCart = productsInCart.slice(0, counter).concat(productsInCart.slice(counter + 1));
//    for (i = 0; i < sessionStorage.length; i++) {
//        var obj = JSON.parse(sessionStorage.getItem("products" + i));
//        if (obj !== null){
//            productsInCart.push(obj);
//        }
//        console.log("getCart: " + sessionStorage.getItem("products"+i));
//        console.log("getCart_productsInCart: " + productsInCart[i]);
//        console.log("getCart_length: " + productsInCart.length);
//    }
    
    console.log("längd före: " + sessionStorage.length);
    console.log("Lista före: " + JSON.stringify(getProducts()));
    console.log("Borttagen choklad: " + JSON.parse(sessionStorage.getItem("products" + counter)));
    sessionStorage.removeItem("products" + counter);
    console.log("längd efter: " + sessionStorage.length);
    console.log("lista efter: " + JSON.stringify(getProducts()));
    
    document.querySelector(".collapsible").innerHTML = "";
    getProducts();
}

function thankYou() {
    
    console.log(sessionStorage.getItem("loggedInPerson"));
    var a =1;
    if(sessionStorage.getItem("loggedInPerson")){
        a++;
    }
    //if(sessionStorage.getItem("loggedInPerson") !== null || sessionStorage.getItem("loggedInPerson") !== undefined ){
     if(a>1){   
    console.log("Du har korrekt kommit in i thankYou, som ar kop-funktionen");
    document.querySelector(".collapsible").innerHTML = "Tack för ditt köp!!";
    console.log("Nu handlade " + sessionStorage.getItem("loggedInPerson") + "!");
    
    
    var choklader = [];

    for (i = 0; i < sessionStorage.length; i++) {
          var obj = JSON.parse(sessionStorage.getItem("products" + i));
          if (obj !== null && !obj.hasOwnProperty('userName')){
              choklader.push(obj);
          }
    }
    console.log(choklader);
    
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
