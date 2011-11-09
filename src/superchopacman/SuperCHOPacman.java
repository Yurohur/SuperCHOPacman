package superchopacman;

import ch.aplu.jgamegrid.Location;
import java.util.ArrayList;

/**
 *
 * @author Ole Schwiegert
 */
public class SuperCHOPacman {
    
    private static ArrayList<Pille> pillen = new ArrayList<Pille>();

    public static void main(String[] args) {
        Spielfeld feld = new Spielfeld();
        pillen.add(new Pille());
        pillen.add(new Pille());
        feld.addActor(pillen.get(0), new Location(7,7));
        feld.addActor(pillen.get(1), new Location(8,9));
        Runner runner = new Runner(pillen, feld);
        feld.addActor(runner, new Location(5,5));
        feld.addKeyListener(runner);
        feld.addActor(new Ghost(runner,feld), new Location (2,2));
        feld.addActor(new Ghost(runner,feld), new Location (11,2));
        feld.addActor(new Ghost(runner,feld), new Location (27,28));
        feld.addActor(new Ghostverfolger(runner,feld), new Location (2,28));
        feld.addActor(new Ghostverfolger(runner, feld), new Location (3,2));
        feld.doRun();
        feld.show();
    }
}