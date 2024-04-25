public class Foe extends Character { 
    private String enemyType; 

    public Foe(String enemyType, int level) {
        super(membuatJenisMusuh(enemyType), enemyType, level); 
        this.weapon = membuatSenjata(enemyType);
        this.armor = null; 
    }

    @Override
    public void attack(Character opponent) {
        if (weapon != null) {
            int damage = weapon.getAttackPoints();
            System.out.println(enemyType + " attacks with " + weapon.getType() + " dealing " + damage + " damage.");
            opponent.receiveDamage(damage);
        }
    }

    private static String membuatJenisMusuh(String enemyType) { 
        return "Enemy " + enemyType;
    }

    private Weapon membuatSenjata (String enemyType) { 
        switch (enemyType) {
            case "Orc":
                return new Weapon("Kapak", 30); 
            case "Elf":
                return new Weapon("Busur", 25);
            case "Dwarf":
                return new Weapon ("Pisau", 20);
            case "Skeleton":
                return new Weapon ("Petir", 35);
            case "Goblin":
                return new Weapon ("Peluru",25);
            case "Dragon":
                return new Weapon ("Api",30);
            default:
                return null;
        }
    }
}
