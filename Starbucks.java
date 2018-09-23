import java.util.Scanner;

public class Starbucks extends Player{

    Scanner in = new Scanner(System.in);
    //Constructor
    public Starbucks(){
        super("Starbucks");
        this.setStationary(true);//Used to make sure it doesn't move
    }

    //Infoline needed to explain The NPC to the player when lookign around
    public String infoline(){
        return " > You see a Starbucks(c), known for there good yet expensive COFFEE.";
    }

    //Interact functionality used when beign called by the human from the room
    public void play(Human p){
        String response;
        if(p.getMoney() < 5){ // Error for if they dont have the money
            System.out.println(" > You don't have enough MUNNIES for coffee, it's $5 a cup.");
        }
        else if(location.getNumThings() == 0){ // Error for if there is no coffee remaining
            System.out.println(" > The Starbucks claims to be out of coffee.");
        }
        else{
            do{ //Normal protocal
                System.out.println("You currently have " + p.getMoney() +  " MUNNIES. Do you want coffee for $5? (y/n)");
                response = in.nextLine();
                if(response.equals("y")){
                    p.subtractMoney(5);
                    p.addtoInv(location.thingName("Coffee"));
                    location.removeThing(location.thingName("Coffee"));
                }
            }while (!(response.equals("y") || response.equals("n")));
        }
    }
}
