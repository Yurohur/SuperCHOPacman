package superchopacman;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.Location.CompassDirection;
import java.awt.Color;
import ch.aplu.jgamegrid.Location;

/**
 *
 * @author phillihe
 */
public class Ghostverfolger extends Actor {

  private Runner runner;
  private Spielfeld feld;
  private int zaehler = 0;

  public Ghostverfolger(Runner runner, Spielfeld feld) {
    super(false, "sprites/feuer.jpg");
    this.runner = runner;
    this.feld = feld;
  }

  public boolean canMove(Location loc) {
    Color col = getBackground().getColor(loc);
    if (col.equals(Color.black)) {
      return true;
    } else {
      return false;
    }
  }

  public CompassDirection verfolger() {
    Location pac = runner.getLocation();
    CompassDirection verfolgungsrichtung = this.getLocation().get4CompassDirectionTo(pac);
    return verfolgungsrichtung;
  }

  public void movement() {
  CompassDirection d= verfolger();
  setDirection(d);

    if (canMove(getLocation().getNeighbourLocation(verfolger()))) {
      move();

    }
  }

  public void pacmanfressen() {
    Location loc = this.getLocation();
    Location pac = runner.getLocation();
    if (loc.equals(pac)) {
      runner.hurt();

    }
  }

 
 @Override
  public void act() {
    movement();
    zaehler += 1;
    pacmanfressen();
    if (zaehler == 5) {
      zaehler = 0;
    }


  }
}
