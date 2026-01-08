package app;
//Lennart war hier gg
import model.Hero;
import model.HTWRoom;
/**
 * @author Puloder
 */
public class EscapeGame {
    private final Hero hero;
    private final HTWRoom[] rooms = new HTWRoom[3];
    private boolean gameRunning = true;
    private boolean gameFinished = false;
    /**
     * @author Puloder
     * beendet das Game.
     */
    public EscapeGame() {
        this.hero = new Hero();
    }
    /**
     * @author Puloder
     * @return gameRunning als Aussage des Status des Games.
     */
    public boolean isGameRunning() {
        return gameRunning;
    }
    
    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }
    /**
     * @author Puloder
     * Prüfung, ob das Game läuft.
     * @return gibt true oder false zurück.
     */
    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }
    /**
     * @author Puloder
     * Weist darufhin, dass das Game begonnen hat.
     */
    public void run() {
        System.out.println("The game has started. Or not?");
    }
    
    public Hero getHero() {
        return hero;
    }
}
