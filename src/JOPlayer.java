
public class JOPlayer extends Player {
    
    public JOPlayer(String username, Gender gender) {
        super(username, gender);
        super.Charisma = 6;
        super.Constitution = 8;
        super.Dexterity = 8;
        super.Intelligence = 2;
        super.Strength = 8;
        super.Wisdom = 2;
        
        super.ResistantTo = DamageType.NEUTRAL;
        super.WeakTo = DamageType.POISON; 
    }

}
