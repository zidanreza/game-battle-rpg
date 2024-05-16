abstract class Hero extends Character {
    protected String race;
    protected Weapon weapon;

    public Hero(String name, int level, int maxHP, int maxMP, String race, Weapon weapon) {
        super(name, level, maxHP, maxMP);
        this.race = race;
        this.weapon = weapon;
    }

    @Override
    public void attack(Character enemy) {
        System.out.println(name + " attacks " + enemy.name + " with " + weapon.getType());
        enemy.receiveDamage(weapon.getAttackPoints());
    }

    @Override
    public abstract void useSkill(Character enemy);

    public void usePotion() {
        currentHP += 100;
        if (currentHP > maxHP) currentHP = maxHP;
        System.out.println(name + " uses a Potion. HP: " + currentHP + "/" + maxHP);
    }

    public void useEther() {
        currentMP += 100;
        if (currentMP > maxMP) currentMP = maxMP;
        System.out.println(name + " uses an Ether. MP: " + currentMP + "/" + maxMP);
    }

    public void useElixir() {
        currentHP += 150;
        if (currentHP > maxHP) currentHP = maxHP;
        currentMP += 100;
        if (currentMP > maxMP) currentMP = maxMP;
        System.out.println(name + " uses an Elixir. HP: " + currentHP + "/" + maxHP + " | MP: " + currentMP + "/" + maxMP);
    }
}