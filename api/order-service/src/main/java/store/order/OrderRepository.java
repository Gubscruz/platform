package store.order;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderModel, String> {

    List<OrderModel> findAllByIdUser(String idUser);

    OrderModel findByIdOrderAndIdUser(String idOrder, String idUser);
}