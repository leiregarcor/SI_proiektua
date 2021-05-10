package model;

public class RankingKud {
    private static RankingKud nRankingKud = new RankingKud();

    private RankingKud() {}

    public static RankingKud getNireRankingKud(){return nRankingKud;}
}
