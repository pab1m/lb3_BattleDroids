import droids.Droid;
import droids.combatdroids.CombatDroid;
import droids.medicaldroids.MedicalDroid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        ArrayList<Droid> droids = new ArrayList<>();
        ArrayList<String> battleRecord = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create a combat droid");
            System.out.println("2. Create a medical droid");
            System.out.println("3. Show the list of created Droids");
            System.out.println("4. Battle 1 vs 1");
            System.out.println("5. Team vs Team");
            System.out.println("6. Play record of the battle");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    createCombatDroid(droids, scanner);
                }

                case 2 -> {
                    createMedicalDroid(droids, scanner);
                }

                case 3 -> {
                    showDroids(droids);
                }

                case 4 -> {
                    oneOnOneBattle(droids, scanner);
                }

                case 5 -> {
                    teamBattle(droids, scanner);
                }

                case 6 -> {
                    BattleRecordSaver.loadAndPlayBattleRecord();
                }

                case 7 -> System.exit(0);

                default -> System.out.println("Incorrect option selection. Try again.");
            }
        }
    }

    private static void createCombatDroid(List<Droid> droids, Scanner scanner) {
        System.out.println("Enter Droid name:");
        String name = scanner.next();

        System.out.println("Enter Droid health:");
        int health = scanner.nextInt();

        System.out.println("Enter Droid damage:");
        int damage = scanner.nextInt();

        System.out.println("Enter Droid armor:");
        int armor = scanner.nextInt();

        CombatDroid newDroid = new CombatDroid();

        newDroid.setName(name);
        newDroid.setHealth(health);
        newDroid.setDamage(damage);
        newDroid.setArmor(armor);

        droids.add(newDroid);

        System.out.println("\u001B[32mCombat Droid " + '"' + newDroid.getName() + '"' + " created.\u001B[0m");

    }

    private static void createMedicalDroid(List<Droid> droids, Scanner scanner) {
        System.out.println("Enter Droid name:");
        String name = scanner.next();

        System.out.println("Enter Droid health:");
        int health = scanner.nextInt();

        System.out.println("Enter Droid damage:");
        int damage = scanner.nextInt();

        System.out.println("Enter Droid healing power:");
        int healingPower = scanner.nextInt();

        MedicalDroid newDroid = new MedicalDroid();
        newDroid.setName(name);
        newDroid.setHealth(health);
        newDroid.setDamage(damage);
        newDroid.setHealingPower(healingPower);
        droids.add(newDroid);

        System.out.println("\u001B[32mMedical Droid " + '"' + newDroid.getName() + '"' + " created.\u001B[0m");

    }

    public static void showDroids(List<Droid> droids) {
        if (droids.isEmpty()) {
            System.out.println("No droids have been created.");
            return;
        }

        System.out.println("\nList of created Droids:");
        for (Droid droid : droids) {
            System.out.println(droid.getName() + droid);
        }
    }

    private static void oneOnOneBattle(List<Droid> droids, Scanner scanner) {
        if (droids.size() < 2) {
            System.out.println("Must have at least 2 droids for battle.");
            return;
        }

        System.out.println("Select two droids to battle:");

        showDroids(droids);
        System.out.println("\nEnter the name of the first droid:");
        String name1 = scanner.next();
        Droid droid1 = findDroidByName(droids, name1);

        System.out.println("Enter the name of the second droid:");
        String name2 = scanner.next();
        Droid droid2 = findDroidByName(droids, name2);

        if (droid1 != null && droid2 != null) {
            Battle.oneOnOneBattle(droid1, droid2);
        } else {
            System.out.println("No droid found with that name.");
        }
    }

    private static Droid findDroidByName(List<Droid> droids, String name) {
        for (Droid droid : droids) {
            if (droid.getName().equals(name)) {
                return droid;
            }
        }
        return null;
    }

    private static void teamBattle(List<Droid> droids, Scanner scanner) {
        if (droids.size() < 4) {
            System.out.println("Must have at least 4 droids (2 on each team) for a team battle.");
            return;
        }

        List<Droid> team1 = new ArrayList<>();
        List<Droid> team2 = new ArrayList<>();

        System.out.println("Select droids for Team 1:");
        selectDroidsForTeam(droids, team1, scanner);

        System.out.println("Select droids for Team 2:");
        selectDroidsForTeam(droids, team2, scanner);

        Battle.teamBattle(team1.toArray(new Droid[0]), team2.toArray(new Droid[0]));
    }

    private static void selectDroidsForTeam(List<Droid> droids, List<Droid> team, Scanner scanner) {
        int numDroids = 2;
        System.out.println("Select " + numDroids + " droids for the team:");

        showDroids(droids);

        for (int i = 0; i < numDroids; i++) {
            System.out.println("Enter the name of droid " + (i + 1) + ":");
            String name = scanner.next();
            Droid selectedDroid = findDroidByName(droids, name);

            if (selectedDroid != null) {
                team.add(selectedDroid);
            } else {
                System.out.println("No droid found with that name.");
                i--;
            }
        }
    }

}