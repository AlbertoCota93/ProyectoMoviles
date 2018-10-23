package com.iteso.proyectomoviles.beans;

public class Match  {
    private int matchId;
    private String matchHero;
    private int imageId;
    private String matchKda;

    public Match (int id, String hero, int image, String kda){
        this.imageId = image;
        this.matchHero = hero;
        this.matchId = id;
        this.matchKda = kda;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getMatchHero() {
        return matchHero;
    }

    public void setMatchHero(String matchHero) {
        this.matchHero = matchHero;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getMatchKda() {
        return matchKda;
    }

    public void setMatchKda(String matchKda) {
        this.matchKda = matchKda;
    }
}
