package store.product;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(name = "product", url = "http://product:8080")
public interface ProductController {

    @PostMapping("/product")
    ResponseEntity<ProductOut> create(
        @RequestBody ProductIn productIn
    );

    @GetMapping("/product")
    ResponseEntity<List<ProductOut>> findAll();

    @GetMapping("/product/{id-product}")
    ResponseEntity<ProductOut> findByIdProduct(
        @PathVariable("id-product") String idProduct
    );

    @PutMapping("/product/{id-product}")
    ResponseEntity<ProductOut> update(
        @PathVariable("id-product") String idProduct, 
        @RequestBody ProductIn productIn
    );

    @DeleteMapping("/product/{id-product}")
    ResponseEntity<Void> delete(
        @PathVariable("id-product") String idProduct
    );
}
