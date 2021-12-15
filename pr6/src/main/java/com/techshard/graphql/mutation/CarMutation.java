package com.techshard.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.techshard.graphql.dao.entity.Car;
import com.techshard.graphql.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarMutation implements GraphQLMutationResolver {

    @Autowired
    private CarService carService;

    public Car createCar(final String title, final String brand, final int price, final int age) {
        return this.carService.createCar(title, brand, price, age);
    }
}
