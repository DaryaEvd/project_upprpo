package ru.nsu.fit.capibaras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    static final ClientDataManager CLIENT_DATA_MANAGER = new ClientDataManager();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}