/**
 * This class will create the node objects of type player for the linked list
 */
public class Node {
    Player player;
    Node next;// pointer to the next element

    /**
     * Instantiates the node with the player data
     */
    public Node(Player p) { this.player = p;}

    /**
     * This is a getter that returns the player information
     */
    public Player getPlayer() {
        return player;
    }

}
