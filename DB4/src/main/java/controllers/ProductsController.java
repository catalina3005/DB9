package controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ProductsService;
import model.Products;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {
    @Autowired
    ProductsService productsService;

    //INSERT
    @PostMapping("/products")
    public Products save(@RequestBody Products product){

        return productsService.saveProducts(product);
    }

    //GET ALL
    @GetMapping("/products/all")
    public List<Products> findAll(){
        return productsService.getAllProducts();
    }

    //GET BY ID
    @GetMapping("/products/{id}")
    public Optional<Products> getById(@PathVariable("id") Integer id){

        return productsService.getById(id);
    }

    // UPDATE
    @PutMapping("/products/{id}")
    public Products update(@RequestBody Products product,
                           @PathVariable("id") Integer id)
    {

        return productsService.updateProducts(product, id);
    }

    // DELETE
    @DeleteMapping("/products/{id}")
    public String deleteProducts(@PathVariable("id") Integer id)
    {

        productsService.deleteProducts(id);
        return "Deleted Successfully";
    }


}