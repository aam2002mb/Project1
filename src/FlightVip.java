public class FlightVip extends Flights{
    private int numchair;

    public FlightVip(String from, String to, String dep_date, String arv_date, int numtravelers, int travelersprice, int numchair) {
        super(from, to, dep_date, arv_date, numtravelers, travelersprice);
        this.numchair = numchair;
    }

    public int getNumchair() {
        return numchair;
    }

    public void setNumchair(int numchair) {
        this.numchair = numchair;
    }

    @Override
    public String toString() {
        return "FlightVip{" +
                "numchair=" + numchair +
                '}';
    }
}
