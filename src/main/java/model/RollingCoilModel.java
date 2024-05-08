package model;

public class RollingCoilModel {
    private int id;
    private String coilNo;
    private String coilName;

    public RollingCoilModel(){}

    public RollingCoilModel(int id, String coilNo, String coilName) {
        this.id = id;
        this.coilNo = coilNo;
        this.coilName = coilName;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoilNo() {
        return coilNo;
    }

    public void setCoilNo(String coilNo) {
        this.coilNo = coilNo;
    }

    public String getCoilName() {
        return coilName;
    }

    public void setCoilName(String coilName) {
        this.coilName = coilName;
    }

}
