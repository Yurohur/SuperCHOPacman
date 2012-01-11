package superchopacman;

import ch.aplu.jgamegrid.GGBackground;
import ch.aplu.jgamegrid.GameGrid;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Hendrik Phillips, Ole Schwiegert, Christian Fastje
 */
public class Spielfeld extends GameGrid {

    public final static int vKaestchen = 30;
    public final static int hKaestchen = 30;
    private SpielfeldGitter feld;

    public Spielfeld(int auswahl) {
        super(hKaestchen, vKaestchen, 20, Color.white, "sprites/bg.jpg", false);
        setTitle("SuperCHOPacman");
        GGBackground bg = getBg();
        feld = new SpielfeldGitter(this, 1, bg);
    }

  
    public ArrayList<Pille> getPillen() {
        return feld.getPillen();
    }
}