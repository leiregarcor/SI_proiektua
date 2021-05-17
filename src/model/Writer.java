package model;

import java.io.*;
import java.util.ArrayList;

public class Writer {
    private static Writer writer = null;

    private Writer() {}

    public static Writer getInstance() {
        if (writer == null) {
            writer = new Writer();
        }
        return writer;
    }

    private void fitxeroaSortu() throws IOException{
        //post: Web-orrien zerrenda fitxategitan gordetzen du
        String ruta= "resources\\Ranking.txt";
        File fitxeroa= new File(ruta);
        BufferedWriter bw;
        if(fitxeroa.exists()) {
            bw = new BufferedWriter(new FileWriter(fitxeroa));
        }else {
            bw = new BufferedWriter(new FileWriter(fitxeroa));
        }
        bw.close();
    }


   public void fitxeroaEguneratu(ArrayList<Erabiltzaile> lista) throws IOException {
        FileWriter fitxero= null;
        PrintWriter pw=null;
        fitxeroaSortu();
        try {
            fitxero= new FileWriter("resources\\Ranking.txt");
            pw=new PrintWriter(fitxero);
            // Hash mapeko balioak arrayList<Web>n gorde

            for(int i=0; i<lista.size();i++) {
                pw.println(i + " " + lista.get(i).getIzena()+ " " + lista.get(i).getPuntuazioa() + " " + lista.get(i).getLvl());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(null!=fitxero) {
                    fitxero.close();
                }
            }catch(Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
