package model;

public class Tablero {
 private Kasila[][] matrizea;
 private static Tablero nTablero = new Tablero(); /** = null */

    private Tablero() {
        this.matrizea = new Kasila[9][9];
    }
    public static Tablero getNireTablero(){
       /** if(Tablero.nTablero==null) {
            Tablero.nTablero=new Tablero();
        }
        return Tablero.nTablero; */
       return nTablero;

    }

}
