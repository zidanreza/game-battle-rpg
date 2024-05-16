public class Elf extends Hero {
    public Elf(String name, int level, int maxHP, int maxMP, Weapon weapon) {
        super(name, level, maxHP, maxMP, "Elf", weapon);
    }

    @Override
    public void useSkill(Character enemy) {
        System.out.println(name + " uses lullaby to put " + enemy.name + " to sleep.");
        enemy.addStatus("Sleep");
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

    public void recover(Character target) {
        int recoverAmount = 50; 
        if (currentMP >= 20) {
            target.currentMP = Math.min(target.maxMP, target.currentMP + recoverAmount);
            currentMP -= 20;
            System.out.println(name + " recovers " + target.name + " for " + recoverAmount + " MP.");
        } else {
            System.out.println(name + " does not have enough MP to recover.");
        }
    }
}