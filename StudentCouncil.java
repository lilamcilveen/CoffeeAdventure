import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentCouncil extends Player {



    public StudentCouncil() {
        super("Student Council");
    }

    @Override
    public String infoline() {
        return " > You see a STUDENT COUNCIL MEMBER who doing security bag searches.";
    }

    public void play(Human p) {
        Boolean test = true;

        System.out.println(" > You walk up to the student council student. They search your bag.");

        for (int i = 0; i < p.getInv().size(); i++) {
            if (p.getInv().get(i).getName().equals("Poison")) {
                System.out.println(" > The student council spots an illegal STRANGE SUBSTANCE in your bag. All you items have been confiscated.");
                p.getInv().clear();
                test = false;
            }
        }
        if(test) {
            System.out.println(" > 'THANKS FOR PARTICIPATING' Your bag is clean. You are rewarded with 2 MUNNIES!");
            p.addMoney(2);
        }
    }
}
