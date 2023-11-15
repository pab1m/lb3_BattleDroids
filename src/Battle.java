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
            System.out.println("\n\u001B[32m" + droid2.getName() + " wins! \u001B[0m");
        } else {
            System.out.println("\n" + "It's a draw!");
        }

    }


    public static void teamBattle(Droid[] team1, Droid[] team2) {
        int team1TotalDamage = calculateTotalDamage(team1);
        System.out.println("\nteam1TotalDamage" + team1TotalDamage);
        System.out.println(team1[0] + " " + team1[1]);
        int team2TotalDamage = calculateTotalDamage(team2);

        int team1Health = calculateTotalHealth(team1);
        System.out.println("\nteam1Health" + team1Health);

        int team2Health = calculateTotalHealth(team2);

        while (team1Health > 0 && team2Health > 0) {
            int team1TurnDamage = calculateTurnDamage(team1);
            System.out.println("\nteam1TurnDamage" + team1TurnDamage);

            int team2TurnDamage = calculateTurnDamage(team2);

            // Визначаємо, яка команда атакує у поточному ході
            if (team1TurnDamage >= team2TurnDamage) {
                team1Health -= team2TurnDamage;
                reduceHealth(team1, team2TurnDamage);
            } else {
                team2Health -= team1TurnDamage;
                reduceHealth(team2, team1TurnDamage);
            }
        }

        if (team1Health > team2Health) {
            System.out.println("Team 1 wins!");
        } else if (team2Health > team1Health) {
            System.out.println("Team 2 wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private static int calculateTotalDamage(Droid[] team) {
        int totalDamage = 0;
        for (Droid droid : team) {
            totalDamage += droid.getDamage();
        }
        return totalDamage;
    }

    private static int calculateTotalHealth(Droid[] team) {
        int totalHealth = 0;
        for (Droid droid : team) {
            totalHealth += droid.getHealth();
        }
        return totalHealth;
    }

    private static int calculateTurnDamage(Droid[] team) {
        int turnDamage = 0;
        for (Droid droid : team) {
            if (droid.isAlive()) {
                turnDamage += droid.getDamage();
            }
        }
        return turnDamage;
    }

    private static void reduceHealth(Droid[] team, int damage) {
        for (Droid droid : team) {
            if (droid.isAlive()) {
                droid.takeDamage(damage);
            }
        }
    }


//    public static void teamBattle(Droid[] team1, Droid[] team2) {
//        int team1TotalDamage = 0;
//        int team2TotalDamage = 0;
//
//        for (Droid droid : team1) {
//            team1TotalDamage += droid.getDamage();
//        }
//
//        for (Droid droid : team2) {
//            team2TotalDamage += droid.getDamage();
//        }
//
//        while (team1TotalDamage > 0 && team2TotalDamage > 0) {
//            for (Droid droid : team2) {
//                droid.takeDamage(team1TotalDamage);
//                if (!droid.isAlive()) {
//                    team2TotalDamage -= droid.getDamage();
//                }
//            }
//
//            for (Droid droid : team1) {
//                droid.takeDamage(team2TotalDamage);
//                if (!droid.isAlive()) {
//                    team1TotalDamage -= droid.getDamage();
//                }
//            }
//        }
//
//        if (team1TotalDamage > 0) {
//            System.out.println("Команда 1 перемогла!");
//        } else if (team2TotalDamage > 0) {
//            System.out.println("Команда 2 перемогла!");
//        } else {
//            System.out.println("Нічия!");
//        }
//    }




}