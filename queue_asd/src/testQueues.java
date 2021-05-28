public interface testQueues<User> {
    public void addPerson(User user);           //adds user as the tail of the queue
    public void deletePerson(User user);        //removes user from queue
    public boolean isInQueue(User user);        //returns true if this queue contains the user
    public void nextPerson();                   //removes the head of the queue
    public Integer numberInQueue(User user);    //returns index of user in this queue
}
