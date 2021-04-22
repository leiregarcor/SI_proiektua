package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TableroCatalog {

    private static TableroCatalog nTableroCatalog = null;
    private static ArrayList<RawTablero> tableroak = new ArrayList<>();

    private TableroCatalog() {
    }

    public static TableroCatalog getInstance() {
        if (nTableroCatalog == null) {
            nTableroCatalog = new TableroCatalog();
        }
        return nTableroCatalog;
    }

    /*
     * public void main(String[] args){ tableroakKargatu(); getTablero(1); }
     */

    public RawTablero getTablero(int index) {
        // Dependiendo de la dificultad, se queda con un Sudoku o otro
        for (RawTablero r : tableroak) {
            if (r.getLvl() == index)
                return r;
        }
        return null;
        // Habra que comprobar la dificultad del sudoku
    }

    public ArrayList<RawTablero> getLista(){
        return tableroak;
    }

}
