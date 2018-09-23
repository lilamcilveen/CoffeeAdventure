public class Coffee extends Thing{

    public Coffee(){ //Constructor
        super("Coffee"); 
    }

    public String getName(){return name;} // Returns the Items name

    public String infoline()
    {
        return " > You see delicious COFFEE being brewed from behind the starbucks counter";} //When the item is looked at when looking around the room this function is called

    public String invLine()
    {
        return " > You are carrying a hot cup of COFFEE ~ Just the thing to wake you up!";} //When the item is looked at when opening the inventory this function is called

    public void interact(Human user)
    {
        System.out.println("You will have to talk to the Starbucks(c) cashier to get a cup of COFFEE");    
    } // When the item is used from the room this function is called


    public void useItem(Human user){
        user.addEnergy(10);
        user.removefromInv(this); 
    } //When item is used from inventory this function is called
}
