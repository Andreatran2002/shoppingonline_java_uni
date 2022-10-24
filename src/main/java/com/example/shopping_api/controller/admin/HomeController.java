package com.example.shopping_api.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // Chỉ định HomeController là Controller
public class HomeController {
    // Khi user truy cập vào endpoint / thì homepage() được gọi
    @GetMapping("/")
    public String homepage() {
        return "index.html";  // Trả về trang index.html
    }

    // Có thể mapping thêm các endpoint khác nữa...
}