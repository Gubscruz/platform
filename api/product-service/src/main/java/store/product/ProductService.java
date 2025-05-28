package store.product;

import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Cacheable(value = "productById", key = "#idProduct")
    public Product findByIdProduct(String idProduct) {
        return productRepository.findByIdProduct(idProduct).to();
    }

    public Product create(Product product) {
        product.creation(new Date());
        product.update(new Date());

        return productRepository.save(new ProductModel(product)).to();
    }

    public Product update(Product product) {
        ProductModel productModel = productRepository.findByIdProduct(product.idProduct());
        if (productModel == null) {
            return null;
        }
        productModel.name(product.name());
        productModel.category(product.category());
        productModel.description(product.description());
        productModel.price(product.price());
        productModel.creation(productModel.creation());
        productModel.update(new Date());
    
        return productRepository.save(new ProductModel(product)).to();
    }

    public void delete(String idProduct) {
        ProductModel productModel = productRepository.findByIdProduct(idProduct);
        if (productModel == null) {
            return;
        }
        productRepository.delete(productModel);
    }
    
    public List<Product> findAll() {
        return StreamSupport
            .stream(productRepository.findAll().spliterator(), false)
            .map(ProductModel::to)
            .toList();
    }

}
