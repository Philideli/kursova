import java.util.Objects;

public class QueueOnLinkedList<User> implements testQueues<User>{
    private Integer id;
    private String name;
    private Node first;
    private Node last;
    private int size = 0;

    private User admin;
    private boolean changeable;

    public QueueOnLinkedList(String name, User admin, Integer id) {
        this.name = name;
        this.admin = admin;
        changeable = true;
        this.id = id;
    }

    @Override
    public void addPerson(User user){
        if (changeable)
            this.offer(user);
    }

    @Override
    public void deletePerson(User user){
        if (changeable)
            this.remove(user);
    }

    @Override
    public boolean isInQueue(User user){
        return this.contains(user);
    }

    @Override
    public void nextPerson(){
        this.poll();
    }

    @Override
    public Integer numberInQueue(User user){
        int index = 0;
        Node node = first;
        while(node != null)
        {
            if(node.element.equals(user))
            {
                return index;
            }
            index++;
            node = node.next;
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

    public QueueOnLinkedList<User> getQueue() {
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
        QueueOnLinkedList<?> queue = (QueueOnLinkedList<?>) o;
        return size == queue.size && changeable == queue.changeable && Objects.equals(id, queue.id) && Objects.equals(name, queue.name) && Objects.equals(first, queue.first) && Objects.equals(last, queue.last) && Objects.equals(admin, queue.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, first, last, size, admin, changeable);
    }

    public void offer(User user)
    {
        Node node = new Node(user);
        if(first == null)
        {
            first = node;
            last = node;
        } else
        {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void poll()
    {
        first = first.next;
        size--;
    }

    public boolean contains(User user)
    {
        int index = 0;
        Node node = first;
        while(node != null)
        {
            if(node.element.equals(user))
            {
                return true;
            }
            index++;
            node = node.next;
        }
        return false;
    }

    public void remove(User user) {

        int index = numberInQueue(user);
        if(index == 0) {
            Node node = new Node(user);
            node.next = first.next;
            first = node;
        }else if(index == this.size)
        {
            Node prevNode = first;
            Node node = new Node(user);
            for(int i = 0 ;i < size-2;i ++){
                prevNode = prevNode.next;
            }
            prevNode.next = node;
        }else
        {
            Node node = first;
            for (int i = 0; i < index - 1; i++)
            {
                node = node.next;
            }
            node.next = node.next.next;
            size--;
        }

    }

    private static class Node<User>
    {
        User element;
        Node next = null;

        public Node(User user)
        {
            this.element = user;
        }
    }
}
