package hello;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import book.bean.Book;
import book.controller.BookAppRestController;

@SpringBootApplication
@ComponentScan(basePackages="book")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
