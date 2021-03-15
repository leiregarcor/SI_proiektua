package model;

public class Tablero {
 private Kasila[][] tablero;
 private static Tablero nTablero = null;

    private Tablero() {
        this.tablero = tablero;
    }
    public static Tablero getNireTablero(){
        if(Tablero.nTablero==null) {
            Tablero.nTablero=new Tablero();
        }
        return Tablero.nTablero;
    }

}
