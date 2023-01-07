package com.example.brickorderingsystem;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrickOrderController {
    private final BrickOrderService orderService;

    public BrickOrderController(final BrickOrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Creates an order for a given number of bricks.
     *
     * @param numberOfBricks number of bricks to order
     * @return a reference to the order created
     */
    @PostMapping("/createOrder") // post instead of put due to idempotency
    public String createOrder(@RequestParam final int numberOfBricks) {
        return this.orderService.createOrder(numberOfBricks);
    }

    @GetMapping("/getOrder")
    public Order getOrder(@RequestParam final String reference) {
        return this.orderService.getOrder(reference);
    }

    @GetMapping("/getOrders")
    public List<Order> getOrders() {
        return this.orderService.getOrders();
    }
}
