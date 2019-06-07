$(document).ready(function(){
    $(`.collapsible`).collapsible();
    var customers = [{name:"Anna", premium:"Yes", totalsum:"100", numberOfOrders:"10", orders:[{
                        id:167538, date:"2019-02-14", totalsum:2000, orderDetails:[
                            {chocolate:"Marabou", price:10, amount:10},
                            {chocolate:"Lindt", price:10, amount:10}
                        ]},
                        {
                        id:2, date:"2019-02-15", totalsum:2000, orderDetails:[
                            {chocolate:"Marabou", price:10, amount:10},
                            {chocolate:"Lindt", price:10, amount:10}
                        ]},
                        {
                        id:3, date:"2019-02-16", totalsum:2000, orderDetails:[
                            {chocolate:"Marabou", price:10, amount:10},
                            {chocolate:"Lindt", price:10, amount:10}
                        ]}
                    ]},
                    {name:"Pelle", premium:"Yes", totalsum:"100", numberOfOrders:"10", orders:[{
                        date:"2019-02-14", totalsum:2000, orderDetails:[
                            {chocolate:"Marabou", price:10, amount:10},
                            {chocolate:"Lindt", price:10, amount:10}
                        ]}
                    ]},
                    {name:"Arne", premium:"No", totalsum:"100", numberOfOrders:"10", orders:[{
                        date:"2019-02-14", totalsum:2000, orderDetails:[
                            {chocolate:"Marabou", price:10, amount:10},
                            {chocolate:"Lindt", price:10, amount:10}
                        ]}
                    ]}];
    getCustomersMap(customers);
});

function getCustomersMap(customers){

    /* Header för startraden */
    var customerList = `<li>`
    + `<div class="collapsible-header valign-wrapper">`
        + `<div class="row headerCustomerList">`
            + `<div class="column"><p>Namn</p></div>`
            + `<div class="column"><p>Premium</p></div>`
            + `<div class="column"><p>Total summa handlat för</p></div>`
            + `<div class="column"><p>Antal ordrar</p></div>`
        + `</div>`
    + `</div>`
    + `</li>`;

    /* sortera listan (ta bort om sorterad lista hämtas) */
    customers.sort((a, b) => a.name.localeCompare(b.name));

    /*Gå igenom listan och skriv först ut startraden (namn, premium, totalsum och numberoforders) + header för orders*/
    customers.map(x =>{
        customerList += `<li>`
        + `<div class="collapsible-header valign-wrapper"><i class="material-icons face-image">face</i>`
            + `<div class="row">`
                + `<div class="column"><p>${x.name}</p></div>`
                + `<div class="column"><p>${x.premium}</p></div>`
                + `<div class="column"><p>${x.totalsum}</p></div>`
                + `<div class="column"><p>${x.numberOfOrders}</p></div>`
            + `</div>`
        + `</div>`
        + `<div class="collapsible-body"> `
        + `<div class="row headerCustomerList">`
            + `<div class="columnID"><p>OrderID</p></div>`
            + `<div class="columnDS"><p>Datum</p></div>`
            + `<div class="columnDS"><p>Totalsumma</p></div>`
            + `<div class="columnOrderDetails"><p>Details</p></div>`
        + `</div>`;

        /*Gå igenom listan med orderinformation och skriv ut + header för orderDetails*/
        x.orders.map(y => {
            customerList += `<div class="row">`
                            + `<div class="columnID"><p>${y.id}</p></div>`
                            + `<div class="columnDS"><p>${y.date}</p></div>`
                            + `<div class="columnDS"><p>${y.totalsum}</p></div>`
                            + `<div class="columnOrder title"><p>Choklad</p></div>`
                            + `<div class="columnOrder title"><p>Pris</p></div>`
                            + `<div class="columnOrder title"><p>Antal</p></div></div>`;

                /*Gå igenom och skriv ut OrderDEtails + tomt utrymme för att allt ska hammna rätt*/
                y.orderDetails.map(i =>{
                    customerList += `<div class="row">`
                                + `<div class="columnID"><p></p></div>`
                                + `<div class="columnDS"><p></p></div>`
                                + `<div class="columnDS"><p></p></div>`
                                + `<div class="columnOrder"><p>${i.chocolate}</p></div>`
                                + `<div class="columnOrder"><p>${i.price}</p></div>`
                                + `<div class="columnOrder"><p>${i.amount}</p></div>`
                                + `</div>`;
                    });

            customerList +=`<div class="row withUpperBorder"></div>`;
        });
        
        customerList += `</div></li>`;
        
        document.querySelector(".collapsible").innerHTML = customerList;
    });
}
