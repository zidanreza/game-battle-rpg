public class Battle {
    public static void main(String[] args) {
        Hero hero = new Hero("Arthur", "Fighter", 8);
        Foe foe = new Foe("Orc", 5);

        System.out.println(hero.name + " vs " + foe.name);
        System.out.println("-----------");

        while (hero.currentHP > 0 && foe.currentHP > 0) {
            hero.attack(foe);
            if (foe.currentHP <= 0) {
                System.out.println(foe.name + " defeated!");
                break;
            }
            
            foe.attack(hero);
            if (hero.currentHP <= 0) {
                System.out.println(hero.name + " defeated!");
                break;
            }
            
            System.out.println(hero.name + " HP: " + hero.currentHP + "/" + hero.maxHP);
            System.out.println(foe.name + " HP: " + foe.currentHP + "/" + foe.maxHP);
            System.out.println("-----------");
            }
        }
    }
