package store.order;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.product.ProductController;
import store.product.ProductOut;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductController productController;

    public Order findByIdOrder(String idOrder, String userId) {
        OrderModel model = orderRepository.findByIdOrderAndIdUser(idOrder, userId);
        return model == null ? null : model.to();
    }

    public List<Order> findAllByUser(String userId) {
        return orderRepository.findAllByIdUser(userId)
                              .stream()
                              .map(OrderModel::to)
                              .toList();
    }

    public Order create(Order order) {
        order.date(new Date());
        order.total(calculateTotal(order.items()));

        OrderModel saved = orderRepository.save(new OrderModel(order));
        persistItems(order.items(), saved);

        return saved.to();
    }

    public Order update(Order order) {
        OrderModel existing = orderRepository
                .findByIdOrderAndIdUser(order.id(), order.idUser());

        if (existing == null) return null;

        existing.date(new Date());
        existing.total(calculateTotal(order.items()));

        existing.items().clear();
        persistItems(order.items(), existing);

        orderRepository.save(existing);
        return existing.to();
    }

    public void delete(String idOrder, String userId) {
        OrderModel existing = orderRepository.findByIdOrderAndIdUser(idOrder, userId);
        if (existing != null) orderRepository.delete(existing);
    }

    /* ---------- helpers ---------- */

    private void persistItems(List<Item> items, OrderModel order) {
        if (items == null) return;

        for (Item i : items) {
            i.price(fetchPrice(i.productId()));
            ItemModel im = new ItemModel(i, order);
            order.items().add(im);
        }
    }

    private Double calculateTotal(List<Item> items) {
        if (items == null) return 0.0;
        return items.stream()
                    .mapToDouble(i -> fetchPrice(i.productId()) * i.quantity())
                    .sum();
    }

    private Double fetchPrice(String productId) {
        ProductOut product = productController.findByIdProduct(productId).getBody();
        return product != null ? product.price() : 0.0;
    }
}