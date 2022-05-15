public class MyList {
    protected Node head;
    protected Node tail;

    /** Hàm khởi tạo không tham số */
    public MyList() {head = tail = null;}
    /** Hàm khởi tạo có tham số */
    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    /** Xoa phan tu dau trong list */
    public void deleteHead() {
        head = head.next;
    }
    /** Xoa phan tu cuoi trong list */
    public void deleteTail() {
        if(head == null) System.out.println("danh sach rong");
        else if(head.next == null) this.deleteHead();   // Nếu danh sách chỉ có 1 phần tử
        else {
            Node current = this.head;
            while(current != null) {
                if(current.next == tail) {
                    current.next = null;    // Xóa Node cuối
                    tail = current;
                    break;
                }
                current = current.next; // cập nhật biến current
            }
            System.out.println("da xoa cuoi danh sach");
        }

    }

    public boolean isEmpty() {return head == null;} // Nếu danh sách có head = null là danh sách rỗng
    public void resetList() {head = tail = null;}   // cho danh sách về rỗng
    /** hàm trả về dộ dài của danh sách */
    public int length() {
        int length = 0;
        Node current = this.head;
        while(current != null) {
            length++;
            current = current .next;
        }
        return length;
    }
    /** Xóa toàn bộ đưa về danh sách rỗng */
    public void clear() {
        Node current = this.head;
        while(current != null) {
            this.head = this.head.next;
            current = current.next;
        }
    }


}
