package superchopacman;

import ch.aplu.jgamegrid.Location;
/**
 *
 * @author Ole Schwiegert
 */
public class SuperCHOPacman {

    public static void main(String[] args) {
        String path = "sprites/feuer.jpg";
        Spielfeld feld = new Spielfeld(1);
        feld.doRun();
        feld.show();
    }
}