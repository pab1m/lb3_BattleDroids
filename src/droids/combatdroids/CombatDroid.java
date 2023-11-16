package droids.combatdroids;
import droids.Droid;


public class CombatDroid extends Droid {
    private int armor;

    public CombatDroid(String name, int health, int damage, int armor) {
        super(name, health, damage);
        this.armor = armor;
    }

    public CombatDroid(){}

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }


    @Override
    public void takeDamage(int damage) {
        int effectiveDamage = damage - getArmor();
        System.out.println("Armor " + '"' + getName() + '"' + " absorbed into itself " +  getArmor() + " units of damage.");
        if (effectiveDamage > 0) {
            int currentHealth = getHealth();
            currentHealth -= effectiveDamage;
            setHealth(currentHealth);
        }
    }

    @Override
    public String toString() {
        return " {" +
                "health=" + getHealth() +
                ", damage=" + getDamage() +
                ", armor=" + getArmor() +
                '}';
    }
}