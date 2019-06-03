package Chokladgruppen.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class Fcs2Application {
    
    private static final Logger log = LoggerFactory.getLogger(Fcs2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Fcs2Application.class, args);
	}
        
        @Bean
	public CommandLineRunner initChocolate (ChocolateRepository repository) {
            
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
                    log.info("OrdersRepository initiated correctly");
                    
                   //here we are gona fill orders
                  };
        }
        
        @Bean
        public CommandLineRunner initOrderDetails (OrderDetailsRepository repository) {
            return (args) -> {
                log.info("OrderDetailsRepository initiated correctly");
                //here we are going to fill orderdetails
                  };
        }
            
        
        
        
     //   @Bean
//	public CommandLineRunner demo(ChocolateRepository repository) {
//            
//            	return (args) -> {
        //                    personrepository.save(new Person("Alice Svensson", "Alice", "Alice123", "Annavägen 12", false, false));
                    //                    personrepository.save(new Person("Maja Adolfsson", "Maja", "Maja123", "Majavägen 10", false, false));
                    //                    personrepository.save(new Person("Ella Asplund", "Ella", "Ella123", "Ellavägen 5", false, false));
                    //                    personrepository.save(new Person("Olivia Bauer", "Olivia", "Olivia123", "Oliviavägen 3", false, false));
                    //                    personrepository.save(new Person("Jenny Svensson", "Jenny", "Jenny123", "Jennyvägen 1", true, false));
                    //                    personrepository.save(new Person("Leo Messi", "Messi", "Leo123", "Leovägen 3", false, false));
                    //                    personrepository.save(new Person("Gabriel Agrell", "Gabriel", "Gabriel123", "Gabrielvägen 3", false, false));
                    //                    personrepository.save(new Person("Elton John", "Elton", "Elton123", "Eltonvägen 3", false, true));
                    //                    personrepository.save(new Person("Lady Gaga", "Lady", "Lady123", "Ladyvägen 1", false, true));
                    //                    personrepository.save(new Person("Taylor Swift", "Taylor", "Taylor123", "Taylorvägen 1", false, false));
                    //                    personrepository.save(new Person("Testperson testis", "t", "t", "Testvagen 1", false, false));
                    //                    personrepository.save(new Person("Admin", "Admin", "Password", "Adminvagen 1", true, false));

//                          };
//	}
}
