import droids.Droid;

import java.util.Random;


public class Battle {
    public static void oneOnOneBattle(Droid droid1, Droid droid2) {
        StringBuilder battleRecord = new StringBuilder("\nBattle Record 1 vs 1:\n");
        battleRecord.append(droid1.getName()).append(" vs ").append(droid2.getName()).append("\n");

        while (droid1.isAlive() && droid2.isAlive()) {
            battleRecord.append("\n").append(droid1.getName()).append("(").append(droid1.getHealth()).append("HP " +
                    "Damage=").append(droid1.getDamage()).append(")").append(" vs ").append(droid2.getName()).append("(")
                    .append(droid2.getHealth()).append("HP Damage=").append(droid2.getDamage()).append(")");

            droid1.attack(droid2);

            if (droid2.isAlive()){
                droid2.attack(droid1);
            }
        }

        if (droid1.isAlive()) {
            battleRecord.append("\n").append(droid1.getName()).append(" wins!");
            System.out.println("\n\u001B[32m" + droid1.getName() + " wins!\u001B[0m");
        } else if (droid2.isAlive()) {
            battleRecord.append("\n").append(droid2.getName()).append(" wins!");
            System.out.println("\n\u001B[32m" + droid2.getName() + " wins! \u001B[0m");
        } else {
            battleRecord.append("\n" + "It's a draw!");
            System.out.println("\n\u001B[33mIt's a draw!\u001B[0m");
        }
        battleRecord.append("\n--------------------------------------------------");
        BattleRecordSaver.saveBattleRecord(battleRecord);
    }


    public static void teamBattle(Droid[] team1, Droid[] team2) {
        Random random = new Random();

        StringBuilder battleRecord = new StringBuilder("\nBattle Record Team vs Team:\n");

        battleRecord.append("\nTeam 1:").append(team1[0]).append(" та ").append(team1[1]);
        battleRecord.append("\n                   VS");
        battleRecord.append("\nTeam 2:").append(team2[0]).append(" та ").append(team2[1]);

        System.out.println("\nTeam 1:" + team1[0] + " та " + team1[1]);
        System.out.printf("%45sVS", "");
        System.out.println("\nTeam 2:" + team2[0] + " та " + team2[1]);

        int team1Health = calculateTotalHealth(team1);
        int team2Health = calculateTotalHealth(team2);

        while (team1Health > 0 && team2Health > 0) {
            int randomValue1 = random.nextInt(2);
            int randomValue2 = random.nextInt(2);

            if ((team2[randomValue1].isAlive()) && (team1[randomValue2].isAlive())){
                team2[randomValue1].attack(team1[randomValue2]);

                battleRecord.append("\n").append(team2[randomValue1].getName()).append("(").append(team2[randomValue1].getHealth()).append("HP " + "Damage=").append(team2[randomValue1].getDamage()).append(")").append(" vs ").append(team1[randomValue2].getName()).append("(").append(team1[randomValue2].getHealth()).append("HP Damage=").append(team1[randomValue2].getDamage()).append(")");
            }

            if ((team1[randomValue1].isAlive()) && (team2[randomValue2].isAlive())){
                team1[randomValue1].attack(team2[randomValue2]);

                battleRecord.append("\n").append(team1[randomValue1].getName()).append("(").append(team1[randomValue1].getHealth()).append("HP " + "Damage=").append(team1[randomValue1].getDamage()).append(")").append(" vs ").append(team2[randomValue2].getName()).append("(").append(team2[randomValue2].getHealth()).append("HP Damage=").append(team2[randomValue2].getDamage()).append(")");
            }

            team1Health = calculateTotalHealth(team1);
            team2Health = calculateTotalHealth(team2);
        }

        if (team1Health > team2Health) {
            battleRecord.append("\n").append("Team 1 wins!");
            System.out.println("\n\u001B[32mTeam 1 wins!\u001B[0m");
        } else if (team2Health > team1Health) {
            battleRecord.append("\n").append("Team 2 wins!");
            System.out.println("\n\u001B[32mTeam 2 wins!\u001B[0m");
        } else {
            battleRecord.append("\n" + "It's a draw!");
            System.out.println("\n\u001B[33mIt's a draw!\u001B[0m");
        }

        battleRecord.append("\n-------------------------------------------------------------");
        BattleRecordSaver.saveBattleRecord(battleRecord);
    }


    private static int calculateTotalHealth(Droid[] team) {
        int totalHealth = 0;
        for (Droid droid : team) {
            totalHealth += droid.getHealth();
        }
        return totalHealth;
    }
}
