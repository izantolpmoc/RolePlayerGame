public class BrokenBottle extends Weapon {
    
    public BrokenBottle() {
        super(DAMAGE, PRICE, NAME);
    }
    
    public DamageType damageType = DamageType.HEMORRAGY;
    
    private static final double DAMAGE = (Math.random() * 40 + 20);;
    private static final double PRICE = 10;
    private static final String NAME = "Tesson de bouteille";
    
    public String ToString() {
        return "Tesson de bouteille";
    }
    
    public String ascii_art() {
        return 
        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⢛⣽⣿⣿⣿⣿⣿⣿⣿ \n"+
        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿ \n"+
        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⣼⠿⠛⠋⢹⣿⣿⣿⣿⣿⣿ \n"+
        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿ \n"+
        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿ \n"+
        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠀⢀⣴⣿ \n"+
        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⢀⣴⣿⣿⣿ \n"+
        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠟⢁⣴⣿⣿⣿⣿⣿ \n"+
        "⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠟⢁⣴⣿⣿⣿⣿⣿⣿⣿ \n"+
        "⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⣠⣴⠶⠶⠶⠶⠚⠋⢁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿ \n"+
        "⣿⣿⣿⣿⠟⠁⠀⠀⠀⣠⡾⠋⣡⣴⣶⣶⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ \n"+
        "⣿⡟⠉⠁⠀⠀⠀⣠⣾⠟⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ \n"+
        "⣿⡄⠘⣿⣦⡀⠸⠟⢁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ \n"+
        "⣿⣿⣄⠈⠛⠿⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ \n"+
        "⣿⣿⣿⣿⣶⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿";
    }
}
