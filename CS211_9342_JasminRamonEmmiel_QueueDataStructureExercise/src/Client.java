/**
 * NAME: JASMIN, Ramon Emmiel P.
 * DATE: 17 October 2023
 */
public class Client {
    private int id;
    private int arrivalTime;
    private int startServiceTime;

    public Client(int id, int arrivalTime){
        this.id = id;
        this.arrivalTime = arrivalTime;
    }

    public Client(int id, int arrivalTime, int startServiceTime){
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.startServiceTime = startServiceTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setStartServiceTime(int startServiceTime) {
        this.startServiceTime = startServiceTime;
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getStartServiceTime() {
        return startServiceTime;
    }

    @Override
    public String toString() {
        return ("N" + id + "("+arrivalTime+")");
    }
}
