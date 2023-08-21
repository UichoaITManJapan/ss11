package ra.run;

import ra.entity.Categories;
import ra.entity.Product;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class ShopManagement {
    public static List<Categories> categoriesList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            shopMenu();
        }
        public static void shopMenu(){
            boolean shopRunning = true;
            do {
                System.out.println("*************************SHOP MANAGEMENT***************");
                System.out.println("1.QUản lý danh mục sản phẩm");
                System.out.println("2. Quản lý sản phẩm");
                System.out.println("3. Thoát");
                System.out.println("========================================================");
                System.out.println("Chọn chức năng :");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        manageCatalogies();
                    case 2:
                        manageProduct();
                    case 3:
                        System.exit(0);
                    default:
                        System.err.println("Vui lòng chọn các chức năng từ 1 đến 3!");
                }

            } while (shopRunning);
        }
        public static void manageCatalogies () {
            boolean isCatalogRunning = true;
            do {
                System.out.println("***************** CATALOG MANAGEMENT**************");
                System.out.println("1. Thêm mới danh mục");
                System.out.println("2. Hiển thị thông tin các danh mục");
                System.out.println("3. Cập nhật tên danh mục theo mã danh mục");
                System.out.println("4. Xóa danh mục theo mã danh mục (Danh mục chưa chứa sản phẩm)");
                System.out.println("5. Thoát (Quay lại Shop Management)");
                System.out.println("========================================================");
                System.out.println("Sự lựa chọn của bạn :");
                int choiceCatalog = Integer.parseInt(scanner.nextLine());
                switch (choiceCatalog) {
                    case 1:
                        addCatalog();
                        break;
                    case 2:
                        displayCatalog();
                        break;
                    case 3:
                        updateCatalog();
                        break;
                    case 4:
                        deleteCatalog();
                        break;
                    case 5:
                        isCatalogRunning = false;
                        shopMenu();
                        break;
                    default:
                        System.err.println("vui lòng lại từ 1 đến 5!");
                }
            } while (isCatalogRunning);
        }
        public static void addCatalog () {
            Categories catalogNew = new Categories();
            catalogNew.inputData(scanner);
            categoriesList.add(catalogNew);
            System.out.println("Đã thêm mới thành công danh mục");
            System.out.println("========================================================");
        }
        public static void displayCatalog () {
            System.out.println("Thông tin danh mục ");
            for (Categories st : categoriesList) {
                st.displayData();
            }
            System.out.println("========================================================");
        }
        public static void updateCatalog () {
            System.out.println("Nhập vào mã danh mục cần cập nhật");
            int updateCatalogId = Integer.parseInt(scanner.nextLine());
            for (Categories ct : categoriesList) {
                if (ct.getCatalogID() == updateCatalogId) {
                    System.out.println("Nhập vào tên cần cập nhật");
                    ct.setCatalogName(scanner.nextLine());
                }
            }
            System.out.println("Đã cập nhật thành công");
        }
        public static void deleteCatalog () {
            System.out.println("Nhập vào mã danh mục cần xoá :");
            int delCatalogId = Integer.parseInt(scanner.nextLine());
            boolean isCheckExistCatalogId = false;
            boolean isCheckExistCatalogIdSetProduct = false;
            for (int i = 0; i < categoriesList.size(); i++) {
                if (categoriesList.get(i).getCatalogID() == delCatalogId) {
                    isCheckExistCatalogId = true;
                    for (Product pt : productList) {
                        if (pt.getCatalogId() == delCatalogId) {
                            isCheckExistCatalogIdSetProduct = true;
                            break;
                        }
                    }
                    if (isCheckExistCatalogIdSetProduct) {
                        System.err.println("Danh mục này đã tồn tại. Không thể xoá danh mục này");
                    } else {
                        categoriesList.remove(i);
                        System.out.println("đã xoá thành công");
                    }
                }
            }
            if (!isCheckExistCatalogId) {
                System.err.println("Mã danh mục không tồn tại!");
            }


        }

        public static void manageProduct () {
            boolean isProductRunning = true;
            do {
                System.out.println("***************** PRODUCT MANAGEMENT**************");
                System.out.println("1. Thêm mới sản phẩm (Khi thêm cho phép chọn danh mục sản phẩm mà sản phẩm thuộc về)");
                System.out.println("2. Hiển thị thông tin sản phẩm");
                System.out.println("3. Cập nhật giá sản phẩm theo mã sản phẩm");
                System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
                System.out.println("5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần");
                System.out.println("6. Sắp xếp sản phẩm theo tên tăng dần");
                System.out.println("7. Thống kê số lượng sản phẩm theo danh mục sản phẩm");
                System.out.println("8. Tìm kiếm sản phẩm theo tên sản phẩm");
                System.out.println("9. Thoát (Quay lại Shop Management)");
                System.out.println("========================================================");
                System.out.println("Sự lựa chọn của bạn :");
                int choiceProduct = Integer.parseInt(scanner.nextLine());
                System.out.println("========================================================");
                switch (choiceProduct) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        displayProduct();
                        break;
                    case 3:
                        updateProductByProductId();
                        break;
                    case 4:
                        deleteProductByProductId();
                        break;
                    case 5:
                        sortProductByPriceASC();
                        break;
                    case 6:
                        sortProductByProductNameASC();
                        break;
                    case 7:
                        thongKeProductByCatalogId();
                        break;
                    case 8:
                        searchProductByProductName();
                        break;
                    case 9:
                        isProductRunning = false;
                        shopMenu();
                    default:
                        System.err.println("Vui lòng chọn từ đến 9!");
                }

            } while (isProductRunning);
        }
        public static void addProduct () {
            System.out.println("Danh sách danh mục :");
            for (Categories ct : categoriesList) {
                ct.displayData();
            }
            System.out.println("Nhập mã danh mục mà sản phẩm cần thêm vào");
            int createCatalogID = Integer.parseInt(scanner.nextLine());
            Categories selectedCatalog = findCatalogById(createCatalogID);
            if (selectedCatalog != null) {
                Product newProduct = new Product();
                newProduct.inputData(scanner);
                newProduct.setCatalogId(createCatalogID);
                productList.add(newProduct);
                System.out.println("Đã thêm mới sản phẩm vào danh mục " + createCatalogID + "thành công");
            } else {
                System.err.println("Không tìm thấy danh mục có mã " + createCatalogID);
            }
        }

        public static void displayProduct(){
            System.out.println("Thông tin sản phẩm");
            for (Product pt : productList) {
                pt.displayData();
            }
            System.out.println("========================================================");
        }
        public static void updateProductByProductId(){
            System.out.println("Nhập vào mã sản phẩm cần cập nhât :");
            String updateProductId = scanner.nextLine();
            for (Product pt : productList) {
                if (pt.getProductId().toLowerCase().equals(updateProductId.toLowerCase())){
                    System.out.println("Nhập vào giá sản phẩm cần cập nhật");
                    pt.setPrice(Float.parseFloat(scanner.nextLine()));
                }
            }
            System.out.println("Đã cập nhật giá sản phẩm thành công");
            System.out.println("========================================================");
        }

        public static void deleteProductByProductId(){
            System.out.println("Nhập vào mã sản phẩm cần xoá");
            String delProductId = scanner.nextLine();
            Product productToDelete = findProductByID(delProductId);
            if (productToDelete != null){
               productList.remove(productToDelete);
                System.out.println("Đã xoá sản phẩm có mã sản phẩm là " + delProductId + " thành công.");
            }else{
                System.err.println("Không tìm thấy sản phẩm có mã là " + delProductId);
            }
            System.out.println("========================================================");
        }
        public static void sortProductByPriceASC(){
            Collections.sort(productList, new Comparator<Product>() {
                @Override
                public int compare(Product pt1, Product pt2) {
                    return Float.compare(pt1.getPrice(), pt2.getPrice());
                }
            });
            System.out.println("Đã sắp xếp sản phẩm theo giá sản phẩm tăng dần thành công.");
            displayProduct();
            System.out.println("========================================================");
        }

        public static void sortProductByProductNameASC(){
            Collections.sort(productList, new Comparator<Product>() {
                @Override
                public int compare(Product pr1, Product pr2) {
                    return pr1.getProductName().compareTo(pr2.getProductName());
                }
            });
            System.out.println("Đã sắp xếp sản phẩm theo tên sản phẩm tăng dần thành công.");
            displayProduct();
            System.out.println("========================================================");
        }

        public static void thongKeProductByCatalogId(){
            for (Categories ct : categoriesList) {
                int ctID = ct.getCatalogID();
                int cntProduct = 0;
                for (Product pr: productList) {
                    if (pr.getCatalogId() == ctID){
                        cntProduct++;
                    }
                }
                System.out.println("Mã danh mục " + ctID + ", Số lượng sản phẩm " + cntProduct);
            }
            System.out.println("========================================================");
        }

        public static void searchProductByProductName(){
            System.out.println("Nhập vào tên sản phẩm cần tìm:");
            String searchProductName = scanner.nextLine();
            System.out.println("Các sản phẩm tìm thấy :");
            boolean searchResult = false;
            for (Product pr: productList) {
                if (pr.getProductName().toLowerCase().contains(searchProductName.toLowerCase())){
                    searchResult = true;
                    pr.displayData();
                }
            }
            if (!searchResult){
                System.err.println("không tìm thấy sản phẩm nào!");
            }
        }

        private static Categories findCatalogById ( int catalogID){
            for (Categories ct : categoriesList) {
                if (ct.getCatalogID() == catalogID) {
                    return ct;
                }
            }
            return null;
        }
        private static Product findProductByID(String productId){
            for (Product pt : productList){
                if (pt.getProductId().toLowerCase().equals(productId.toLowerCase())){
                    return pt;
                }
            }
            return null;
        }
    }

