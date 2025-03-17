package trip;
public class Trip {
    String startLocation;
    String endLocation;
    int distance;
    public final boolean isGoing = true;

    public void setRoute(String startLocation, String endLocation) {
        System.out.println("Route from " + startLocation + " to " + endLocation);
    }
    public void setRoute(int distance) {
        System.out.println("Route is this far: " + distance);
    }
}
