package model;

public class KasilaAldakorra extends Kasila {
    private Boolean[] aukerak;  //Bistaratzen eta kalkulatzen diren hautagaiak
    private Boolean[] borratuta; //Manualki borratutako hautagaiak

    public KasilaAldakorra(int pErr, int pZut) {
        super(pErr, pZut);
        aukerak = new Boolean[10];
        borratuta = new Boolean[10];
        for(int i=0; i< aukerak.length;i++){
            aukerak[i]=true;
            borratuta[i]=false;
        }
    }

    public Boolean[] getAukerak() {
        return aukerak;
    }

    public void setAukerak(Boolean[] pHaut) {
        for(int i=0; i<aukerak.length;i++){     //Hautagaiak eguneratzeko loop-a
            if(aukerak[i]!=pHaut[i]){           //Bistan hautagai bat aldatu den konprobatu
                borratuta[i]=!pHaut[i];         //Borratutako hautagaien array-a eguneratu
            }
            aukerak[i]=pHaut[i];
        }
        for(int i=0; i<borratuta.length;i++){   //Manualki borratutako hautagaiak bistatik ezabatu
            if(borratuta[i]){
                aukerak[i]=false;
            }
        }
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

    public String hautagaiakToString(){
        String ema = "";
        for (int i=1; i< aukerak.length; i++){
            if (aukerak[i]){
                ema += String.valueOf(i) + " ";
            }
        }
        return ema;
    }

    public void hautagaiakErreseteatu(){
        for(int i=0; i< aukerak.length;i++){
            aukerak[i]=false;
        }
    }

}
