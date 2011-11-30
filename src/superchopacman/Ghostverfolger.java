package superchopacman;

import ch.aplu.jgamegrid.Location.CompassDirection;
import ch.aplu.jgamegrid.Location;

/**
 *
 * @author phillihe
 */
public class Ghostverfolger extends Ghost {

  public Ghostverfolger(Runner runner, Spielfeld feld) {
    super(runner, feld, "sprites/ghostverfolger.png");
    this.runner = runner;
    this.feld = feld;
  }

 
  public CompassDirection verfolger() {
    Location pac = runner.getLocation();
    CompassDirection verfolgungsrichtung = this.getLocation().get4CompassDirectionTo(pac);
    return verfolgungsrichtung;
  }

    
  public void movement1() {
  CompassDirection d= verfolger();
  

    if (canMove(getLocation().getNeighbourLocation(verfolger()))) {
      setDirection(d);
        move();
   
    }
    else {
        movement();
    }
  }


  }