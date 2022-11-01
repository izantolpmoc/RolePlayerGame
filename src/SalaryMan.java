
public class SalaryMan extends Player{

    
    public SalaryMan(String username, Gender gender) {
        super(username, gender);
        super.Charisma = 8;
        super.Constitution = 4;
        super.Dexterity = 5;
        super.Intelligence = 8;
        super.Strength = 3;
        super.Wisdom = 4;
        
        super.ResistantTo = DamageType.POISON;
        super.WeakTo = DamageType.HEMORRAGY;
    }
    
}
