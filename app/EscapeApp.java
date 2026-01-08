package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
/**
 * @author Puloder
 */
public class EscapeApp {

    public static final String SAVE_FILE_NAME = "save";
    private EscapeGame game;
    private boolean gameRunning = true;

    public static void main(String[] args) {
        System.out.println("Welcome to the HTW escape");
        System.out.println("========================================\n");

        EscapeApp app = new EscapeApp();

        while (true) {
            app.showMainMenu();
            String choice = app.readUserInput();
            app.handleUserInput(choice);
            System.out.println("====================");
        }
    }
    /**
     * @author Puloder
     * Zeigt das Startmenü
     */
    private void showMainMenu() {
        System.out.println("You're in the main menu");
        System.out.println("What do you want to do next?");
        System.out.println("(1) Spiel Starten");
        System.out.println("(2) Spiel fortsetzen (nur anzeigen, wenn ein Spiel gestartet worden ist)");
        System.out.println("(3) Spiel laden (nur anzeigen, wenn ein gespeichertes Spiel vorhanden ist)");
        System.out.println("(4) Spiel speichern (nur anzeigen, wenn ein Spiel gestartet worden ist)");
        System.out.println("(5) Spiel löschen (nur anzeigen, wenn ein gespeichertes Spiel vorhanden ist)");
        System.out.println("(6) Programm beenden");
        System.out.println("(7) Regelwerk (Optional)");
        System.out.println("Please choose a number between 1 and 6: ");
    }
    /**
     * @author Puloder
     * @param userInput
     * Liest einen Input des Users und gibt ihn zurück 
     * @return userIntut 
     */
    private String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        // TBD
        return userInput;
    }
    /**
     * @author Puloder
     * @param input
     * wertet den userInput aus.
     */
    private void handleUserInput(String input) {
        switch (input) {
            case "1":
                this.startGame();
                break;
            case "2":
                break;
            // ...
            case "6":
                break;
            default:
                System.out.println("Invalid input. Please choose a correct number between 1 and 6");
                break;
        }
    }
    /**
     * @author Puloder
     * Startet ein neues Game.
     */
    private void startGame() {
        this.game = new EscapeGame();
        resumeGame();
    }
    /**
     * @author Puloder
     * Setzt ein Game fort.
     */
    private void resumeGame() {
        this.game.setGameRunning(true);
        this.game.run();
    }
    /**
     * @author Puloder
     * Löscht die ein Game, sofern es existiert.
     */
    private void deleteGame() {
        if (new File(SAVE_FILE_NAME).delete()) {
            System.out.println("Game deleted!");
        }
    }
    /**
     * @author Puloder
     * Speichert einen Fortschritt des Games in einer Datei.
     */
    private void saveGame() {
        try (FileOutputStream fos = new FileOutputStream(SAVE_FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
            oos.flush();
        } catch (Exception ex) {
            System.err.println("Something went wrong while saving the game: " + ex.getMessage());
            return;
        }
        System.out.println("Game saved!");
    }
    /**
     * @author Puloder
     * Lädt ein gespeichertes Game
     */
    private void loadGame() {
        try (FileInputStream fis = new FileInputStream(SAVE_FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.game = (EscapeGame) ois.readObject();
            System.out.println("Game loaded!");
        } catch (Exception ex) {
            System.err.println("Something went wrong while loading the game: " + ex.getMessage());
        }
    }
    /**
     * @author Puloder
     * Prüft, ob ein Game läuft.
     * @return game als Aussage über des Status des Games.
     */
    private boolean isGameRunning() {
        return game != null;
    }
    /**
     * @author Puloder
     * Prüft, ob ein Game abgeschlossen ist. 
     * @return game als Aussage über den Status des Games
     */
    private boolean isGameFinished() {
        return game != null && game.isGameFinished();
    }
    /**
     * @author Puloder
     * Prüft, ob ein Game gespeichert wurde
     * @return True oder False als Aussage über den Status der Speicherung.
     */
    private boolean hasSavedGame() {
        return new File(SAVE_FILE_NAME).exists();
    }

}
