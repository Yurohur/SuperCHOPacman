package superchopacman;

import ch.aplu.jgamegrid.Location;
/**
 *
 * @author Ole Schwiegert
 */
public class SuperCHOPacman {

    public static void main(String[] args) {
        String path = "sprites/feuer.jpg";
        Spielfeld feld = new Spielfeld();
        Runner runner = new Runner(feld.getPillen(), feld);
        feld.addActor(runner, new Location(16,12));
        feld.addKeyListener(runner);
        feld.addActor(new Ghost(runner,feld,path), new Location (2,2));
        feld.addActor(new Ghost(runner,feld, path), new Location (11,2));
        feld.addActor(new Ghost(runner,feld, path), new Location (27,28));
        feld.addActor(new Ghostverfolger(runner,feld), new Location (2,28));
        feld.addActor(new Ghostverfolger(runner, feld), new Location (3,2));
        feld.doRun();
        feld.show();
    }
}