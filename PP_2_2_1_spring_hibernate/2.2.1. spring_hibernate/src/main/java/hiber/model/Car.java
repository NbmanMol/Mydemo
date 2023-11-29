package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userCar")
    Long car_id;
    @Column(name = "model")
    String model;
    @Column(name = "series")
    Integer series;
    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", model='" + model + '\'' +
                ", series=" + series +
                ", user=" + user +
                '}';
    }
}
