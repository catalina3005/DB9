package controllers;

import model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CustomersService;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomersController {

    @Autowired
    CustomersService customersService;

    //INSERT CUSTOMERS
    @PostMapping("/customers")
    public Customers saveCustomers(@RequestBody Customers customer){
        return customersService.saveCustomers(customer);
    }

    //GET ALL CUSTOMERS
    @GetMapping("/customers/all")
    public List<Customers> findAll(){
        return customersService.getAllCustomers();
    }

    //GET BY ID
    @GetMapping("/customers/{id}")
    public Optional<Customers> getById(@PathVariable("id") Integer id){
        return customersService.getById(id);
    }

    // UPDATE CUSTOMERS
    @PutMapping("/customers/{id}")
    public Customers updateCustomers(@RequestBody Customers customer,
                                     @PathVariable("id") Integer id)
    {

        return customersService.updateCustomers(customer, id);
    }

    // DELETE CUSTOMERS
    @DeleteMapping("/customers/{id}")
    public String deleteCustomersById(@PathVariable("id") Integer id)
    {

        customersService.deleteCustomersById(id);
        return "Deleted Successfully";
    }
}
