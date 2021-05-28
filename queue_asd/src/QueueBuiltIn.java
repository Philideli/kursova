import java.util.*;

public class QueueBuiltIn<User> implements testQueues<User>{
    private Integer id;
    private String name;
    Queue<User> queue = new LinkedList<>();
    private User admin;
    private boolean changeable;

    public QueueBuiltIn(String name, User admin, Integer id) {
        this.name = name;
        this.admin = admin;
        changeable = true;
        this.id = id;
    }

    @Override
    public void addPerson(User user){
        if (changeable)
            queue.offer(user);
    }

    @Override
    public void deletePerson(User user){
        if (changeable)
            queue.remove(user);
    }

    @Override
    public boolean isInQueue(User user){
        return  queue.contains(user);
    }

    @Override
    public void nextPerson(){
        queue.poll();
    }

    @Override
    public Integer numberInQueue(User user){
        int number = 1;
        for (User items:queue){
            if (items.equals(user))
                return number;
            number++;
        }
        return number;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public QueueBuiltIn<User> getQueue() {
        return this;
    }

    public User getAdmin() {
        return admin;
    }

    public boolean isAdmin(User user){
        return admin.equals(user);
    };

    public boolean isChangeable() {
        return changeable;
    }

    public void setChangeable() {
        this.changeable = !this.isChangeable();
    }

    public String printChangeable(){
        if(this.isChangeable())
            return "Muttable";
        else
            return "Immutable";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueBuiltIn<?> that = (QueueBuiltIn<?>) o;
        return changeable == that.changeable && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(queue, that.queue) && Objects.equals(admin, that.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, queue, admin, changeable);
    }
}
