package store.order;

import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(fluent = true)
public class Order implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String idUser; // melhor passar o objeto account
    private Date date;
    private Double total;
    private List<Item> items;
}