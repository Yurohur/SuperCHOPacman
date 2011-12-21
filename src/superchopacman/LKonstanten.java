package superchopacman;

import java.io.*;

/**
 *
 * @author Christian Fastje
 */
public final class LKonstanten {

    /*
     * Die Methode Einlesen liest das Labyrinth aus einer Textdatei. Diese wird dann zeilenweise in einen String geschrieben.
     */
    public static String Einlesen(String Dateiname) {
        String Labyrinth = "";

        try {
            String zeile;
            StringBuffer puffer = new StringBuffer();
            FileReader filereader = new FileReader(Dateiname);
            BufferedReader reader = new BufferedReader(filereader);
            while ((zeile = reader.readLine()) != null) {
                puffer.append(zeile);
            }
            reader.close();
            Labyrinth = puffer.toString();
        } catch (Exception leseFehler) {
            // leseFehler.printStackTrace(); 
            throw new RuntimeException("Fehler beim Einlesen der Labyrinth1 Textdatei", leseFehler);
        }
        return Labyrinth;
    }

    public static String Labyrinth1() {
        return Einlesen("Labyrinth1.txt");
    }

    public static String Labyrinth2() {
        return Einlesen("Labyrinth2.txt");
    }
}
