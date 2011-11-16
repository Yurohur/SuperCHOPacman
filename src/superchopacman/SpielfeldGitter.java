package superchopacman;

import ch.aplu.jgamegrid.Location;
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

  public SpielfeldGitter(Spielfeld spielfeld) {
   String Labyrinth =
            "xxxxxxxxxxxxxxx" + // 0
            "xxxxxxxxxxxxxxx" + // 1
            "xx............x" + // 2
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
            "x..........xxxx" + // 15
            "x.xxx.x.xx.xxxx" + // 16
            "x.xxx.x.xx.xxxx" + // 17
            "x.xxx.x.xx....." + // 18
            "x.....x.xxxxx.x" + // 19
            "xxxxxxx.xxxxx.x" + // 20
            "xx............x" + // 21
            "xx.xxxx.xx.xxxx" + // 22
            "xx.xxxx.xx.xxxx" + // 23
            "xx............." + // 24
            "xx.xxxx.xxxxx.x" + // 25
            "xx.xxxx.xxxxx.x" + // 26
            "xx.xxxx.xxxxx.x" + // 27
            "xx............x" + // 28
            "xxxxxxxxxxxxxxx" + // 29
            "xxxxxxxxxxxxxxx";  // 30 
       
    
   /* String Labyrinth2 =
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
    */
        



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
      if (c == '.') {
        int zeile = i/15;
        int spalte = i%15;
        Pille ac1 = new Pille();
        Pille ac2 = new Pille();
        spielfeld.addActor(ac1, new Location(spalte,zeile));
        spielfeld.addActor(ac2, new Location(29-spalte,zeile));
        pillen.add(ac1);
        pillen.add(ac2);
      }
    }
    /*
    for (int i = 0; i < vKaestchen; i++)
    for (int k = 0; k < hKaestchen; k++)
    System.out.println(a[i][k]);
     */
  }

  public int getCell(Location location) {
    return a[location.y][location.x];
  }

  private int toInt(char c) {
    if (c == 'x') {
      return 0;
    }
    if (c == '.') {
      return 1;
    }
    return -1;
  }
  
  public ArrayList<Pille> getPillen() {
      return pillen;
  }
}
