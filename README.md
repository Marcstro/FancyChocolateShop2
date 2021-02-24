

NOTE: use the NextStep branch, I will merge it into master as soon as I've got time to deal with the conflicts.

This project is not entirely complete.

Unfortunately I could not find the completed version of the project, this version lacks features such as displaying current money amount, admin page is not showing correct data and website navigation needs some adjustments.

But the program runs just fine; "FancyChocolateShop2" is a "complete" deluxe chocolate shop. Start the Java maven project, go to http://localhost:8080 and you'll be presented with a website hosting the chocolate shop.

Either make a new account, log in as a user (existing username: Alice, Password: alice123) or log in as Admin (username: Admin, password: Password). And you'll be able to make purchases with the money available in your account. Orders, new accounts and history will be saved in the H2-database through the java REST API. Admin accounts was intended to be able to see all purchases, but currently only see example orders.

This is the group project that I and 2 others did during our backend course at Nackademin. The frontend is written in Javascript with some jQuery, the backend is made with Java Spring boot to create a REST API, along with H2 to create a SQL database. It was made during my first year as a student and could definitely have been written a lot better, but considering our skill at the time I'm quite pleased with how it turned out. /Marcus Strom
