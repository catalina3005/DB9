package service;
import model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductsRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    //GET ALL

    public List<Products> getAllProducts() {
        //List<Products> aux = new ArrayList<>();
        //  productsRepository.findAll().iterator().forEachRemaining(aux::add);
        //  return aux;
        return (List<Products>)productsRepository.findAll();
    }

    //GET BY ID
    public Optional<Products> getById(Integer id) {
        return productsRepository.findById(id);
    }

    //INSERT
    public Products saveProducts(Products product){
        return productsRepository.save(product);
    }

    //UPDATE
    public Products updateProducts(Products product, Integer id) {
        Products p = productsRepository.findById(id).get();

        if(Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())) {
            p.setName((product.getName()));
        }
        if(Objects.nonNull(product.getPrice())) {
            p.setPrice((product.getPrice()));
        }
        return productsRepository.save(p);

    }

    //DELETE
    public void deleteProducts(Integer id){
        productsRepository.deleteById(id);
    }

}