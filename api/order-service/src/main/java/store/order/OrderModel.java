package store.order;

import jakarta.persistence.*;
import java.util.*;
import java.util.stream.Collectors;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Table(name = "orders", schema = "order")
@Getter
@Setter
@Accessors(fluent = true)          // generates fluent  accessors: id(), date() …
@NoArgsConstructor
public class OrderModel {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idOrder;

    @Column(name = "date")
    private Date date;

    @Column(name = "total")
    private Double total;

    @Column(name = "id_user")
    private String idUser;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemModel> items = new ArrayList<>();

    public OrderModel(Order source) {
        this.idOrder = source.id();
        this.idUser  = source.idUser();
        this.date    = source.date();
        this.total   = source.total();
    }

    public Order to() {
        return Order.builder()
                .id(idOrder)
                .idUser(idUser)
                .date(date)
                .total(total)
                .items(items.stream().map(ItemModel::to).toList())
                .build();
    }
}