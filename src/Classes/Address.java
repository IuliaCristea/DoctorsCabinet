package Classes;

import Log.MyLogger;

public class Address {
    private String street;
    private String building;
    private String apartment;
    private String town;

    public Address(String address){
        try {
            String[] tokens = address.split(" ");
            this.street = tokens[0];
            this.building = tokens[1];
            this.apartment = tokens[2];
            this.town = tokens[3];
        }
        catch(Exception ex)
        {
            MyLogger.Error("parse address ", ex.toString());
        }
    }
    public Address(String street, String building, String apartment, String town)
    {
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding() {
        return building;
    }

    public String getApartment() {
        return apartment;
    }

    public String getTown() {
        return town;
    }
}
