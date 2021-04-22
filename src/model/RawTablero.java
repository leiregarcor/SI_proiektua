package model;

public class RawTablero {

    private int lvl;
    private String izena;
    private int[][] soluzioa;
    private int[][] bista;

    public RawTablero() {
        this.soluzioa= new int[9][9];
        this.bista= new int[9][9];
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

    public void balioakEsleitu(boolean m, int index, String zenbakiak) {
        // Index errenkada zenbakia markatzen du, zenbakiak, bete beharreko zenbakiak.
        // Boolearrak ze matrizean esleitu behar dugun markatuko du.
        if (m) {
            for (int i = 0; i <= 8; i++) {
                int x = Integer.parseInt(String.valueOf(zenbakiak.charAt(i)));
                this.bista[index][i]=x;
            }
        } else {
            for (int i = 0; i <= 8; i++) {
                int x = Integer.parseInt(String.valueOf(zenbakiak.charAt(i)));
                this.soluzioa[index][i]=x;
            }

        }
    }

    public int[][] getBista() {
        return bista;
    }

    public int[][] getSoluzioa() {
        return soluzioa;
    }

    public void setSoluzioa(int[][] s) {
        this.soluzioa = s;
    }

    public void setBista(int[][] b) {
        this.bista = b;
    }

}
