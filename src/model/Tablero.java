package model;

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

    public void tableroaKargatu(int lvl){
        int bista[][]=TableroCatalog.getInstance().getTablero(lvl).getBista();
        int soluzioa[][]=TableroCatalog.getInstance().getTablero(lvl).getSoluzioa();
        for (int err=0; err< matrizea.length; err++) {
            for (int zut=0; zut< matrizea[0].length;zut++){
                if (bista[err][zut]==0){
                    matrizea[err][zut] = new KasilaAldakorra(err, zut);
                    matrizea[err][zut].setBista(bista[err][zut]);
                    matrizea[err][zut].setSoluzio(soluzioa[err][zut]);
                }
                else{
                    matrizea[err][zut]= new KasilaAldaezina(err, zut);
                    matrizea[err][zut].setBista(bista[err][zut]);
                    matrizea[err][zut].setSoluzio(soluzioa[err][zut]);
                    kasilaHutsik--;
                }
            }
        }
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
}