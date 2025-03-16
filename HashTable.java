public class HashTable {
    //Add the data members
    private List[] hashTable;
    private int numBuckets;
    private int occubiedPlaces;

    /**
     * Default Constructor
     */
    public HashTable(){
        hashTable= new List[10];
        numBuckets = hashTable.length;
        occubiedPlaces = 0;
    }

    /**
     * Copy Constructor
     */
    public HashTable(HashTable hash){
        this.numBuckets = hash.numBuckets;
        this.hashTable= new List[numBuckets];
        this.occubiedPlaces= hash.occubiedPlaces;
    }

    /**
     *returns a deep copy of the current instance
     */
    private HashTable createClone(){
        return new HashTable(HashTable.this);
    }

    /**
     *This method will add a player to the hash table
     * Adds a key/value pair to the map
     */
    public void add(Player p){
        //this will determine which bucket they would go in
        int placement = hash(p);

        //if the load factor is over .75, then it will resize
        if((double) (occubiedPlaces/numBuckets) > .75){
            resize();
            //hashTable[placement]= p;
        }
        //if false, then it will insert the player into the designated bucket
        else{

        }

    }

    /**
     *This should return the player based off of their name
     * Takes a key as a parameter and
     * searches for the key. If it is found the value
     * associated with the key is returned
     */
    public Player find(String name){
        return null;
    }

    /**
     * Prints all data in the hash table.
     * It should show data by bucket
     */
    public void show(){

    }

    /**
     * This will resize the current hash table by creating a new one
     */
    private void resize(){

    }

    /**
     *Should return the hash value in which the specific bucket the player will be placed in
     */
    private int hash(Player p){
        int hash = p.hashCode();
        return hash % numBuckets;
    }






}
