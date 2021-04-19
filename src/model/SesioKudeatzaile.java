package model;

public class SesioKudeatzaile {
    private static SesioKudeatzaile sk = null;
    private int lvl;
    private String izena;
    private SesioKudeatzaile(){}

    public static SesioKudeatzaile getInstance() {
        if (sk == null){
            sk = new SesioKudeatzaile();
        }
        return sk;
    }

    public void setDiff(int lvl){
        this.lvl = lvl;
    }
    public int getLvl(){
        return this.lvl;
    }
    
    
    
}
