public class MyStack {
    protected Node head;

    public MyStack() {head = null;}
    /** Hàm đẩy sản phẩm x vào trong danh sách stack */
    public void push(Product x) {head = new Node(x, head);}
}
