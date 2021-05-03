package model;

public class Mezua {
    private int[] info= new int[3];
    private String hautagaiak= new String();

    public Mezua(){}

    public void setInfo(int[] info) {
        this.info = info;
    }

    public int[] getInfo() {
        return info;
    }

    public void setHautagaiak(String hautagaiak) {
        this.hautagaiak = hautagaiak;
    }

    public String getHautagaiak() {
        return hautagaiak;
    }
}
