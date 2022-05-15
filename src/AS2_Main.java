import java.util.Scanner;

public class AS2_Main {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        OperationToProduct giaithuat = new OperationToProduct();
        int choice;
        MyList list1 = new MyList();
        MyStack stackList = new MyStack();
        MyQueue queueList = new MyQueue();
        do {
            showMenu();
            System.out.print("choice: ");
            choice = s.nextInt();
            switch(choice) {
                case 1:
                    giaithuat.getAllItemsFromFile("Data.txt", list1);
                    giaithuat.displayAll(list1);
                    break;
                case 2:
                    giaithuat.addLast(list1);
                    break;
                case 3:
                    giaithuat.displayAll(list1);
                    break;
                case 4:
                    giaithuat.writeAllItemsToFile("Data.txt", list1);
                    break;
                case 5:
                    giaithuat.searchByCode(list1);
                    break;
                case 6:
                    giaithuat.deleteByCode(list1);

                    break;
                case 7:
                    giaithuat.quickSort(list1);
                    System.out.println("Successfully!");
                    System.out.println();
                    break;
                case 8:
                    System.out.print("Quantity= " + list1.head.infor.soLuong + " => (");
                    giaithuat.convertToBinary(list1.head.infor.soLuong);
                    System.out.print(")");
                    System.out.println();
                    break;
                case 9:
                    giaithuat.getAllItemsFromFile("Data.txt", stackList);
                    break;
                case 10:
                    giaithuat.getAllItemsFromFile("Data.txt", queueList);
                    break;
                case 0:
                    System.out.println("hen gap lai.thanks");
                    break;
                default:
                    System.out.println("Lua chon khong phu hop!");
            }
        } while(choice != 0);
    }

    public static void showMenu() {
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
    }
}
