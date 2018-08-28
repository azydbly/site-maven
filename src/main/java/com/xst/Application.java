package com.xst;

import com.xst.controller.BaseController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableCaching
@MapperScan(basePackages = "com.*.mapper")
@SpringBootApplication
public class Application extends BaseController {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    String home(){
        return "login";
    }

    @RequestMapping("/404")
    String notFound() {
        return "error/404";
    }

    @RequestMapping("/500")
    String error() {
        return "error/500";
    }


}

