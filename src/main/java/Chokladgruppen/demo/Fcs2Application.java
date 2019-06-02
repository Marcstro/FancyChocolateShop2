package Chokladgruppen.demo;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@ComponentScan({"Chokladgruppen.repository","Chokladgruppen.domain", "com.example.demo", "Chokladgruppen.demo"})
public class Fcs2Application {
//    @Autowired
//    Person p1;
    
    //PersonRepository pr;
//    @Autowired
//    private PersonRepository pr;
    
    ChocolateRepository cr;
    PersonRepository pr;
    OrdersRepository or;
    OrderDetailsRepository odr;
   
    private static final Logger log = LoggerFactory.getLogger(Fcs2Application.class);

    @Autowired
    OrdersRepository or2;
	public static void main(String[] args) {
		SpringApplication.run(Fcs2Application.class, args);
	}
        
         @Bean
         
	public CommandLineRunner initChocolate (ChocolateRepository repository) {
            cr=repository;
            
            	return (args) -> {
                        repository.save(new Chocolate("Le Grand Louis XVI", 8616, "The dark chocolates with 99% cocoa", "Debauve and Gallais", 2000, 0, "", true,"Le-Grand-Louis-XVI.jpg"));
                    repository.save(new Chocolate("Wispa Gold", 15316.39, "Chocolate is wrapped in an edible gold leaf", "Cadbury", 500, 0, "", true, "Wispa-gold.jpg"));
                    repository.save(new Chocolate("Chocopologie Chocolate Truffle", 24895.31, "Dark chocolate, ganache, and French Perigord truffle", "Knipschildt", 500, 0, "", false, "Chocopologie-Chocolate-Truffle.jpg"));
                    repository.save(new Chocolate("Flavored Truffles", 938.06, "Plain dark chocolate, black currant, caramell toffee ", "La Maison du Chocolat", 2000, 0, "", false, "Amedei-Toscano-Black-Truffles-in-Swarovski-Chocolate-Box.jpg"));
                    repository.save(new Chocolate("Boite Maison", 1856.89, "Selection of 93 ganaches,pralines and dark chocolate truffles", "La Maison du Chocolat", 1500, 0, "", false, "Grand-Cru-by-Pierre-Marcolni-1.jpg"));
                    repository.save(new Chocolate("Sweet Surprise Tower", 899.58, "Creamy milk chocolates and luscious chocolate truffles", "Godiva", 3000, 0, "", false, "Richart-Chocolate.jpg"));
                    repository.save(new Chocolate("Milk Chocolate Dipped Strawberies", 765, "12 sweet strawberries covered in smooth milk chocolate ", "Godiva", 3000, 0, "", false, "Voges-Haut.jpg"));
                    repository.save(new Chocolate("Chocolate Pearls", 449.80, " Dark Chocolate Pearls 55%, Dark Chocolate Crunchy Pearls 55%, CARAMÉLIA 36% Crunchy Pearls.", "Valrhona", 4000, 0, "", false, "Chocolates-with-Edible-Gold-by-DeLafee.jpg"));
                    repository.save(new Chocolate("Coffret Selection", 525.45, "An assortment of almonds and hazelnuts coated in milk chocolate", "Valrhona", 3500, 0, "", false, "Amedei-Porcelana.jpg"));
                    repository.save(new Chocolate("Tosca", 567.25, "A box with 7 delightful artisan chocolates, the best southern European almonds covered in chocolate", "Puccini bomboni", 1000, 0, "", false, "The-Aficionados-Collection.jpg"));
                  
                    
                    
			// fetch all customers
                        log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Chocolate chokladen : repository.findAll()) {
				log.info(chokladen.toString());
			}
			log.info("");
                        
                        
                        log.info("Costs lower than: 800.00:");
                        repository.findByPriceLessThan(800.00).forEach(item -> {
				log.info(item.toString());
			});
                        
                        };
			
	}
        
        @Bean
        public CommandLineRunner initPeople (PersonRepository repository) {
            return (args) -> {
                
               // pr = repository;
//                Person p1 = new Person("Alice Svensson", "Alice", "Alice123", "Annavägen 12", false, false);
//               repository.save(p1);

                    pr = repository;
                                    repository.save(new Person("Alice Svensson", "Alice", "Alice123", "Annavägen 12", false, false));
                                        repository.save(new Person("Maja Adolfsson", "Maja", "Maja123", "Majavägen 10", false, false));
                                        repository.save(new Person("Ella Asplund", "Ella", "Ella123", "Ellavägen 5", false, false));
                                        repository.save(new Person("Olivia Bauer", "Olivia", "Olivia123", "Oliviavägen 3", false, false));
                                        repository.save(new Person("Jenny Svensson", "Jenny", "Jenny123", "Jennyvägen 1", true, false));
                                        repository.save(new Person("Leo Messi", "Messi", "Leo123", "Leovägen 3", false, false));
                                        repository.save(new Person("Gabriel Agrell", "Gabriel", "Gabriel123", "Gabrielvägen 3", false, false));
                                        repository.save(new Person("Elton John", "Elton", "Elton123", "Eltonvägen 3", false, true));
                                        repository.save(new Person("Lady Gaga", "Lady", "Lady123", "Ladyvägen 1", false, true));
                                        repository.save(new Person("Taylor Swift", "Taylor", "Taylor123", "Taylorvägen 1", false, false));
                                        repository.save(new Person("Testperson testis", "t", "t", "Testvagen 1", false, false));
                                        repository.save(new Person("Admin", "Admin", "Password", "Adminvagen 1", true, false));
                                        
//                       or2.save(new Orders(p1));                 
                                        
                                        // fetch all customers
                        log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Person person : repository.findAll()) {
				log.info(person.toString());
			}
			log.info("");
                        
                        
                        log.info("And these are premium people:");
                        repository.findByPremiumTrue().forEach(item -> {
				log.info(item.toString());
			});
                };
        }
        
        @Bean
        public CommandLineRunner initOrders (OrdersRepository repository) {
            return (args) -> {
                System.out.println("..");
                
                log.info("OrdersRepository initiated correctly");
                    
                 or = repository;

                 //this little thing below
                 //created a random amounts of orders for EVERY person
                 //want a more or less random orders? Change number below
                 int HowManyRandomOrders = 6;
                    List<Person> litenLista = new ArrayList();
                    for (Person pp : pr.findAll()) {
                                int randomAntal = (int)(Math.random()*HowManyRandomOrders);
                                for(int x=0; x<randomAntal; x++){
                                    repository.save(new Orders(pp));
                                }
			}
                    
                    
                    //here you can add orders as you want them
                    //in ways so they wont be randomised
                    
//                      repository.save(new Orders(pr.findById(11).get(0)));
//                      repository.save(new Orders(pr.findById(12).get(0)));
//                      repository.save(new Orders(pr.findById(13).get(0)));
//                      repository.save(new Orders(pr.findById(14).get(0)));
//                      repository.save(new Orders(pr.findById(15).get(0)));
//                      repository.save(new Orders(pr.findById(16).get(0)));
                      
                
                
//                    log.info("OrdersRepository initiated correctly");
//                    
//                    or = repository;
//                    log.info("marcus har skriver du ut folk");
//                    log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Person person : pr.findAll()) {
//				log.info(person.toString());
//                                String temp = String.valueOf(person.getId());
//                                log.info(temp);
//			}
//                        System.out.println(pr.findById(11));
//                        Person p = pr.findById(11).get(0);
//                        Orders o1 = new Orders();
//                        o1.setPerson(p);
//                        repository.save(o1);
//                        
////                        repository.save(new Orders(p));
//                        
                        log.info("Orders found with findAll():");
			log.info("-------------------------------");
			for (Orders orders : repository.findAll()) {
				log.info(orders.toString());
			}
                        
                        
                        
                    //log.info(pr.findById(1));
                    //this.pr=pr;
                    //ChocolateRepository cr;
                    
                   // repository.save(new Orders(p1));
                    
                    //PersonRepository pr;
                    
                    //funkar ej :(
                    //public Orders(Date date, double price, Person person) {
//                    for (Person person : pr.findAll()) {
//				log.info(person.toString());
//                                repository.save(new Orders(person));
//			}

                    //funkar ej :(
                    //repository.save(new Orders(pr.findById(1).get(0)));
                    
                    //funkar!
                    //repository.save(new Orders(new Person()));
                    
                    //funkar!
                    //repository.save(new Orders());
                    
//                    log.info("Orders found with findAll():");
//			log.info("-------------------------------");
//			for (Orders orders : repository.findAll()) {
//				log.info(orders.toString());
//			}
//			log.info("");
                    //repository.save(new Person("Alice Svensson", "Alice", "Alice123", "Annavägen 12", false, false));
                    
                   //here we are gona fill orders
                  };
        }
        
        @Bean
        public CommandLineRunner initOrderDetails (OrderDetailsRepository repository) {
            return (args) -> {
                log.info("OrderDetailsRepository initiated correctly");
                odr=repository;
                
                //this little thing below
                 //created a random amounts of orderdetails for EVERY order
                 //want a more or less random orders? Change number below
                 int HowManyRandomChocolates = 6;
                 
                    List<Chocolate> litenLista = new ArrayList();
                    for(Chocolate ck: cr.findAll()){
                        litenLista.add(ck);
                    }
                    
                    for (Orders ors : or.findAll()) {
                                int randomAntal = (int)(Math.random()*HowManyRandomChocolates);
                                for(int x=0; x<randomAntal; x++){
                                    int AntalChokladAttKopa = (int)(Math.random()*10);
                                    Chocolate randomChoklad = litenLista.get(((int)(Math.random()*(litenLista.size()-1))));
                                    repository.save(new OrderDetails(AntalChokladAttKopa, 
                                            randomChoklad,
                                            ors));
                                }
			}
                
                //this below is to create desired orders
                //not randomised
                
//                repository.save(new OrderDetails(5,
//                        cr.findById(1).get(0),
//                        or.findById(23).get(0)));
//                
                
                
                log.info("Orderdetails found with findAll():");
			log.info("-------------------------------");
			for (OrderDetails orderDetails : repository.findAll()) {
				log.info(orderDetails.toString());
			}
                //here we are going to fill orderdetails
                
                
                
                
                  };
        }
            
        
        
        
     //   @Bean
//	public CommandLineRunner demo(ChocolateRepository repository) {
//            
//            	return (args) -> {
//                        repository.save(new Chocolate("Le Grand Louis XVI", 8616, "The dark chocolates with 99% cocoa", "Debauve and Gallais", 2000, 0, "", true,"Le-Grand-Louis-XVI.jpg"));
//                    repository.save(new Chocolate("Wispa Gold", 15316.39, "Chocolate is wrapped in an edible gold leaf", "Cadbury", 500, 0, "", true, "Wispa-gold.jpg"));
//                    repository.save(new Chocolate("Chocopologie Chocolate Truffle", 24895.31, "Dark chocolate, ganache, and French Perigord truffle", "Knipschildt", 500, 0, "", false, "Chocopologie-Chocolate-Truffle.jpg"));
//                    repository.save(new Chocolate("Flavored Truffles", 938.06, "Plain dark chocolate, black currant, caramell toffee ", "La Maison du Chocolat", 2000, 0, "", false, "Amedei-Toscano-Black-Truffles-in-Swarovski-Chocolate-Box.jpg"));
//                    repository.save(new Chocolate("Boite Maison", 1856.89, "Selection of 93 ganaches,pralines and dark chocolate truffles", "La Maison du Chocolat", 1500, 0, "", false, "Grand-Cru-by-Pierre-Marcolni-1.jpg"));
//                    repository.save(new Chocolate("Sweet Surprise Tower", 899.58, "Creamy milk chocolates and luscious chocolate truffles", "Godiva", 3000, 0, "", false, "Richart-Chocolate.jpg"));
//                    repository.save(new Chocolate("Milk Chocolate Dipped Strawberies", 765, "12 sweet strawberries covered in smooth milk chocolate ", "Godiva", 3000, 0, "", false, "Voges-Haut.jpg"));
//                    repository.save(new Chocolate("Chocolate Pearls", 449.80, " Dark Chocolate Pearls 55%, Dark Chocolate Crunchy Pearls 55%, CARAMÉLIA 36% Crunchy Pearls.", "Valrhona", 4000, 0, "", false, "Chocolates-with-Edible-Gold-by-DeLafee.jpg"));
//                    repository.save(new Chocolate("Coffret Selection", 525.45, "An assortment of almonds and hazelnuts coated in milk chocolate", "Valrhona", 3500, 0, "", false, "Amedei-Porcelana.jpg"));
//                    repository.save(new Chocolate("Tosca", 567.25, "A box with 7 delightful artisan chocolates, the best southern European almonds covered in chocolate", "Puccini bomboni", 1000, 0, "", false, "The-Aficionados-Collection.jpg"));
//                  
//                    
//			// fetch all customers
//                        log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Chocolate chokladen : repository.findAll()) {
//				log.info(chokladen.toString());
//			}
//			log.info("");
//                        
//                        
//                        log.info("Costs lower than: 800.00:");
//                        repository.findByPriceLessThan(800.00).forEach(item -> {
//				log.info(item.toString());
//			});
//                        
//                        };
//			
//	}
//        
//        @Bean
//        public CommandLineRunner initPeople (PersonRepository repository) {
//            return (args) -> {
//                                    repository.save(new Person("Alice Svensson", "Alice", "Alice123", "Annavägen 12", false, false));
//                                        repository.save(new Person("Maja Adolfsson", "Maja", "Maja123", "Majavägen 10", false, false));
//                                        repository.save(new Person("Ella Asplund", "Ella", "Ella123", "Ellavägen 5", false, false));
//                                        repository.save(new Person("Olivia Bauer", "Olivia", "Olivia123", "Oliviavägen 3", false, false));
//                                        repository.save(new Person("Jenny Svensson", "Jenny", "Jenny123", "Jennyvägen 1", true, false));
//                                        repository.save(new Person("Leo Messi", "Messi", "Leo123", "Leovägen 3", false, false));
//                                        repository.save(new Person("Gabriel Agrell", "Gabriel", "Gabriel123", "Gabrielvägen 3", false, false));
//                                        repository.save(new Person("Elton John", "Elton", "Elton123", "Eltonvägen 3", false, true));
//                                        repository.save(new Person("Lady Gaga", "Lady", "Lady123", "Ladyvägen 1", false, true));
//                                        repository.save(new Person("Taylor Swift", "Taylor", "Taylor123", "Taylorvägen 1", false, false));
//                                        repository.save(new Person("Testperson testis", "t", "t", "Testvagen 1", false, false));
//                                        repository.save(new Person("Admin", "Admin", "Password", "Adminvagen 1", true, false));
//                                        
//                                        
//                                        // fetch all customers
//                        log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Person person : repository.findAll()) {
//				log.info(person.toString());
//			}
//			log.info("");
//                        
//                        
//                        log.info("And these are premium people:");
//                        repository.findByPremiumTrue().forEach(item -> {
//				log.info(item.toString());
//			});
//                };
//        }
//        
//        @Bean
//        public CommandLineRunner initOrders (OrdersRepository repository) {
//            return (args) -> {
//                    log.info("OrdersRepository initiated correctly");
//                    
//                   //here we are gona fill orders
//                  };
//        }
//        
//        @Bean
//        public CommandLineRunner initOrderDetails (OrderDetailsRepository repository) {
//            return (args) -> {
//                log.info("OrderDetailsRepository initiated correctly");
//                //here we are going to fill orderdetails
//                  };
//        }
//            
//        
//        
       
}
