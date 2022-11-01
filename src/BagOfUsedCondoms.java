
public class BagOfUsedCondoms extends Weapon {
    public BagOfUsedCondoms() {
        super(DAMAGE, PRICE, NAME);
    }
    
    public DamageType damageType = DamageType.POISON;
    
    private static final double DAMAGE = (Math.random() * 40 + 20);;
    private static final double PRICE = 5;
    private static final String NAME = "Sac rempli de préservatifs usagés";
    
    public String ToString() {
        return "Sac rempli de préservatifs usagés";
    }
    
    public String ascii_art() {
        return 
                "       .--._ .\r\n"
                + "        \\ ).'\r\n"
                + "         )|/\r\n"
                + "      _.'''-._\r\n"
                + "     (        \\\r\n"
                + "      \\        )\r\n"
                + "      )'-.    (\r\n"
                + "     /     _.-'\\\r\n"
                + "    /           )\r\n"
                + "   ('-._       /\r\n"
                + "    \\        _/ \r\n"
                + "     '-.__==''\r\n"
                + "";
    }
}
