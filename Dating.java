/**
 * Name         : Yap Kai Herng
 * Matric. No   : A199729A
 */

import java.util.*;

public class Dating {
    private void run() {
        Scanner sc = new Scanner(System.in);
        //first int is irrelevant since we can use hasNextLine()
        sc.nextLine(); 
        LinkedList<Person> males = new LinkedList<>();
        LinkedList<Person> females = new LinkedList<>();
        while (sc.hasNextLine()) {
            String curr = sc.nextLine();
            //split each line into "<gender>" and "<name>"
            String[] split = curr.split(" ");
            Person toAdd = new Person(split[1]);
            if (split[0].equals("MALE")) {
                males.add(toAdd);
            } else {
                females.add(toAdd);
            }
        }
        sc.close();
        double waitTime = 0;
        int matchCounter = 0;
        //matching occurs when there are males and females
        //matches occur in a FIFO structure via poll()
        while (!males.isEmpty() && !females.isEmpty()) {
            Person matchedMale = males.poll();
            Person matchedFemale = females.poll();
            System.out.println(matchedMale.name() + " matches " +
                    matchedFemale.name());
            matchCounter++;
            waitTime += matchedMale.queueDiff(matchedFemale);
        }
        //if there are no matches, the wait time is 0
        //if there are matches, the number of people matched is twice 
        //of the num of matches. 
        double avgWait = matchCounter == 0 ? 0 : waitTime/(matchCounter
                * 2);

        System.out.println(String.format("%.2f", avgWait));
    }


    public static void main(String args[]) {
        Dating dating = new Dating();
        dating.run();
    }
}

/*
This class works as a ADT to store the name and which request number 
each person is. There is a global static counter to track the number of Person 
objects created, which acts as a proxy for the Peron's request number
*/
class Person{

    private final int queueNo;
    private final String name;
    private static int COUNT = 1;

    /*
    Persons are created with a number via a internal counter Person.COUNT
    */
    public Person(String name) {
        this.name = name;
        this.queueNo = Person.COUNT;
        Person.COUNT++;

    }

    //pre-cond: input is another person
    //post-cond: output is the wait time between the two people
    //in terms of number of requests in between
    public double  queueDiff(Person other) {
        return Math.abs(this.queueNo  - other.queueNo);
    }

    public String name() {
        return this.name;
    }
}
