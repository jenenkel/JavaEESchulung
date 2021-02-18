package jsf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Clothing {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private boolean selected = false;
    private double price;

    public Clothing() {
    }

    public Clothing(String name) {
        this.name = name;
        this.price = Math.round(ThreadLocalRandom.current().nextDouble(0, 100));
    }


    public long getId() {
        return id;
    }

    public boolean isSelected() {
        return selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public double getPrice() {
        return price;
    }
}
