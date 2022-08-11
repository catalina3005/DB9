package service;
import model.Customers;
import repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomersService {

    @Autowired
    CustomersRepository customersRepository;

    List<Customers> list = new ArrayList<>();

    //GET ALL CUSTOMERS
    public List<Customers> getAllCustomers() {
        //List<Customers> aux = new ArrayList<>();
        //  customersRepository.findAll().iterator().forEachRemaining(aux::add);
        //  return aux;
        return (List<Customers>)customersRepository.findAll();
    }

    //GET BY ID
    public Optional<Customers> getById(Integer id) {
        return customersRepository.findById(id);
    }

    //INSERT CUSTOMERS
    public Customers saveCustomers(Customers customer){
        return customersRepository.save(customer);
    }

    //UPDATE CUSTOMERS
    public Customers updateCustomers(Customers customer, Integer id) {
        Customers c = customersRepository.findById(id).get();

        if(Objects.nonNull(customer.getName()) && !"".equalsIgnoreCase(customer.getName())) {
            c.setName((customer.getName()));
        }
        if(Objects.nonNull(customer.getEmail()) && !"".equalsIgnoreCase(customer.getEmail())) {
            c.setEmail((customer.getEmail()));
        }
        return customersRepository.save(c);

    }

    //DELETE CUSTOMERS
    public void deleteCustomersById(Integer id){
        customersRepository.deleteById(id);
    }

}