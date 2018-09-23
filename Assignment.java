import java.util.Scanner;

public class Assignment extends Thing{



    public Assignment(){
        super("Assignment");
    }

    public String infoline(){
        return " > Your are in the lab. You must print ASSIGNMENT to hand it in";
    }

    public String invLine(){
        return " > Your ASSIGNMENT is ready to hand in: To use press ";
    }

    public void interact(Human p){
        Scanner in = new Scanner(System.in);
        String response;
        System.out.println(" > To print your ASSIGNMENT, you must pay $2.");

        if(p.getMoney() < 2){
            System.out.println(" > You do not have enough MUNNIES" + "to print your ASSIGNMENT.");
        }

        else if(location.getNumThings() == 0){
            System.out.println(" > It looks like you have already printed your ASSIGNMENT");
        }

        else{
            do{
                System.out.println(" > You currently have " + p.getMoney() + " MUNNIES. Print ASSIGNMENT for 2 MUNNIES? (y/n)");
                response = in.nextLine();
                if(response.equals("y")){
                    p.subtractMoney(2);
                    p.addtoInv(location.getThing(0));
                    location.removeThing(location.getThing(0));
                    System.out.println(" > You have obtained ASSIGNMENT");
                }
                else {
                    System.out.println(" > You did not print your ASSIGNMENT");
                }
            }while (!(response.equals("y") || response.equals("n")));
        }
    }

    public void useItem(Human user){
        if(user.getRoom().getName().equals("Classroom")){
            user.removefromInv(this);
            System.out.println(" > You have handed in the ASSIGNMENT!");
            System.out.println("The game is over!");
            user.setgameState(2);
        }

        else if(!location.getName().equals("Classroom")){
            System.out.println(" > You cannot hand in your ASSIGNMENT here, you must hand it in the classroom.");
        }
    }
}