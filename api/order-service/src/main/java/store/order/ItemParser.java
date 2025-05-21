package store.order;

public class ItemParser {

    public static Item to(ItemIn in) {
        return in == null ? null :
            Item.builder()
                .productId(in.idProduct)
                .quantity(in.quantity)
                .build();
    }

    public static ItemOut to(Item i) {
        return i == null ? null :
            ItemOut.builder()
                .id(i.id())
                .product(ProductRef.builder().id(i.productId()).build())
                .quantity(i.quantity())
                .total(i.price() * i.quantity())
                .build();
}
}