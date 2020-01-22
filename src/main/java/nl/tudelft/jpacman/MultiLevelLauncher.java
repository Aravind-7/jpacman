package nl.tudelft.jpacman;

import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.DefaultPointCalculator;

public class MultiLevelLauncher extends Launcher {

    private MultiLevelGame multiGame;
    private String levelMap = DEFAULT_MAP;


    /**
     * This method is to create a new launcher for multilevel game.
     *
     * @return it returns a multiGame.
     */
    @Override
    public MultiLevelGame makeGame() {
        Player player = getPlayerFactory().createPacMan();
        multiGame = new MultiLevelGame(player, new DefaultPointCalculator());
        addLevels();
        return multiGame;
    }

    private void addLevels() {
        addLevel(makeLevel());
        addLevel(makeLevel());
        addLevel(makeLevel());
    }

    private void addLevel(Level newLevel) {
        multiGame.addLevel(newLevel);
    }

    @Override
    public MultiLevelGame getGame() {
        return multiGame;
    }

    public Launcher withMapFile(String fileName) {
        levelMap = fileName;
        return this;

    }
}
