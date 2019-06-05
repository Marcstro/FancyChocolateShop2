
//var productsInCart = [{chocolate:{name:"Chokladtryffel", price:100}, amount:10}, 
//                        {chocolate:{name:"Praliner", price:265}, amount:2}, 
//                        {chocolate:{name:"Chokladägg", price:120}, amount:4}, 
//                        {chocolate:{name:"Chokladhäst", price:673}, amount:8}];

var productsInCart = [];

$(document).ready(function () {
    getCart();
});


function getCustomer() {
    var person = JSON.parse(sessionStorage.getItem("loggedInPerson"));
    console.log("personFromStorage: " + JSON.stringify(person));
}

function getCart() {
    for (i = 0; i < sessionStorage.length; i++) {
        var obj = JSON.parse(sessionStorage.getItem("products" + i));
        if (obj !== null){
            productsInCart.push(obj);
        }
        console.log("getCart: " + sessionStorage.getItem("products"+i));
        console.log("getCart_productsInCart: " + productsInCart[i]);
        console.log("getCart_length: " + productsInCart.length);
    }

    // TEST! Denna ska väl användas på annat ställe sedan. 
    // getCustomer();
    // setTimeout(getProducts, 1000);
    getProducts();

}


function getProducts() {

    console.log(productsInCart[0].name);
    console.log("length: " + productsInCart.length);

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
        console.log("productsInCart: " + JSON.stringify(productsInCart));
        console.log("length_in_map: " + productsInCart.length);
        // console.log("x.name: " + x.name);
        // console.log("counter: " + counter + "x: " + JSON.stringify(x)); 
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
    productsInCart = productsInCart.slice(0, counter).concat(productsInCart.slice(counter + 1));
    document.querySelector(".collapsible").innerHTML = "";
    getProducts();
}

function thankYou() {
    document.querySelector(".collapsible").innerHTML = "";
    document.querySelector(".thankYou").innerHTML = 
                `<div class="row">
                    <div class="col s12 m8 offset-m3 l8 offset-l3 xl8 offset-xl3">
                        <p class="dreamyFont3">Tack för ditt köp! Välkommen åter!</p>
                    </div>
                </div>`;
}

function updateAmount(counter) {
    productsInCart[counter].amount;
}
