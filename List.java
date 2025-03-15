public class List {
//Add the necessary data members
    private Node head;
    private int size;


    /**
     * Default Constructor
     */
    public List(){
        head = null;
        size = 0;
    }

    /**
     *Copy Constructor
     */
    public List(List list){

    }

    /**
     *A clone class that returns the clone of the current instance
     * it will call the copy constructor using the current list
     * then will return the new list that was made.
     */
    private List createClone(){ return new List(List.this); }

    /**
     * This should all a player to the linked list
     */
    public void add(Player p){
        if(head == null)
            head = new Node(p);
        else{
            Node temp = head;
            head = new Node(p);
            head.next = temp;
        }

    }

    /**
     *This will return the player with the same name as the one in the signature
     */
    public Player find(String name){
        Node iteration = head;
        for(int i = 0; i < size; i++){
            if(iteration.getPlayer().getName().equals(name))
                break;

            iteration = iteration.next;
        }
        return iteration.getPlayer();
    }




}
