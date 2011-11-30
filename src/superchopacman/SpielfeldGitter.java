package superchopacman;

import ch.aplu.jgamegrid.GGBackground;
import ch.aplu.jgamegrid.Location;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class SpielfeldGitter {

    public final static int vKaestchen = 30;
    public final static int hKaestchen = 30;
    public int[][] a = new int[hKaestchen][vKaestchen];
    private ArrayList<Pille> pillen = new ArrayList<Pille>();
    private String Labyrinth;
    private Runner runner;

    public SpielfeldGitter(Spielfeld spielfeld, int auswahl, GGBackground bg) {


        if (auswahl == 1) {
            Labyrinth = LKonstanten.Labyrinth1();                    
        } 
        else if (auswahl == 2) {
            Labyrinth = LKonstanten.Labyrinth2();                 
        }




        //Konvertiert String in ArrayList
        for (int i = 0; i < vKaestchen; i++) {
            for (int k = 0; k < hKaestchen / 2; k++) {
                a[i][k] = toInt(Labyrinth.charAt(15 * i + k));
            }
            for (int k = hKaestchen / 2; k < hKaestchen; k++) {
                a[i][k] = toInt(Labyrinth.charAt(15 * i + (29 - k)));
            }
        }        
        for (int i = 0; i < Labyrinth.length(); i++) {
            char c = Labyrinth.charAt(i);
            int zeile = i / 15;
            int spalte = i % 15;
            //Fügt Pillen ein
            if (c == '.' || c == 'G' || c == 'V') {
                Pille ac1 = new Pille();
                Pille ac2 = new Pille();
                spielfeld.addActor(ac1, new Location(spalte, zeile));
                spielfeld.addActor(ac2, new Location(29 - spalte, zeile));
                pillen.add(ac1);
                pillen.add(ac2);
            }
            //Fügt den Runner ein
            if (c == 'R') {
                Pille p = new Pille();
                pillen.add(p);
                runner = new Runner(pillen, spielfeld);
                spielfeld.addKeyListener(runner);
                spielfeld.addActor(runner, new Location(spalte, zeile));
                spielfeld.addActor(p, new Location(29 - spalte, zeile));
            }
            //Fügt den zufällig laufenden Ghost ein
            if (c == 'G') {
                spielfeld.addActor(new Ghost(runner, spielfeld, "sprites/feuer.jpg"), new Location(spalte, zeile));
                spielfeld.addActor(new Ghost(runner, spielfeld, "sprites/feuer.jpg"), new Location(29 - spalte, zeile));
            }
            if (c == 'V') {
                spielfeld.addActor(new Ghostverfolger(runner, spielfeld), new Location(spalte, zeile));
                spielfeld.addActor(new Ghostverfolger(runner, spielfeld), new Location(29 - spalte, zeile));
            }
        }

        //Malt den schwarzen Boden
        for (int y = 0; y < vKaestchen; y++) {
            for (int x = 0; x < hKaestchen; x++) {
                Location location = new Location(x, y);
                int cell = getCell(location);
                if (cell == 1 || cell == 2 || cell == 3 || cell == 4) {
                    bg.fillCell(location, Color.black);
                }
            }
        }
    }

    private int toInt(char c) {
        if (c == 'x') {
            return 0;
        }
        if (c == '.') {
            return 1;
        }
        if (c == 'R') {
            return 2;
        }
        if (c == 'G') {
            return 3;
        }
        if (c == 'V') {
            return 4;
        }
        return -1;
    }

    public final int getCell(Location location) {
        return a[location.y][location.x];
    }

    public ArrayList<Pille> getPillen() {
        return pillen;
    }
}
