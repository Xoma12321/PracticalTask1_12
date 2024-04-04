import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car implements Externalizable {
    private String name;
    private int year;
    private String gosNomer;
    private boolean carCondition;
    private int price;

    public Car(String name, int year, String gosNomer, boolean carCondition, int price) {
        this.name = name;
        this.year = year;
        this.gosNomer = gosNomer;
        this.carCondition = carCondition;
        this.price = price;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGosNomer() {
        return gosNomer;
    }

    public void setGosNomer(String gosNomer) {
        this.gosNomer = gosNomer;
    }

    public boolean isCarCondition() {
        return carCondition;
    }

    public void setCarCondition(boolean carCondition) {
        this.carCondition = carCondition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.getYear());
        out.writeObject(this.getGosNomer());
        out.writeObject(this.isCarCondition());
        out.writeObject(this.getPrice());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String)in.readObject();
        this.year = (Integer) in.readObject();
        this.gosNomer = (String) in.readObject();
        this.carCondition = (Boolean) in.readObject();
        this.price = (Integer) in.readObject();
    }
    @Override
    public String toString() {
        return "Car(Name : " + this.name + ", year : " + this.year + ", GosNomer : " + this.gosNomer + ", carCondition : " + this.carCondition + ", price: " + this.price + ")\n";
    }
}
