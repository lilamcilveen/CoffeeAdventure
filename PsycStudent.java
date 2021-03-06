import java.util.Scanner;

public class PsycStudent extends Player {

    public PsycStudent() {
        super("Psychology Student");
    }


    @Override
    //this tells you what you see
    public String infoline() {
        return " > You notice a PSYCHOLOGY STUDENT surveying the room. He needs help ~ Offering 10 MUNNIES in reward!";
    }
//all the actions this player can do 
    public void play(Human p) {

        Scanner sc = new Scanner(System.in);
        String input;

        if (p.getEnergy() < 5) {//if you have less than 5 energies 
            System.out.println("You do not have enough ENERGY to interact with the student. You need more ENERGY!");
        } else {
            do {//if you have more that 5 energies or just 5 energies it lets you communicate with the comp-player
                System.out.println("You decide to walk up to the student.");
                System.out.println(" > It costs 5 ENERGY to help the student.");
                System.out.println("Give 5 ENERGY to earn 10 MUNNIES? (y/n)");
                input = sc.next();
                if (input.equals("y")) {//if you choose yes
                    p.subtractEnergy(5);//subtracts 5 energy points
                    p.addMoney(10);//adds 10 dollars
                    System.out.println(" > YAY! You now have " + p.getMoney() + " MUNNIES");
                }
                else if (input.equals("n")) {//if you choose no



                    if (p.getMoney() <= 5) {//will check if you have 5 dollars or less 
                        System.out.println(" > Uh oh... You've pissed him off!");
                        System.out.println(" > The psychology student steals your remaining " + p.getMoney() + " MUNNIES");
                        p.subtractMoney(p.getMoney());//takes all your money

                    }
                    else {
                        System.out.println(" > Uh oh... You've pissed him off! He steals 5 MUNNIES from your wallet");
                        System.out.println(" > You have " + p.getMoney() + " MUNNIES remaining");
                        p.subtractMoney(5);//subtracts 5 dollars from you
                    }
                }
            } while (!(input.equals("y") || input.equals("n"))); //does the fuction as long as the input is not y or n
        }
    }
}
