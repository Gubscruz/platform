package store.product;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder @Accessors(fluent = true)
public record ProductIn(
    String name,
    String category,
    String description,
    Double price
) {
    
}
