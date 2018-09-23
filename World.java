import java.io.*;
import java.util.LinkedList;

public class World {
    private Room[][] rooms;

    public static int numPlayers;   
    public static int numThings;
    private int col;
    private int row;
    private int totalCol, totalRow;
    private Human mainCharacter = new Human("Human Player");
    private PsycStudent psyc = new PsycStudent();
    private Starbucks starbucks = new Starbucks();
    private Friend friend = new Friend();
    private StudentCouncil sc = new StudentCouncil();
    private Player[] listP = {psyc, friend, starbucks, sc}; //Add other players Here
    private EnergyDrink drink = new EnergyDrink();
    private Assignment assignment = new Assignment();
    private Poison poison = new Poison();
    private Coffee coffee = new Coffee();
    private Thing[] listT = {drink, assignment, coffee, poison}; // Add other things here
    private int altNumPlayers;

    public World(String file) {

        System.out.println("Loading world from " + file + " ...\n");
        int i = -1;
        int number = 0;
        altNumPlayers = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {//reads file

            String tempLine = br.readLine();//reads current line
            String arrayStr[] = tempLine.split(", ");//the comma seperates each string 
            mainCharacter.setEnergy(Integer.parseInt(arrayStr[0]));
            mainCharacter.setMoney(Integer.parseInt(arrayStr[1]));
            if(arrayStr[2].equals("1")) {//boolean value of Thing(drink) is true 
                mainCharacter.addtoInv(drink);//add drink to inventory index 2
            }
            if(arrayStr[3].equals("1")) {//boolean value of Thing(assignment) is true 
                mainCharacter.addtoInv(assignment);//add assignment to inventory index 3
            }
            if(arrayStr[4].equals("1")) {//boolean value of Thing(coffee) is true
                mainCharacter.addtoInv(coffee);//add coffee to inventory index 5
            }
            if(arrayStr[5].equals("1")) {//boolean value of Thing(poison) is true
                mainCharacter.addtoInv(poison);//add poison to inventory index 5
            }



            for (String line; (line = br.readLine()) != null; i++) {//reading each line in the input file as long as it is not null
                //total number of rooms
                if (i == -1) {
                    String[] setUp = line.split(", ");
                    totalCol = Integer.parseInt(setUp[0]);
                    totalRow = Integer.parseInt(setUp[1]);
                    rooms = new Room[totalCol][totalRow];
                 // room number
                } else if (i % 5 == 0) {
                    String[] strRooms = line.split(", ");
                    number = Integer.parseInt(strRooms[0]);
                    col = Integer.parseInt(strRooms[1]);
                    row = Integer.parseInt(strRooms[2]);
                    rooms[col][row] = new Room(col, row, number, this);
                    //room name
                } else if (i % 5 == 1) {
                    rooms[col][row].setName(line.trim());
                //walls in each room
    
                } else if (i % 5 == 2) {
                    String[] strWalls = line.split(", ");
                    int[] temp = {Integer.parseInt(strWalls[0]), Integer.parseInt(strWalls[1]), Integer.parseInt(strWalls[2]), Integer.parseInt(strWalls[3])};
                    rooms[col][row].setWalls(temp);
                    //players in each room 
                } else if (i % 5 == 3) {
                    String[] players = line.split(", ");//seperate each player by comma
                    World.numPlayers = players.length;
                    for (int j = 0; j < players.length; j++) {
                      if (Integer.parseInt(players[j]) == 1) {
            
                            if (j == 0) {
                                rooms[col][row].addplayer(mainCharacter);
                                mainCharacter.setRoom(rooms[col][row]);
                                mainCharacter.setWorld(this);
                            } else {
                                rooms[col][row].addplayer(listP[j - 1]);
                                listP[j - 1].setRoom(rooms[col][row]);
                                listP[j - 1].setWorld(this);

                            }

                            altNumPlayers++;
                            //System.out.println(altNumPlayers);
                }

                   }
                    //things in each room
                } else if (i % 5 == 4) {
                    String[] things = line.split(", ");
                    World.numThings = things.length;
                    for (int j = 0; j < things.length; j++) {
                        if (Integer.parseInt(things[j]) == 1) {
                            rooms[col][row].addThing(listT[j]);
                            listT[j].setRoom(rooms[col][row]);
                            listT[j].setWorld(this);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + file + " was not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Room getRoom(int col, int row) {
        return rooms[col][row];
    }

    public void playTurn() {

        if(altNumPlayers > 3) {
            for (int i = 0; i < listP.length; i++) {//goes through list of players 
                if (!listP[i].getStationary()) {//if its a player that doesnt move 
                    listP[i].move((int) (Math.random() * 4));//place them randomly in any room 
                }
            }
        }

        mainCharacter.play(mainCharacter);
    }

    public Human getHuman() {
        return mainCharacter;

    }


    public void printFile() {
        try(PrintWriter writer  = new PrintWriter("save.txt")) {
            String z = ""; //Next chunk Prints out the first line involving Players energy, money, and things in inventory
            LinkedList<Thing> playerStatus = mainCharacter.getInv();
            z += mainCharacter.getEnergy() + ", ";
            z+= mainCharacter.getMoney() + ", ";
            if(playerStatus.contains(drink)) {
                z += "1, ";
            }
            else {
                z+= "0, ";
            }
            if(playerStatus.contains(assignment)) {
                z += "1, ";
            }
            else {
                z+= "0, ";
            }
            if(playerStatus.contains(coffee)) {
                z += "1, ";
            }
            else {
                z+= "0, ";
            }
            if(playerStatus.contains(poison)) {
                z += "1";
            }
            else {
                z+= "0";
            }
            writer.println(z);
            writer.println(totalCol*totalRow + ", " + totalCol + ", " + totalRow);
            for (int j = 0; j < totalRow; j++) { //Goes through each room 
                for (int i = 0; i < totalCol; i++) {
                    String s = "";
                    s += (1 + i + j * 3); //Printing Room Number and Room Col/Row
                    s += ", ";
                    s += i;
                    s += ", ";
                    s += j;
                    writer.println(s); //Printing Name 
                    s = rooms[i][j].getName();
                    writer.println(s);
                    int[] w = rooms[i][j].getWalls(); //Printing Walls
                    s = "";
                    s += w[0];
                    s += ", ";
                    s += w[1];
                    s += ", ";
                    s += w[2];
                    s += ", ";
                    s += w[3];
                    writer.println(s);
                    LinkedList<Player> p = rooms[i][j].getPlayers();//Printing Characters in rooms
                    s = "";
                    if (p.contains(mainCharacter)) {
                        s += "1, ";
                    } else {
                        s += "0, ";
                    }
                    if (p.contains(psyc)) {
                        s += "1, ";
                    } else {
                        s += "0, ";
                    }
                    if (p.contains(friend)) {
                        s += "1, ";
                    } else {
                        s += "0, ";
                    }
                    if (p.contains(starbucks)) {
                        s += "1, ";
                    } else {
                        s += "0, ";
                    }
                    if (p.contains(sc)) {
                        s += "1";
                    } else {
                        s += "0";
                    }
                    writer.println(s);
                    LinkedList<Thing> t = rooms[i][j].getThings(); //Printing Things in each room 
                    s = "";
                    if (p.contains(drink)) {
                        s += "1, ";
                    } else {
                        s += "0, ";
                    }
                    if (p.contains(assignment)) {
                        s += "1, ";
                    } else {
                        s += "0, ";
                    }
                    if (p.contains(coffee)) {
                        s += "1, ";
                    } else {
                        s += "0, ";
                    }
                    if (p.contains(poison)) {
                        s += "1";
                    } else {
                        s += "0";
                    }
                    writer.println(s);
                }
            }
            writer.close();
        } catch(FileNotFoundException e){ //Error For file missing
            System.out.println("save failed");
        }
    }
}
