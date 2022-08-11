package repository;
import model.Orders;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
    public Optional<Orders> findById(Integer Id);
    public List<Orders> findAll();

}