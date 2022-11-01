
public class Tourist extends Player {
    
    public Tourist(String username, Gender gender) {
        super(username, gender);
        super.Charisma = 5;
        super.Constitution = 4;
        super.Dexterity = 4;
        super.Intelligence = 4;
        super.Strength = 3;
        super.Wisdom = 8;
        
        super.ResistantTo = DamageType.NEUTRAL;
        super.WeakTo = DamageType.POISON;
    }
}
