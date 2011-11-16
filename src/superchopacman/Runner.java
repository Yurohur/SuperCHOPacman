package superchopacman;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGKeyListener;
import ch.aplu.jgamegrid.Location;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Diese Klasse stellt den "Pacman" oder Runner. Sie kümmert sich
 * um die Bewegung des Pacman und das Fressen der Pillen
 * 
 * @author Ole Schwiegert
 */
public class Runner extends Actor implements GGKeyListener {
    
    private int nGefressen = 0;
    private int lifes = 3;
    private Spielfeld feld;
    private ArrayList<Pille> pillen = new ArrayList<Pille>();
    public int maxPillen = pillen.size()+1;
    
    /**
     * Konstruktor der Klasse Runner. Setzt das Spriteimage und deklariert die
     * pillen
     * 
     * @param pillen Alle Pillen auf dem Spielfeld. Wird benötigt um deren
     * Locations zu ermitteln und sie beim Fressen entfernen zu können.
     */
    public Runner(ArrayList<Pille> pillen, Spielfeld feld) {
        super(false, "sprites/runner.jpg");
        this.pillen = pillen;
        this.feld = feld;
    }

    /**
     * Setzt die neue Richtung(Direction) des Runners beim Pressen einer Pfeiltaste
     * 
     * @param evt Gedrückte Taste
     * @return unwichtig
     */
    @Override
    public boolean keyPressed(KeyEvent evt) {
        switch(evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                if(canMove(getLocation().getNeighbourLocation(Location.SOUTH))) {
                    setDirection(Location.SOUTH);
                }
                break;
            case KeyEvent.VK_UP:
                if(canMove(getLocation().getNeighbourLocation(Location.NORTH))) {
                    setDirection(Location.NORTH);
                }
                break;
            case KeyEvent.VK_LEFT:
                if(canMove(getLocation().getNeighbourLocation(Location.WEST))) {
                    setDirection(Location.WEST);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(canMove(getLocation().getNeighbourLocation(Location.EAST))) {
                    setDirection(Location.EAST);
                }
                break;
        }
        return true;
    }
    
    /**
     * Überprüft, ob sich der Runner bewegen darf.
     * 
     * @param loc Location, auf die sich der Runner begeben will
     * @return erluabt oder nicht erlaubt
     */
    public boolean canMove(Location loc) {
        Color col = getBackground().getColor(loc);
        if (col.equals(Color.black)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public int getnGefressen() {
        return nGefressen;
    }
    
    /**
     * Überprüft, ob der Runner mit einer Pille "kollidiert" ist und "frisst" sie
     * im entsprechenden Fall.
     */
    public void fressVersuch() {
        Location loc = this.getLocation();
        for(int i=0; i<=pillen.size()-1; i++) {
            Location ploc = pillen.get(i).getLocation();
            if(loc.equals(ploc)) {
                pillen.get(i).removeSelf();
                pillen.remove(i);
                nGefressen++;
            }
        }
        
    }
    
    /**
     * Diese Funktion wird vom Ghost aufgerufen, wenn sich Ghost und Runner
     * auf der selben Location befinden.
     */
    public void hurt() {
        lifes -= 1;
        if(lifes<=0) {
            feld.stopGameThread();
        }
    }

    /**
     * -
     * @param evt -
     * @return -
     */
    @Override
    public boolean keyReleased(KeyEvent evt) {
        return true;
    }
    
    /**
     * 
     */
    @Override
    public void act() {
        if(canMove(getLocation().getNeighbourLocation(getDirection()))) {
            setLocation(getLocation().getNeighbourLocation(getDirection()));
        }
        fressVersuch();
        System.out.println("Highscore:"+nGefressen);
        System.out.println("Leben:"+lifes);
    }
    
}
