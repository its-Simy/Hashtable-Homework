/**
 * This will be a hashtable of lists that will allow for separate chaining to avoid collisions when adding players
 *
 */
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
        for(int i=0; i < numBuckets; i++){
            hashTable[i] = new List();
        }
        occubiedPlaces = 0;
    }

    /**
     * Copy Constructor
     */
    public HashTable(HashTable hash){
        this.numBuckets = hash.numBuckets;
        this.hashTable= new List[numBuckets];
        for(int i=0; i < numBuckets; i++){
            this.hashTable[i] = new List(hash.hashTable[i].createClone());
        }
        this.occubiedPlaces= hash.occubiedPlaces;
    }

    /**
     *returns a deep copy of the current instance
     */
    public HashTable createClone(){
        return new HashTable(HashTable.this);
    }

    /**
     *This method will add a player to the hash table
     * Adds a key/value pair to the map
     */
    public void add(Player p){
        //this will determine which bucket they would go in
        int placement = Math.abs(hashCode(p,numBuckets));
        occubiedPlaces++;
        double loadfactor = (double) occubiedPlaces / numBuckets;

        //if the load factor is over 75%, then it will resize
        if(loadfactor > .75){
            resize();
            placement = Math.abs(hashCode(p,numBuckets));
        }
        hashTable[placement].add(p);//adds player to the specified bucket list

    }

    /**
     *This should return the player based off of their name
     * Takes a key as a parameter and
     * searches for the key. If it is found the value
     * associated with the key is returned
     */
    public Player find(String name){
        Player p = null;
        for(int i = 0; i < numBuckets; i++){
            if(hashTable[i] != null)
                p = hashTable[i].find(name);
        }
        return p;
    }//end of find method

    /**
     * Prints all data in the hash table.
     * It should show data by bucket
     */
    public void show(){
        for(int i = 0; i < numBuckets; i++){
            hashTable[i].printList();
        }

    }//end of show method

    /**
     * This will resize the current hash table by creating a new one
     * along with rehashing all the current players inside the hashtable into the new bucket array
     * Lastly, it will set the new array made into the one for this hashtable,
     * along with setting a new value to num buckets.
     */
    private void resize(){
        List[] newHashTable= new List[numBuckets * 2];//creates new hashtable with double the size
        int replacementBuckets= newHashTable.length;//creates a new number of buckets for the new rehashing
        for(int i=0; i < replacementBuckets; i++){
            newHashTable[i] = new List();
        }

        occubiedPlaces= 0;

        for(int i = 0; i < numBuckets; i++){

            Player p = hashTable[i].remove();
            while(p != null) {
                int placement = Math.abs(hashCode(p, numBuckets));
                occubiedPlaces++;

                newHashTable[placement].add(p);
                p = hashTable[i].remove();
            }

        }
        this.numBuckets = replacementBuckets;
        this.hashTable= newHashTable;

    }//end of resize method

    /**
     *Should return the hash value in which the specific bucket the player will be placed in
     */
    private int hashCode(Player p, int numberOfBuckets){
        int hash = p.hashCode();
        return hash % numberOfBuckets;
    }//end of hash method




}//end of the hashTable class
