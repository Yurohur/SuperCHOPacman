package superchopacman;

import ch.aplu.jgamegrid.Actor;
import java.awt.Color;
import ch.aplu.jgamegrid.Location;

/**
 *
 * @author phillihe
 */
public class Ghost extends Actor {

  private Runner runner;
  private Spielfeld feld;
  private int zaehler = 0;

  public Ghost(Runner runner, Spielfeld feld) {
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

  /**
   * Berechnet zufällig eine der vier Himmelsrichtungen
   */
  public void Richtung() {
    int random = (int) Math.floor(Math.random() * 4);
    switch (random) {
      case 0:
        setDirection(Location.NORTH);
        break;
      case 1:
        setDirection(Location.EAST);
        break;
      case 2:
        setDirection(Location.SOUTH);
        break;
      case 3:
        setDirection(Location.WEST);
        break;
    }
  }

  

  public void movement() {


    if (canMove(getLocation().getNeighbourLocation(getDirection()))) {
      move();

    }
  }

  /**
   * Vergleicht die Positionen vom Ghost und Runner und zieht dem Runner ein Leben wenn die
   * Positionen übereinstimmen
   */
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
      Richtung();
      zaehler = 0;
    }


  }
}