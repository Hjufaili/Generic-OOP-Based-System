import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemService {

    private static List<Item> itemsList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);


    public static void addNewItem() {
        System.out.println("Select item type:");
        System.out.println("1 - General Item");
        System.out.println("2 - Electronic Item");
        System.out.println("3 - Furniture Item");
        System.out.println("4 - Stationery Item");
        int type = scanner.nextInt();
        scanner.nextLine();

        Item item;
        switch (type) {
            case 2 -> item = new ElectronicItem();
            case 3 -> item = new FurnitureItem();
            case 4 -> item = new StationeryItem();
            default -> item = new Item();
        }

        System.out.println("Enter the item ID:");
        Integer itemId = scanner.nextInt();
        while (itemId == null || itemId < 0 || checkIfItemIdExists(itemId)) {
            System.out.println("Invalid or duplicate ID. Enter another:");
            itemId = scanner.nextInt();
        }
        item.setId(itemId);
        scanner.nextLine();

        System.out.println("Enter item name:");
        String name = scanner.nextLine();
        while (HelperUtils.isNull(name) || HelperUtils.checkIfEmptyOrBlank(name)) {
            System.out.println("Name cannot be empty. Try again:");
            name = scanner.nextLine();
        }
        item.setName(name);

        System.out.println("Enter item price:");
        float price = scanner.nextFloat();
        item.setPrice(price);
        scanner.nextLine();

        if (item instanceof ElectronicItem electronic) {
            System.out.println("Enter brand:");
            electronic.setBrand(scanner.nextLine());
        } else if (item instanceof FurnitureItem furniture) {
            System.out.println("Enter brand:");
            furniture.setBrand(scanner.nextLine());
        } else if (item instanceof StationeryItem stationery) {
            System.out.println("Enter brand:");
            stationery.setBrand(scanner.nextLine());
        }

        itemsList.add(item);
        System.out.println("Item added successfully!");
    }

    public static void editExistingItem() {
        System.out.println("Enter the ID of the item you want to edit:"); // 👈 Better to use ID (names may not be unique)
        Integer itemId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Item foundItem = null;
        for (Item item : itemsList) {
            if (item.getId().equals(itemId)) {
                foundItem = item;
                break;
            }
        }

        if (foundItem == null) {
            System.out.println("No item found with ID: " + itemId);
            return;
        }

        // Edit common fields (name, price)
        System.out.println("Current name: " + foundItem.getName());
        System.out.println("Enter new name (or press Enter to keep current):");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            // Optional: check for duplicate name among other items (excluding self)
            boolean nameExists = false;
            for (Item item : itemsList) {
                if (!item.getId().equals(foundItem.getId()) && item.getName().equals(newName)) {
                    nameExists = true;
                    break;
                }
            }
            if (nameExists) {
                System.out.println("Name already exists. Keeping current name.");
            } else {
                foundItem.setName(newName);
            }
        }

        System.out.println("Current price: " + foundItem.getPrice());
        System.out.println("Enter new price (or press Enter to keep current):");
        String priceInput = scanner.nextLine();
        if (!priceInput.isEmpty()) {
            try {
                float newPrice = Float.parseFloat(priceInput);
                if (newPrice >= 0) {
                    foundItem.setPrice(newPrice);
                } else {
                    System.out.println("Price must be non-negative. Keeping current price.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Keeping current price.");
            }
        }

        if (foundItem instanceof ElectronicItem electronic) {
            System.out.println("Current brand: " + electronic.getBrand());
            System.out.println("Enter new brand (or press Enter to keep current):");
            String brand = scanner.nextLine();
            if (!brand.isEmpty()) {
                electronic.setBrand(brand);
            }
        } else if (foundItem instanceof FurnitureItem furniture) {
            System.out.println("Current brand: " + furniture.getBrand());
            System.out.println("Enter new brand (or press Enter to keep current):");
            String brand = scanner.nextLine();
            if (!brand.isEmpty()) {
                furniture.setBrand(brand);
            }
        } else if (foundItem instanceof StationeryItem stationery) {
            System.out.println("Current brand: " + stationery.getBrand());
            System.out.println("Enter new brand (or press Enter to keep current):");
            String brand = scanner.nextLine();
            if (!brand.isEmpty()) {
                stationery.setBrand(brand);
            }
        }

        System.out.println("Item updated successfully!");
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
            System.out.println("No items.");
            return;
        }

        for (Item item : itemsList) {
            System.out.println("Name: " + item.getName());
            System.out.println("Price: " + item.getPrice());
            System.out.println("ID: " + item.getId());

            if (item instanceof ElectronicItem e) {
                System.out.println("Type: Electronic, Brand: " + e.getBrand());
            } else if (item instanceof FurnitureItem f) {
                System.out.println("Type: Furniture, Brand: " + f.getBrand());
            } else if (item instanceof StationeryItem s) {
                System.out.println("Type: Stationery, Brand: " + s.getBrand());
            } else {
                System.out.println("Type: General Item");
            }
            System.out.println("------------------------");
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
