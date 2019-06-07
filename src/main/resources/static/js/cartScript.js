var productsInCart = [];

$(document).ready(function () {
    getCart();
});

function getCart() {
    productsInCart.length = 0;
    for (i = 0; i < sessionStorage.length; i++) {
        var keyName = sessionStorage.key(i);
        var obj = JSON.parse(sessionStorage.getItem(keyName));

        if (keyName !== "loggedInPerson") {
            productsInCart.push(obj);
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
    });

    ProductHTML += `</tbody></table>`;

    var totalSum = 0;
    productsInCart.map(x => {
        totalSum += x.price * x.amount;
    });

    //Om det sedan ska läggas till premiumkunder kan en kolla det och ge rabatt här
    var discount = 0;
    var sumToPay = totalSum;

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

    // Hålla reda på om chokladobjektet tagits bort
    var chocolateRemoved = false;
    // Matcha namnet på produkten med ett nyckelvärde i sessionStorage
    for (i = 0; i < sessionStorage.length; i++) {
        var keyNameToRemove = sessionStorage.key(i);
        var objToRemove = JSON.parse(sessionStorage.getItem(keyNameToRemove));

        if (!chocolateRemoved && keyNameToRemove !== "loggedInPerson") {
            // Kolla att värdet inte är null
            if (objToRemove !== null) {
                var nameOnSessionObjChocolate = objToRemove.name;
                // Överensstämmer namnen? Ta bort objektet.
                if (nameOnObjToDelete === nameOnSessionObjChocolate) {
                    sessionStorage.removeItem(keyNameToRemove);
                    chocolateRemoved = true;
                }
            }
        }
    }
    $('.collapsible').empty();
    getCart();
}

function thankYou() {
    var a = 1;
    if (sessionStorage.getItem("loggedInPerson")) {
        a++;
    }
    
    if (a > 1) {
        document.querySelector(".collapsible").innerHTML = "";
        document.querySelector("#headerLinks").innerHTML = `<li><a href="http://localhost:8080/index" class="black-text">Startsidan</a></li>`;
        document.querySelector(".thankYou").innerHTML =
                `<div class="row">
                    <div class="col s12 m8 offset-m3 l8 offset-l3 xl8 offset-xl3">
                        <p class="dreamyFont3">Tack för ditt köp! Välkommen åter!</p>
                    </div>
                </div>`;

        var choklader = [];

        for (i = 0; i < sessionStorage.length; i++) {
            var obj = JSON.parse(sessionStorage.getItem("products" + i));
            if (obj !== null && !obj.hasOwnProperty('userName')) {
                choklader.push(obj);
            }
        }

        $.ajax({
            url: '/purchase',
            method: 'POST',
            data: JSON.stringify({
                "person": JSON.parse(sessionStorage.getItem("loggedInPerson")),
                "chocolates": choklader,
            }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,

            success: function (kopet) {
                $('.GETJson-test').append("Added data03");
                if (kopet.correct) {
                    logOut();
                } else {
                    logOut();
                }
            }
        });
    } else {
        console.log("No one is logged in");
    }
}

function logOut() {
    sessionStorage.clear();
}

function updateAmount(counter) {
    productsInCart[counter].amount;
}