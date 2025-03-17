public class Main {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable();
        Player player1 = new Player();
        Player player2 = new Player("Juan", 1000);
        Player player3 = new Player("Oscar", 50);
        hashTable.add(player1);
        hashTable.add(player2);
        hashTable.add(player3);


        hashTable.show();

    }//end of the main method

}//end of the main class
