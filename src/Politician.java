
public class Politician extends Player {
    
    public Politician(String username, Gender gender) {
        super(username, gender);
        super.Charisma = 8;
        super.Constitution = 4;
        super.Dexterity = 3;
        super.Intelligence = 8;
        super.Strength = 3;
        super.Wisdom = 3;
        
        super.ResistantTo = DamageType.POISON;
        super.WeakTo = DamageType.HEMORRAGY;
    }

}
