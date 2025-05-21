package store.order;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderResource implements OrderController {

    @Autowired
    private OrderService svc;

    @Override
    public ResponseEntity<OrderOut> create(
            @RequestBody OrderIn in,
            @RequestHeader("User-Id") String uid) {

        Order created = svc.create(OrderParser.to(in, uid));
        return ResponseEntity.ok(OrderParser.to(created));
    }

    @Override
    public ResponseEntity<List<OrderOut>> findAll(
            @RequestHeader("User-Id") String uid) {

        return ResponseEntity.ok(
                svc.findAllByUser(uid).stream().map(OrderParser::to).toList()
        );
    }

    @Override
    public ResponseEntity<OrderOut> findByIdOrder(
            @PathVariable("id") String id,
            @RequestHeader("User-Id") String uid) {

        Order o = svc.findByIdOrder(id, uid);
        return o == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(OrderParser.to(o));
    }

    @Override
    public ResponseEntity<OrderOut> update(
            @PathVariable("id") String id,
            @RequestBody OrderIn in,
            @RequestHeader("User-Id") String uid) {

        Order updated = svc.update(OrderParser.to(in, uid).id(id));
        return updated == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(OrderParser.to(updated));
    }

    @Override
    public ResponseEntity<Void> delete(
            @PathVariable("id") String id,
            @RequestHeader("User-Id") String uid) {

        svc.delete(id, uid);
        return ResponseEntity.noContent().build();
    }
}