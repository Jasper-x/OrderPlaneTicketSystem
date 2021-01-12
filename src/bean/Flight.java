package bean;

public class Flight {

    private String flightId;
    private String planeType;
    private String totalseatsnum;
    private String departureAirPort;
    private String destinationAirPort;
    private String departureTime;


    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }


    public String getTotalseatsnum() {
        return totalseatsnum;
    }

    public void setTotalseatsnum(String totalseatsnum) {
        this.totalseatsnum = totalseatsnum;
    }

    public String getDepartureAirPort() {
        return departureAirPort;
    }

    public void setDepartureAirPort(String departureAirPort) {
        this.departureAirPort = departureAirPort;
    }

    public String getDestinationAirPort() {
        return destinationAirPort;
    }

    public void setDestinationAirPort(String destinationAirPort) {
        this.destinationAirPort = destinationAirPort;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
