package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SudokuCatalog {
    private static SudokuCatalog nSudokuCatalog = new SudokuCatalog();
    private static ArrayList<Sudoku> sudokuak = new ArrayList<>();
    public SudokuCatalog getInstance(){ return nSudokuCatalog;}

    public static void main(String[] args) {
        tableroakKargatu();
    }

    public static void tableroakKargatu() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("resources/sudoku.txt"));
            String line = reader.readLine();
            Sudoku sudoku;
            while (line != null) {
                System.out.println(line);
                //Primera linea, marca el nombre del sudoku.
                sudoku = new Sudoku();
                sudoku.setIzena(line);
                //Siguiente linea marca el nivel
                line = reader.readLine();
                sudoku.setLvl(Integer.parseInt(line));
                //Ahora empezamos los setup de los dos tipos de casillas.
                //Primeros nueve numeros
                for (int i = 0; i <= 8;i++){
                    line = reader.readLine();
                    sudoku.balioakEsleitu(true,i,line);
                }
                for (int i = 0; i <= 8;i++){
                    line = reader.readLine();
                    sudoku.balioakEsleitu(false,i,line);
                }
                    line = reader.readLine();
              sudokuak.add(sudoku);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


