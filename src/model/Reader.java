package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    private static Reader reader = null;

    private Reader() {}

    public static Reader getInstance() {
        if (reader == null) {
            reader = new Reader();
        }
        return reader;
    }

    public ArrayList<String> fitxeroakKargatu(File pFitxeroa) {
        BufferedReader reader;
        ArrayList<String> ema = new ArrayList<String>();

        try {
            reader = new BufferedReader(new FileReader(pFitxeroa));
            String line = reader.readLine();

            while (line != null) {
                ema.add(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ema;
    }
}
