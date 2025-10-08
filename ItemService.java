import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemService {

    private static List<Item> itemsList = new ArrayList<>();
    public static Integer itemOption = 0;
    public static Scanner scanner = new Scanner(System.in);

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

    public static void editExistingItem() {
        System.out.println("Enter the name of the item you want to edit:");
        scanner.nextLine();
        String itemName = scanner.nextLine();

        while (HelperUtils.isNull(itemName) || HelperUtils.checkIfEmptyOrBlank(itemName)) {
            System.out.println("Please enter a valid name:");
            itemName = scanner.nextLine();
        }

        boolean found = false;
        for (Item item : itemsList) {
            if (item.getName().equals(itemName)) {
                System.out.println("Enter the new name for the item:");
                String newName = scanner.nextLine();

                while (HelperUtils.isNull(newName) || HelperUtils.checkIfEmptyOrBlank(newName) ||
                        (checkIfItemNameExists(newName) && !newName.equals(itemName))) {
                    System.out.println("Name is invalid or already exists. Enter a different name:");
                    newName = scanner.nextLine();
                }

                item.setName(newName);
                System.out.println("Item edited successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No item found with the name: " + itemName);
        }
    }

    public static void removeItem() {
        System.out.println("Enter the ID of the item to remove:");
        Integer userInput = scanner.nextInt();

        if (userInput == null || userInput < 0) {
            System.out.println("Invalid input");
            return;
        }

        boolean removed = false;
        for (int i = 0; i < itemsList.size(); i++) {
            if (itemsList.get(i).getId().equals(userInput)) {
                itemsList.remove(i);
                System.out.println("Item removed successfully!");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("No item found with ID: " + userInput);
        }
    }

    public static void displayAllItems() {
        if (itemsList.isEmpty()) {
            System.out.println("No items");
            return;
        }
        System.out.println("Display All Items");
        for (Item c : itemsList) {
            System.out.println("the name of item is " + c.getName() +
                    "\n the price is " + c.getPrice());

        }
    }


    public static boolean checkIfItemIdExists(int idToCheck) {
        for (Item item : itemsList) {
            if (item.getId() == idToCheck) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfItemNameExists(String nameToCheck) {
        for (Item item : itemsList) {
            if (item.getName().equals(nameToCheck)) {
                return true;
            }
        }
        return false;
    }
}
