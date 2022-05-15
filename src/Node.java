public class Node {
    Product infor;
    Node next;

    public Node() {}
    public Node(Product infor) {this.infor = infor;}
    public Node(Product infor, Node next) {
        this.infor = infor;
        this.next = next;
    }
}
