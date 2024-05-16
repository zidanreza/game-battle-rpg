public class Fairy extends Hero {
    public Fairy(String name, int level, int maxHP, int maxMP, Weapon weapon) {
        super(name, level, maxHP, maxMP, "Fairy", weapon);
    }

    @Override
    public void useSkill(Character enemy) {
        // Implementasi skill khusus Fairy
        System.out.println(name + " uses magic wand to heal.");
        heal(this); 
    }

    public void heal(Character target) {
        int healAmount = 50; 
        if (currentMP >= 30) { 
            target.currentHP = Math.min(target.maxHP, target.currentHP + healAmount);
            currentMP -= 30;
            System.out.println(name + " heals " + target.name + " for " + healAmount + " HP.");
        } else {
            System.out.println(name + " does not have enough MP to heal.");
        }
    }
}