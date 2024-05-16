class Dragon extends Foe {
    public Dragon(String name, int level, int maxHP, int maxMP) {
        super(name, level, maxHP, maxMP, "Dragon");
    }

    @Override
    public void useSkill(Character enemy) {
        System.out.println(name + " uses fire skill on " + enemy.name);
        if (currentMP >= 30) {
            enemy.receiveDamage(60);
            enemy.addStatus("Weak");
            currentMP -= 30;
        } else {
            System.out.println("Not enough MP to use skill.");
        }
    }
}