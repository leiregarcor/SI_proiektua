package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SudokuCatalog {
    private static SudokuCatalog nSudokuCatalog = new SudokuCatalog();
    private ArrayList<Tablero> sudokuak;
    public SudokuCatalog getInstance(){ return nSudokuCatalog;}

    public static void main(String[] args) {
        tableroakKargatu();
    }

    public static void tableroakKargatu() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/kerman/Desktop/Workspace/SI_proiektua/resources/sudoku.txt"));
            String line = reader.readLine();
            while (line != null) {

                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


