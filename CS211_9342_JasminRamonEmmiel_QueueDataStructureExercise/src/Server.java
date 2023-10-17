/**
 * NAME: JASMIN, Ramon Emmiel P.
 * DATE: 17 October 2023
 */

import java.util.Random;

public class Server implements Comparable<Server>{
    private int id;
    private Client client;
    private double meanServiceTime;
    private int serviceTime;
    private int startServiceTime;
    private int stopServiceTime;
    private Random randomNumberGenerator;

    public Server(){
        this.id = 1;
        this.client = null;
    }

    public Server(int id, Client client, double meanServiceTime, int startServiceTime){
        this.randomNumberGenerator = new Random();
        this.startServiceTime = startServiceTime;
        this.id = id;
        this.client = client;
        this.meanServiceTime = meanServiceTime;
        this.serviceTime = randomNumberGenerator.nextInt((int) Math.ceil(meanServiceTime));
        this.stopServiceTime = startServiceTime + serviceTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getMeanServiceTime() {
        return meanServiceTime;
    }

    public void setMeanServiceTime(double meanServiceTime) {
        this.meanServiceTime = meanServiceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getStartServiceTime() {
        return startServiceTime;
    }

    public void setStartServiceTime(int startServiceTime) {
        this.startServiceTime = startServiceTime;
    }

    public int getStopServiceTime() {
        return stopServiceTime;
    }

    public void setStopServiceTime(int stopServiceTime) {
        this.stopServiceTime = stopServiceTime;
    }

    public Random getRandomNumberGenerator() {
        return randomNumberGenerator;
    }

    public void setRandomNumberGenerator(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public boolean isIdle(){
        return client == null;
    }

    public int compareTo(Server another){
        return this.toString().compareTo(another.toString());
    }

    @Override
    public String toString() {
        return "S" + id;
    }
}
