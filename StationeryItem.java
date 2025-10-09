import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StationeryItem extends Item {

    private String brand;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    private static List<StationeryItem> stationeryList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);


    public static void addNewItem() {
        System.out.println("Add a new item");
        boolean flag = true;
        while (flag) {
            StationeryItem stationeryItem = new StationeryItem();
            System.out.println("Enter the item id");
            Integer itemId = scanner.nextInt();
            while (itemId == null || itemId < 0 || checkIfItemIdExists(itemId)) {
                System.out.println("Input is not accepted, please enter another ID");
                itemId = scanner.nextInt();
            }
            stationeryItem.setId(itemId);
            scanner.nextLine();
            System.out.println("Enter item name");
            String itemName = scanner.nextLine();
            stationeryItem.setName(itemName);

            System.out.println("Enter item price");
            float itemPrice = scanner.nextFloat();
            scanner.nextLine();
            stationeryItem.setPrice(itemPrice);

            System.out.println("Enter item brand");
            String itemBrand = scanner.nextLine();
            scanner.nextLine();
            stationeryItem.setBrand(itemBrand);

            stationeryList.add(stationeryItem);
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
        for (StationeryItem item : stationeryList) {
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
        for (int i = 0; i < stationeryList.size(); i++) {
            if (stationeryList.get(i).getId().equals(userInput)) {
                stationeryList.remove(i);
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
        if (stationeryList.isEmpty()) {
            System.out.println("No items");
            return;
        }
        System.out.println("Display All Items");
        for (StationeryItem c : stationeryList) {
            System.out.println("the name of item is " + c.getName() +
                    "\n the price is " + c.getPrice());

        }
    }


    public static boolean checkIfItemIdExists(int idToCheck) {
        for (StationeryItem item : stationeryList) {
            if (item.getId() == idToCheck) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfItemNameExists(String nameToCheck) {
        for (StationeryItem item : stationeryList) {
            if (item.getName().equals(nameToCheck)) {
                return true;
            }
        }
        return false;
    }
}
