package store.product;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "product")
@Getter
@Setter
@Accessors(fluent = true)
@NoArgsConstructor
public class ProductModel {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idProduct;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Double price;

    @Column(name = "creation")
    private Date creation;

    @Column(name = "update")
    private Date update;

    public ProductModel(Product p) {
        this.idProduct = p.idProduct();
        this.name = p.name();
        this.description = p.description();
        this.category = p.category();
        this.price = p.price();
        this.creation = p.creation();
        this.update = p.update();
    }

    public Product to() {
        return Product.builder()
            .idProduct(idProduct)
            .name(name)
            .description(description)
            .category(category)
            .price(price)
            .creation(creation)
            .update(update)
            .build();
    }
}