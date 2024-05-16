public class Fighter extends Hero {
    public Fighter(String name, int level, int maxHP, int maxMP, Weapon weapon) {
        super(name, level, maxHP, maxMP, "Fighter", weapon);
    }

    @Override
    public void useSkill(Character enemy) {

    }
}