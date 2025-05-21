package store.product;

public class ProductParser {

    public static Product to(ProductIn in) {
        return in == null ? null :
            Product.builder()
                .name(in.name())
                .category(in.category())
                .description(in.description())
                .price(in.price() == null ? null : in.price().doubleValue())
                .build();
    }

    public static ProductOut to(Product p) {
        return p == null ? null :
            ProductOut.builder()
                .idProduct(p.idProduct())
                .name(p.name())
                .category(p.category())
                .description(p.description())
                .price(p.price())
                .build();
    }

}