public class AngrySeller extends Monster {
    private static DamageType damageType;

    public AngrySeller()
    {
        super(NAME, damageType, DAMAGE);
        damageType = DamageType.HEMORRAGY;
    }
   
    private static final double DAMAGE = (Math.random() * 3 + 1);
    private static final String NAME = "Vendeur en colère";
    
    @Override
    public void Attack(Player player) {
            player.TakeDamage(DAMAGE, damageType);
    }
}
