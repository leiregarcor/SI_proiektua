package model;


public class Tablero {
 private Kasila[][] matrizea;
 private static Tablero nTablero = new Tablero();
    private int lvl;
    private String izena;

    private Tablero() {
        this.matrizea = new Kasila[9][9];
        this.sortuMatrizea();
        this.fitxeroaKargatu();
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    /** = null */

    public static Tablero getNireTablero(){
       /** if(Tablero.nTablero==null) {
            Tablero.nTablero=new Tablero();
        }
        return Tablero.nTablero; */
       return nTablero;

    }

    private void sortuMatrizea(){
        for (int err=0; err<matrizea.length ; err++){
            for (int zut=0; zut<matrizea[0].length; zut++){
                matrizea[err][zut]= new Kasila(err, zut);
            }
        }
    }
    public boolean zuzenaDa(){
        //soluzioa sartutako balioarekin konparatuko da, true balio zuzena bada, false bestela.
        boolean ema = true;
        int err=0;
        int zut=0;

        while(ema&& err<matrizea.length ){
            while (ema && zut<matrizea[0].length){
                ema= matrizea[err][zut].zuzenaDa();
                zut++;
            }
            err++;
        }
        return ema;
    }

    private void fitxeroaKargatu(){

    }

}
