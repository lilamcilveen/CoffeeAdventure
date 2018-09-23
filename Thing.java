/*
  Things (food/drink items) the player will be able to pick up to restore "energy"
  >REMOVE DATA ID
*/



public abstract class Thing{

    public String name;
    public Room location;
    public World world;

    public Thing(String tempName){
        name = tempName;
    }

    //*removeThing method

    public void setWorld(World newWorld){world = newWorld;}
    public void setRoom(Room newRoom){location = newRoom;}
    public String getName(){return name;}

    public abstract String infoline(); //When the item is looked at when looking around the room this function is called
    public abstract String invLine(); //When the item is looked at when opening the inventory this function is called
    public abstract void interact(Human user); // When the item is used from the room this function is called
    public abstract void useItem(Human user); //When item is used from inventory this function is called
}
