public class Weapon {
    private String type;
    private int attackPoints;

    public Weapon(String type, int attackPoints) {
        this.type = type;
        this.attackPoints = attackPoints;
    }

    public String getType() {
        return type;
    }

    public int getAttackPoints() {
        return attackPoints;
    }
}
