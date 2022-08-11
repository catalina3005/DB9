package model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Customers {
    @Id
    @GeneratedValue
    private Integer id;
    @NonNull
    private String name;
    private String email;
}
