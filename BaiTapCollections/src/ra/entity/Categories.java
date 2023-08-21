package ra.entity;


import ra.ISHop;

import static ra.run.ShopManagement.categoriesList;

import java.util.Scanner;

public class Categories implements ISHop {
    private int catalogID;
    private String catalogName;
    private boolean status;
    public Categories() {
    }

    public Categories(int catalogID, String catalogName, boolean status) {
        this.catalogID = catalogID;
        this.catalogName = catalogName;
        this.status = status;
    }

    public int getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(int catalogID) {
        this.catalogID = catalogID;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhap vao catalogID");
        do {
            this.catalogID = Integer.parseInt(scanner.nextLine());
            if (isCheckExistCatalogId(catalogID)){
                break;
            }else {
                System.err.println("Ma danh muc da ton tai. vui long nhap lai");
            }
        }while (true);

        System.out.println(" Nhap vao catalogName");
        boolean checkCatalogName = true;
        do {
            this.catalogName = scanner.nextLine();
            boolean isCheckExistCatalogName = false;
            for (Categories ct: categoriesList) {
                if (ct.catalogName.equals(this.catalogName)){
                    isCheckExistCatalogName = true;
                    break;
                }
            }
            if (isCheckExistCatalogName){
                System.err.println("Tên danh mục đã tồn tại. Vui lòng nhập lại");
            }else {
                break;
            }
        }while (checkCatalogName);

        System.out.println("Nhâpj vào trang thái");
        this.status = Boolean.parseBoolean(scanner.nextLine());

    }

    @Override
    public void displayData() {
        System.out.println("CatalogId : " +this.catalogID);
        System.out.println("CatalogName : " + this.catalogName);
        String checkStatusCatalog = status ? "Hoạt động" : "Không hoạt động";
        System.out.println("Trạng thái : " + checkStatusCatalog);
        System.out.println("========================================================");
    }
    boolean isCheckExistCatalogId(int catalogID){
        for (Categories ct: categoriesList) {
            if (ct.getCatalogID() == catalogID){
                return false;
            }
        }
        return true;
    }
}
