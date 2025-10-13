import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FurnitureItem extends Item {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getTypeInfo() {
        return "Type: Furniture Item / color: " + color;
    }
}
