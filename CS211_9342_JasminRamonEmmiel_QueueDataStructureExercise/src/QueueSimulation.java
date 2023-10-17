/**
 * NAME: JASMIN, Ramon Emmiel P.
 * DATE: 17 October 2023
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueSimulation {
    public static void main(String[] args) {
        try {
            QueueSimulation simulation = new QueueSimulation();
            simulation.run();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * ALGORITHM
     *
     * 1. Initialize the random variables that will generate random numbers for arrival and service time
     * 2. initialize the avergae inter arrival time to 4, time duration to 50, and average time of service to 5.
     * 3. Initialize a queue that will contain the list of clients
     * 4. Initialize the first client id to 1
     * 5. Initialize a Server called server
     * 6. In a loop that runs for the specified simulation time duration, the following events occur:
     *      a. Check if the current time matches the next client arrival time. If it does, generate a new client,
     *         add them to the queue, and update the next arrival time. This simulates clients arriving at the system.
     *      b. Check if the server is idle and there are clients in the queue. If both conditions are met, assign the
     *         next client in the queue to the server and set the start and stop service times. This simulates the
     *         server serving a client.
     *      c. Check if the current time matches the stop service time of the server, and if the current time is greater
     *         than zero (to avoid unnecessary output at time zero). If these conditions are met, the server has finished
     *         serving a client, and the client is removed from the server.
     *
     * 7. The simulation runs until the specified time duration is reached, and the events of clients arriving, being
     *    served, and completing service are recorded.
     */
    public void run(){
        Random randomArrivalGenerator = new Random();
        Random randomServiceTimeGenerator = new Random();
        int averageInterarrival = 4;
        int simulationTimeDuration = 50;
        double meanServiceTime = 5;

        int nextArrivalTime = randomArrivalGenerator.nextInt(averageInterarrival);

        Queue<Client> myListOfClients = new LinkedList<Client>();

        int clientId = 1;

        Server server = new Server();

        for (int time = 0; time <= simulationTimeDuration; time++){
            if (time == nextArrivalTime){
                System.out.println("Client" + clientId + " has arrived at time = " + nextArrivalTime);
                Client newClient = new Client(clientId, nextArrivalTime);
                myListOfClients.add(newClient);
                showList(myListOfClients);
                System.out.println("Number of clients in the list = " + myListOfClients.size());
                clientId++;
                nextArrivalTime += 1 + randomArrivalGenerator.nextInt(averageInterarrival);
                System.out.println("Next client will arrive at time = " + nextArrivalTime);
            }

            if (server.isIdle() && !myListOfClients.isEmpty()){
                Client clientToServer = myListOfClients.remove();
                server.setClient(clientToServer);
                server.setStartServiceTime(time);
                int serveTime = randomServiceTimeGenerator.nextInt((int) meanServiceTime);
                int timeForServerToBecomeFree = time + serveTime;
                server.setStopServiceTime(timeForServerToBecomeFree);
                System.out.println("At time = " + time + " Server started serving client " + clientToServer + ".");
                System.out.println("Server will be free at time = " + timeForServerToBecomeFree);
                showList(myListOfClients);
            }

            if (time == server.getStopServiceTime() && time > 0){
                System.out.println("At time = " + time + " Server finished serving client " + server.getClient() + ".");
                server.setClient(null);
            }
        }
    }

    public void showList(Queue<Client> a){
        System.out.println("Queue of Waiting Clients: ");
        for (Client c:a){
            System.out.println(c.toString() + "");
        }
        System.out.println();
        return;
    }
}
