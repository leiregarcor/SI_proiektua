package model;

import java.util.ArrayList;
import java.util.List;

public class RankingKud {
    private static RankingKud nRankingKud = new RankingKud();

    private RankingKud() {}
    private List<Erabiltzaile> erabiltzaileKol = new ArrayList<Erabiltzaile>();

    public static RankingKud getNireRankingKud(){return nRankingKud;}

    public void addErabiltzaile(Erabiltzaile e){
        erabiltzaileKol.add(e);
    }
}
