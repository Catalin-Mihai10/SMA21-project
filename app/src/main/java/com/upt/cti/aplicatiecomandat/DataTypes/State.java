package com.upt.cti.aplicatiecomandat.DataTypes;

public class State {

    private int stateId;
    private String stateName;
    private String diacritice;
    private String city;
    private String auto;
    private int zip;
    private int populatie;
    private double lat,lng;

    public State(){}

    public State(int stateId, String stateName, String diacritice, String city, String auto, int zip, int populatie, double lat, double lng){
        this.stateId = stateId;
        this.stateName = stateName;
        this.diacritice = diacritice;
        this.city = city;
        this.auto = auto;
        this.zip = zip;
        this.populatie = populatie;
        this.lat = lat;
        this.lng = lng;
    }

    public int getStateId(){ return stateId;}

    public String getStateName(){ return stateName;}

    public String getCity(){ return city;}

    public String getDiacritice(){ return diacritice;}

    public String getAuto(){ return auto;}

    public void setStateId(int stateId){ this.stateId = stateId;}

    public void setStateName(String stateName){ this.stateName = stateName;}

    public int compare(State lhs, State rhs){
        return lhs.getStateName().compareTo(rhs.getStateName());
    }
}
