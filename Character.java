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

    public abstract void attack(Character enemy); //menyerang 

    public void usePotion(int amount) { //ramuan
        this.currentHP = Math.min(this.maxHP, this.currentHP + amount);
    } // Metode untuk menggunakan item Potion yang akan menambah currentHP sejumlah amount (tetapi tidak melebihi maxHP).

    public void useEther(int amount) {
        this.currentMP = Math.min(this.maxMP, this.currentMP + amount);
    } //useEther(int jumlah): Metode untuk menggunakan item Ether yang akan menambah currentMP sejumlah jumlah (tetapi tidak melebihi maxMP).

    public void useElixir(int hpAmount, int mpAmount) {
        usePotion(hpAmount);
        useEther(mpAmount);
    } //useElixir(int hpAmount, int mpAmount): Metode untuk menggunakan item Elixir yang akan menambah currentHP sejumlah hpAmount dan currentMP sejumlah mpAmount.

    private int hitungMaxHP(int level) {
        // Implementasi perhitungan maxHP berdasarkan level
        return level * 50; // Contoh: HP maksimum adalah 50 per level
    }

    private int hitungMaxMP(int level) {
        // Implementasi perhitungan maxMP berdasarkan level
        return level * 50; // Contoh: MP maksimum adalah 50 per level
    }

    public void receiveDamage(int damage) { // menerima damage 
        int effectiveDamage = Math.max(0, damage - (armor != null ? armor.getDefensePoints() : 0));
        this.currentHP = Math.max(0, this.currentHP - effectiveDamage);

    } // receiveDamage(int damage): Metode untuk mengurangi currentHP karakter berdasarkan damage yang diterima setelah dipertimbangkan dengan defensePoints dari armor.
    
}
