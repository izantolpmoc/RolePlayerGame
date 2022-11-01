import java.util.ArrayList;
import java.util.Scanner;

public class StreetSeller {

    public StreetSeller(String name, ArrayList inventory)
    {
        Name = name;
        Inventory = inventory;
    }
    
    private String Name;
    private ArrayList<Item> Inventory = new ArrayList();
    
    public void Sell(Player player) {
        Scanner in = new Scanner(System.in);
        System.out.println("Votre argent: " + player.Money + "€");
        System.out.println("-------------------------\n");
        for (int i = 0; i<Inventory.size(); i++) {
            System.out.println(i + " - " + Inventory.get(i).Name + ": " + Inventory.get(i).Price + "€");
        }
        System.out.println("[-1]" + " - " + "Annuler");
        var chosenItem = in.nextInt();
        if (chosenItem == -1) {
            System.out.println("Vous avez annulé la transaction.");
            return;
        }
        
        //ask for choice again when out of range
        while (!(chosenItem < Inventory.size()))
        {
            for (int i = 0; i<Inventory.size(); i++) {
                System.out.println(i + " - " + Inventory.get(i).Name + ": " + Inventory.get(i).Price + "€");
            }
            System.out.println("[-1]" + " - " + "Annuler");
            chosenItem = in.nextInt();
            if (chosenItem == -1) {
                System.out.println("Vous avez annulé la transaction.");
                return;
            }
        }
        
        var item = Inventory.get(chosenItem);
        if (player.Money > item.Price)
        {
            player.Inventory.add(item);
            Inventory.remove(item);
            player.Money -= item.Price;
        }
        else System.out.println("Vous n'avez pas assez d'argent pour vous payer cet item.");
            
    }
    
    public void Buy(Player player) {
        Scanner in = new Scanner(System.in);
        System.out.println("Votre argent: " + player.Money + "€");
        System.out.println("-------------------------\n");
        for (int i = 0; i<player.Inventory.size(); i++) {
            System.out.println(i + " - " + player.Inventory.get(i).Name + ": " + player.Inventory.get(i).Price + "€");
        }
        System.out.println("[-1]" + " - " + "Annuler");
        var chosenItem = in.nextInt();
        if (chosenItem == -1) {
            System.out.println("Vous avez annulé la transaction.");
            return;
        }
        
        //ask for choice again when out of range
        while (!(chosenItem < player.Inventory.size()))
        {
            for (int i = 0; i<player.Inventory.size(); i++) {
                System.out.println(i + " - " + player.Inventory.get(i).Name + ": " + player.Inventory.get(i).Price + "€");
            }
            System.out.println("[-1]" + " - " + "Annuler");
            chosenItem = in.nextInt();
            if (chosenItem == -1) {
                System.out.println("Vous avez annulé la transaction.");
                return;
            }
            
        }
        
        var item = player.Inventory.get(chosenItem);
        Inventory.add(item);
        player.Inventory.remove(item);
        player.ReceiveMoney(item.Price);
        

            
    }
    
}
