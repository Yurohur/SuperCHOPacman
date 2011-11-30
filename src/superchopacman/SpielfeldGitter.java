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
            Labyrinth =
                    "xxxxxxxxxxxxxxx" + // 0
                    "xxxxxxxxxxxxxxx" + // 1
                    "xx..R.........x" + // 2
                    "xx.xxxx.xxxxx.x" + // 3
                    "xx.xxxx.xxxxx.x" + // 4
                    "xx.xxxx.xxxxx.x" + // 5
                    "xx............." + // 6
                    "xx.xxxx.xx.xxxx" + // 7
                    "xx.xxxx.xx.xxxx" + // 8
                    "xx............x" + // 9
                    "xxxxxxx.xxxxx.x" + // 10
                    "x.....x.xxxxx.x" + // 11
                    "x.xxx.x.xx....." + // 12
                    "x.xxx.x.xx.xxxx" + // 13
                    "x.xxx.x.xx.xxxx" + // 14
                    "xV.........xxxx" + // 15
                    "x.xxx.x.xx.xxxx" + // 16
                    "x.xxx.x.xx.xxxx" + // 17
                    "x.xxx.x.xx....." + // 18
                    "x.....x.xxxxx.x" + // 19
                    "xxxxxxx.xxxxx.x" + // 20
                    "xx............x" + // 21
                    "xx.xxxx.xx.xxxx" + // 22
                    "xx.xxxx.xx.xxxx" + // 23
                    "xx....G........" + // 24
                    "xx.xxxx.xxxxx.x" + // 25
                    "xx.xxxx.xxxxx.x" + // 26
                    "xx.xxxx.xxxxx.x" + // 27
                    "xx............x" + // 28
                    "xxxxxxxxxxxxxxx" + // 29
                    "xxxxxxxxxxxxxxx";  // 30 

        } else if (auswahl == 2) {

            Labyrinth =
                    "xxxxxxxxxxxxxxx" + // 0
                    "x.....x.......x" + // 1
                    "x.xxx...xxxxx.x" + // 2
                    "x.....x.......x" + // 3
                    "xxx.xxxxxxxxxxx" + // 4
                    "x.............." + // 5
                    "x.xx.x.xx.xxxxx" + // 6
                    "x.xx.x.xx.xxxxx" + // 7
                    "x....x.xx......" + // 8
                    "xx.xxx.xx.xxxxx" + // 9
                    "x.........xxxxx" + // 10
                    "x.xx.xxxx.xxxxx" + // 11
                    "x.xx.xxxx......" + // 12
                    "x.xx.xxxxx.xxxx" + // 13
                    "x.xx.xxxxx.xxxx" + // 14
                    "x..........xxxx" + // 15
                    "xx.xxx.xxx.xxxx" + // 16
                    "x....x.xxx.xxxx" + // 17
                    "x.xx.x.xx......" + // 18
                    "x.xx.x.xx.xxxxx" + // 19
                    "x....x....xxxxx" + // 20
                    "xx.xxx.xx.xxxxx" + // 21
                    "xx.xxx.xx......" + // 22
                    "xx.xxx.xxxxxx.x" + // 23
                    "x..........xx.x" + // 24
                    "x.xxxx.xxx.xx.." + // 25
                    "x.xxxx.x......x" + // 26
                    "x.xxxx.x.xxxx.x" + // 27
                    "x.............x" + // 28
                    "xxxxxxxxxxxxxxx" + // 29
                    "xxxxxxxxxxxxxxx";  // 30
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
