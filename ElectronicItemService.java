import java.util.Scanner;

public class ElectronicItemService {

    private static Scanner scanner = new Scanner(System.in);

    public static void addElectronicItem() {
        ElectronicItem item = new ElectronicItem();

        Integer id = ItemService.inputId();
        item.setId(id);

        String name = ItemService.inputName();
        item.setName(name);

        Float price = ItemService.inputPrice();
        item.setPrice(price);

        System.out.println("Enter item's brand:");
        String brand = scanner.nextLine();
        while (brand == null || brand.trim().isEmpty()) {
            System.out.println("Brand cannot be empty. Try again:");
            brand = scanner.nextLine();
        }
        item.setBrand(brand);

        ItemService.save(item);
        System.out.println("Electronic item added successfully!");
    }

    public static void editElectronicItem(ElectronicItem item) {
        ItemService.editCommonFields(item);

        System.out.println("Current brand: " + item.getBrand());
        System.out.println("Enter new brand (or press Enter to keep current):");
        String brand = scanner.nextLine();
        if (!brand.isEmpty()) {
            item.setBrand(brand);
        }
    }
}