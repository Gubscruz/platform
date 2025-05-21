package store.order;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<ItemModel, String> {

    List<ItemModel> findAllByOrder_IdOrder(String idOrder);
}