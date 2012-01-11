package superchopacman;

import ch.aplu.jgamegrid.Actor;
import java.awt.Color;
import ch.aplu.jgamegrid.Location;

/**
 *
 * @author Hendrik Phillips
 */
public class Ghost extends Actor {

  protected Runner runner;
  protected Spielfeld feld;
  protected int zaehler = 0;

  public Ghost(Runner runner, Spielfeld feld, String path) {
    super(false, path);
    this.runner = runner;
    this.feld = feld;
  }
/**
   * Überprüft, ob der nächste Pixel in Bewegungsrichtung eine Barriere 
   * oder ein Teil des Labyrints ist-ob sich der Pacman dorthin bewegen darf. 
   * @param loc
   * @return true - false
   */
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

  /**
   * Ruft canMove auf. wenn der Pacman sich bewegen darf,
   * geht er einen Schritt. Wenn er sich nicht bewegen darf, wird die Funktion
   * Richtung neu aufgerufen.
   */

  public void movement() {


    if (canMove(getLocation().getNeighbourLocation(getDirection()))) {
      move();

    }
    else {
        Richtung();
    }
  }

  /**
   * Vergleicht die Positionen vom Ghost und Runner und zieht dem Runner ein Leben ab
   * wenn die Positionen übereinstimmen
   */
  public void pacmanfressen() {
    Location loc = this.getLocation();
    Location pac = runner.getLocation();
    if (loc.equals(pac)) {
      runner.hurt();

    }
  }

  /**
   * Führt den Ghost aus. Erhöht den Zähler um 1. Macht einen Fressversuch
   * Führt die Funktion movement aus.
   */
  
  @Override
  public void act() {
    zaehler += 1;
    pacmanfressen();
    movement();
    if (zaehler == 5) {
      Richtung();
      zaehler = 0;
    }


  }
}