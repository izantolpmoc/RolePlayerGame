import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class RGPMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
       System.out.println(ConsoleColors.BLACK_BACKGROUND_BRIGHT +  ConsoleColors.WHITE_BOLD);
       slowPrint("Bienvenue dans Paris Survival");
       System.out.println(ConsoleColors.RESET);
       System.out.println("            .\r\n"
               + "           .|.\r\n"
               + "           |||\r\n"
               + "           |||\r\n"
               + "           |||\r\n"
               + "           |||\r\n"
               + "           j_I\r\n"
               + "          .)_(.\r\n"
               + "          |===|\r\n"
               + "          /___\\\r\n"
               + "         //___\\\\\r\n"
               + "        /=======\\\r\n"
               + "       / .-\"\"\"-. \\\r\n"
               + "      |__|     |__|\r\n");
       
       //INTRODUCTION
        slowPrint("X : ET MERDE !");
        slowPrint("X : Sur quoi j'ai encore trébuché moi...");
        slowPrint("X : Encore un saoulard qui s'est endormi par terre, c'est vraiment de pire en pire cette ville!");
        slowPrint("X : Tiens, c'est bizarre quand même je n'ai pas l'impression de l'avoir déjà vu dans le coin...");
        
        System.out.println(ConsoleColors.RED + "Vous sortez d'un sommeil très profond avec un mal de crâne terrible. L'inconnu vous demande comment vous vous appelez. Que répondez-vous ?" + ConsoleColors.RESET);
        String username = in.nextLine();
        while (username.isBlank()) {
            System.out.println("Ecoute, tu es peut-être timide ou complètement dans les vapes mais je ne lâcherai pas le morceau. \n"
                    + "C'est important de savoir à qui on a affaire et tu pourrais avoir besoin d'un ami. \n"
                    + "Si tu ne veux pas donner ton petit nom dis moi au moins ton pseudo");
            username = in.nextLine();
        }
        slowPrint("X : Enchanté " + username + ", en tout cas tu es vraiment dans un sale état !");
        slowPrint("X : Moi c'est Yvan.");
        
        
        System.out.println(ConsoleColors.RED + "Yvan vous aide à vos redresser et vous offre de l'eau. Il semble vous regarder avec curiosité. \nVous lui parlez: ");
        System.out.println("-------------------------\n");
        System.out.println("1 - Merci pour ton aide Yvan, à vrai dire je ne sais pas comment je me suis retrouvée seule ici [femme]");
        System.out.println("2 - Merci pour ton aide Yvan, à vrai dire je ne sais pas comment je me suis retrouvé seul ici [homme]");
        System.out.println("3 - Merci pour ton aide Yvan, à vrai dire je ne sais pas ce que je fiche ici [autre]"+ ConsoleColors.RESET);
        var chosenGender = in.nextInt();
        Gender gender;
        switch (chosenGender) {
            case 1 :
                 gender = Gender.FEMALE;
            break;
            case 2 :
                gender = Gender.MALE;
            break;
            default:
                gender = Gender.OTHER;
            break;
        }
        
        slowPrint("Yvan: Je vois, et qu'est ce que tu fais dans la vie ?");
        System.out.println(ConsoleColors.RED + "Veuillez choisir votre Catégorie Socio-Professionelle");
        System.out.println("-------------------------\n");
        if(gender == Gender.MALE || gender == Gender.OTHER) {
            System.out.println("1 - [étudiant]");
            System.out.println("2 - [homme d'affaires]");
            System.out.println("3 - [homme politique]");
        }
        else {
            System.out.println("1 - [étudiante]");
            System.out.println("2 - [femme d'affaires]");
            System.out.println("3 - [femme politique]"); 
        }
        System.out.println("4 - [sportif des JO de Paris]");
        System.out.println("5 - [touriste]"+ ConsoleColors.RESET);
        var chosenCategory = in.nextInt();
        while (chosenCategory < 1 || chosenCategory > 5) {
            System.out.println(ConsoleColors.RED + "Veuillez choisir votre Catégorie parmi les choix proposés");
            chosenCategory = in.nextInt();
        }
        
        Player player;
        switch (chosenCategory) {
            case 1 :
                player = new Student(username, gender);
           break;
           case 2 :
               player = new SalaryMan(username, gender);
           break;
           case 3:
               player = new Politician(username, gender);
           break;
           case 4:
               player = new JOPlayer(username, gender);
           break;
           default:
               player = new Tourist(username, gender);
           break;
        }

        slowPrint("Yvan: Ah oui d'accord ça ne rigole pas!");
        slowPrint("Yvan: Bon écoute, je ne peux pas rester plus longtemps et tous les transports sont en grève aujourd'hui.");
        var map = new Map();
        map.print2D();
        slowPrint("Yvan: Si tu veux rentrer chez toi je te suggère d'aller en haut à droite de cette carte, là où il y a un drapeau. \n"
                + "Tu y trouveras surement des chauffeurs et pour 50€ tu devrais pouvoir obtenir une course!");
        slowPrint("Yvan: Ce n'est pas grand chose mais je veux bien te donner ces 5€ et la carte.");
        player.Additem(map);
        player.ReceiveMoney(5);
        slowPrint("Yvan: Bon courage, " + username +".");
        
        
        //MAIN GAME
        while(player.HealthPoints > 0 && map.playerPos != 9)
            move(map, player);
        
        
        //OUTCOMES
        if(map.playerPos == 9 && player.Money >= 50)
        {
            slowPrint("Vous apercevez au loin un chauffeur, Yvan avait raison !");
            slowPrint("Vous vous approchez et lui donnez ses 50€");
            slowPrint("Vous rentrez enfin chez vous...");
            System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT);
            slowPrint("Vous avez gagné !");
            System.out.println(ConsoleColors.RESET);
        }
        else if(map.playerPos == 9 && player.Money < 50) {
            slowPrint("Vous n'avez réussi à obtenir que " + player.Money + "/50€");
            slowPrint("Vous voyez un chauffeur au loin mais celui-ci vous fait comprendre que vous n'avez pas assez d'argent.");
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT);
            slowPrint("Vous avez perdu...");
            System.out.println(ConsoleColors.RESET);
        }
        else {
            slowPrint("Malheureusement, vous n'avez pas survécu à votre périple...");
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT);
            slowPrint("Vous avez perdu.");
            System.out.println(ConsoleColors.RESET);
        }
            
    }
    

    public static void slowPrint(String output) {
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
    

    public static void move(Map map, Player player) {
        Scanner in = new Scanner(System.in);
        System.out.println("Votre vie: " + player.HealthPoints + "/100");
        System.out.println("Votre XP: " + player.XP + "/100");
        System.out.println("Votre arme: " + player.Weapon.ToString() + " ("+player.Weapon.Damage+"/100)");
        map.print2D();
        System.out.println("Avancez sur la carte jusqu'à atteindre le drapeau: ");
        System.out.println("-------------------------\n");
        System.out.println("1 - Haut");
        System.out.println("2 - Bas");
        System.out.println("3 - Droite");
        System.out.println("4 - Gauche");
        System.out.println("5 - Changer d'arme");
        System.out.println("6 - Manger"+ ConsoleColors.RESET);
        var chosenDirection = in.nextInt();
        while (chosenDirection < 1 || chosenDirection > 6) {
            System.out.println(ConsoleColors.RED + "Veuillez choisir une direction parmi les choix proposés" + ConsoleColors.RESET);
            chosenDirection = in.nextInt();
        }
        
        switch (chosenDirection) {
            case 1 :
                map.move(Direction.UP, player);
           break;
           case 2 :
                map.move(Direction.DOWN, player);
           break;
           case 3:
               map.move(Direction.RIGHT, player);
           break;
           case 4:
               map.move(Direction.LEFT, player);
           break;
           case 5 :
               player.ChangeWeapon();
           break;
           case 6 : 
               player.Eat();
           break;
        }
        
    }

}
