package model;


public class Tablero {

    private Sudoku sudoku;
    private static Tablero nTablero = new Tablero();


    private Tablero(){};
    public static Tablero getNireTablero(){
       return nTablero;
    }

    public boolean kasillaZuzenaDa(int zutabe,int errenkada ){
        return sudoku.getMatrizea()[zutabe][errenkada].zuzenaDa();
    }
    private void fitxeroaKargatu(){

    }
    public Sudoku getSudoku() {
        return sudoku;
    }

    public void setSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

}
