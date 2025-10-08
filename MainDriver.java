import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainDriver {


    public static Integer itemOption = 0;
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        while (itemOption != 5) {
                ItemService.showItemMenu();
            itemOption = scanner.nextInt();
            if (itemOption == 1) {
                ItemService.addNewItem();
            } else if (itemOption == 2) {
                ItemService.editExistingItem();
            } else if (itemOption == 3) {
                ItemService.removeItem();
            } else if (itemOption == 4) {
                ItemService.displayAllItems();

            } else if (itemOption == 5) {
                System.out.println("Exit from item");
                itemOption = 5;

            } else {
                System.out.println("Please enter a number from the menu");
            }
        }
    }




}
