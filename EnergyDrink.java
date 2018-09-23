public class EnergyDrink extends Thing {

  //constructor
    public EnergyDrink() {
        super("Energy Drink");
    }


    public String getName() {
        return name;
    }

    public String infoline() {// this is what you see in the room 
        return " > You see a vending machine that has an ENERGY DRINK in it.";
    }

    public String invLine() {//this is what is in inventory for this thing 
        return " > You are holding a Monster ENERGY DRINK: To drink press ";
    }

    public void interact(Human user) {//interaction with human 
        if (user.getMoney() < 2) {//if human has less than 2 dollars 
            System.out.println(" > You cannot afford this ENERGY DRINK.");
        }

        else
            user.subtractMoney(2); //if they have 2dollars 
        System.out.println(" > You have purchased an ENERGY DRINK.");
        location.removeThing(this);//removes this from Thing 
        user.addtoInv(this);//add to our inventory

    }


    public void useItem(Human user) {

        user.addEnergy(10);//after consuming 
        user.removefromInv(this);//remove from inventory
        System.out.println(" > I FEEL PUMPED!");
    }
}
