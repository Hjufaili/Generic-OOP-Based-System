import java.util.Scanner;

public class StationeryItemService {

    private static Scanner scanner = new Scanner(System.in);

    public static void addStationeryItem() {
        StationeryItem item = new StationeryItem();

        item.setId(ItemService.inputId());
        item.setName(ItemService.inputName());
        item.setPrice(ItemService.inputPrice());

        System.out.println("Enter material:");
        String material = scanner.nextLine();
        while (material == null || material.trim().isEmpty()) {
            System.out.println("Material cannot be empty. Try again:");
            material = scanner.nextLine();
        }
        item.setMeterial(material);

        ItemService.save(item);
        System.out.println("Stationery item added successfully!");
    }

    public static void editStationeryItem(StationeryItem item) {
        ItemService.editCommonFields(item);

        System.out.println("Current material: " + item.getMeterial());
        System.out.println("Enter new material (or press Enter to keep current):");
        String material = scanner.nextLine();
        if (!material.isEmpty()) {
            item.setMeterial(material);
        }
    }
}