import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Room {
    //Variables
    private LinkedList<Player> players;
    private LinkedList<Thing> things;
    private LinkedList<Integer> rooms;
    private int number;
    protected String name;
    private World world;
    private int col;
    private int row;
    private int[] walls = new int[4];

    public Room() {

    }
    //Constructor
    public Room(int newCol, int newRow, int number, World newWorld) {
        world = newWorld;
        col = newCol;
        row = newRow;
        this.number = number;
        rooms = new LinkedList<Integer>();
        players = new LinkedList<Player>();
        things = new LinkedList<Thing>();
    }
    
    public void addRoom(Integer number) {
        rooms.add(number);

    }
    //Getters for Room Details 
    public World getWorld() {
        return world;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    //Returns the identity of a thing if given its specific name & is in the room
    public Thing thingName(String temp){
        for (int i = 0; i < things.size(); i++){
            if(things.get(i).getName().equals(temp)){
                return things.get(i);
            }
        }
        return null;
    }


    //Getters/Setters
    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void setWalls(int[] wallTF) {
        walls = wallTF;
    }

    public int[] getWalls() {
        return walls;
    }

    public int getNumRooms() {
        return rooms.size();
    }

    public LinkedList<Integer> getRooms() {
        return rooms;
    }

// Functions for Accessing Player Linked List in Room

    public int getNumPlayers() {
        return players.size();
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    public void addplayer(Player toadd) {
        players.add(toadd);
    }

    public void removeplayer(Player toremove) {
        players.remove(toremove);
    }


//Functions for accessing the Things in each room

    public int getNumThings() {
        return things.size();
    }

    public LinkedList<Thing> getThings() {
        return things;
    }

    public Thing getThing(int i) {
        return things.get(i);
    }

    public void addThing(Thing toAdd) {
        things.add(toAdd);
    }

    public void removeThing(Thing toRemove) {
        things.remove(toRemove);
    }

    //Functions called by move in order to get the identity of the room located in a particular direction from this room
    public Room west() {
        if (walls[3] == 1) {
            return this;
        } else {
            return this.world.getRoom(col - 1, row);
        }
    }

    public Room east() {
        if ((walls[1]) == 1) {
            return this;
        } else {
            return this.world.getRoom(col+1, row);
        }
    }

    public Room north() {
        if (walls[0] ==1) {
            return this;
        } else {
            return this.world.getRoom(col, row-1);
        }
    }

    public Room south() {
        if (walls[2] == 1) {
            return this;
        } else {
            return this.world.getRoom(col, row+1);

        }
    }

    public void printConsole() {
        System.out.println("Room: " + number);
        System.out.println("Name: " + name);
        System.out.print("Next rooms: ");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.print(rooms.get(i));
            if (i < rooms.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.print("Players: ");
        for (int i = 0; i < players.size(); i++) {
            System.out.print(players.get(i));
            if (i < players.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.print("Things: ");
        for (int i = 0; i < things.size(); i++) {
            System.out.print(things.get(i));
            if (i < things.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }

    public void printFile(FileWriter fw) throws IOException {
        fw.write(number + "\n");
        fw.write(name + "\n");
        for (int i = 0; i < rooms.size(); i++) {
            fw.write("" + rooms.get(i));
            if (i < rooms.size() - 1) {
                fw.write(", ");
            }
        }
        fw.write("\n");
        for (int i = 0; i < World.numPlayers; i++) {
            if (players.contains(i)) {
                fw.write("1");
            } else {
                fw.write("0");
            }
            if (i < World.numPlayers - 1) {
                fw.write(", ");
            }
        }
        fw.write("\n");
        for (int i = 0; i < World.numThings; i++) {
            if (things.contains(i)) {
                fw.write("1");
            } else {
                fw.write("0");
            }
            if (i < World.numThings - 1) {
                fw.write(", ");
            }
        }

        fw.write("\n");
    }
}
