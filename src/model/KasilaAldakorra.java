package model;

public class KasilaAldakorra extends Kasila {
    private Boolean[] aukerak;
    private Boolean[] borratuta;

    public KasilaAldakorra(int pErr, int pZut) {
        super(pErr, pZut);
        aukerak = new Boolean[10];
        borratuta = new Boolean[10];
    }

    public Boolean[] getAukerak() {
        return aukerak;
    }

    public void setAukerak(Boolean[] aukerak) {
        this.aukerak = aukerak;
    }


    public boolean zuzenaDa() {
        // Kasila bateko soluzioa sartutako balioarekin konparatuko da, true balio
        // zuzena bada, false bestela.
        return this.soluzio == this.bista;
    }
    public Boolean[] getBorratuta() {
        return borratuta;
    }

    public void setBorratuta(Boolean[] borratuta) {
        this.borratuta = borratuta;
    }
}
