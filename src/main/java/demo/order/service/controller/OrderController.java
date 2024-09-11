package demo.order.service.controller;

import demo.order.service.feign.UserClient;
import demo.order.service.feign.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/{orderId}/user/{userId}")
    public String getOrderWithUser(@PathVariable("orderId") Long orderId, @PathVariable("userId") Long userId) {
        UserResponse user = userClient.getUserById(userId);
        return "Order ID: " + orderId + ", User: " + user.getName() + ", Email: " + user.getEmail();
    }
}
