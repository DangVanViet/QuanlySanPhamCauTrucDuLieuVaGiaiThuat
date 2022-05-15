import java.io.*;
import java.util.Scanner;

public class OperationToProduct {
    // Tạo biến nhập riêng dành cho chuỗi và số
    public static Scanner so = new Scanner(System.in);
    public static Scanner sc = new Scanner(System.in);

    /**
     * Reading all products from the file and insert them to the list at tail.
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyList list) {
        try {
            list.resetList();// cho list ve rong de lay chi du lieu tu file

            System.out.println("Read from file");
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true) {
                line = br.readLine();   //cho bien Line chay tu dong dau toi cuoi
                if(line == null) break; // dừng cho đến khi biến Line đọc cho đến cuối file
                String b[] = line.split(" ");// luu tung phan tu sau khi tach vao mang b
                //tao doi tuong Product tu cac phan tu cua mang b
                Product newProduct = new Product(b[0], b[1], Integer.parseInt(b[2]), Double.parseDouble(b[3]));
                Node newNode = new Node(newProduct);
                if(list.head == null) { // luu cac Node vao list
                    list.head = newNode;
                    list.tail = newNode;
                }
                list.tail.next = newNode;   // Nếu danh sách không rỗng thì lưu vào đuôi danh sách
                list.tail = newNode;
            }

        } catch(Exception e) {}
    }

    /**
     * Reading all products from the file and insert them to the stack.
     * @param fileName The file name of the file
     * @param stack     The Stack contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyStack stack) {
        try {
            System.out.println("Read from file");
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true) {
                line = br.readLine();   //cho bien Line chay tu dong dau toi cuoi
                if(line == null) break;
                String b[] = line.split(" ");// luu tung phan tu sau khi tach vao mang b
                //tao doi tuong Product tu cac phan tu cua mang b
                Product newProduct = new Product(b[0], b[1], Integer.parseInt(b[2]), Double.parseDouble(b[3]));
                stack.push(newProduct);   // đẩy Node vào stack
            }
            // In danh sách stack ra màn hình
            Node current = stack.head;
            System.out.printf("%-10s  |%-20s  |%-15s  |%-15s\n", "maSp", "tenSp", "soLuong", "gia");
            System.out.println();
            while(current != null) {
                System.out.println(current.infor.toString());
                current = current.next;
            }
            System.out.println();
            System.out.println("Successfully!");
            System.out.println();
        } catch(Exception e) {}
    }

    /**
     * Reading all products from the file and insert them to the queue.
     * @param fileName The file name of the file
     * @param queue     The Queue contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyQueue queue) {
        try {
            System.out.println("Read from file");
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true) {
                line = br.readLine();   //cho bien Line chay tu dong dau toi cuoi
                if(line == null) break;
                String b[] = line.split(" ");// luu tung phan tu sau khi tach vao mang b
                //tao doi tuong Product tu cac phan tu cua mang b
                Product newProduct = new Product(b[0], b[1], Integer.parseInt(b[2]), Double.parseDouble(b[3]));
                queue.enqueue(newProduct);
            }
            Node current = queue.head;
            System.out.printf("%-10s  |%-20s  |%-15s  |%-15s\n", "maSp", "tenSp", "soLuong", "gia");
            System.out.println();
            while(current != null) {
                System.out.println(current.infor.toString());
                current = current.next;
            }
            System.out.println();
            System.out.println("Successfully!");
            System.out.println();
        } catch(Exception e) {}
    }

    /** Hàm kiểm tra xem mã sản phẩm đã tồn tại hay chưa
     * @param check
     * @param list
     * */
    public boolean isExits(String check, MyList list) {
        Node current = list.head;
        while(current != null) {
            //Nếu chuỗi check mà giống mã sản phẩm đã có thì trả về false
            if(current.infor.maSp.equals(check)) return false;
            current = current.next;
        }
        return true;
    }

    /**
     * Adding a product to the list, info of the product input from keyboard.
     * @param list The Linked list
     */
    public void addLast(MyList list) {
        System.out.print("Input new ID: ");
        String newID;
        while(true) {   // Nhập mã sản phẩm cho đến khi hợp lệ(mã chưa tồn tại trong list)
            newID = sc.next();
            if(isExits(newID, list)) break;
            System.out.println("Ma ID da ton tai nhap lai: ");
        }
        System.out.print("Input Product's Name: ");
        String newName = sc.next();
        System.out.print("Input Product's quantity: ");
        int newQuantity = so.nextInt();
        System.out.print("Input Product's price: ");
        double newPrice = so.nextDouble();

        //tạo 1 sản phẩm có chứa các thông tin vừa nhập
        Product newProduct = new Product(newID, newName, newQuantity, newPrice);
        Node newNode = new Node(newProduct);
        if(list.head == null) { // luu cac Node vao list
            list.head = newNode;
            list.tail = newNode;
        }
        list.tail.next = newNode;
        list.tail = newNode;
    }

    /**
     * Printing all prodcuts of the list to console screen
     * @param list
     */
    public void displayAll(MyList list) {
        Node current = list.head;
        System.out.printf("%-10s  |%-20s  |%-15s  |%-15s\n", "maSp", "tenSp", "soLuong", "gia");
        System.out.println();
        while(current != null) {
            System.out.println(current.infor.toString());
            current = current.next;
        }
        System.out.println();
        System.out.println("Successfully!");
        System.out.println();
    }

    /**
     * Writing all products from the list to the file
     * @param fileName Input file name
     * @param list     Input Linked list
     */
    public void writeAllItemsToFile(String fileName, MyList list) {
        try {
            PrintWriter pw = new PrintWriter(fileName);// Tạo biến pw dùng để viết vào fileName

            Node current = list.head;
            while(current != null) {
                pw.println(current.infor.maSp + " " + current.infor.tenSp + " "
                        + current.infor.soLuong + " " + current.infor.gia + " ");
                current = current.next;
            }
            pw.close(); //sau khi viết xong thì đóng file viết lại
            System.out.println("Successfully!");
        } catch(Exception e) {}
    }

    /**
     * Searching product by ID input from keyboard.
     * @param list
     */
    public void searchByCode(MyList list) {
        System.out.print("Input the ID to search = ");
        String searchID = sc.next();

        Node current = list.head;
        while(current != null) {
            if(current.infor.maSp.equals(searchID)) {   // Nếu có Node mà thông tin giống  searchID thì hiển thị ra màn hình
                System.out.print("Result: ");
                System.out.println(current.infor.toString());;
                break;
            }
            current = current.next;
        }
        System.out.println("khong co san pham nao voi ma ID: " + searchID);
    }

    /**
     * Deleting first product that has the ID input from keyboard from the list.
     * @param list
     */
    public void deleteByCode(MyList list) {
        System.out.print("Input the bycode to delete= ");
        String deleteID = sc.next();
        if(isExits(deleteID, list)) {
            System.out.println("Khong ton tai san pham co ID: " + deleteID);
            return;
        }
        // trường hợp Node cần xóa là Node đầu
        if(list.head.infor.maSp.equals(deleteID)) {list.deleteHead(); return;}
        // Trường hợp Node cần xóa là Node cuối
        if(list.tail.infor.maSp.equals(deleteID)) {list.deleteTail(); return;}
        // Trường hợp Node cần xóa nằm giữa trong danh sách có nhiều Node
        Node current = list.head;
        while(current.next != null) {
            if(current.next.infor.maSp.equals(deleteID)) {
                Node xoa = current.next;
                current.next = xoa.next;
            }
            current = current.next;
        }
        System.out.println("Deleted!");
        System.out.println();
    }

    /**
     * Sorting products in linked list by ID
     * @param list The Linked list
     */
    public void sortByCode(MyList list) {   // sắp xếp bằng thuật toán selection
        Node current = list.head;
        Node index = null;
        Product temp;

        if(list.head == null) {return;}
        else {
            while(current != null) {
                index = current.next;
                while(index != null) {
                    int x = current.infor.maSp.compareTo(index.infor.maSp);
                    if(x > 0) { // theo thứ tự nếu current đang đứng ngược so với index thì đổi chỗ
                        temp = current.infor;
                        current.infor = index.infor;
                        index.infor = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    /**
     * Sorting products in linked list by ID
     * @param list The Linked list
     */
    public void quickSort(MyList list) { // sắp xếp bằng quicksort có sử dụng đệ quy
        if(list.head == list.tail) return;
        MyList L1 = new MyList();
        MyList L2 = new MyList();
        Node tag = list.head;
        list.head = list.head.next; // cap nhat lai list.head
        tag.next = null; // co lap tag

        while(list.head != null) {
            Node p = list.head;
            list.head = list.head.next;
            p.next = null;
            if(p.infor.maSp.compareTo(tag.infor.maSp) <= 0) {  // Nếu maSp của p đứng trước hoặc bằng tag theo bảng chữ cái
                p.next = L1.head;
                L1.head = p;
            } else {
                p.next = L2.head;
                L2.head = p;}
        }
        quickSort(L1);  // gọi đệ quy sắp xếp L1, L2
        quickSort(L2);
        if(L1.head != null) {   // nếu L1 không rỗng
            list.head = L1.head;
            L1.tail.next = tag;
        } else list.head = tag;
        tag.next = L2.head;
        if(L2.head != null) list.tail = L2.tail;
        else list.tail = tag;
    }
    /**
     * Convert a decimal to an array of binary. Example: input i = 18 -> Output =
     * {0, 1, 0, 0, 0, 1}
     * @param i Input decimal number
     * @return Array of binary numbers
     */
    public void convertToBinary(int i) {
        if(i == 0) return;
        else {
            int r = i % 2;
            convertToBinary(i / 2);
            System.out.print(r);
        }
    }
}
