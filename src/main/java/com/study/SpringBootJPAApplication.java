package com.study;

import com.study.model.Book;
import com.study.model.User;
import com.study.service.BookService;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootJPAApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJPAApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(userService.findById(1));
    }
}
