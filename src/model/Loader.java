package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Tablero;

public class Loader {
    private static Loader loader = null;

    private Loader() {}

    public static Loader getInstance() {
        if (loader == null) {
            loader = new Loader();
        }
        return loader;
    }

    public void tableroakKargatu() {
        BufferedReader reader;
        try {
            //reader = new BufferedReader(new FileReader("resources/sudoku.txt"));
            reader = new BufferedReader(new FileReader("resources/sudokuDemo.txt"));
            String line = reader.readLine();
            RawTablero rTablero;
            while (line != null) {
                // Primera linea, marca el nombre del sudoku.
                rTablero = new RawTablero();
                rTablero.setIzena(line);
                // Siguiente linea marca el nivel
                line = reader.readLine();
                rTablero.setLvl(Integer.parseInt(line));
                // Ahora empezamos los setup de los dos tipos de casillas.
                // Primeros nueve numeros
                for (int i = 0; i <= 8; i++) {
                    line = reader.readLine();
                    rTablero.balioakEsleitu(true, i, line);
                }
                for (int i = 0; i <= 8; i++) {
                    // soluzioa
                    line = reader.readLine();
                    rTablero.balioakEsleitu(false, i, line);
                }
                line = reader.readLine();
                TableroCatalog.getInstance().getLista().add(rTablero);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
