abstract class Character {
    protected String name;
    protected int level;
    protected int maxHP;
    protected int currentHP;
    protected int maxMP;
    protected int currentMP;
    protected String status;

    public Character(String name, int level, int maxHP, int maxMP) {
        this.name = name;
        this.level = level;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.maxMP = maxMP;
        this.currentMP = maxMP;
        this.status = "";
    }

    public void attack(Character enemy) {
        System.out.println(name + " attacks " + enemy.name);
        enemy.receiveDamage(10); // Example damage
    }

    public abstract void useSkill(Character enemy);

    public void receiveDamage(int damage) {
        currentHP -= damage;
        if (currentHP < 0) currentHP = 0;
        System.out.println(name + " receives " + damage + " damage. Current HP: " + currentHP);
    }

    public void addStatus(String status) {
        this.status = status;
        System.out.println(name + " is now " + status);
    }

    public void removeStatus() {
        this.status = "";
        System.out.println(name + " status cleared");
    }

}