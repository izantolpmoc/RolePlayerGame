import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player {
    public Player(String username, Gender gender) {
        Username = username;
        Gender = gender;
        
        if(gender == Gender.MALE)
            AttackBonus = 5;
    }
    
    // attributes
    private String Username;
    private Gender Gender;
    public double HealthPoints = 100;
    protected double Strength;
    protected double Constitution;
    protected double Dexterity;
    protected double Intelligence;
    protected double Wisdom;
    protected double Charisma;
    private double AttackBonus;
    public DamageType ResistantTo;
    public DamageType WeakTo;
    protected double XP = 0;
    private double Level = 0;
    
    protected double Money = 0;
    protected ArrayList<Item> Inventory = new ArrayList();
    protected Weapon Weapon = new BareHands(AttackBonus);
    
    public void attack(Destructible destructible) {
        Weapon.attack(destructible);
    }
    
    public void attack(Monster monster) {
        Weapon.attack(monster);
    }
    
    public void attack(Obstacle obstacle) {
        Weapon.attack(obstacle);
    }
    
    public void TakeDamage(double damage, DamageType type) {
        switch (type) {
            case FIRE:
                if(ResistantTo == DamageType.FIRE) HealthPoints -= (damage - 2);
                if(WeakTo == DamageType.FIRE) HealthPoints -= (damage + 2);
                if(HealthPoints > 0)
                    System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ "Vous perdez de la vie: "+ HealthPoints +"/100" + ConsoleColors.RESET);
                if(HealthPoints <= 0)
                    System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ "Vous êtes mort(e)" +ConsoleColors.RESET); 
            break;
            case NEUTRAL:
                if(ResistantTo == DamageType.NEUTRAL) HealthPoints -= (damage - 2);
                if(WeakTo == DamageType.NEUTRAL) HealthPoints -= (damage + 2);
                if(HealthPoints > 0)
                    System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ "Vous perdez de la vie: "+ HealthPoints +"/100" + ConsoleColors.RESET);
                if(HealthPoints <= 0)
                    System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ "Vous êtes mort(e)" +ConsoleColors.RESET); 
            break;
            case POISON:
                if(ResistantTo == DamageType.POISON) HealthPoints -= (damage - 2);
                if(WeakTo == DamageType.POISON) HealthPoints -= (damage + 2);
                if(HealthPoints > 0)
                    System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ "Vous perdez de la vie: "+ HealthPoints +"/100" + ConsoleColors.RESET);
                if(HealthPoints <= 0)
                    System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ "Vous êtes mort(e)" +ConsoleColors.RESET); 
            break;
            case HEMORRAGY:
                if(ResistantTo == DamageType.HEMORRAGY) HealthPoints -= (damage - 2);
                if(WeakTo == DamageType.HEMORRAGY) HealthPoints -= (damage + 2);
                if(HealthPoints > 0)
                    System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ "Vous perdez de la vie: "+ HealthPoints +"/100" + ConsoleColors.RESET);
                if(HealthPoints <= 0)
                    System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ "Vous êtes mort(e)" +ConsoleColors.RESET); 
            break;
        }
        
    }
    public void Heal(double points) { HealthPoints += points; }
    
    public void Eat() { 
        Scanner in = new Scanner(System.in);
        System.out.println("Souhaitez vous manger ?: ");
        System.out.println("-------------------------\n");
        for (int i = 0; i<Inventory.size(); i++) {
            System.out.println(i + " - " + Inventory.get(i).Name);
        }
        System.out.println("[-1]" + " - " + "Annuler");
        var chosenItem = in.nextInt();
        if (chosenItem == -1) {
            System.out.println("Vous avez annulé l'action.");
            return;
        }
        var item = Inventory.get(chosenItem);
        if(!(item instanceof Consumable))
        {
            System.out.println("Vous ne pouvez pas manger " + item.Name);
            return;
        }
        if (HealthPoints >= 100)
        {
            System.out.println("Votre barre de vie est déjà pleine.");
            return;
        }
            Consumable consumable = (Consumable) item;
            Heal(consumable.HealthPointsRestored);
            Inventory.remove(item); 
    }
    
    public void Additem(Item item) { 
        Inventory.add(item); 
        if (item instanceof Weapon) System.out.println(((Weapon) item).ascii_art());
        System.out.println(ConsoleColors.GREEN_BACKGROUND + item.Name + " a été ajouté(e) à votre inventaire." + ConsoleColors.RESET);
    }
    public void ReceiveMoney(double amount) { 
        Money += amount; 
        System.out.println(ConsoleColors.GREEN_BACKGROUND + "Vous avez reçu "+ amount+ "€" + ConsoleColors.RESET);
    };
    public void ChangeWeapon() {
        Scanner in = new Scanner(System.in);
        System.out.println("Souhaitez vous changer d'arme ?");
        System.out.println("-------------------------\n");
        for (int i = 0; i<Inventory.size(); i++) {
            System.out.println(i + " - " + Inventory.get(i).Name + ": " + Inventory.get(i).Price + "€");
        }
        System.out.println("[-1]" + " - " + "Annuler");
        var chosenItem = in.nextInt();
        if (chosenItem == -1) {
            System.out.println("Votre arme actuelle est: " + Weapon.Name);
            return;
        }
        var newWeapon = Inventory.get(chosenItem);
        
        if(!(newWeapon instanceof Weapon))
        {
            System.out.println(newWeapon.Name + " n'est pas une arme !");
            return;
        }
        if (Inventory.contains(newWeapon) || (newWeapon.toString() == new BareHands().toString()))
            Weapon = (Weapon) newWeapon;
    }
    public void gainXP(double xp) { 
        if (XP < 100) XP += xp; 
        if (XP >= 100) levelUp(XP-100);
    }
    public void levelUp(double newXP) {
        if(HealthPoints <= 0) return;
        Level ++;
        System.out.println(ConsoleColors.BLUE_BOLD + "Vous venez de passer de passer au niveau " + Level + ConsoleColors.RESET);
        XP = newXP;
        ReceiveMoney(10);
        if(HealthPoints < 100) Heal(30);
    }
}
