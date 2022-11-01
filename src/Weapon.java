
public abstract class Weapon extends Item {

    protected double Damage;
    protected DamageType DamageType;
    protected String Name;
    protected double Price;
    
    public Weapon(double damage, double price, String name) {
        super(name,price);
        Damage = damage;
    }
    
    abstract public String ascii_art();
    
    public void attack(Destructible destructible) {
        if(destructible.HealthPoints > 0) destructible.TakeDamage(Damage, DamageType);
        else System.out.println(destructible.toString() + " a été vaincu !");
    }
    
    public void attack(Monster monster) {
        System.out.println(monster.Name + ": " + monster.HealthPoints + "/100");
        monster.TakeDamage(Damage, DamageType);
        if(monster.HealthPoints <= 0) System.out.println(monster.Name + " a été vaincu(e) !");
    }
    
    public void attack(Obstacle obstacle) {
        System.out.println(obstacle.Name + ": " + obstacle.HealthPoints + "/100");
        obstacle.TakeDamage(Damage, DamageType);   
        if(obstacle.HealthPoints <= 0) System.out.println(obstacle.Name + " a été détruit(e) !");
    }
    
    public String ToString() {
        return this.getClass().getName();
    }
}
