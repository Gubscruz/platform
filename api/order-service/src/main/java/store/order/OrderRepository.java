package store.order;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderModel, String> {

    @EntityGraph(attributePaths = "items")        
    List<OrderModel> findAllByIdUser(String idUser);

    OrderModel findByIdOrderAndIdUser(String idOrder, String idUser);
}