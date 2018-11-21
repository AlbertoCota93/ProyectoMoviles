package com.iteso.proyectomoviles.beans;

public class Summoner {

    String summoner, champion, spell1, spell2;
    String summonerIcon, level, rank;

    @Override
    public String toString() {
        return "Summoner{" +
                "summoner='" + summoner + '\'' +
                ", champion='" + champion + '\'' +
                ", spell1='" + spell1 + '\'' +
                ", spell2='" + spell2 + '\'' +
                ", summonerIcon='" + summonerIcon + '\'' +
                ", level='" + level + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }

    public String getSummonerIcon() {
        return summonerIcon;
    }

    public void setSummonerIcon(String summonerIcon) {
        this.summonerIcon = summonerIcon;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSummoner() {
        return summoner;
    }

    public void setSummoner(String summoner) {
        this.summoner = summoner;
    }

    public String getChampion() {
        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
    }

    public String getSpell1() {
        return spell1;
    }

    public void setSpell1(String spell1) {
        this.spell1 = spell1;
    }

    public String getSpell2() {
        return spell2;
    }

    public void setSpell2(String spell2) {
        this.spell2 = spell2;
    }
}
