package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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

    public void rawTableroakKargatu(){
        File tableroak = new File("resources/sudokuDemo.txt");
        ArrayList<String> ema = Reader.getInstance().fitxeroakKargatu(tableroak);
//reader = new BufferedReader(new FileReader("resources/sudoku.txt"));
        RawTablero rTablero;

        Iterator<String> itr = ema.iterator();
        String line;
        while (itr.hasNext()) {
            line= itr.next();
            // Primera linea, marca el nombre del sudoku.
            rTablero = new RawTablero();
            rTablero.setIzena(line);
            // Siguiente linea marca el nivel
            line = itr.next();
            rTablero.setLvl(Integer.parseInt(line));
            // Ahora empezamos los setup de los dos tipos de casillas.
            // Primeros nueve numeros
            for (int i = 0; i <= 8; i++) {
                line = itr.next();
                rTablero.balioakEsleitu(true, i, line);
            }
            for (int i = 0; i <= 8; i++) {
                // soluzioa
                line = itr.next();
                rTablero.balioakEsleitu(false, i, line);
            }
            this.getLista().add(rTablero);
        }

    }

}
