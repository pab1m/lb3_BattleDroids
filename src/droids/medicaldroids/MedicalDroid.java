package droids.medicaldroids;
import droids.Droid;


public class MedicalDroid extends Droid{
    private int healingPower;

    public MedicalDroid(String name, int health, int damage, int healingPower) {
        super(name, health, damage);
        this.healingPower = healingPower;
    }

    public MedicalDroid() {
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    public void heal(int healingPower) {
        int currentHP = getHealth();

        currentHP += healingPower;
        setHealth(currentHP);

//        System.out.println('"' + getName()+ '"' + " has recovered " + healingPower + " health.");
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        heal(healingPower);
        System.out.println('"' + getName()+ '"' + " has recovered " + healingPower + " health.");

    }

    @Override
    public String toString() {
        return "{" +
                "name=" + getName() +
                ", health=" + getHealth() +
                ", damage=" + getDamage() +
                ", healingPower=" + getHealingPower() +
                '}';
    }


}