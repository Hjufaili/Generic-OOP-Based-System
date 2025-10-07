import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainDriver {
    public static List<Item> itemsList = new ArrayList<>();
    public static Integer itemOption = 0;
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        while (itemOption != 5) {
            showItemMenu();

        }
    }


    public static void showItemMenu() {
        System.out.println("""
                =====Item Management Menu=====
                1- Add a new item
                2- Edit an Existing Item
                3- Remove an Item
                4- Display All Items
                5- Exit
                ==============================
                Please enter your choice:
                """);
    }


}
