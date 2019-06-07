$(document).ready(function () {
    // För popupen:
    $('.modal').modal();
    // Hämta Chokladobjekten
    getChocolates();
});

var listOfProducts = [];

$('#resetSok').click(function () {
    // Ta bort de taggar som redan finns
    $('#divForChocolateCards').empty();
    $('#popUpContent').empty();
    // Lägga dit chokladerna igen
    getChocolates();
});

$('#sokknapp').click(function () {
    var sokt = $('#autocomplete-input').val();
    $("divForChocolateCards").empty();
    var myNode = document.getElementById("divForChocolateCards");
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
    var urlen = "http://localhost:8080/Chocolates/sokt/" + sokt;
    $.ajax({
        url: urlen,
    }).then(function (data) {
        listOfProducts = [];
        for (var i = 0; i < data.length; i++) {
            listOfProducts.push(data[i]);
        }
        // För att skapa chokladKorten
        addChocolateCardElements();
    });
});

function getChocolates() {
    $.ajax({
        url: "http://localhost:8080/Chocolates"
    }).then(function (data) {
        listOfProducts = data;
        // För att skapa chokladKorten
        addChocolateCardElements();
    });
};

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
            popUpContentDiv.innerHTML += `<div class="modal-content">`
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

function saveCartAndPersonToStorage() {
    var currentObj = listOfProducts[currentPopUp];
    var amount = $('#productAmount').val();
    currentObj.amount = amount;

    var ObjAsString = JSON.stringify(currentObj);

    // Skapa array med alla key-namn, för att jämföra med
    var keyNamesArray = [];
    for (i = 0; i < sessionStorage.length; i++) {
        var keyName = sessionStorage.key(i);
        if (keyName !== "loggedInPerson") {
            keyNamesArray.push(keyName);
        }
    }

    var counter = 0;  // var counter = sessionStorage.length;
    var objectIsSet = false;
    var keyNameSuggestionIsInArray = false;

    while (!objectIsSet) {
        var keyNameSuggestion = "products" + counter;

        if (keyNamesArray.length === 0) {
            console.log("keyNamesArray  är tom!");
        } else if (keyNamesArray.length > 0) {
            // Kolla om det föreslagna namnet finns i arrayen
            for (i = 0; i < keyNamesArray.length; i++) {
                if (keyNamesArray[i].localeCompare(keyNameSuggestion) === 0) {
                    keyNameSuggestionIsInArray = true;
                }
            }
        }

        // Om det förslagna namnet inte fanns i arrayen, lägg till i Storage
        if (!keyNameSuggestionIsInArray) {
            sessionStorage.setItem(keyNameSuggestion, ObjAsString);
            objectIsSet = true;
        } else if (keyNameSuggestionIsInArray) {
            counter++;
            keyNameSuggestionIsInArray = false;
        }
    }
}

$("body").on("click", "#btnAddProductsToCart", function () {
    saveCartAndPersonToStorage();
});

$('#goToCart').click(function () {
    if (sessionStorage.length > 1) {
        window.open("/cart", "_self");
    }
});

$('#btnGoToCart').click(function () {
    if (sessionStorage.length > 1) {
        window.open("/cart", "_self");
    }
});