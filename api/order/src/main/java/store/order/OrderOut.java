package store.order;

import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.experimental.Accessors;

@Builder @Accessors(fluent = true)
public record OrderOut(
        String id,
        Date date,
        Double total,
        List<ItemOut> items
) {}