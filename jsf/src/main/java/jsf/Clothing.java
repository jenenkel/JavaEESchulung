package jsf;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Clothing {
    private String name;
    private boolean selected = false;
    private double price;

    public Clothing(String name) {
        this.name = name;
        this.price = Math.round(ThreadLocalRandom.current().nextDouble(0, 100));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public double getPrice() {
        return price;
    }
}
