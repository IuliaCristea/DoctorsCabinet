public class Address {
    String Street;
    int StreetNumber;
    String Building;
    int Floor;
    int ApartmentOrRoom;

    public void setStreet(String street) {
        Street = street;
    }

    public void setStreetNumber(int streetNumber) {
        StreetNumber = streetNumber;
    }

    public void setBuilding(String building) {
        Building = building;
    }

    public void setFloor(int floor) {
        Floor = floor;
    }

    public void setApartmentOrRoom(int apartmentOrRoom) {
        ApartmentOrRoom = apartmentOrRoom;
    }

    public String getStreet() {
        return Street;
    }

    public int getStreetNumber() {
        return StreetNumber;
    }

    public String getBuilding() {
        return Building;
    }

    public int getFloor() {
        return Floor;
    }

    public int getApartmentOrRoom() {
        return ApartmentOrRoom;
    }

}
