package model;

import java.io.*;

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


    public void fitxeroaEguneratu() throws IOException {
        FileWriter fitxero= null;
        PrintWriter pw=null;
        fitxeroaSortu();
        try {
            fitxero= new FileWriter("resources\\Ranking.txt");
            pw=new PrintWriter(fitxero);
            Collection<Web> c= this.webMapa.values();
            ArrayList<Web> list= new ArrayList<>(c);
            // Hash mapeko balioak arrayList<Web>n gorde

            for(int i=0; i<list.size();i++) {
                pw.println(list.get(i).getUrlWeb()+" " +i);
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
