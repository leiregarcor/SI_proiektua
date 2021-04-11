package model;

public class Tablero {

    private int lvl;
    private String izena;
    private Kasila[][] matrizea;
    private int kasilaHutsik;

    public Tablero() {
        this.matrizea = new Kasila[9][9];
        this.sortuMatrizea();
        this.kasilaHutsik = 81; //kasila kopurua
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

    private void sortuMatrizea(){
        for (int err=0; err<matrizea.length ; err++){
            for (int zut=0; zut<matrizea[0].length; zut++){
                matrizea[err][zut]= new Kasila(err, zut);
            }
        }
    }
    
    public boolean partidaBukatu() {
    	//Erabiltzaileak kasila guztiak bete baditu true, bestela false bueltatu
    	boolean ema = true;
        int zut=0,err=0;
        while (ema && err<matrizea.length){
           while (ema && zut<matrizea[0].length){
               ema = (matrizea[err][zut].getPredicted()!=0);
               zut++;
           }
           err++;
        }
    	return ema;
    }

    public boolean zuzenaDa(){
        //Soluzioa sartutako balioarekin konparatuko da, true balio zuzena bada, false bestela.
         boolean ema = true;
         int zut=0,err=0;
         while (ema && err<matrizea.length){
            while (ema && zut<matrizea[0].length){
                ema=matrizea[err][zut].zuzenaDa();
                zut++;
            }
            err++;
         }
         return ema;
    }
    public  void balioakEsleitu(boolean m,int index, String zenbakiak){
        //Index errenkada zenbakia markatzen du, zenbakiak, bete beharreko zenbakiak.
        //Boolearrak ze matrizean esleitu behar dugun markatuko du.
        if(m){
            for (int i = 0;i<=8;i++){
                int x = Integer.parseInt(String.valueOf(zenbakiak.charAt(i)));
                this.matrizea[index][i].setPredicted(x);
                if(x!=0) {
                	this.kasilaHutsik--;
                }
            }
        }else{
            for (int i = 0;i<=8;i++){
                int x = Integer.parseInt(String.valueOf(zenbakiak.charAt(i)));
                this.matrizea[index][i].setActual(x);
            }

        }
    }
}