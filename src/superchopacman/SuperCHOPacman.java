package superchopacman;

/**
 *
 * @author Ole Schwiegert
 */
public class SuperCHOPacman {

    public static void main(String[] args) {
        Spielfeld feld = new Spielfeld(1);
        feld.doRun();
        feld.show();
    }
}