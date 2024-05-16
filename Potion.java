class Potion implements Item {
    @Override
    public void use(Character character) {
        character.currentHP += 100;
        if (character.currentHP > character.maxHP) {
            character.currentHP = character.maxHP;
        }
        System.out.println(character.name + " used a Potion. HP is now " + character.currentHP);
    }
}

class Ether implements Item {
    @Override
    public void use(Character character) {
        character.currentMP += 100;
        if (character.currentMP > character.maxMP) {
            character.currentMP = character.maxMP;
        }
        System.out.println(character.name + " used an Ether. MP is now " + character.currentMP);
    }
}

class Elixir implements Item {
    @Override
    public void use(Character character) {
        character.currentHP += 150;
        character.currentMP += 100;
        if (character.currentHP > character.maxHP) {
            character.currentHP = character.maxHP;
        }
        if (character.currentMP > character.maxMP) {
            character.currentMP = character.maxMP;
        }
        System.out.println(character.name + " used an Elixir. HP is now " + character.currentHP + " and MP is now " + character.currentMP);
    }
}