package com.techshard.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.techshard.graphql.dao.entity.Car;
import com.techshard.graphql.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarQuery implements GraphQLQueryResolver {

    @Autowired
    private CarService carService;

    public List<Car> getCars(final int count) {
        return this.carService.getAllCars(count);
    }

    public Optional<Car> getCar(final int id) {
        return this.carService.getCar(id);
    }
}
