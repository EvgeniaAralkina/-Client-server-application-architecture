package com.techshard.graphql.service;

import com.techshard.graphql.dao.entity.Car;
import com.techshard.graphql.dao.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository ;
    public CarService(final CarRepository carRepository) {
        this.carRepository = carRepository ;
    }

    @Transactional
    public Car createCar(final String title, final String brand, final int price, final int age) {
        final Car car = new Car();
        car.setAge(age);
        car.setBrand(brand);
        car.setPrice(price);
        car.setTitle(title);
        return this.carRepository.save(car);
    }

    @Transactional(readOnly = true)
    public List<Car> getAllCars(final int count) {
        return this.carRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Car> getCar(final int id) {
        return this.carRepository.findById(id);
    }
}
