public class Archer extends Hero {
    public Archer(String name, int level, int maxHP, int maxMP, Weapon weapon) {
        super(name, level, maxHP, maxMP, "Archer", weapon);
    }

    @Override
    public void useSkill(Character enemy) {

    }
}