import droids.Droid;
import droids.combatdroids.CombatDroid;
import droids.medicaldroids.MedicalDroid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Droid> droids = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create a combat droid");
            System.out.println("2. Create a medical droid");

            System.out.println("3. Show the list of created Droids");
            System.out.println("4. Battle 1 vs 1");
            System.out.println("5. Team vs Team");
            System.out.println("6. Save record of the battle");
            System.out.println("7. Play record of the battle");
            System.out.println("8. Exit");

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
                // Логіка бою команда на команду
                case 5 -> {
                }
                // Логіка запису бою у файл
                case 6 -> {
                }
                // Логіка відтворення бою з файлу
                case 7 ->{}

                case 8 -> System.exit(0);

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

        System.out.println("\u001B[32mCombat Droid " + newDroid.getName() + " created.\u001B[0m");

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

        System.out.println("\u001B[32mMedical Droid " + newDroid.getName() + " created.\u001B[0m");

    }

    public static void showDroids(List<Droid> droids) {
        if (droids.isEmpty()) {
            System.out.println("No droids have been created.");
            return;
        }

        System.out.println("List of created Droids:");
        for (Droid droid : droids) {
            System.out.println(droid.getName());
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
//            Battle.oneOnOneBattle((CombatDroid) droid1, (MedicalDroid) droid2);
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

}