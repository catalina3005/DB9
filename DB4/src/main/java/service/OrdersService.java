package service;
import model.Orders;
import repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    //GET ALL
    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    //GET BY ID
    public Optional<Orders> getById(Integer id){
        return ordersRepository.findById(id);
    }

    //INSERT
    public Orders saveOrders(Orders orders){
        return ordersRepository.save(orders);
    }

    //UPDATE
    public Orders updateOrders(Orders orders, Integer id){
        Orders o = ordersRepository.findById(id).get();

        if(Objects.nonNull(orders.getStatus()) && !"".equalsIgnoreCase(orders.getStatus())){
            o.setStatus(orders.getStatus());
        }
        if(Objects.nonNull(orders.getComments()) && !"".equalsIgnoreCase(orders.getComments())){
            o.setComments(orders.getComments());
        }
        return ordersRepository.save(o);
    }

    //DELETE
    public void deleteOrders(Integer id){
        ordersRepository.deleteById(id);
    }
}