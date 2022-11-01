
public abstract class Obstacle extends Destructible {

    public Obstacle(String name, DamageType damageType)
    {
        Name = name;
        DamageType = damageType;
    }
    protected String Name;
    protected DamageType DamageType;
    
    public String ToString() {
        return Name;
    }
}
