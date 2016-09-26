/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrupA_AngelFrancisco_KANGUROS;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author EVA-00
 */
public class Dades {

    private ArrayList<Worker> workers = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Service> services = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addWorker(String name, int age, String address, String city, float wage) {
        if (age < 16) {
            System.out.println("Too young");
        } else if (age < 18) {
            System.out.println("Tutor:");
            String tutor = sc.next();
            workers.add(new Minor(name, age, address, city, wage, tutor));
        } else {
            workers.add(new Adult(name, age, address, city, wage));
        }
    }

    public void addClient(String name, String DNI, String opinion, int birthday) {
        clients.add(new Client(name, DNI, opinion, birthday));
    }

    public void updateWorker(int pos, String type) {
        switch (type) {
            case "name":
                System.out.println("Name:");
                workers.get(pos).setName(sc.next());
                break;
            case "age":
                System.out.println("Age:");
                workers.get(pos).setAge(sc.nextInt());
                break;
            case "address":
                System.out.println("Address:");
                workers.get(pos).setAddress(sc.next());
                break;
            case "city":
                System.out.println("City:");
                workers.get(pos).setCity(sc.next());
                break;
            case "wage":
                System.out.println("Wage:");
                workers.get(pos).setWage(sc.nextFloat());
                break;
            case "tutor":
                if (workers.get(pos) instanceof Minor) {
                    Minor temp = (Minor) workers.get(pos);
                    System.out.println("Tutor:");
                    temp.setTutor(sc.next());
                } else {
                    System.out.println("Not a minor");
                }
                break;
            case "default":
                System.out.println("Unknown type");
                break;
        }
    }

    public void updateClient(int pos, String type) {
        switch (type) {
            case "age":
                System.out.println("Name:");
                clients.get(pos).setName(sc.next());
                break;
            case "DNI":
                System.out.println("DNI:");
                clients.get(pos).setDNI(sc.next());
                break;
        }
    }

    public void newService(int posw, int posc) {
        float hour;
        if (workers.get(posw) instanceof Minor) {
            do {
                System.out.println("Hours of work: (1-4)");
                hour = sc.nextFloat();
            } while (hour < 0 || hour > 4);
        } else {
            do {
                System.out.println("Hours of work: (1-8)");
                hour = sc.nextFloat();
            } while (hour < 0 || hour > 8);
        }
        workers.get(posw).newService();
        services.add(new Service(workers.get(posw), clients.get(posc)));
    }

    public int isInWorker(String name) {
        int i = 0;
        Worker temp = new Worker(name);
        for (Worker w : workers) {
            if (temp.equals(w)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int isInClient(String name, String DNI) {
        int i = 0;
        Client temp = new Client(name, DNI);
        for (Client c : clients) {
            if (c.equals(temp)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void printMostRequested(String type) {
        switch (type) {
            case "Worker":
                if (!workers.isEmpty()) {
                    printWorker();
                }
                break;
            case "Client":
                if (!clients.isEmpty()) {
                    printClient();
                }
                break;
        }
    }

    private void printWorker() {
        ArrayList<Worker> temp = new ArrayList<>(workers);
        int max = -1;
        Worker remove = new Worker("temp");
        while (!temp.isEmpty()) {
            for (Worker w : temp) {
                if (w.getServices() > max) {
                    remove = w;
                    max = w.getServices();
                }
            }
            System.out.println(remove.getName() + ": " + max);
            max = -1;
            temp.remove(remove);
        }
    }

    private void printClient() {
        ArrayList<Client> temp = new ArrayList<>(clients);
        int max = -1;
        Client remove = new Client("temp", "temp");
        while (!temp.isEmpty()) {
            for (Client c : temp) {
                if (c.getServices() > max) {
                    remove = c;
                    max = c.getServices();
                }
            }
            System.out.println(remove.getName() + ": " + max);
            max=-1;
            temp.remove(remove);
        }
    }
}
