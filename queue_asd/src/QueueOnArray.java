import java.util.Arrays;
import java.util.Objects;

public class QueueOnArray<User> implements testQueues<User>{
    private Integer id;
    private String name;
    private User admin;
    private boolean changeable;

    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private int pointer = -1;
    private Object[] queue = new Object[INIT_SIZE];

    public QueueOnArray(String name, User admin, Integer id) {
        this.name = name;
        this.admin = admin;
        changeable = true;
        this.id = id;
    }


    @Override
    public void addPerson(User user) {
        if (changeable)
            this.offer(user);
    }

    @Override
    public void deletePerson(User user) {
        if (changeable)
            this.remove(user);
    }

    @Override
    public boolean isInQueue(User user) {
        return this.contains(user);
    }

    @Override
    public void nextPerson() {
        this.poll();
    }

    @Override
    public Integer numberInQueue(User user) {
        int index = -1;
        for (int i = 0; i <= pointer; i++){
            if (queue[i] == user){
                return i;
            }
        }
        return index;
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

    public QueueOnArray<User> getQueue() {
        return this;
    }

    public User getAdmin() {
        return this.admin;
    }

    public boolean isAdmin(User user){
        return admin.equals(user);
    }

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
        QueueOnArray that = (QueueOnArray) o;
        return changeable == that.changeable && INIT_SIZE == that.INIT_SIZE && CUT_RATE == that.CUT_RATE && pointer == that.pointer && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(admin, that.admin) && Arrays.equals(queue, that.queue);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, admin, changeable, INIT_SIZE, CUT_RATE, pointer);
        result = 31 * result + Arrays.hashCode(queue);
        return result;
    }

    public void offer(User user){
        if (user != null){
            if (pointer == queue.length-1){
                resize(queue.length*2);
            }
            pointer++;
            queue[pointer] = user;
        }
    }

    public void poll(){
        for (int i = 0; i < pointer; i++){
            queue[i] = queue[i+1];
        }
        queue[pointer] = null;
        pointer--;
        if (queue.length > INIT_SIZE && pointer < queue.length / CUT_RATE){
            resize(queue.length/2);
        }
    }

    public boolean contains(User user){
        for (int i = 0; i <= pointer; i++){
            if (queue[i] == user){
                return true;
            }
        }
        return false;
    }

    public void remove(User user){
        int index = numberInQueue(user);
        if (index == -1) return;
        for (int i = index; i < pointer; i++){
            queue[i] = queue[i+1];
        }
        queue[pointer] = null;
        pointer--;
        if (queue.length > INIT_SIZE && pointer < queue.length / CUT_RATE){
            resize(queue.length/2);
        }
    }

    private void resize(int newLength){
        Object[] newQueue = new Object[newLength];
        System.arraycopy(queue, 0, newQueue, 0, pointer);
        queue = newQueue;
    }


}
