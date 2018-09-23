import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import java.util.Scanner;

public class Game {

    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        String input;

        World world;

        System.out.println("Would you like to load a save game file? (y/n)");
        input = sc.next();
        if(input.equals("y"))
        {
            world = new World("save.txt");
        }
        else {
            world = new World("input.txt");
            System.out.println("You finished your assignment after pulling an all-nighter!! You can barely stand, print out your document then get to the class.");
            System.out.println("But WATCH OUT, your really tired and cannot walk much further!");
        }


        System.out.println();
        Human mainCharacter = world.getHuman(); //*we still need a getHuman method to exist for this one to compile, not sure what it does
        int gameState = 0;
        do{
            world.playTurn();
            gameState = mainCharacter.getGameState();
        }while(gameState == 0);
        if(gameState == 1){
          
          /*
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            System.out.println("????????????????????????????????????");
            
            */
      

            System.out.println("You ran out of energy and were unable to hand in your assignment.");
            System.out.println("GAME OVER");
            
            


        }
        else if(gameState == 2){
            System.out.println("You successfully were able to hand in your assignment, congratulations!!!");
            System.out.println("                                                      `                                          ");
            System.out.println("                                         `                                                       ");
            System.out.println("                                                                                                 ");
            System.out.println("                                   ` .                                                           ");
            System.out.println("                                            .                                                    ");
            System.out.println("                             `            ` `                                                    ");
            System.out.println("                            `          `  .  .                                                   ");
            System.out.println("                                               :           ``                                    ");
            System.out.println("                              `` `      `  ` ` `                                                 ");
            System.out.println("                            `  `  .          `     `                `                            ");
            System.out.println("                     `.         ,``      `                 .       `                             ");
            System.out.println("                   .`    .       .` ,    .  `      `       `                                     ");
            System.out.println("                      ``  `      `   .      .                     :                              ");
            System.out.println("                        .           : .   `   ` .  `    .                   ``                   ");
            System.out.println("                         .         `   `  .      `      . .      .         `                     ");
            System.out.println("                                   `.` `  `     , `     ` .             ` .                      ");
            System.out.println("                       `   ,                 `` `  `.   `       .      ` `                       ");
            System.out.println("             .`  `.          ` .  .`.`` `  ` ;`     `        . `      `                          ");
            System.out.println("            .`    `          `` `    `. ,``, `           `     .     `                           ");
            System.out.println("         .     ``    ``       .,       ` ` .             `          .  `   . `  .  .             ");
            System.out.println("             ``   `    `       ```    .`  , .  `    `  `    . .       :  ..     .                ");
            System.out.println("          .     ..  `   .        .`    ,  ` .  `    .  :    .        `   :,      .               ");
            System.out.println("                   .  `  `.     `      .` `., .    `   .`    ,    `   ` .  `       `` ``         ");
            System.out.println("             .````   ` `   .     , `   .,  `` `,   `    .  `     `  .`    ``      . ,            ");
            System.out.println("                    ` ` `   ,     `.    `  . ..  `          `      ,` .  ``    `. ,              ");
            System.out.println("                      ` `    ,      `   .. ` . `   `        `   ````    `     .  `               ");
            System.out.println("               ` `      `, `  `    . `  `.  ,`     `  .   `   .` ,`    .`    .                   ");
            System.out.println("        ` ``         ` ` .` .  :`,.. ,      ``         `   ` `   ``    ` `,`` `   ``   `         ");
            System.out.println("      .       .`         ``  . .`   `.    ,,.`     `          , `, .  ..  ``.        ``..``      ");
            System.out.println("                 `         ..``  .   `.`     `.` ` .     ,`       . . . .`    .   `,             ");
            System.out.println("      ..``          ,       . `,  .    ;. `. ,`.  `. `       ` ` ` ,.  `  .  `  ,                ");
            System.out.println("  `          `        .        `, `   ` ` `, `.. ``. `.  ` `, `   `` .  `  :  :``.``  `` ` ``    ");
            System.out.println("`               `,      .       .` .   .:  `..`. `.` `  `     .  `` ,  `           .``           ");
            System.out.println("                   .`    `      ``` ,    . .``,`.`:.    ,``. ` ``.  ` . , ,    ..                ");
            System.out.println("         `` ```.``    .    .      `. `  `,````.  .``   ` `  . ``, ,` `.``.   ``        `         ");
            System.out.println("        `          `,   .    .    `.. `     ` . .,``   ,  ` `` .`     ,`  ..                     ");
            System.out.println("                  .   `. ..`  ,     `..  ,,,. . .,` .  , ` ,  `. .   .`  .        ,. `,,`` `     ");
            System.out.println("   ` ``  .,.   , `.``    ,  ,``,:, , ``. :``.,,,..,`` ,   ,      ,`   ```.`   ,  ```       . .   ");
            System.out.println(" `     ,     ` `.`     .`  ` .`..``,`:. `.:,., ..`: .., ,. `,   :`.  `.    ` .`,.``         . ,  ");
            System.out.println("            ,      ``     ` ,. .``.  ``.`. ``. ,. . ,``` `,,``  ;  .,    ,`.`      .             ");
            System.out.println("       ` ...```        `   ` ,   .     ` , .,.`,. ,  .````` ` `. ,,    ,.      . `           `   ");
            System.out.println("   ```             ```    ,    .`  ` .  `.` ..:,,`,, `.  .``,`  .,.  `.   `.`   `..``.     `,`   ");
            System.out.println(" `           ````.,    ```  `.    .`` `  ```..,,:`,,````......``  ``  .`    .` `,.`   `` ..      ");
            System.out.println("`        `       ``` ``., `.`  ,    ` ` ` `` `. . ``:.. ..  .,  `. .`  ``  ``               .  . ");
            System.out.println("      `       ``            `.`.  `  ``. ` ,`  ,. ` ..`.`.,,` . ,    `.``.`         `.       ,   ");
            System.out.println("    .`      `                   `.: .  ,`.` .,`,, ..,,``.., ,,. `....     `` . `,`..`. ,         ");
            System.out.println("   `       `          ``   .`      , .:` ., ..`.``,,,,`.``.,``````   ``` `  :           ``    `  ");
            System.out.println("  `                  ,`` .         `  `:,` `, ``:, ..:,,,,`: `  ,````.       `             .     ");
            System.out.println(" `          `  `   ,    ,     ` .,.`     `;.,...`,:`,`,:.```....`        .`   `.          ` `    ");
            System.out.println("         .        `    .        .     ```   .,,,`.,:`.,,..` ``,..,..,`.. `` . .`. `.         `   ");
            System.out.println("      ``         `            `.,,` `.``,.````,,.,;,,,..:``     ,` ,        `..`   :.  ``        ");
            System.out.println("     `           `    ` ..  ` . ,     `   ` `,.,`,,,,,:;,.```. `,. ` ,        ,  ```   .` ``     ");
            System.out.println("   .                 .  `.   `     ..,   ``:`` . :,.,:;`:.   `,`,``   .`.           `       .    ");
            System.out.println("  `              ``   ``     .`     ``,,:` ..``` ..`. : ,.  `      ,..`  ,  `  `      `    `  ,  ");
            System.out.println("               `     `  :.      .. .,.   ,:,,  ..,  ,`   ``.:  `.   .   `.:    `.    `      `    ");
            System.out.println(" `           ,     .`      ..``  ``    .:``   . .. `;.`` `  ..:,   `    .  .,`    .              ");
            System.out.println(",          `.    ``     ```    ,` .  .`` .,` ., ,,` ``,  ,`    ....  `,   `    .`   .         `  ");
            System.out.println("          .  `   `   ```,   . `    ... ,` `     ``,`,,.`: `     . ,`..     ..     ``           ` ");
            System.out.println("         , `      `` .    .  `    ,```` ``  `. `, ,. ``.`` ``    ` `` `   ` `        ` `       ` ");
            System.out.println("        , .     `  ,    .  .    :,,  , .`      ``.,` ..`.    `    `. ``` .  ,        ` `         ");
            System.out.println("       ` ,       .    `   :     .` `` `.`   `  .``,.  ` `,  .      .``, `` . ..       ` `        ");
            System.out.println("            .`  .   .    `   . `` ``  .`  `   `.``.   `,`.. .   `   . ``  ` `` ,       . ,       ");
            System.out.println("            . `            ``.  `    ` ` . `   `  `.   . `.` `   `     ``   ``.           .      ");
            System.out.println("     ,   ` ` .   ,         . ` ``   ,     `  ` `   `   .  ` . `   ,  ,  `.    ` `       .  ,     ");
            System.out.println("            `   .      ` `` . ``        ` `   `   `    `` .` ` `   ` `         ` `               ");
            System.out.println("    .      .           . . . ``    .  `  `    .`  ,     ` .`,        `          ` .         `    ");
            System.out.println("          .   `       ` ` , `.   `     ` `  ` .     `   `:`.. . .     `    ,     `               ");
            System.out.println("         ,   ,        ` .` `    ` .   . `   .  `` .`,   ..`  ` ` .    ,`   ``                    ");
            System.out.println("    `       `       `. `  `    `     `         `    .       ,,.       .      `       .           ");
            System.out.println("        .   `      `.   ``,   ,  `   ` `      ` , ` .    `,     `           .       ` .          ");
            System.out.println("   `    `         `,  , `.   `   .  `      ` ,``. `.     `` .  .   `      ` ` `      ,`          ");
            System.out.println("                  .    ..   `         .      `     ,     ` ` `            .                      ");
            System.out.println("                ..   `,    .    `         `        ,       , `      `      .   `       `         ");
            System.out.println("               `.     .   `     : `  ,    .  ``    `       ` `  .`          `   `                ");
            System.out.println("                                             ``           ` ,        .       `         .         ");
            System.out.println("              .     .`   `       .  ,    .   .``   ` .    ` `    .  ,                            ");
            System.out.println("             .      .   `                `     ,     .    ` .    .    `       `  `               ");
            System.out.println("                   .   .           .                        :.       .`          `               ");
            System.out.println("            .     ``  `        `        .  ``    `   .      `.    ``           .                 ");
            System.out.println("            `     ,               `     `  ,,    `   .       `        ,                          ");
            System.out.println("           `     `   .        `            .``   `   `     `       `.  `        `                ");
            System.out.println("                 `               `     `     .    .  .       ``    `   `        .                ");
            System.out.println("                    .        `   .           `    `  `     ` ``      ` `                         ");
            System.out.println("                .                         .      `.        . ..     .` .                         ");
            System.out.println("               `.  `        .   `         .;      .  `     . ,      ``  .                        ");
            System.out.println("               `                           .         `                  `                        ");
            System.out.println("                ` `        .   `     `      `   `    ,     `                                     ");
            System.out.println("              `                      `   `           ,     .   .         `                       ");
            System.out.println("                          .              `.      ,   `     .   .     `                           ");
            System.out.println("                              `     ,     `      `   .     `   `     .   `                       ");
            System.out.println("                         `                 `       ` `         `     `   `                       ");
            System.out.println("                         .              `  .                   `     ,                           ");
            System.out.println("                                        .       `  .                 `   ,                       ");
            System.out.println("                                                   .           .                                 ");
            System.out.println("                                       `  ,        ``          `                                 ");
            System.out.println("                                       .  `                                                      ");
            System.out.println("                                       `                                                         ");
            System.out.println("                                         .                                                       ");
            System.out.println("                                                  `                                              ");
            System.out.println("                                                  `                                              ");
            System.out.println("                                       ***FIREWORKS***                                           ");
            System.out.println();
            System.out.println("You successfully were able to hand in your assignment. CONGRATULATIONS!!!");
        }

        else if(gameState == 3) {
            System.out.println("The game was successfully saved");
        }

    }
}
