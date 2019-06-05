
$(document).ready(function () {
    // För popupen:
    $('.modal').modal();
    // Hämta Chokladobjekten
    getChocolates();
});

var listOfProducts = [];

$('#resetSok').click(function () {
    getChocolates();
});

$('#sokknapp').click(function () {
    console.log("Klickat pa sak");
    var sokt = $('#autocomplete-input').val()
    console.log(sokt);
//    listOfProducts=[];
//    addChocolateCardElements();
//    //document.querySelector("#divForChocolateCards").empty();//.empty();//.empty();
    $("divForChocolateCards").empty();
//    chocolateCardsDiv=null;
    var myNode = document.getElementById("divForChocolateCards");
    while (myNode.firstChild) {
    myNode.removeChild(myNode.firstChild);
    }
    var urlen = "http://localhost:8080/Chocolates/sokt/" + sokt;
    console.log(urlen);
    //var urlen = "http://localhost:8080/Chocolates";
    $.ajax({
            url: urlen,
        }).then(function (data) {
            console.log(JSON.stringify(data));
            console.log("test01");
            listOfProducts=[];
            console.log("Och sa har manga hittades:" + data.length);
            for(var i=0; i<data.length; i++){
            listOfProducts.push(data[i]);
            }
            // För att skapa chokladKorten
            addChocolateCardElements();
        });
});

function getChocolates() {
    console.log($('#userName').val());
    console.log("skriver ut saker");
    $.ajax({
    url: "http://localhost:8080/Chocolates"
    }).then(function (data) {
        console.log("test02");
        //console.log(JSON.stringify(data));
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
    // console.log("du kom till addChocolateCardElements");
    // console.log(listOfProducts.length);
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


function saveCartAndPersonToStorage(){
    
    var currentObj = listOfProducts[currentPopUp];
    var amount = $('#productAmount').val();
    currentObj.amount = amount;
   
    var ObjAsString = JSON.stringify(currentObj);
    // Varje key får ett nummer för att vara unik
    if (sessionStorage.length > 0){
        sessionStorage.setItem("products"+sessionStorage.length, ObjAsString);
    }
    else {
        sessionStorage.setItem("products0", ObjAsString);
    }
    
    // -- ANVÄND INLOGGAD PERSON SEDAN --
//    var person = JSON.stringify({name: "anna", password: "pass"});
//    sessionStorage.setItem("loggedInPerson", person);
    // console.log("person: " + JSON.stringify(person));
    
}


$("body").on("click", "#btnAddProductsToCart", function(){
    saveCartAndPersonToStorage();
});

$('#goToCart').click(function () {
    saveCartAndPersonToStorage();
});

// När man klickar på kundvagn i headern sparas ett customerAndCart-obj i
// sessionStorage, som kan användas av cart sedan.
//// (Egentligen kanske detta inte behöver göras förrän i cart, när man ska skicka till servern)
//$('#goToCart').click(function () {
//    
//    console.log("Inne i goToCart!");
//    
//    // Först hämta kundvagns-arrayen 
//    var cartArray = [];
//    for (i = 0; i < sessionStorage.length; i++){   
//        cartArray.push(JSON.parse(sessionStorage.getItem("products"+i)));
////        console.log("cartArray: " + cartArray[i].name);
////        console.log("cartArrayStringify: " + JSON.stringify(cartArray[i]));
//        console.log("cartArray, length: " + cartArray.length);
//    }
//    
//    // -- ANVÄND INLOGGAD PERSON SEDAN --
//    var person = {name: "jny", password: "pass"};
//    // console.log("person: " + JSON.stringify(person));
//    
//    // Skapa CustomerAndCart
//    var customerAndCart = {person, cartArray};
//    // console.log("customerAndCart: " + JSON.stringify(customerAndCart));
// 
//    // Sparar denna i sessionStorage
// 
//});

