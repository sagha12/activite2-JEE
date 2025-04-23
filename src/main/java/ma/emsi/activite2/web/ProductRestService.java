package ma.emsi.activite2.web;

import ma.emsi.activite2.entities.Product;
import ma.emsi.activite2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> products(){
        return productRepository.findAll();
    }
    @GetMapping("/product/{id}")
    public Product findProduct(@PathVariable Long id){
        return productRepository.findById(id).get();
    }
}
