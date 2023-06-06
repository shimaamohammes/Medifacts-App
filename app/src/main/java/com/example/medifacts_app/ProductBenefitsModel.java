package com.example.medifacts_app;

public class ProductBenefitsModel {

    public static final int BENEFITS_TITLE = 0;
    public static final int BENEFITS_BODY = 1;

    private int type;
    //////BenefitsTitle
    private String title;
    //////BenefitsTitle

    //////BenefitsBody
    private String medicinename;
    private String medicinevalue;

    public String getMedicinename() {
        return medicinename;
    }

    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }

    public String getMedicinevalue() {
        return medicinevalue;
    }

    public void setMedicinevalue(String medicinevalue) {
        this.medicinevalue = medicinevalue;
    }

    public ProductBenefitsModel(int type, String medicinename, String medicinevalue) {
        this.type = type;
        this.medicinename = medicinename;
        this.medicinevalue = medicinevalue;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductBenefitsModel(int type, String title) {
        this.type = type;
        this.title = title;
    }
//////BenefitsBody

}
