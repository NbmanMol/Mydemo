package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service implements Serv {
    public static List<Car> carCount(int count) {
        List<Car> carList = new ArrayList<>();
        List<Car> cars = new ArrayList<>(count);
        carList.add(new Car("Ford", 258, "Black"));
        carList.add(new Car("BMW", 845, "Red"));
        carList.add(new Car("Lada", 369, "White"));
        carList.add(new Car("KIA", 123, "Green"));
        carList.add(new Car("Toyota", 895, "Blue"));
        cars.addAll(carList.subList(0,count));
        return cars;
    }
}
