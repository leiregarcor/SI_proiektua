package model;

public class KasilaAldakorra extends Kasila {
    private String aukerak;

    public KasilaAldakorra(int pErr, int pZut) {
        super(pErr, pZut);
    }



    public String getAukerak() {
        return aukerak;
    }

    public void setAukerak(String aukerak) {
        this.aukerak = aukerak;
    }


    public boolean zuzenaDa() {
        // Kasila bateko soluzioa sartutako balioarekin konparatuko da, true balio
        // zuzena bada, false bestela.
        return this.soluzio == this.bista;
    }

}
