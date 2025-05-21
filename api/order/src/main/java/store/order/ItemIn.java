package store.order;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder @Accessors(fluent = true)
public class ItemIn {
    public String idProduct;
    public Integer quantity;
}
