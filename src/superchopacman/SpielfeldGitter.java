/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superchopacman;

import ch.aplu.jgamegrid.Location;

/**
 *
 * @author Christian
 */
public class SpielfeldGitter {

  public final static int vKaestchen = 30;
  public final static int hKaestchen = 30;
  public int[][] a = new int[hKaestchen][vKaestchen];

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
        spielfeld.addActor(new Pille(), new Location(spalte,zeile));
        spielfeld.addActor(new Pille(), new Location(29-spalte,30-zeile));
      }
    }
    /*
    for (int i = 0; i < vBier; i++)
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
}
