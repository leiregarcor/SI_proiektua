package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TableroCatalog {
	
	private static TableroCatalog nTableroCatalog = null;
	private static ArrayList<Tablero> tableroak = new ArrayList<>();
   
    
    private TableroCatalog(){}
    
    public static TableroCatalog getInstance(){
        if(nTableroCatalog == null){
        	nTableroCatalog = new TableroCatalog();
        }
            return nTableroCatalog;
        }

    
  /*  public  void main(String[] args){
        tableroakKargatu();
        getTablero(1);
    }
   */    
    
    public  void tableroakKargatu() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("resources/sudoku.txt"));
            //reader = new BufferedReader(new FileReader("resources/sudokuDemo.txt"));
            String line = reader.readLine();
            Tablero tablero;
            while (line != null) {
                //Primera linea, marca el nombre del sudoku.
            	tablero = new Tablero();
            	tablero.setIzena(line);
                //Siguiente linea marca el nivel
                line = reader.readLine();
                tablero.setLvl(Integer.parseInt(line));
                //Ahora empezamos los setup de los dos tipos de casillas.
                //Primeros nueve numeros
                for (int i = 0; i <= 8;i++){
                    line = reader.readLine();
                    tablero.balioakEsleitu(true,i,line);
                }
                for (int i = 0; i <= 8;i++){
                	//soluzioa
                    line = reader.readLine();
                    tablero.balioakEsleitu(false,i,line);
                }
                    line = reader.readLine();
                    tableroak.add(tablero);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Tablero getTablero(int index) {
        //Dependiendo de la dificultad, se queda con un Sudoku o otro
        for (Tablero s: tableroak){
            if (s.getLvl() == index) return s;
        }
        return null;
        // Habra que comprobar la dificultad del sudoku
    }

}


