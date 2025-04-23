package ma.emsi.activite2;

import ma.emsi.activite2.entities.Product;
import ma.emsi.activite2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Activite2Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(Activite2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //productRepository.save(new Product(null,"Computer",1000,3));
        //productRepository.save(new Product(null,"Phone",1200,5));
        //productRepository.save(new Product(null,"TV",5000,2));
        List<Product> products = productRepository.findAll();
        products.forEach(System.out::println);
        Product product = productRepository.findById(2L).get();
        System.out.println(product);
        System.out.println("*************************************");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(System.out::println);
        System.out.println("*************************************");
        List<Product> productList2 = productRepository.search("%C%");
        productList2.forEach(System.out::println);
        System.out.println("*************************************");
        List<Product> productList3 = productRepository.findByPriceGreaterThan(1200);
        productList3.forEach(System.out::println);
        System.out.println("*************************************");
        List<Product> productList4 = productRepository.searchByPrice(1200);
        productList4.forEach(System.out::println);
    }
}
