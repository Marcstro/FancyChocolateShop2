
$(document).ready(function () {
    // För popupen:
    $('.modal').modal();
    // För att skapa chokladKorten
    addChocolateCardElements();
});

// Initialisering av drop down för sökrutan på produkter
// document.addEventListener('DOMContentLoaded', function () {
//     var elems = document.querySelectorAll('.dropdown-trigger');
//     var instances = M.Dropdown.init(elems, options);
// });
// Or with jQuery
// $('.dropdown-trigger').dropdown();


var listOfProducts = [
    {
        id: 1,
        smallPictureName: "Amedei-Porcelana_small.jpg",
        pictureName: "Amedei-Porcelana.jpg",
        name: "Amedei-Porcelana",
        brand: "Debauve and Gallais",
        description: "The dark chocolates with 99% cocoa",
        amount: 0
    }, {
        id: 2,
        smallPictureName: "Amedei-Porcelana_small.jpg",
        pictureName: "Amedei-Porcelana.jpg",
        name: "Chocopologie Chocolate Truffle",
        brand: "La Maison du Chocolat",
        description: "Chocolate is wrapped in an edible gold leaf",
        amount: 0
    }, {
        id: 3,
        smallPictureName: "Amedei-Porcelana_small.jpg",
        pictureName: "Amedei-Porcelana.jpg",
        name: "Chocolate Pearls",
        brand: "Valrhona",
        description: "Dark Chocolate Pearls 55%, Dark Chocolate Crunchy Pearls 55%, Caramélia 36%",
        amount: 0
    }, {
        id: 4,
        smallPictureName: "Amedei-Porcelana_small.jpg",
        pictureName: "Amedei-Porcelana.jpg",
        name: "Amedei-Porcelana",
        brand: "Debauve and Gallais",
        description: "The dark chocolates with 99% cocoa",
        amount: 0
    }, {
        id: 5,
        smallPictureName: "Amedei-Porcelana_small.jpg",
        pictureName: "Amedei-Porcelana.jpg",
        name: "Chocopologie Chocolate Truffle",
        brand: "La Maison du Chocolat",
        description: "Chocolate is wrapped in an edible gold leaf",
        amount: 0
    }, {
        id: 6,
        smallPictureName: "Amedei-Porcelana_small.jpg",
        pictureName: "Amedei-Porcelana.jpg",
        name: "Chocolate Pearls",
        brand: "Valrhona",
        description: "Dark Chocolate Pearls 55%, Dark Chocolate Crunchy Pearls 55%, Caramélia 36%",
        amount: 0
    }
];

// Element att lägga choklad-korten i
const chocolateCardsDiv = document.querySelector("#divForChocolateCards");
// Element att lägga popUpContent i
const popUpContentDiv = document.querySelector("#popUpContent");


// Skapar html för pop up
function addPopUpContent(id) {
    listOfProducts.map((x, i) => {
        if (x.id === id) {
            console.log("inne i addPopUpContent - id: " + id)
            popUpContentDiv.innerHTML += `<div class="row">`
                    + `<div class="col s6 m2 l2 xl2">`
                    + `<img src="images/${x.smallPictureName}">`
                    + `</div>`
                    + `</div>`
                    + `<div class="row">`
                    + `<div class="col s12 m10 l10 xl10 ">`
                    + `<h4 class="cardTitleFont">${x.name}</h4>`
                    + `<h6 class=dreamyFont3>${x.brand}</h6>`
                    + `<p>${x.description}</p>`
                    + `</div>`
                    + `</div>`;
        }
    });
}


// Skapar html för chocolateCards
function addChocolateCardElements() {
    listOfProducts.map((x, i) => {
        chocolateCardsDiv.innerHTML += `<div class="col s4 m4">`
                + `<div class="card">`
                + `<div class="card-image">`
                + `<img src="images/${x.smallPictureName}">`
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
        console.log("Id1: " + listOfProducts[i].id);
        listenerElement[i].addEventListener("click", function () {
            addPopUpContent(x.id);
        });
    });

}
