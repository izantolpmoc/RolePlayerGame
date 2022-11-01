import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Map extends Item {
    
    public Map() {
        super(NAME, PRICE);
    }

    private static final double PRICE = 0;
    private static final String NAME = "Carte de Paris";
    private String[][] map = new String[][]{
        {"🏢","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲",ConsoleColors.RED + "🚩" + ConsoleColors.RESET},
        {"🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲"},
        {"🌲","🌲","🌲","🌲","🌲","🌲","🌲","🏢","🌲","🌲"},
        {"🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲"},
        {"🌲","🌲","🌲","🌲","⛲","🌲","🌲","🌲","🌲","🌲"},
        {"🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲"},
        {"🌲","🌲","🌲","🏢","🌲","🌲","🌲","🏢","🌲","🌲"},
        {"🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲"},
        {"🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲"},
        {"🌲","🏢","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲"}};


    //Map where the events are pre-defined
    public static final int[][] MAPELEMENTS = new int[][]{
        {4,1,1,1,1,1,1,1,1,9},
        {1,2,2,2,2,3,2,2,5,1},
        {1,3,2,2,2,2,2,4,2,1},
        {1,2,5,4,2,2,2,5,2,1},
        {1,2,3,3,0,5,5,3,2,1},
        {1,2,2,2,2,2,2,2,2,1},
        {1,3,2,4,2,2,3,4,2,1},
        {1,2,3,5,2,2,2,2,2,1},
        {1,2,5,2,2,2,3,4,5,1},
        {1,4,3,1,1,1,1,1,1,1}};

    // Map displayed to the user
    public static final String[][] MAPBASE = new String[][]{
        {"🏢","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲",ConsoleColors.RED + "🚩" + ConsoleColors.RESET},
        {"🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲"},
        {"🌲","🌲","🌲","🌲","🌲","🌲","🌲","🏢","🌲","🌲"},
        {"🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲"},
        {"🌲","🌲","🌲","🌲","⛲","🌲","🌲","🌲","🌲","🌲"},
        {"🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲"},
        {"🌲","🌲","🌲","🏢","🌲","🌲","🌲","🏢","🌲","🌲"},
        {"🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲"},
        {"🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲"},
        {"🌲","🏢","🌲","🌲","🌲","🌲","🌲","🌲","🌲","🌲"}};
    

        int x = 9;
        int y = 0;
        int playerPos = MAPELEMENTS[x][y];
        
        public void move(Direction direction, Player player) {
            this.map[x][y] = Map.MAPBASE[x][y];
            
            switch(direction) {
                case UP :
                    if(x > 0) x-=1;
                break;
                case DOWN :
                    if(x < 9) x+=1;
                break;
                case LEFT :
                    if(y > 0) y-=1;
                break;
                case RIGHT:
                    if(y < 9) y+=1;
                break;
            }

            playerPos = MAPELEMENTS[x][y];
            this.print2D();
            this.Action(player);
        }
        
        public void print2D()
        {
            this.map[x][y] = ConsoleColors.WHITE_BOLD + ConsoleColors.BLACK_BACKGROUND + "🧍‍♂️" + ConsoleColors.RESET;
            for (String[] row : map)
            System.out.println(Arrays.toString(row));
        }
        
        public void Action(Player player)
        {
            Scanner in = new Scanner(System.in);
            
            switch(playerPos) {
                case 0:
                    System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "Vous repérez un objet brillant sous un banc. Vous vous rapprochez. UNE ROLEX ! Sans aucune hésitation, vous ramassez le butin et le revendez dans une petite boutique pour la coquette somme de 7800€." + ConsoleColors.RESET);
                    player.ReceiveMoney(7800);
                break;
                case 1:
                    System.out.println(ConsoleColors.RED + "Vous marchez sur un trottoir 'miné'. Une forte dextérité peut vous aider à esquiver les crottes de chien." + ConsoleColors.RESET);
                    slowPrint("Votre dextérité: " + player.Dexterity);
                    if(player.Dexterity > 5)
                        slowPrint("Vous arrivez à avancer sans soucis.");
                    else
                    {
                        slowPrint("Vous marchez sur une crotte");
                        player.TakeDamage(5, DamageType.POISON);
                    }
                break;
                case 2:
                    System.out.println(ConsoleColors.RED + "Une tonne d'encombrants vous bloque la route." + ConsoleColors.RESET);
                    var trash = new Trash();
                    
                    System.out.println(ConsoleColors.RED + "Que faites vous ?");
                    System.out.println("-------------------------\n");
                    
                    System.out.println("1 - Attaquer avec l'arme");
                    System.out.println("2 - Prendre une autre direction"+ ConsoleColors.RESET);
                    if(player.Dexterity >= 8) {
                        System.out.println(ConsoleColors.RED +"3 - Escalader"+ ConsoleColors.RESET);
                    }
                    var chosenAction = in.nextInt();
                    while (chosenAction < 1 || chosenAction > 3) {
                        System.out.println(ConsoleColors.RED + "Veuillez choisir parmi les options proposés");
                        chosenAction = in.nextInt();
                    }
                    
                    switch (chosenAction) {
                        case 1:
                            fight(player, trash);
                            if(player.HealthPoints > 0) player.Additem(new BrokenBottle());
                        break;
                        case 2:
                            move(Direction.DOWN, player);
                        break;
                        case 3:
                            slowPrint("Vous réussissez à escalader grâce à votre dexterité");
                        break;
                    }
                break;
                case 3:
                    var prostitute = new Prostitute();
                    System.out.println(ConsoleColors.RED + "Une drôle de femme vous aborde en sortant d'une camionette, elle vous réclame de l'argent contre un service sexuel que vous n'avez pas demandé." + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.RED + "Que faites vous ?");
                    System.out.println("-------------------------\n");
                    
                    System.out.println("1 - Attaquer avec l'arme");
                    System.out.println("2 - Fuir" + ConsoleColors.RESET);
                    chosenAction = in.nextInt();
                    while (chosenAction < 1 || chosenAction > 3) {
                        System.out.println(ConsoleColors.RED + "Veuillez choisir parmi les options proposés" + ConsoleColors.RESET);
                        chosenAction = in.nextInt();
                    }
                    
                    switch (chosenAction) {
                        case 1:
                            fight(player, prostitute);
                            if(player.HealthPoints > 0) player.Additem(new BagOfUsedCondoms());
                        break;
                        case 2:
                            move(Direction.DOWN, player);
                        break;
                    }
                break;
                case 4:
                    System.out.println(ConsoleColors.PURPLE_BOLD + "MALBORO, MALBORO, MARRONS CHAUDS, MARRONS CHAUDS, 1 EURO, 1 EUROOOO. Un groupe de vendeurs à la sauvette sont prêts à marchander avec vous." + ConsoleColors.RESET);
                    var sellerInventory = new ArrayList<Item>();
                    sellerInventory.add(new Fireworks());
                    sellerInventory.add(new Syringe());
                    sellerInventory.add(new HotChestnuts());
                    var seller = new StreetSeller("Vendeur du coin", sellerInventory);
                    
                    System.out.println(ConsoleColors.RED + "Que faites vous ?");
                    System.out.println("-------------------------\n");
                    
                    System.out.println("1 - Acheter");
                    System.out.println("2 - Vendre");
                    System.out.println("3 - Fuir" + ConsoleColors.RESET);
                    chosenAction = in.nextInt();
                    while (chosenAction < 1 || chosenAction > 3) {
                        System.out.println(ConsoleColors.RED + "Veuillez choisir parmi les options proposés" + ConsoleColors.RESET);
                        chosenAction = in.nextInt();
                    }
                    
                    switch (chosenAction) {
                        case 1:
                            seller.Sell(player);
                        break;
                        case 2:
                            seller.Buy(player);
                        break;
                        case 3:
                            if(player.Charisma >= 8 || player.Constitution >= 8)
                                move(Direction.RIGHT, player);
                            else
                            {
                                System.out.println(ConsoleColors.RED + "Les vendeurs ne laissent pas partir si facilement. Vous allez devoir vous battre." + ConsoleColors.RESET);
                                fight(player, new AngrySeller());
                                if(player.HealthPoints > 0) player.ReceiveMoney(10);
                            }
                        break;
                    }
                    

                break;
                case 5:
                    System.out.println(ConsoleColors.RED + "Vous marchez sur un trottoir 'miné'. Une forte dextérité peut vous aider à esquiver les crottes de chien." + ConsoleColors.RESET);
                    slowPrint("Votre dextérité: " + player.Dexterity);
                    if(player.Dexterity > 5)
                        slowPrint("Vous arrivez à avancer sans soucis.");
                    else
                    {
                        slowPrint("Vous marchez sur une crotte");
                        player.TakeDamage(5, DamageType.POISON);
                    }
                break;
                    
            }
        }

        private void slowPrint(String output) {
            for (int i = 0; i<output.length(); i++) {
                char c = output.charAt(i);
                System.out.print(c);
                try {
                  TimeUnit.MILLISECONDS.sleep(30);
                }
                catch (Exception e) {

                }
              }
              System.out.println("\n");
        }
        
        private void fight(Player player, Obstacle obstacle) {
            while(obstacle.HealthPoints > 0)            
                player.attack(obstacle);
                
            if (player.WeakTo == obstacle.DamageType)
                player.TakeDamage(5, obstacle.DamageType);
            
            player.gainXP(10);
        }
        
        private void fight(Player player, Monster monster) {
            while(monster.HealthPoints > 0 && player.HealthPoints > 0) 
            {
                player.attack(monster);
                monster.Attack(player);
            }
            
            player.gainXP(25);
        }
} 
