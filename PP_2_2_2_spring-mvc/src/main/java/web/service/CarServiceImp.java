package web.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
@Service
public class CarServiceImp implements CarService {
    private final List<Car> carList;

    public CarServiceImp() {
        this.carList = new ArrayList<>();
        carList.add(new Car("Ford", 258, "Black"));
        carList.add(new Car("BMW", 845, "Red"));
        carList.add(new Car("Lada", 369, "White"));
        carList.add(new Car("KIA", 123, "Green"));
        carList.add(new Car("Toyota", 895, "Blue"));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getFixedCarList(Integer count) {
        return new ArrayList<>(carList.subList(0, count));
    }
}
