

public class Fireworks extends Weapon {
    public Fireworks() {
        super(DAMAGE, PRICE, NAME);
    }
    
    public DamageType damageType = DamageType.FIRE;
    
    private static final double DAMAGE = (Math.random() * 50 + 20);
    private static final double PRICE = 40;
    private static final String NAME = "Mortier";
    
    public String toString() {
        return "Tirs de mortier";
    }
    
    public String ascii_art() {
        return "                       (\r\n"
        + "      __________       )\\\r\n"
        + "     /         /\\______{,}\r\n"
        + "     \\_________\\/\r\n"
        + "\r\n"
        + "                      . : .\r\n"
        + "      __________    '.  :  .'\r\n"
        + "     /         /\\__.__'.:.'  .\r\n"
        + "     \\_________\\/  .  .':'.  .\r\n"
        + "                    .'  :  '.\r\n"
        + "                      ' : '";
    }
}
