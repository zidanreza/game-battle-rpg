public abstract class Character {
    protected String name;
    protected String race;
    protected int level;
    protected int maxHP;
    protected int currentHP;
    protected int maxMP;
    protected int currentMP;
    protected Weapon weapon;
    protected Armor armor;

    public Character(String name, String race, int level) {
        this.name = name;
        this.race = race;
        this.level = level;
        this.maxHP = hitungMaxHP(level);
        this.currentHP = this.maxHP;
        this.maxMP = hitungMaxMP(level);
        this.currentMP = this.maxMP;
    }

    public abstract void attack(Character enemy);

    public void usePotion(int amount) { 
        this.currentHP = Math.min(this.maxHP, this.currentHP + amount);
    } 

    public void useEther(int amount) {
        this.currentMP = Math.min(this.maxMP, this.currentMP + amount);
    } 

    public void useElixir(int hpAmount, int mpAmount) {
        usePotion(hpAmount);
        useEther(mpAmount);
    } 

    private int hitungMaxHP(int level) {
        return level * 50;
    }

    private int hitungMaxMP(int level) {
        return level * 50;
    }

    public void receiveDamage(int damage) {
        int effectiveDamage = Math.max(0, damage - (armor != null ? armor.getDefensePoints() : 0));
        this.currentHP = Math.max(0, this.currentHP - effectiveDamage);

    }
    
}
