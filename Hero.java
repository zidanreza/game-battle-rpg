public class Hero extends Character {
    public Hero(String name, String race, int level) { 
        super(name, race, level);
        this.weapon = membuatSenjata(race);
        this.armor = null; 
    }

    @Override
    public void attack(Character enemy) { 
        if (weapon != null) {
            int damage = weapon.getAttackPoints(); 
            System.out.println(name + " attacks with " + weapon.getType() + " dealing " + damage + " damage.");
            enemy.receiveDamage(damage); 
           
        }
    }

    private Weapon membuatSenjata(String race) { 
        switch (race) {
            case "Knight":
                return new Weapon("Sword", 30); 
            case "Archer":
                return new Weapon("Arrow", 20); 
            case "Fighter":
                return new Weapon("Gloves", 25); 
            case "Fairy":
                return new Weapon("Magic Wand", 35);
            default:
                return null;
        }
    }
}
