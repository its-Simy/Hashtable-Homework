import java.io.*;

public class Main {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("info.txt"));
            String line = reader.readLine();
            String name = "";
            int score = 0;
            while(line != null) {
                //if the line is a Name, then it should, cast that as the name
                    name = line;
                    line = reader.readLine();
                    score = Integer.parseInt(line);
                    Player player = new Player(name, score);
                    hashTable.add(player);
                    line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n The following are the players inside of the hashtable \n");
        hashTable.show();


        HashTable hashTable2 = new HashTable(hashTable);
        System.out.println("\nThe following are the players inside of the copied hashtable using copy constructor:\n");
        hashTable2.show();

        System.out.println("\nThis is the deep copy of the hashtable before modification:\n");
        HashTable hashTable3 = new HashTable(hashTable2.createClone());
        hashTable3.show();


        Player player2 = new Player("John Smith", 1);
        hashTable3.add(player2);
        System.out.println("\nThis is the deep copy of the hashtable after modification:\n");
        hashTable3.show();

        System.out.println("\nThis is the original hashtable that was copied:\n");
        hashTable2.show();


        System.out.println("\nThis is the demonstration of the clone method:\n");

        System.out.println("\nThis is the original hashtable before modification:\n");
        hashTable2.show();

        HashTable hashTable4 = new HashTable();
        hashTable4 = hashTable2.createClone();

        System.out.println("\nThis is the deep copy using the clone method:\n");
        hashTable4.show();


        System.out.println("\nThis is the original hashtable after modification:\n");
        hashTable2.add(player2);
        hashTable2.show();

        System.out.println("\nThis is the clone hashtable after original got modified:\n");
        hashTable4.show();


        String playerName = "Matthew Sanders";
        System.out.println("\nThe following demostrates the Find method for the player " + playerName + ":\n");
        System.out.println(playerName + "'s score: " + hashTable.find(playerName).getScore());



    }//end of the main method

}//end of the main class
