package com.iteso.proyectomoviles.beans;

public class ProTeam {
    private String name;
    private int logo;
    private String region;
    private int id;

    public ProTeam(String name, int logo, String region, int id){
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
