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
            itemOption = scanner.nextInt();
            if (itemOption == 1) {
                addNewItem();
            }

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
    public static void addNewItem() {
        System.out.println("Add a new item");
        boolean flag = true;
        while (flag) {
            Item item = new Item();
            System.out.println("Enter the item id");
            Integer itemId = scanner.nextInt();
            while (itemId == null || itemId < 0 || checkIfItemIdExists(itemId)) {
                System.out.println("Input is not accepted, please enter another ID");
                itemId = scanner.nextInt();
            }
            item.setId(itemId);
            scanner.nextLine();
            System.out.println("Enter item name");
            String itemName = scanner.nextLine();
            item.setName(itemName);

            System.out.println("Enter item price");
            float itemPrice = scanner.nextFloat();
            scanner.nextLine();
            item.setPrice(itemPrice);

            itemsList.add(item);
            System.out.println("The item successfully added");
            System.out.println("Do you want to exit press (q) or press anything else to cont. !");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")) {
                flag = false;
            }
        }
    }


}
