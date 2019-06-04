
$(document).ready(function () {
    // För popupen:
    $('.modal').modal();
    // Hämta Chokladobjekten
    getChocolates();
});

var listOfProducts = [];
function getChocolates() {
    $.ajax({
    url: "http://localhost:8080/Chocolates"
    }).then(function (data) {
        listOfProducts = data;
        // För att skapa chokladKorten
        addChocolateCardElements();
    });
};


// Initialisering av drop down för sökrutan på produkter
// document.addEventListener('DOMContentLoaded', function () {
//     var elems = document.querySelectorAll('.dropdown-trigger');
//     var instances = M.Dropdown.init(elems, options);
// });
// Or with jQuery
// $('.dropdown-trigger').dropdown();




// Element att lägga choklad-korten i
const chocolateCardsDiv = document.querySelector("#divForChocolateCards");
// Element att lägga popUpContent i
const popUpContentDiv = document.querySelector("#popUpContent");
// Skapar html för chocolateCards
function addChocolateCardElements() {
    listOfProducts.map((x, i) => {
        chocolateCardsDiv.innerHTML += `<div class="col s4 m4">`
        + `<div class="card">`
        + `<div class="card-image">`
        + `<img class="chocolateImages" src="images/${x.pictureName}">`
        + `<span class="card-title cardTitleFont">${x.name}</span>`
        + `<a id="modalLink${i}" class="btn-floating halfway-fab waves-effect waves-light pink lighten-4 modal-trigger" href="#modal1">`
        + `<i class="material-icons">more_horiz</i></a>`
        + `</div>`
        + `<div class="card-content">`
        + `<p>${x.description}</p>`
        + `</div>`
        + `</div>`
        + `</div>`;
    });
    addEventListenersToChocolateCards();
}


//  Array för att skapa dynamiska eventListener-variabler
var listenerElement = [];
// Lägger till actionListerners efter att html-koden för alla kort genererats
function addEventListenersToChocolateCards() {
    listOfProducts.map((x, i) => {
        listenerElement.push("listenerElement" + i);
        listenerElement[i] = document.getElementById(`modalLink${i}`);
        // console.log("Id1: " + listOfProducts[i].chocolateId);
        listenerElement[i].addEventListener("click", function () {
            addPopUpContent(x.chocolateId);
            
        });
    });
}


// Sparar vilken popup som visas
var currentPopUp = -1;

// Skapar html för pop up
function addPopUpContent(id) {
    listOfProducts.map((x, i) => {
        if (x.chocolateId === id) {
            currentPopUp = i;
            // console.log("inne i addPopUpContent - id: " + id)
            popUpContentDiv.innerHTML +=`<div class="modal-content">`
            + `<div class="row">`
            + `<div class="col s6 m2 l2 xl2">`
            + `<img src="images/${x.smallPictureName}">`
            + `</div>`
            + `</div>`
            + `<div class="row">`
            + `<div class="col s12 m10 l10 xl10 ">`
            + `<h4 class="cardTitleFont">${x.name}</h4>`
            + `<h6 class=dreamyFont3>${x.brand}</h6>`
            + `<p>${x.description}</p>`
            + `<p>${x.price}</p>`
            + `</div>`
            + `</div>`
            + `<div class="row">`
            + `<div class="input-field col s12 m10 l10 xl10">`
            + `<i class="material-icons prefix">add_circle</i>`
            + `<input type="number" class="placeholder inputAmount" id="productAmount">`
            + `<label for="productAmount">Antal</label>`
            + `</div>`
            + `</div>`
            + `</div>`
            + `<div class="modal-footer">`
            + `<button id="btnAddProductsToCart" class="btn waves-effect waves-light" type="button" name="action"><i class="material-icons left">add_shopping_cart</i>Köp</button>`
            + `<button id="btnBackToProducts" class="btn waves-effect waves-light" type="button" name="action"><i class="material-icons left">arrow_back</i><a style="color: white;"href="products">Tillbaka</a></button>`
            + `</div>`;
            
        }
        
    });
};


// Arrayen tömdes när popupen stängdes. Pga att sidan laddas om då?
var cartArray = [];

$("body").on("click", "#btnAddProductsToCart", function(){
    console.log("Knappen funkar!");
    var amount = $('#productAmount').val();
    console.log("amount: " + amount);
    console.log(JSON.stringify(listOfProducts[currentPopUp]));
    
    // Här sparar man allt i en array. Sedan när man klickar på köp skickas
    // hela listan till servern
    // Kolla om produkten redan finns. Lägga till antalet då, bara.
    
    cartArray.push(listOfProducts[currentPopUp]);
    // console.log("Arrayen: " + JSON.stringify(cartArray));
    
    cartArray.map((x, i)=>{
        console.log("Arrayen: index " + i + ": " + x);
    });
});


$("body").on("click", "#btnAddProductsToCart", function(){
    console.log("Arrayens längd: " + cartArray.length); // < read the length of the amended array here
});