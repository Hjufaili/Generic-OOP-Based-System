import java.util.Scanner;

public class FurnitureItemService {

    private static Scanner scanner = new Scanner(System.in);

    public static void addFurnitureItem() {
        FurnitureItem item = new FurnitureItem();

        item.setId(ItemService.inputId());
        item.setName(ItemService.inputName());
        item.setPrice(ItemService.inputPrice());

        System.out.println("Enter color:");
        String color = scanner.nextLine();
        while (color == null || color.trim().isEmpty()) {
            System.out.println("Color cannot be empty. Try again:");
            color = scanner.nextLine();
        }
        item.setColor(color);

        ItemService.save(item);
        System.out.println("Furniture item added successfully!");
    }

    public static void editFurnitureItem(FurnitureItem item) {
        ItemService.editCommonFields(item);

        System.out.println("Current color: " + item.getColor());
        System.out.println("Enter new color (or press Enter to keep current):");
        String color = scanner.nextLine();
        if (!color.isEmpty()) {
            item.setColor(color);
        }
    }
}