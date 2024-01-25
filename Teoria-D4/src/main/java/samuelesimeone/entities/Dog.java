package samuelesimeone.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cane")
public class Dog extends Animal{

    private double maxSpeed;

    public Dog() {
    }

    public Dog(String name, int age, double maxSpeed) {
        super(name, age);
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "maxSpeed=" + maxSpeed +
                '}';
    }
}
