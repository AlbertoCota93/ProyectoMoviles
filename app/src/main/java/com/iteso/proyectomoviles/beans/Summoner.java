package com.iteso.proyectomoviles.beans;

public class Summoner {

    String summoner, champion, spell1, spell2;
    String summonerIcon, level, rankSolo, id, tierSolo, rankFlex, tierFlex;

    public String getTierSolo() {
        return tierSolo;
    }

    public void setTierSolo(String tier) {
        this.tierSolo = tier;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getRankSolo() {
        return rankSolo;
    }

    public void setRankSolo(String rankSolo) {
        this.rankSolo = rankSolo;
    }

    public String getRankFlex() {
        return rankFlex;
    }

    public void setRankFlex(String rankFlex) {
        this.rankFlex = rankFlex;
    }

    public String getTierFlex() {
        return tierFlex;
    }

    public void setTierFlex(String tierFlex) {
        this.tierFlex = tierFlex;
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
