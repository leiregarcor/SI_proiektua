package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SudokuCatalog {

    private static SudokuCatalog nSudokuCatalog = null;
    public static SudokuCatalog getInstance(){
        if(nSudokuCatalog == null){
            nSudokuCatalog = new SudokuCatalog();
        }
            return nSudokuCatalog;
        }

    private static ArrayList<Sudoku> sudokuak = new ArrayList<>();

    private SudokuCatalog(){}

    public  void main(String[] args){
        tableroakKargatu();
        getSudoku(1);
    }
    public  void tableroakKargatu() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("resources/sudoku.txt"));
            String line = reader.readLine();
            Sudoku sudoku;
            while (line != null) {
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
    public Sudoku getSudoku(int index) {
        //Dependiendo de la dificultad, se queda con un Sudoku o otro
        for (Sudoku s: sudokuak){
            if (s.getLvl() == index) return s;
        }
        System.out.println("Ez da aurkitu sailtazun horreko sudokurik!");
        return null;
        // Habra que comprobar la dificultad del sudoku
    }

}


