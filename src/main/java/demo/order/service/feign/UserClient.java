package demo.order.service.feign;

import demo.order.service.feign.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8080")
public interface UserClient {

    @GetMapping(value = "/users/{id}", produces = "application/json")
    UserResponse getUserById(@PathVariable("id") Long id);
}
