
public class Destructible {
    
    protected DamageType WeakTo;
    protected DamageType ResistantTo;
    public double HealthPoints = 100;
    
    public void TakeDamage(double damage, DamageType type) { 
        if (ResistantTo == type)
            HealthPoints -= (damage - 5);
        
        else if (WeakTo == type)
            HealthPoints -= (damage + 5);
        
        else
            HealthPoints -= damage;
    }
}
