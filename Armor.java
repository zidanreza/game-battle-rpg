public class Armor {
    private String type;
    private int defensePoints;
    
    public Armor(String type, int defensePoints) {
        this.type = type;
        this.defensePoints = defensePoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }
}
