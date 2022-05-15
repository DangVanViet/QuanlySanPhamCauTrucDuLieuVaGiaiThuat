public class MyQueue {
    protected Node head;
    protected Node tail;

    public MyQueue() {head = tail = null;}
    public boolean isEmpty() {return head == null;}
    /** Hàm thêm Node vào danh sách queue
     * @param x
     * */
    public void enqueue(Product x) {
        if(isEmpty()) head = tail = new Node(x); // trường hợp danh sách rỗng
        else {
            tail.next = new Node(x);
            tail = tail.next;
            tail.next = null;
        }
    }
}
