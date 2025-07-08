package com.example.karta_agona;

import java.util.Comparator;

public class TeamComparatorsR8 {

    private TeamComparatorsR8(){

    }




    public static Comparator<TeamR8> getTeamNameComparator() {
        return new TeamNameComparator();
    }

    private static class TeamNameComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return t1.getName().compareTo(t2.getName());
        }
    }

    public static Comparator<TeamR8> getGPComparator() {
        return new GPComparator();
    }

    private static class GPComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return t1.getGames_played()-(t2.getGames_played());
        }
    }

    public static Comparator<TeamR8> getPointsComparator() {
        return new PointsComparator();
    }

    private static class PointsComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return t1.getPoints()-(t2.getPoints());
        }
    }

    public static Comparator<TeamR8> getPPGComparator() {
        return new PPGComparator();
    }

    private static class PPGComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getPoints()/t1.getGames_played())-(t2.getPoints()/t2.getGames_played());
        }
    }


    public static Comparator<TeamR8> getTwoPMComparator() {
        return new TwoPMComparator();
    }

    private static class TwoPMComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getMade2p())-(t2.getMade2p());
        }
    }

    public static Comparator<TeamR8> getThreePMComparator() {
        return new ThreePMComparator();
    }

    private static class ThreePMComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getMade3p())-(t2.getMade3p());
        }
    }

    public static Comparator<TeamR8> getFTMComparator() {
        return new FTMComparator();
    }

    private static class FTMComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getMadeft())-(t2.getMadeft());
        }
    }

    public static Comparator<TeamR8> getRebsComparator() {
        return new RebsComparator();
    }

    private static class RebsComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getOff_rebs()+t1.getDef_rebs())-(t2.getOff_rebs()+t2.getDef_rebs());
        }
    }

    public static Comparator<TeamR8> getDRebsComparator() {
        return new DRebsComparator();
    }

    private static class DRebsComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getDef_rebs())-(t2.getDef_rebs());
        }
    }
    public static Comparator<TeamR8> getORebsComparator() {
        return new ORebsComparator();
    }

    private static class ORebsComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getOff_rebs())-(t2.getOff_rebs());
        }
    }
    public static Comparator<TeamR8> getASTComparator() {
        return new ASTComparator();
    }

    private static class ASTComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getAssist())-(t2.getAssist());
        }
    }

    public static Comparator<TeamR8> getBLKComparator() {
        return new BLKComparator();
    }

    private static class BLKComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getBlocks())-(t2.getBlocks());
        }
    }

    public static Comparator<TeamR8> getBLK_onComparator() {
        return new BLK_onComparator();
    }

    private static class BLK_onComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getBlocks_on())-(t2.getBlocks_on());
        }
    }

    public static Comparator<TeamR8> getSTLComparator() {
        return new STLComparator();
    }

    private static class STLComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getSteals())-(t2.getSteals());
        }
    }

    public static Comparator<TeamR8> getTURNComparator() {
        return new TURNComparator();
    }

    private static class TURNComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getTurnovers())-(t2.getTurnovers());
        }
    }
    public static Comparator<TeamR8> getFOULSFComparator() {
        return new FOULSFComparator();
    }

    private static class FOULSFComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getFouls_drawn())-(t2.getFouls_drawn());
        }
    }

    public static Comparator<TeamR8> getFOULSMComparator() {
        return new FOULSMComparator();
    }

    private static class FOULSMComparator implements Comparator<TeamR8> {
        @Override
        public int compare(final TeamR8 t1, final TeamR8 t2) {
            return (t1.getFouls_commited())-(t2.getFouls_commited());
        }
    }
//    public static Comparator<TeamR8> getRANKComparator() {
//        return new RANKComparator();
//    }
//
//    private static class RANKComparator implements Comparator<TeamR8> {
//        @Override
//        public int compare(final TeamR8 t1, final TeamR8 t2) {
//            return (t1.getRank())-(t2.getRank());
//        }
//    }




}

