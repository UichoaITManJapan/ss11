package ra.entity;

import ra.ISHop;
import static ra.run.ShopManagement.productList;
import java.util.Scanner;

public class Product implements ISHop {
    private String productId;
    private String productName;
    private float price;
    private String title;
    private int catalogId;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float price, String title, int catalogId, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.catalogId = catalogId;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("nhập vào productId :");
        do {
            this.productId = scanner.nextLine();
            if (isCheckProductId(productId)){
                if (this.productId.length() >=5 && this.productId.startsWith("P")){
                    break;
                }else {
                    System.err.println("Mã sản phẩm phải có 5 ký tự trở lên và phải bắt đầu là P. Vui lòng nhập lại!");
                }
            }else {
                System.err.println("Mã sản phẩm đã tồn tại. Vui lòng nhập lại!");
            }
        }while (true);

        System.out.println("Nhập vào tên sản phẩm");
        boolean checkProductName = true;
       do {
           this.productName = scanner.nextLine();
           boolean isCheckExistProductName = false;
           for (Product pt: productList) {
               if (pt.productName.equals(this.productName)){
                   isCheckExistProductName = true;
                   break;
               }
           }
           if (isCheckExistProductName){
               System.err.println("tên sản phẩm đã tồn tại. vui lòng nhập lại!");
           }else {
               break;
           }
       }while(checkProductName);

        System.out.println("Nhập vào giá sản phẩm");
        this.price = Float.parseFloat(scanner.nextLine());

        System.out.println("Nhập vào tiêu đề sản phẩm");
        this.title = scanner.nextLine();

        System.out.println("Nhập vào max danh mục mà sản phẩm thuộc về");
        this.catalogId = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập vào trạng thái sản phẩm");
        this.status = Boolean.parseBoolean(scanner.nextLine());

    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm : " +this.productId);
        System.out.println("Tên sản phẩm : " + this.productName);
        System.out.println("Giá sản phẩm : "+this.price);
        System.out.println("Tiêu đề sản phẩm : " +this.title);
        System.out.println("Mã danh mục mà sản phẩm thuộc về : " + this.catalogId);
        String checkStatusProduct = status ? "Còn hàng" : "Đã bán hết";
        System.out.println("Trạng thái sản phẩm : " +checkStatusProduct);
        System.out.println("========================================================");
    }
    boolean isCheckProductId(String productId){
        for (Product pt : productList) {
            if (pt.productId.equals(this.productId)){
                return false;
            }
        }
        return true;
    }
}
