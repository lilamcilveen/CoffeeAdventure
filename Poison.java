public class Poison extends Thing{

    public Poison(){
        super("Poison");
    }


    public String getName(){return name;
    }

    public String infoline()
    {
        return " > You notice a ERLENMEYER FLASK filled with a STRANGE SUBSTANCE sitting on the ground.";
    }


    public String invLine()
    {
        return " > You are holding an ERLENMEYER FLASK filled with a STRANGE SUBSTANCE: To drink press ";
    }

    public void interact(Human p) {
        System.out.println(" > You picked up the FLASK filled with the STRANGE SUBSTANCE.");
        p.addtoInv(this);
        p.getRoom().removeThing(p.getRoom().thingName("Poison"));
    }


    public void useItem(Human user){
        System.out.println(" > You chug down the STRANGE SUBSTANCE.");

        double num = Math.random();
        if(0.5 < num)
        {
            System.out.println(" > WOAH you just got 10 energy points!");
            user.addEnergy(10);
        }
        else {
            System.out.println(" > WOAH you just lost 10 energy points!");
            user.subtractEnergy(10);
        }


    }
}