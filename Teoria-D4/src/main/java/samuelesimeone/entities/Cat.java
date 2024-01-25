package samuelesimeone.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("gatto")
public class Cat extends Animal{
    private double maxJumping;

    public Cat() {
    }

    public Cat(String name, int age, double maxJumping) {
        super(name, age);
        this.maxJumping = maxJumping;
    }

    public double getMaxJumping() {
        return maxJumping;
    }

    public void setMaxJumping(double maxJumping) {
        this.maxJumping = maxJumping;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "maxJumping=" + maxJumping +
                '}';
    }
}
