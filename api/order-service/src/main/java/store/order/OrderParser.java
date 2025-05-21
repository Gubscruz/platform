package store.order;

import java.util.ArrayList;
import java.util.List;

public class OrderParser {

    public static Order to(OrderIn in, String userId) {
        if (in == null) return null;

        List<Item> items = in.items() == null
                ? new ArrayList<>()
                : in.items().stream().map(ItemParser::to).toList();

        return Order.builder()
                .idUser(userId)
                .items(items)
                .build();
    }

    public static OrderOut to(Order o) {
        if (o == null) return null;

        List<ItemOut> items = o.items() == null
                ? new ArrayList<>()
                : o.items().stream().map(ItemParser::to).toList();

        return OrderOut.builder()
                .id(o.id())
                .date(o.date())
                .total(o.total())
                .items(items)
                .build();
    }
}