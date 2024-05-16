class Knight extends Hero {
    public Knight(String name, int level, int maxHP, int maxMP, Weapon weapon) {
        super(name, level, maxHP, maxMP, "Knight", weapon);
    }

    @Override
    public void useSkill(Character enemy) {
        System.out.println(name + " uses sword skill on " + enemy.name);
        if (currentMP >= 20) {
            enemy.receiveDamage(50);
            currentMP -= 20;
        } else {
            System.out.println("Not enough MP to use skill.");
        }
    }
}