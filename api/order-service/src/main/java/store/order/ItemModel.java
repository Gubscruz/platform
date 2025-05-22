package store.order;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Table(name = "item", schema = "store_order")
@Getter @Setter @NoArgsConstructor @Accessors(fluent = true)
public class ItemModel {

    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idItem;

    @Column(name = "id_product")
    private String idProduct;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "item_price")
    private Double itemPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    private OrderModel order;

    public ItemModel(Item source, OrderModel order) {
        this.idItem = source.id();
        this.idProduct = source.productId();
        this.quantity = source.quantity();
        this.itemPrice = source.price();
        this.order = order;
    }

    public Item to() {
        return Item.builder()
            .id(idItem)
            .productId(idProduct)
            .quantity(quantity)
            .price(itemPrice)
            .build();
    }
}