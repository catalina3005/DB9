package repository;

import model.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomersRepository extends CrudRepository<Customers, Integer> {
    public Optional<Customers> findById(Integer id);
    public List<Customers> findAll();
    public void delete(Customers customer);
}