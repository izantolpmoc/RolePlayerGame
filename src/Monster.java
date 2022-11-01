
public abstract class Monster extends Destructible {
    
    public Monster(String name, DamageType damageType, double damage)
    {
        Name = name;
        DamageType = damageType;
        Damage = damage;
    }
    protected String Name;
    protected DamageType DamageType;
    protected double Damage;
    abstract public void Attack(Player player);
    
    public String ToString() {
        return Name;
    }
}
