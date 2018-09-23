import java.util.LinkedList;

public abstract class Player implements Character {
    protected World world; //world player is in
    protected Room location; //location of player
    protected String name; // Name of Player
    protected boolean stationary = false; // States wether the object is stationary
    public Player(String newName) {
        this.name = newName;
    }

    public void move(int direction){
        if(direction == 0){
            this.getRoom().removeplayer(this);
            this.setRoom(this.getRoom().north());
            this.getRoom().addplayer(this);
        }
        else if(direction == 1){
            this.getRoom().removeplayer(this);
            this.setRoom(this.getRoom().east());
            this.getRoom().addplayer(this);
        }
        else if(direction == 2){
            this.getRoom().removeplayer(this);
            this.setRoom(this.getRoom().south());
            this.getRoom().addplayer(this);
        }
        else if(direction == 3){
            this.getRoom().removeplayer(this);
            this.setRoom(this.getRoom().west());
            this.getRoom().addplayer(this);
        }
    }

    public String getName() { return name; }

    public World getWorld() {
        return world;
    }

    public void setWorld(World tempWorld){
        world = tempWorld;
    }

    public Room getRoom() {
        return location;
    }

    public boolean getStationary(){
        return stationary;
    }

    public void setStationary(boolean newState){
        stationary = newState;
    }

    public void setRoom(Room newRoom) {
        this.location = newRoom;
    }

    public abstract void play(Human user); //Asks for input on what to do

    public abstract String infoline(); // Prints Line depending

}