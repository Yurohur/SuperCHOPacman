package superchopacman;

import ch.aplu.jgamegrid.Location.CompassDirection;
import ch.aplu.jgamegrid.Location;

/**
 *@author phillihe
 */
public class Ghostverfolger extends Ghost {

    public Ghostverfolger(Runner runner, Spielfeld feld) {
        super(runner, feld, "sprites/ghost.gif");
        this.runner = runner;
        this.feld = feld;
    }

    /**
     * Vergleich die Position des Ghostverfolgers it der des Pacmans und gibt 
     * eine Richtung aus. Diese entspricht einer der vier Himmelsrichtungen.
     * @return 
     */
    public CompassDirection verfolger() {
        Location pac = runner.getLocation();
        CompassDirection verfolgungsrichtung = this.getLocation().get4CompassDirectionTo(pac);
        return verfolgungsrichtung;
    }
/**
     * Überschreibt die movement Funktion des Ghosts. Die neue Bewegungsrichtung
     * ist die ausgegebene Richtung der Verfolger Funktion.
     * Wenn der Ghostverfolger sich nicht in die Verfolgerrichtung bewegen kann,
     * wird die movement Funktion des Ghosts aufgerufen -Zufalls Richtung-
     */
    @Override
    public void movement() {
        CompassDirection d = verfolger();


        if (canMove(getLocation().getNeighbourLocation(verfolger()))) {
            setDirection(d);
            move();

        } else {
            super.movement();

        }
    }
}