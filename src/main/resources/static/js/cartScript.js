
var productsInCart = [{chocolate:{name:"Chokladtryffel", price:100}, amount:10}, 
                        {chocolate:{name:"Praliner", price:265}, amount:2}, 
                        {chocolate:{name:"Chokladägg", price:120}, amount:4}, 
                        {chocolate:{name:"Chokladhäst", price:673}, amount:8}];

$(document).ready(function(){
    getProducts();
});

function getProducts(){
    var ProductHTML = ` <table class="highlight cartItems"><thead>
                            <tr class="row">
                                <th class="cartColumnChocolate">Choklad</th>
                                <th class="cartColumn">Pris</th>
                                <th class="cartColumn">Antal</th>
                                <th class="cartColumn"></th>
                            </tr>
                        </thead>
                        <tbody>`;

                    
    var counter = 0;
    productsInCart.map(x => {
        ProductHTML += `<tr class="row">
                            <td class="cartColumnChocolate"><p>${x.chocolate.name}</p></td>
                            <td class="cartColumn"><p>${x.chocolate.price}</p></td>
                            <td class="cartColumn"><p>${x.amount}</p></td>
                            <td class="cartColumn"><a class="pink lighten-5 black-text btn removeButton" id="1" onClick="addEventListenerRemove(${counter})">Ta bort</a></td>
                        </tr>`;
        counter++;
    });
    
    ProductHTML += `</tbody></table>`;
    
    var totalSum = 9867.996467;
//    productsInCart.map(x => {
//        totalSum += x.chocolate.price * x.amount;
//    });
    
    var discount = 0;
    var sumToPay = totalSum;
    if (true){
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

function addEventListenerRemove(counter){
        productsInCart = productsInCart.slice(0, counter).concat(productsInCart.slice(counter+1));
        document.querySelector(".collapsible").innerHTML = "";
        getProducts();
}

function thankYou(){
        document.querySelector(".collapsible").innerHTML = "Tack för ditt köp!!";
}

function updateAmount(counter){
    productsInCart[counter].amount;
}
