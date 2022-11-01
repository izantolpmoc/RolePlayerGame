
public class Trash extends Obstacle {

    private static DamageType damageType;

    public Trash() {
        super(NAME, damageType);
        damageType = DamageType.POISON;
    }
    
    private static final String NAME = "Déchets";
    
}
