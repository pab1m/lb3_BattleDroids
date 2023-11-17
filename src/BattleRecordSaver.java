import java.io.*;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class BattleRecordSaver {
    public static void saveBattleRecord(StringBuilder battleRecord) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("battle_record.txt"));
            writer.append(battleRecord);
            writer.close();

            System.out.println("Battle record saved to 'battle_record.txt'.");
        } catch (IOException e) {
            System.out.println("Error while saving battle record: " + e.getMessage());
        }
    }


    public static void loadAndPlayBattleRecord() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("battle_record.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error while loading battle record: " + e.getMessage());
        }
    }

}
