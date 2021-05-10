package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class Sudoku extends Observable {

    private Tablero tablero= new Tablero();
    private static Sudoku nSudoku = new Sudoku();

    private Sudoku() {}

    public static Sudoku getNireSudoku() {
        return nSudoku;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public boolean tableroKargatu(int pLvl){
        Boolean b=tablero.tableroaKargatu(pLvl);
        if(b){
            hautagaiakLortu();
            setChanged();
            notifyObservers();
        }
        return b;
    }

    public void kasilaEguneratu(int pErr, int pZut, int pBalio, Boolean[] pHautagaiak, Boolean pBalioaAldatu) {
        if(tablero.getMatrizea()[pErr][pZut] instanceof KasilaAldakorra){
            if(pBalioaAldatu){
                tablero.getMatrizea()[pErr][pZut].setBista(pBalio);
                ((KasilaAldakorra) tablero.getMatrizea()[pErr][pZut]).hautagaiakErreseteatu();
                hautagaiakLortu();
            }
            else{
                tablero.getMatrizea()[pErr][pZut].setBista(pBalio);
                ((KasilaAldakorra) tablero.getMatrizea()[pErr][pZut]).setAukerak(pHautagaiak);
            }
            setChanged();
            notifyObservers();
        }
    }

    private void hautagaiakLortu() {
        // Iteramos todas las casillas y por cada una calculamos sus posibilidades.
        for (int err = 0; err < tablero.getMatrizea().length; err++) {
            for (int zut = 0; zut < tablero.getMatrizea()[0].length; zut++) {
                if (tablero.getMatrizea()[err][zut] instanceof KasilaAldakorra && tablero.getMatrizea()[err][zut].getBista() == 0) {
                    KasilaAldakorra ka= (KasilaAldakorra) tablero.getMatrizea()[err][zut];
                    hautagaiakKalkulatu(ka);
                }
            }
        }
    }

    private void hautagaiakKalkulatu(KasilaAldakorra pKasila) {
        Kasila[][] matrize = tablero.getMatrizea();
        int zenbaki=0;
        for (int err = 0; err < matrize.length; err++) {
            for (int zut = 0; zut < matrize[0].length; zut++) {
                if (err == pKasila.getErr() || zut == pKasila.getZut() || (err / 3) * 3 + (zut / 3) == pKasila.getKoadrante()) {
                    zenbaki=matrize[err][zut].getBista();
                    if(zenbaki!=0 && pKasila.getAukerak()[zenbaki]){
                        pKasila.getAukerak()[zenbaki]=false;
                    }
                }
            }
        }
        for (int i=1; i<pKasila.getBorratuta().length; i++){
            //erabiltzaileak manualki borratutako hautagaiak kendu bistatik
            if(pKasila.getBorratuta()[i] && !pKasila.getAukerak()[i]){
                pKasila.getAukerak()[i]=false;
            }
        }
    }

}
