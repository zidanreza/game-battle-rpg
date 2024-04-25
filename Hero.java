public class Hero extends Character {
    public Hero(String name, String race, int level) { // memangggil constructor charakter menggunakan super 
        super(name, race, level);
        this.weapon = membuatSenjata(race);
        this.armor = null; // Hero tidak memiliki armor secara default
    }

    @Override
    public void attack(Character enemy) { // menyerang
        if (weapon != null) {
            int damage = weapon.getAttackPoints(); // get attack di clasas weapon
            System.out.println(name + " attacks with " + weapon.getType() + " dealing " + damage + " damage.");
            // serangan (heronya) dengan (senjata ...) menghasilakna (....) kerusakan
            enemy.receiveDamage(damage); // menerima damage
           
        }
    }

    private Weapon membuatSenjata(String race) { // membuat senjata berdasarkan race 
        switch (race) {
            case "Knight":
                return new Weapon("Sword", 30); // Contoh: Pedang dengan 30 attack points
            case "Archer":
                return new Weapon("Arrow", 20); // Contoh: Panah dengan 20 attack points
            case "Fighter":
                return new Weapon("Gloves", 25); // Contoh: Sarung tangan dengan 25 attack points
            case "Fairy":
                return new Weapon("Magic Wand", 35); // Contoh: Tongkat sihir dengan 35 attack points
            default:
                return null;
        }
    }
}
