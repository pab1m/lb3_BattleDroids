import droids.Droid;
import droids.combatdroids.CombatDroid;
import droids.medicaldroids.MedicalDroid;

public class Battle {
    public static void oneOnOneBattle(Droid droid1, Droid droid2) {
        while (droid1.isAlive() && droid2.isAlive()) {
            droid1.attack(droid2);

            if (droid2.isAlive()){
                droid2.attack(droid1);
            }
        }

        if (droid1.isAlive()) {
            System.out.println("\n\u001B[32m" + droid1.getName() + " wins!\u001B[0m");
        } else if (droid2.isAlive()) {
            System.out.println("\n" + droid2.getName() + " \u001B[32m wins! \u001B[0m");
        } else {
            System.out.println("\n" + "It's a draw!");
        }


    }

    public static void teamBattle(Droid[] team1, Droid[] team2) {
        int team1TotalDamage = 0;
        int team2TotalDamage = 0;

        for (Droid droid : team1) {
            team1TotalDamage += droid.getDamage();
        }

        for (Droid droid : team2) {
            team2TotalDamage += droid.getDamage();
        }

        while (team1TotalDamage > 0 && team2TotalDamage > 0) {
            for (Droid droid : team2) {
                droid.takeDamage(team1TotalDamage);
                if (droid.getHealth() <= 0) {
                    team2TotalDamage -= droid.getDamage();
                }
            }

            for (Droid droid : team1) {
                droid.takeDamage(team2TotalDamage);
                if (droid.getHealth() <= 0) {
                    team1TotalDamage -= droid.getDamage();
                }
            }
        }

        if (team1TotalDamage > 0) {
            System.out.println("Команда 1 перемогла!");
        } else if (team2TotalDamage > 0) {
            System.out.println("Команда 2 перемогла!");
        } else {
            System.out.println("Нічия!");
        }
    }




}