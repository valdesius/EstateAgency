package com.vsu;

import com.vsu.domain.Client;
import com.vsu.repository.ClientRepository;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        List<Client> clientList = context.getBean(ClientRepository.class).findAll();
        clientList.stream().forEach(System.out::println);
//        try {
//            Console.main(args);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }
}
