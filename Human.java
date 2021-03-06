//HUMAN CLASS

//Importing Necessary Libraries
import java.util.LinkedList;
import java.util.Scanner;
import static java.lang.System.in;

public class Human extends Player {
    int energy;
    int money;
    int gameState;
    Coffee coffee = new Coffee();
    
    //Constructer
    public Human(String name) {
        super(name);
        energy = 10;
        money = 5;
    }


    /************************
     ****INVENTORY METHODS****
     ************************/

    private LinkedList<Thing> inventory = new LinkedList<>();

    public void addtoInv(Thing toAdd) {

        inventory.add(toAdd);
    }

    public void removefromInv(Thing toRemove) {
        inventory.remove(toRemove);
    }

    public void useItem(Thing toUse) {
        toUse.useItem(this);
    }

    public LinkedList<Thing> getInv() {
        return inventory;
    }

    public void printInv() {
        System.out.println("Your Inventory contains: ");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).invLine() + " " + i);
        }
        System.out.println("You have " + getMoney() + " MUNNIES remaining");
    }
    //Returns the thing with the given name if it is in the inventory
    public Thing invName(String temp) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(temp)) {
                return inventory.get(i);
            }
        }
        return null;
    }


    /******************************
     //****GETTER/SETTER METHODS****
     ******************************/

    //Energy Control Methods
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void addEnergy(int add) {
        energy += add;
    }

    public void subtractEnergy(int subtract) {
        energy -= subtract;
    }
    
    //Money Control Methods
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int add) {
        money += add;
    }

    public void subtractMoney(int subtract) {
        money -= subtract;
    }


    /*Encompasses the possible plays a human can make in a turn
     */
    public void play(Human user) {
        //Shows the user there current status/what is around them
        System.out.println("You have " + this.getEnergy() + " ENERGY remaining");
        this.look(); 
        
        Scanner in = new Scanner(System.in);
        //Determining the players preferred action
        System.out.println();
        System.out.println("What would you like to do? [type h <enter> for help] ");
        System.out.println();

        String action = in.nextLine();

        //PRINT HELP MENU
        if (action.trim().equals("h")) {
            help();
        }

        //DESCRIBES THE PLAYER'S SURROUNDINGS
        if (action.trim().equals("l")) {
            look();
       }

        //PLAYER MOVEMENT - G to prompt movement
        if (action.trim().charAt(0) == 'g') {
            String wallCheck = this.getRoom().getName();

            switch (action.trim().charAt(action.trim().length() - 1)) {
                //North
                case 'n':
                    this.move(0);
                    break;
                //East
                case 'e':
                    this.move(1);
                    break;
                //South
                case 's':
                    this.move(2);
                    break;
                //West
                case 'w':
                    this.move(3);
                    break;
                default:
                    System.out.println("That is not a valid direction");
                    break;
            }
            //Notifies player when they hit a wall
            if (wallCheck.equals(this.getRoom().getName())) {
                System.out.println("You bumped into a wall, you can't go that direction");
            }
            System.out.println("Coordinate: " + location.getCol() + " " + location.getRow());

            this.subtractEnergy(1); //The player loses an energy whenever they move rooms

        }

        //INTERACT WITH A PLAYER IN THE ROOM
        if (action.trim().charAt(0) == 'i') {

            try { 
                int number = Integer.parseInt(String.valueOf(action.trim().charAt((action.trim().length() - 1))));

                if (number <= location.getNumPlayers() && number > 0) {
                    LinkedList<Player> temp = location.getPlayers();
                    temp.remove(this);  //removes player
                    if (!temp.get(number - 1).equals(this)) {
                        temp.get(number - 1).play(this);
                    } else {
                        System.out.println("There are not that many players in this room!");
                    }
                }//Bug test for self interaction
                else {
                    action = "h";
                }
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT! You did not successfully interact.");
            }
            System.out.println();
        }

        //INTERACT WITH A THING IN THE ROOM
        if (action.trim().charAt(0) == 't') {
            try {
                int number = Integer.parseInt(String.valueOf(action.trim().charAt(action.trim().length() - 1)));
                if (number <= location.getNumThings() && number > 0) {
                    LinkedList<Thing> temp = location.getThings();
                    temp.get(number - 1).interact(this);
                }//Bug test for self interaction
                else {
                    System.out.println("There are not that many things in this room!");
                }
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT! You did not successfully interact.");
            }

            System.out.println();

        }
        //Accessing your inventory
        if (action.trim().charAt(0) == 'b') {
            this.printInv();
            System.out.println("Type the number of the item you want to use:");
            System.out.println("To exit type 'x'");
            String item = in.nextLine();

            if (!item.equals("x")) {

                try {
                    if (Integer.parseInt(item) >= 0 && Integer.parseInt(item) < inventory.size()) {
                        inventory.get(Integer.parseInt(item)).useItem(this);
                    } else {
                        System.out.println("You do not have the specified item in your inventory.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("INVALID INPUT! Type 'b' to open inventory again.");
                }
            }
        }

        if (action.trim().charAt(0) == 's') {
            location.addplayer(this);
            world.printFile();  //save game
            setgameState(3);    //
        }

        if (this.getEnergy() <= 0) {
            gameState = 1;
        } //If the player is out of energy, the game will end
     
    }
        
//Functions relating to the games endings
    public void setgameState(int newState) {
        gameState = newState;
    }

    public int getGameState() {
        return gameState;
    }

    //Displays surroundings in rooms and how to interact with them
    public void look() {
        String s = "You are currently in ";
        s += this.getRoom().getName();
        System.out.println(s);
        LinkedList<Player> temp = location.getPlayers();
        temp.remove(this);
        for (int i = 0; i < location.getNumPlayers(); i++) {
            if (!temp.get(i).equals(this)) {
                System.out.println(temp.get(i).infoline() + "(To Interact type 'i," + (i + 1) + "')");
            }
        }
        LinkedList<Thing> temp2 = location.getThings();
        for (int j = 0; j < location.getNumThings(); j++) {
            System.out.println(temp2.get(j).infoline() + "(To Interact type 't," + (j + 1) + "')");
        }
    }
//Display list of possible commans
    public void help() {
        String s = "Your options are:\n ";
        s += "'h' for help \n ";
        s += "'l' to look around the room \n ";
        s += "'g, x' to go in direction x (x can be n,e,w,s) \n ";
        s += "'b' to open your inventory \n ";
        s += "'i, #' To interact with a listed person # (# can be 1,2,3,4) \n ";
        s += "'t, #' to interact with a listed thing \n ";
        s += "'s, #' to SAVE and QUIT \n ";
        System.out.println(s);
    }
//Display the infoline of the player
    public String infoline() {
        return "You have " + energy + " energy remaining.";
    }
//Necessary Getters
    public String getName() {
        return null;
    }

    public World getWorld() {
        return null;
    }
}
