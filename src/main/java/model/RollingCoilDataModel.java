/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class RollingCoilDataModel {
    private String coilNo;
    private int coilId;
    private String time;
    private String seq;
    private int temperature;
    private int thickness;

    public RollingCoilDataModel() {
    }

    public RollingCoilDataModel(String coilNo, int coilId, String time, String seq, int temperature, int thickness) {
        this.coilNo = coilNo;
        this.coilId = coilId;
        this.time = time;
        this.seq = seq;
        this.temperature = temperature;
        this.thickness = thickness;
    }

    public String getCoilNo() {
        return coilNo;
    }

    public void setCoilNo(String coilNo) {
        this.coilNo = coilNo;
    }

    public int getCoilId() {
        return coilId;
    }

    public void setCoilId(int coilId) {
        this.coilId = coilId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    

}
