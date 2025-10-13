import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectronicItem extends Item {

    private String brand;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Override
    public String getTypeInfo() {
        return "Type: Electronic Item / Brand: " + brand;
    }

}
