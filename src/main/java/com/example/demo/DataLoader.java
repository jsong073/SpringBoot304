package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CarRepository carRepository;

    @Override
    public void run (String... strings) throws Exception {
        Car car;
        car = new Car("2019", "Honda", "Civic", "White");
        carRepository.save(car);
        car = new Car("2015", "Toyota", "Camry", "Red");
        carRepository.save(car);
        car = new Car("2009", "Ford", "F150", "Gray");
        carRepository.save(car);
    }
}
