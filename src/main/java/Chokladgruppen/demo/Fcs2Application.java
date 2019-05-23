package Chokladgruppen.demo;


import Chokladgruppen.domain.Chocolate;
import Chokladgruppen.domain.Person;
import Chokladgruppen.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import Chokladgruppen.repository.ChokladRepository;
import Chokladgruppen.repository.OrderDetailsRepository;
import Chokladgruppen.repository.OrderRepository;

@SpringBootApplication
public class Fcs2Application {

	public static void main(String[] args) {
		SpringApplication.run(Fcs2Application.class, args);
                
	}
         @Bean
       
            CommandLineRunner init(ChokladRepository chokladrepository){

                return args -> {
                       
                    chokladrepository.save(new Chocolate("Le Grand Louis XVI", 8616, "The dark chocolates with 99% cocoa", "Debauve and Gallais", 2000, 0, "", true,"Le-Grand-Louis-XVI.jpg"));
                    chokladrepository.save(new Chocolate("Wispa Gold", 15316.39, "Chocolate is wrapped in an edible gold leaf", "Cadbury", 500, 0, "", true, "Wispa-gold.jpg"));
                    chokladrepository.save(new Chocolate("Chocopologie Chocolate Truffle", 24895.31, "Dark chocolate, ganache, and French Perigord truffle", "Knipschildt", 500, 0, "", false, "Chocopologie-Chocolate-Truffle.jpg"));
                    chokladrepository.save(new Chocolate("Flavored Truffles", 938.06, "Plain dark chocolate, black currant, caramell toffee ", "La Maison du Chocolat", 2000, 0, "", false, "Amedei-Toscano-Black-Truffles-in-Swarovski-Chocolate-Box.jpg"));
                    chokladrepository.save(new Chocolate("Boite Maison", 1856.89, "Selection of 93 ganaches,pralines and dark chocolate truffles", "La Maison du Chocolat", 1500, 0, "", false, "Grand-Cru-by-Pierre-Marcolni-1.jpg"));
                    chokladrepository.save(new Chocolate("Sweet Surprise Tower", 899.58, "Creamy milk chocolates and luscious chocolate truffles", "Godiva", 3000, 0, "", false, "Richart-Chocolate.jpg"));
                    chokladrepository.save(new Chocolate("Milk Chocolate Dipped Strawberies", 765, "12 sweet strawberries covered in smooth milk chocolate ", "Godiva", 3000, 0, "", false, "Voges-Haut.jpg"));
                    chokladrepository.save(new Chocolate("Chocolate Pearls", 449.80, " Dark Chocolate Pearls 55%, Dark Chocolate Crunchy Pearls 55%, CARAMÉLIA 36% Crunchy Pearls.", "Valrhona", 4000, 0, "", false, "Chocolates-with-Edible-Gold-by-DeLafee.jpg"));
                    chokladrepository.save(new Chocolate("Coffret Selection", 525.45, "An assortment of almonds and hazelnuts coated in milk chocolate", "Valrhona", 3500, 0, "", false, "Amedei-Porcelana.jpg"));
                    chokladrepository.save(new Chocolate("Tosca", 567.25, "A box with 7 delightful artisan chocolates, the best southern European almonds covered in chocolate", "Puccini bomboni", 1000, 0, "", false, "The-Aficionados-Collection.jpg"));
                  
                          
                };

            }
            @Bean
            
                CommandLineRunner init(PersonRepository personrepository){
                
                return args ->{
                    
                    personrepository.save(new Person("Alice Svensson", "Alice", "Alice123", "Annavägen 12", false, false));
                    personrepository.save(new Person("Maja Adolfsson", "Maja", "Maja123", "Majavägen 10", false, false));
                    personrepository.save(new Person("Ella Asplund", "Ella", "Ella123", "Ellavägen 5", false, false));
                    personrepository.save(new Person("Olivia Bauer", "Olivia", "Olivia123", "Oliviavägen 3", false, false));
                    personrepository.save(new Person("Jenny Svensson", "Jenny", "Jenny123", "Jennyvägen 1", true, false));
                    personrepository.save(new Person("Leo Messi", "Messi", "Leo123", "Leovägen 3", false, false));
                    personrepository.save(new Person("Gabriel Agrell", "Gabriel", "Gabriel123", "Gabrielvägen 3", false, false));
                    personrepository.save(new Person("Elton John", "Elton", "Elton123", "Eltonvägen 3", false, true));
                    personrepository.save(new Person("Lady Gaga", "Lady", "Lady123", "Ladyvägen 1", false, true));
                    personrepository.save(new Person("Taylor Swift", "Taylor", "Taylor123", "Taylorvägen 1", false, false));
                    personrepository.save(new Person("Testperson testis", "t", "t", "Testvagen 1", false, false));
                    personrepository.save(new Person("Admin", "Admin", "Password", "Adminvagen 1", true, false));


                    
                };
                
            }
            
            @Bean
            
                CommandLineRunner init(OrderDetailsRepository orderDetalisRepository){
                 return args->{
                
                
                };
                 
                 
            }
            @Bean 
                 
                CommandLineRunner init(OrderRepository orderRepository){
                    return args->{
                            
                        
                        
                    };
                }
                
            
}
