
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
// Behöver nog ha med sig ett id här. Använder ett hårdkodat nu
var id = 1;
var index = -1;
function addPopUpContent(id) {
//    console.log("Inne i metoden!");

    listOfProducts.map((x, i) => {
//        console.log("Inne i map!");

        if (x.id === 1) {
//            console.log("Sätter index!");
            index = 1;
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
            console.log("x: " + JSON.stringify(x));
        }
    });


}

// Skapar html för chocolateCards
function addChocolateCardElements() {
    VariableNamesArray = [];

    listOfProducts.map((x, i) => {
        chocolateCardsDiv.innerHTML += `<div class="col s4 m4">`
            + `<div class="card">`
            + `<div class="card-image">`
            + `<img src="images/${x.pictureName}">`
            + `<span class="card-title cardTitleFont">${x.name}</span>`
            + `<a id="modalLink${i}" class="btn-floating halfway-fab waves-effect waves-light pink lighten-4 modal-trigger" href="#modal1">`
            + `<i class="material-icons">more_horiz</i></a>`
            + `</div>`
            + `<div class="card-content">`
            + `<p>${x.description}</p>`
            + `</div>`
            + `</div>`
            + `</div>`;

        // Lägger till actionListener till länk som öppnar popUp
        // Detta ger sista kortet info på popupen, pga listenerElement sparas över
        var listenerElement = document.getElementById(`modalLink${i}`);
        listenerElement.addEventListener("click", addPopUpContent);

    });


}
