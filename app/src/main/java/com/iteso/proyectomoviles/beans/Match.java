package com.iteso.proyectomoviles.beans;

public class Match  {
    private int matchId;
    private String matchHero;
    private String imageURL;
    private String matchKda;

    public Match (int id, String hero, String image, String kda){
        this.imageURL = image;
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

    public String getImageId() {
        return imageURL;
    }

    public void setImageId(String imageId) {
        this.imageURL = imageId;
    }

    public String getMatchKda() {
        return matchKda;
    }

    public void setMatchKda(String matchKda) {
        this.matchKda = matchKda;
    }
}
