package store.product;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Builder
@Data @Accessors(fluent = true)
public class Product {

    private String idProduct;
    private String name;
    private String category;
    private String description;
    private Double price;
    private Date creation;
    private Date update;
    
}
