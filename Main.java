import java.io.*;

public class Main {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable();
        /*
        Player player1 = new Player();
        Player player2 = new Player("Juan", 1000);
        Player player3 = new Player("Oscar", 50);
        Player player4 = new Player("maaz", 60);
        Player player5 = new Player("arthur", 70);
        Player player6 = new Player("alshibli", 10);
        Player player7 = new Player("aaron", 90);
        Player player8 = new Player("Jose", 20);
        Player player9 = new Player("logan", 30);
        hashTable.add(player1);
        hashTable.add(player2);
        hashTable.add(player3);
        hashTable.add(player4);
        hashTable.add(player5);
        hashTable.add(player6);
        hashTable.add(player7);
        hashTable.add(player8);
        hashTable.add(player9);

         */



        try {
            BufferedReader reader = new BufferedReader(new FileReader("info.txt"));
            String line = reader.readLine();
            String name = null;
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
        //prints out all the players in the hashtable
        hashTable.show();

        /*
        HashTable hashTable2 = new HashTable(hashTable);
        System.out.println("\n The following are the players inside of the copied hashtable using copy constructor\n");
        //hashTable2.show();

        HashTable hashTable3 = new HashTable(hashTable2.createClone());
        //Player player2 = new Player("John Smith", 1);
        //hashTable3.add(player2);
        //hashTable3.show();
        //System.out.println("This was the one that was copied\n");
        //hashTable2.show();
 */
        System.out.println(hashTable.find("Matthew Sanders"));









    }//end of the main method

}//end of the main class
