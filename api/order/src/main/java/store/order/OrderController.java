package store.order;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "order", url = "http://order:8080")
public interface OrderController {

    @PostMapping("/order")
    ResponseEntity<OrderOut> create(
            @RequestBody OrderIn orderIn,
            @RequestHeader("User-Id") String userId
    );

    @GetMapping("/order")
    ResponseEntity<List<OrderOut>> findAll(@RequestHeader("User-Id") String userId);

    @GetMapping("/order/{id}")
    ResponseEntity<OrderOut> findByIdOrder(
            @PathVariable("id") String idOrder,
            @RequestHeader("User-Id") String userId
    );

    @PutMapping("/order/{id}")
    ResponseEntity<OrderOut> update(
            @PathVariable("id") String idOrder,
            @RequestBody OrderIn orderIn,
            @RequestHeader("User-Id") String userId
    );

    @DeleteMapping("/order/{id}")
    ResponseEntity<Void> delete(
            @PathVariable("id") String idOrder,
            @RequestHeader("User-Id") String userId
    );
}