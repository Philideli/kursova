import java.util.LinkedList;

public class Main {

    static LinkedList<User> users = new LinkedList<User>();

    public static void main(String args[]){
        createUsers();
        testForQueueOnArray();
        testForQueueOnLinkedList();
        testForQueueBuiltIn();
    }

    public static void createUsers(){
        for (int i=0;i<20000;i++){
            users.add(new User("User" + i, "u" + i + "ser", i));
        }
    }

    public static void testForQueueOnArray(){
        QueueOnArray queue = new QueueOnArray("queueOnArray", users.element(), 1);

        System.out.println("--------------Queue on Array test-------------");
        long start = System.nanoTime();
        for (int i=0;i<20000;i++){
            queue.addPerson(users.get(i));
        }
        long end = System.nanoTime();
        System.out.println("addTest  | " + (end - start)/1000000 +" мс/20 000");

        start = System.nanoTime();
        for (int i=0;i<20000;i++){
            queue.isInQueue(users.get(i));
        }
        end = System.nanoTime();
        System.out.println("findTest  | " + (end - start)/1000000 +" мс/20 000");

        start = System.nanoTime();
        for (int i=0;i<20000;i++){
            queue.nextPerson();
        }
        end = System.nanoTime();
        System.out.println("nextTest  | " + (end - start)/1000000 +" мс/20 000");

        for (int i=0;i<20000;i++){
            queue.addPerson(users.get(i));
        }

        start = System.nanoTime();
        for (int i=0;i<20000;i++){
            queue.deletePerson(users.get(i));
        }
        end = System.nanoTime();
        System.out.println("deleteTest  | " + (end - start)/1000000 +" мс/20 000");

    }

    public static void testForQueueOnLinkedList(){
        QueueOnLinkedList queue = new QueueOnLinkedList("queueOnLinkedList", users.element(), 1);

        System.out.println("--------------Queue on Linked list test-------------");
        long start = System.nanoTime();
        for (int i=0;i<20000;i++){
            queue.addPerson(users.get(i));
        }
        long end = System.nanoTime();
        System.out.println("addTest  | " + (end - start)/1000000 +" мс/20 000");

        start = System.nanoTime();
        for (int i=0;i<20000;i++){
            queue.isInQueue(users.get(i));
        }
        end = System.nanoTime();
        System.out.println("findTest  | " + (end - start)/1000000 +" мс/20 000");

        start = System.nanoTime();
        for (int i=0;i<20000;i++){
            queue.nextPerson();
        }
        end = System.nanoTime();
        System.out.println("nextTest  | " + (end - start)/1000000 +" мс/20 000");

        for (int i=0;i<20000;i++){
            queue.addPerson(users.get(i));
        }

        start = System.nanoTime();
        for (int i=0;i<20000;i++){
            queue.deletePerson(users.get(i));
        }
        end = System.nanoTime();
        System.out.println("deleteTest  | " + (end - start)/1000000 +" мс/20 000");
    }

    public static void testForQueueBuiltIn(){
        QueueBuiltIn queue = new QueueBuiltIn("queueBuiltIn", users.element(), 1);

        System.out.println("--------------Built in queue test-------------");
        long start = System.nanoTime();
        for (int i=0;i<20000;i++){
            queue.addPerson(users.get(i));
        }
        long end = System.nanoTime();
        System.out.println("addTest  | " + (end - start)/1000000 +" мс/20 000");

        start = System.nanoTime();
        for (int i=0;i<20000;i++){
            queue.isInQueue(users.get(i));
        }
        end = System.nanoTime();
        System.out.println("findTest  | " + (end - start)/1000000 +" мс/20 000");

        start = System.nanoTime();
        for (int i=0;i<20000;i++){
            queue.nextPerson();
        }
        end = System.nanoTime();
        System.out.println("nextTest  | " + (end - start)/1000000 +" мс/20 000");

        for (int i=0;i<20000;i++){
            queue.addPerson(users.get(i));
        }

        start = System.nanoTime();
        for (int i=0;i<20000;i++){
            queue.deletePerson(users.get(i));
        }
        end = System.nanoTime();
        System.out.println("deleteTest  | " + (end - start)/1000000 +" мс/20 000");
    }

}
