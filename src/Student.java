public class Student extends Player{

    public Student(String username, Gender gender) {
        super(username, gender);
        super.Charisma = gender == Gender.FEMALE 
                ? 7
                : 4 ;
        super.Constitution = 5;
        super.Dexterity = 6;
        super.Intelligence = 6;
        super.Strength = 4;
        super.Wisdom = 2;
        
        super.ResistantTo = DamageType.POISON;
        super.WeakTo = DamageType.HEMORRAGY;
    }
    
}
