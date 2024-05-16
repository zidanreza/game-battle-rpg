abstract class Foe extends Character {
    protected String race;

    public Foe(String name, int level, int maxHP, int maxMP, String race) {
        super(name, level, maxHP, maxMP);
        this.race = race;
    }

    @Override
    public abstract void useSkill(Character enemy);
}
