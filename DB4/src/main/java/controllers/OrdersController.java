package controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.OrdersService;
import model.Orders;
import java.util.List;
import java.util.Optional;

@RestController
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    //INSERT
    @PostMapping("/orders")
    public Orders save(@RequestBody Orders orders){
        return ordersService.saveOrders(orders);
    }

    //GET ALL
    @GetMapping("/orders/all")
    public List<Orders> getAll() {
        return ordersService.getAllOrders();
    }

    //GET BY ID
    @GetMapping("/orders/{Id}")
    public Optional<Orders> getById(@PathVariable("Id") Integer id){
        return ordersService.getById(id);
    }

    //UPDATE
    @PutMapping("/orders/{ID}")
    public Orders update(@RequestBody Orders orders, @PathVariable("ID") Integer id) {
        return ordersService.updateOrders(orders, id);
    }

    //DELETE
    @DeleteMapping("/orders/{ID}")
    public String delete(@PathVariable("ID")Integer id){
        ordersService.deleteOrders(id);
        return "Deleted Successfully";
    }
}