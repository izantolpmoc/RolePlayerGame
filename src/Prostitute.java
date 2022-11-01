public class Prostitute extends Monster {

    private static DamageType damageType;

    public Prostitute()
    {
        super(NAME, damageType, DAMAGE);
        damageType = DamageType.POISON;
    }
   
    private static final double DAMAGE = (Math.random() * 3 + 1);
    private static final String NAME = "Prostituée";
    
    @Override
    public void Attack(Player player) {
            player.TakeDamage(DAMAGE, damageType);
    }

}
