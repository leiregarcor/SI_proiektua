package model;

import java.util.Arrays;

public class Tablero {

    private int lvl;
    private String izena;
    private Kasila[][] matrizea;
    private int kasilaHutsik;

    public Tablero() {
        this.matrizea = new Kasila[9][9];
        this.kasilaHutsik = 81; // kasila kopurua
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public Kasila[][] getMatrizea() {
        return matrizea;
    }

    public void setMatrizea(Kasila[][] matrizea) {
        this.matrizea = matrizea;
    }

    public boolean tableroaKargatu(int lvl){
        Boolean b=true;
        if(TableroCatalog.getInstance().getTablero(lvl)==null){
            b=false;
        }
        else{
            int bista[][]=TableroCatalog.getInstance().getTablero(lvl).getBista();
            int soluzioa[][]=TableroCatalog.getInstance().getTablero(lvl).getSoluzioa();
            Kasila k;
            for (int err=0; err< matrizea.length; err++) {
                for (int zut=0; zut< matrizea[0].length;zut++){
                    if (bista[err][zut]==0){
                        matrizea[err][zut] = new KasilaAldakorra(err, zut);
                        matrizea[err][zut].setBista(bista[err][zut]);
                        if(matrizea[err][zut] instanceof KasilaAldakorra){
                            ((KasilaAldakorra) matrizea[err][zut]).setSoluzio(soluzioa[err][zut]);
                        }
                    }
                    else{
                        matrizea[err][zut]= new KasilaAldaezina(err, zut);
                        matrizea[err][zut].setBista(bista[err][zut]);
                        kasilaHutsik--;
                    }
                }
            }
        }
        return b;
    }

    public boolean partidaBukatu() {
        // Erabiltzaileak kasila guztiak bete baditu true, bestela false bueltatu
        boolean ema = true;
        int zut = 0, err = 0;
        while (ema && err < matrizea.length) {
            zut = 0;
            while (ema && zut < matrizea[0].length) {
                ema = (matrizea[err][zut].getBista() != 0);
                zut++;
            }
            err++;
        }
        return ema;
    }

    public boolean zuzenaDa() {
        // Soluzioa sartutako balioarekin konparatuko da, true balio zuzena bada, false
        // bestela.
        boolean ema = true;
        int zut = 0, err = 0;
        while (ema && err < matrizea.length) {
            zut = 0;
            while (ema && zut < matrizea[0].length) {
                if (matrizea[err][zut] instanceof KasilaAldakorra){
                    ema = ((KasilaAldakorra) matrizea[err][zut]).zuzenaDa();
                }
                zut++;
            }
            err++;
        }
        return ema;
    }

    public int[] soleCandidateLaguntza(){
        boolean aurk = false;
        int[] ema= new int[3];
        int kont = 0;
        int pos=0;
        int zenbaki = 0;
        int zut=0;
        int err=0;
        while (!aurk && err < matrizea.length) {
            zut=0;
            while (!aurk && zut < matrizea[0].length) {
                if (matrizea[err][zut] instanceof KasilaAldakorra && matrizea[err][zut].getBista() == 0) {
                    KasilaAldakorra ka= (KasilaAldakorra) matrizea[err][zut];
                    Boolean[] posible= new Boolean[10];
                    Arrays.fill(posible, true);
                    posible[0]=false;
                    for (int e = 0; e < matrizea.length; e++) {
                        for (int z = 0; z < matrizea[0].length; z++) {
                            if (e == ka.getErr() || z == ka.getZut() || (e / 3) * 3 + (z / 3) == ka.getKoadrante()) {
                                zenbaki=matrizea[e][z].getBista();
                                if(zenbaki!=0 && posible[zenbaki]){
                                    posible[zenbaki]=false;
                                }
                            }
                        }
                    }
                    for (int i=0; i< posible.length; i++){
                        if(posible[i]){
                            kont++;
                            pos=i;
                        }
                    }
                    if(kont==1){
                        aurk=true;
                        ema= new int[]{pos,err,zut};
                    }
                    kont=0;
                }
                zut++;
            }
            err++;
        }
        if(!aurk){
            ema= new int[]{-1,-1,-1};
        }
        return ema;
    }

    public int[] uniqueCandidateLaguntza(){
        boolean aurk = false;
        int[] ema= new int[3];
        int kont = 0;
        int pos=0;
        int zut=0;
        int err = 0;
        while (!aurk&&err<matrizea.length) {
            zut = 0;
            while (!aurk && zut < matrizea.length) {
                if (matrizea[err][zut] instanceof KasilaAldakorra && matrizea[err][zut].getBista() == 0) {
                    KasilaAldakorra ka = (KasilaAldakorra) matrizea[err][zut];
                    Boolean[] posible = new Boolean[10];
                    Arrays.fill(posible, true);
                    posible[0] = false;
                    for (int errenkada = 0; errenkada < matrizea.length; errenkada++) {
                        if (matrizea[errenkada][zut] instanceof KasilaAldakorra && matrizea[errenkada][zut].getBista() == 0) {
                            KasilaAldakorra ka2 = (KasilaAldakorra) matrizea[errenkada][zut];
                            if(!ka2.equals(ka)){
                                for (int i = 0; i < ka2.getAukerak().length; i++) {
                                    if (ka2.getAukerak()[i]) {
                                        posible[i] = false;
                                    }
                                }
                            }
                        }
                        else {
                            posible[matrizea[errenkada][zut].getBista()]=false;
                        }
                    }
                    for (int j = 0; j < posible.length; j++) {
                        if (posible[j]) {
                            kont++;
                            pos = j;
                        }
                    }
                    if (kont == 1) {
                        aurk = true;
                        ema = new int[]{pos, err, zut};
                    }
                    kont = 0;
                    if (!aurk) {
                        Arrays.fill(posible, true);
                        posible[0] = false;
                        for (int zutabea = 0; zutabea < matrizea[0].length; zutabea++) {
                            if (matrizea[err][zutabea] instanceof KasilaAldakorra && matrizea[err][zutabea].getBista() == 0) {
                                KasilaAldakorra ka2 = (KasilaAldakorra) matrizea[err][zutabea];
                                if(!ka2.equals(ka)){
                                    for (int i = 0; i < ka2.getAukerak().length; i++) {
                                        if (ka2.getAukerak()[i]) {
                                            posible[i] = false;
                                        }
                                    }
                                }
                            }
                            else {
                                posible[matrizea[err][zutabea].getBista()]=false;
                            }
                        }
                        for (int j = 0; j < posible.length; j++) {
                            if (posible[j]) {
                                kont++;
                                pos = j;
                            }
                        }
                        if (kont == 1) {
                            aurk = true;
                            ema = new int[]{pos, err, zut};
                        }
                        kont = 0;
                        if (!aurk) {
                            Arrays.fill(posible, true);
                            posible[0] = false;
                            for (int e = 0; e < matrizea.length; e++) {
                                for (int z = 0; z < matrizea[0].length; z++) {
                                    if ((e / 3) * 3 + (z / 3) == ka.getKoadrante()) {
                                        if (matrizea[e][z] instanceof KasilaAldakorra && matrizea[e][z].getBista() == 0) {
                                            KasilaAldakorra ka2 = (KasilaAldakorra) matrizea[e][z];
                                            if(!ka2.equals(ka)){
                                                for (int i = 0; i < ka2.getAukerak().length; i++) {
                                                    if (ka2.getAukerak()[i]) {
                                                        posible[i] = false;
                                                    }
                                                }
                                            }
                                        }
                                        else {
                                            posible[matrizea[e][z].getBista()]=false;
                                        }
                                    }
                                }
                            }
                            for (int j = 0; j < posible.length; j++) {
                                if (posible[j]) {
                                    kont++;
                                    pos = j;
                                }
                            }
                            if (kont == 1) {
                                aurk = true;
                                ema = new int[]{pos, err, zut};
                            }
                            kont = 0;
                        }
                    }
                }
                zut++;
            }
            err++;
        }
        if(!aurk){
            ema= new int[]{-1,-1,-1};
        }
        return ema;
    }
}