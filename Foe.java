public class Foe extends Character { 
    private String enemyType; //menyimpan jenis musuh 

    public Foe(String enemyType, int level) {
        super(membuatJenisMusuh(enemyType), enemyType, level); // Pemanggilan ini digunakan untuk inisialisasi atribut-atribut dari kelas induk (Character) yang memiliki parameter konstruktor.
        this.enemyType = enemyType;
        this.weapon = membuatSenjata(enemyType);
        this.armor = null; // Foe tidak memiliki armor secara default
    }

    @Override
    public void attack(Character opponent) {
        if (weapon != null) {
            int damage = weapon.getAttackPoints();
            System.out.println(enemyType + " attacks with " + weapon.getType() + " dealing " + damage + " damage.");
            opponent.receiveDamage(damage);
        }
    }

    private static String membuatJenisMusuh(String enemyType) { // berdasarkan senjata
        // Implementasi pembuatan nama foe berdasarkan jenisnya
        return "Enemy " + enemyType;
    }

    private Weapon membuatSenjata (String enemyType) { // berdasarkan type musuh 
        // Implementasi pembuatan senjata foe berdasarkan jenisnya
        switch (enemyType) {
            case "Orc":
                return new Weapon("Kapak", 30); // Contoh: Kapak dengan 30 attack points
            case "Elf":
                return new Weapon("Busur", 25); // Contoh: Busur dengan 25 attack points
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
