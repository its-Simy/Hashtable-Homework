import java.util.Objects;

    /**
     * This is the Player class that are essentially the nodes for the heap implementation.
     * Each player contains their name and score.
     */
    public class Player{

        /**
         *All the data members needed
         */
        private int score;
        private String name;

        /**
         *Constructor that creates a Player object when no parameters are inputted
         */
        public Player(){
            name = "Simon";
            score = 10;
        }


        /**
         *Constructor that creates a Player object when both parameters are inputted
         */
        public Player(String _name, int _score){
            this.name = _name;
            this.score = _score;
        }

        /**
         *Creates a deep copy of the Player object
         */
        public Player(Player other){
            this.name = other.name;
            this.score = other.score;
        }

        /**
         * returns a hash code based on the name of the player
         * This will be used in order to properly place players into buckets within the hashtable
         */
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    /**
         *Returns the score of the player
         */
        public int getScore() {
            return score;
        }
        /**
         *Sets the score of the player
         */
        public void setScore(int _score) {
            score = _score;
        }
        /**
         *Returns the name of the player
         */
        public String getName() {
            return name;
        }
        /**
         *Sets the name of the player
         */
        public void setName(String _name) {
            this.name = _name;
        }


        /**
         *Creates a deep copy clone of the current instance
         * */
        public Player createClone(){
            Player clone = new Player(this);
            return clone;
        }

        /**
         *This returns if the names are equal or not
         */
        @Override
        public boolean equals(Object obj) {
            Player p = (Player) obj;
            return(this.name.equals(p.getName()));
        }

    }//end of player class

