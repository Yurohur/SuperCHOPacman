/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

  public Ghost(Runner runner, Spielfeld feld) {
    super(false, "sprites/feuer.jpg");
    this.runner = runner;
    this.feld = feld;
  }
  public boolean canMove(Location loc) {
  Color col = getBackground().getColor(loc);
  if(col.equals(Color.blue)){
    return false;
  }
  else{
    return true;
  }
}

  public void pacmanfressen () {
    Location loc = this.getLocation();
    Location pac = runner.getLocation();
    if(loc.equals(pac)){
      runner.removeSelf();
      feld.stopGameThread();
    }
  }

  @Override
  public void act() {
    pacmanfressen();

  }
}




