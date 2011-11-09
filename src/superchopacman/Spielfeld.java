package superchopacman;

import ch.aplu.jgamegrid.GGBackground;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Ole Schwiegert
 */
public class Spielfeld extends GameGrid {

    public final static int vKaestchen = 30;
    public final static int hKaestchen = 30;
    private ArrayList<Pille> pillen = new ArrayList<Pille>();
    private SpielfeldGitter feld;

    public Spielfeld() {
        super(hKaestchen, vKaestchen, 20, Color.white, "sprites/bg.jpg", false);
        setTitle("SuperCHOPacman");
        GGBackground bg = getBg();
        drawGrid(bg);
    }

    private void drawGrid(GGBackground bg) {
        feld = new SpielfeldGitter(this);
        for (int y = 0; y < vKaestchen; y++) {
            for (int x = 0; x < hKaestchen; x++) {
                Location location = new Location(x, y);
                int a = feld.getCell(location);
                if (a == 1 || a == 2) {
                    bg.fillCell(location, Color.black);
                }                
            }
        }
    }
    
    public ArrayList<Pille> getPillen() {
        return feld.getPillen();
    }
}