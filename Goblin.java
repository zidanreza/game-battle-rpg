class Goblin extends Foe {
    public Goblin(String name, int level, int maxHP, int maxMP) {
        super(name, level, maxHP, maxMP, "Goblin");
    }

    @Override
    public void useSkill(Character enemy) {
        System.out.println(name + " uses gigit skill on " + enemy.name);
        if (currentMP >= 10) {
            enemy.receiveDamage(30);
            enemy.addStatus("Poison");
            currentMP -= 10;
        } else {
            System.out.println("Not enough MP to use skill.");
        }
    }
}