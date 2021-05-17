package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RankingKud {
    private static RankingKud nRankingKud = new RankingKud();
    private List<Erabiltzaile> erabiltzaileKol = new ArrayList<Erabiltzaile>();

    private RankingKud() {}

    public static RankingKud getNireRankingKud(){return nRankingKud;}

    public void addErabiltzaile(Erabiltzaile e){
        erabiltzaileKol.add(e);
    }

    public void rankingKargatu(){
        File ranking= new File("resources/Ranking.txt");
        ArrayList<String> ema = Reader.getInstance().fitxeroakKargatu(ranking);
        Erabiltzaile erabiltzaile;
        Iterator<String> itr = ema.iterator();
        String line= itr.next();

        while (itr.hasNext()){
            line= itr.next();
            erabiltzaile = new Erabiltzaile();
            String[] l= line.split(" ");
            erabiltzaile.setIzena(l[1]);
            erabiltzaile.setPuntuazioa(Integer.parseInt(l[2]));
            erabiltzaile.setLvl(Integer.parseInt(l[3]));
            addErabiltzaile(erabiltzaile);
        }
    }

    public ArrayList<Erabiltzaile> rankingOrdenatu(){
        return (ArrayList<Erabiltzaile>) erabiltzaileKol.stream()
                .sorted(Comparator.comparing(p->p.getPuntuazioa()));
    }

}
