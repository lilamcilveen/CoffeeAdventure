import java.util.Scanner;

public class Friend extends Player{

    Scanner in = new Scanner(System.in);

    public Friend(){
        super("Friend");
    }

    public String infoline(){
        return " > Your FRIEND waves to you!";
    }

    public void play(Human p){
        String response;
        Boolean test = true;

        System.out.println("She offers to hand in the assignment in return for 5 MUNNIES");

        for(int i=0; i < p.getInv().size(); i++){
            if(p.getInv().get(i).getName().equals("Assignment")){
                if(p.getMoney() < 5){
                    System.out.println(" > You do not have enough MUNNIES to pay your friend to hand in your assignment.");
                }
                else{
                    do{
                        System.out.println(" > You currently have " + p.getMoney() + " MUNNIES. Do you want to pay your friend 5 MUNNIES to hand in your assignment? (y/n)");
                        response = in.nextLine();
                        if(response.equals("y")){
                            p.subtractMoney(5);
                            Thing temp = p.invName("Assignment");
                            p.removefromInv(temp);
                            location.removeThing(temp);
                            System.out.println(" > Your friend has just handed in the assignment!");
                            System.out.println("The game is over!");
                            p.setgameState(2);
                            }
                        else if(response.equals("n")){
                            continue;
                        }
                    }while(!(response.equals("y") || response.equals("n")));
                }
                test = false;
            }else{
                System.out.println(" > You do not have the assignment ready to give to your friend.");
            }
        }
        if(test) {

        }
    }
}