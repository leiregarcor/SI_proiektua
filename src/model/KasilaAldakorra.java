package model;

public class KasilaAldakorra extends Kasila {
    private int bista; //erabiltzaileak sartutakoa
    private String aukerak;

	
	public KasilaAldakorra (int pErr, int pZut)
	{
		super(pErr, pZut);
	}

	
    public int getBista() {
        return bista;
    }
	
    
    public String getAukerak() {
        return aukerak;
    }

    public void setAukerak(String aukerak) {
        this.aukerak = aukerak;
    }

    public void setBista(int bista) {
        this.bista = bista;
    }

    public boolean zuzenaDa(){
        // Kasila bateko soluzioa sartutako balioarekin konparatuko da, true balio zuzena bada, false bestela.
        return this.soluzio == this.bista;
    }
    
    
    
}
