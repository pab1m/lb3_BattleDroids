package droids;


public class Droid {

    private String name;
    private int health;
    private int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public Droid() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage){
        if (damage > 0)
            health -= damage;
        else System.out.println("Invalid damage value");
    }


    public void attack(Droid target) {
        System.out.println("\n" + getName() + "(" + getHealth() + "HP Damage=" + getDamage() + ")" + " vs " + target.getName() + "(" + target.getHealth() + "HP Damage=" + target.getDamage() + ")");
        System.out.println("\n" + getName() + "(" + getHealth() + "HP Damage=" + getDamage() + ")" + " vs " + target.getName() + "(" + target.getHealth() + "HP Damage=" + target.getDamage() + ")");
        int damageDealt = getDamage();
        System.out.println('"'+ getName() + '"' + " attacks " + '"' + target.getName() + '"' + " and deals " + damageDealt + " damage.");
        target.takeDamage(damageDealt);
    }


    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }
}