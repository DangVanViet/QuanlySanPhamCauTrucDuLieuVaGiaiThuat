public class Product {
    String maSp;
    String tenSp;
    int soLuong;
    double gia;

    public Product() {}
    /** hàm khởi tạo có tham số */
    public Product(String maSp, String tenSp, int soLuong, double gia) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.gia = gia;
    }
    @Override
    public String toString() {
       return String.format("%-10s  |%-20s  |%-15s  |%-15f", maSp, tenSp, soLuong, gia);
    }
}
