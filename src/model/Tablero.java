package model;

public class Tablero {
 private Kasila[][] matrizea;
 private static Tablero nTablero = new Tablero(); /** = null */
 private int lvl;
    private Tablero() {
        this.matrizea = new Kasila[9][9];
        this.sortuMatrizea();
        this.fitxeroaKargatu();
    }
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

    private void fitxeroaKargatu(){

    }

}
