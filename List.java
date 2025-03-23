/**
 * This is the class that contains the linked lists used for the buckets for separate chaining
 */
public class List {
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
     * Should make a deep copy of the instance list
     */
    public List(List list){
        head = null;
        size = 0;
        if(list.head == null)
            return;

        Node tracker = list.head;
        while(tracker != null){

            Player copied_Player = tracker.player.createClone();

            this.add(copied_Player);
            tracker = tracker.next;
        }
    }

    /**
     *A clone class that returns the clone of the current instance
     * it will call the copy constructor using the current list
     * then will return the new list that was made.
     */
    public List createClone(){ return new List(List.this); }

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
        size++;
    }

    /**
     *This will return the player with the same name as the one in the signature
     */
    public Player find(String name){
        Player finder = new Player(name,5);//creates temporary player that will be used to find hashcode

        int code = finder.hashCode();//hashcode of the player we are trying to find


        Node iteration = head;
        if(iteration == null)
            return null;
        for(int i = 0; i < size; i++){
            //if the players name is equal to the name that is being looked for
            // then stop the loop, and return that player
            if(iteration.getPlayer().hashCode() == code)
                break;

            iteration = iteration.next;
        }

        return iteration.getPlayer();
    }

    /**
     *Will return the size of the linked list
     */
    public int getSize(){
        return size;
    }

    public void printList(){
        Node iteration = head;
        for(int i = 0; i < size; i++){
            System.out.println(iteration.getPlayer().getName() + "'s score is " + iteration.player.getScore());
            iteration = iteration.next;
        }

    }

    /**This will remove the head of the list
     *and change the head to the next player only if there is one
     * if not then it returns null
     */
    public Player remove(){
        if(head == null)
            return null;

        Node temp = head;
        head = head.next;

        return temp.getPlayer();
    }//end of the remove method



}//end of the list class
