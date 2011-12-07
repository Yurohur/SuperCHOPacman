package superchopacman;

import java.io.*;

/**
 *
 * @author fastjech
 */
public final class LKonstanten {

    public static String Labyrinth1() {
        String Labyrinth1 = "";

        try {
            String zeile;
            StringBuffer puffer = new StringBuffer();
            FileReader filereader = new FileReader("Labyrinth1.txt");
            BufferedReader reader = new BufferedReader(filereader);
            while ((zeile = reader.readLine()) != null) {
                puffer.append(zeile);
            }
            reader.close();
            Labyrinth1 = puffer.toString();
        } catch (Exception leseFehler) {
            // leseFehler.printStackTrace(); 
            throw new RuntimeException("Fehler beim Einlesen der Labyrinth1 Textdatei", leseFehler);
        }
        return Labyrinth1;
    }

    
    public static String Labyrinth2() {
        String Labyrinth2 = "";

        try {
            String zeile;
            StringBuffer puffer = new StringBuffer();
            FileReader filereader = new FileReader("Labyrinth2.txt");
            BufferedReader reader = new BufferedReader(filereader);
            while ((zeile = reader.readLine()) != null) {
                puffer.append(zeile);
            }
            reader.close();
            Labyrinth2 = puffer.toString();
        } catch (Exception leseFehler) {
            // leseFehler.printStackTrace(); 
            throw new RuntimeException("Fehler beim Einlesen der Labyrinth2 Textdatei", leseFehler);
        }
        return Labyrinth2;
    }
}
