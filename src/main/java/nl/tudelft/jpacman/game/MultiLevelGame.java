package nl.tudelft.jpacman.game;

import com.google.common.collect.ImmutableList;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;

import java.util.LinkedList;
import java.util.List;

public class MultiLevelGame extends Game {


    private final Player player;
    private List<Level> levels;
    private int levelnumber =0 ;

    public MultiLevelGame(Player player, PointCalculator pointCalculator) {

        super(pointCalculator);
        this.player = player;
        levels = new LinkedList<Level>();
    }


    public void addLevel(Level level) {
        levels.add(level);
    }



    @Override
    public Level getLevel() {
        return levels.get(levelnumber);

    }
    @Override
    public void levelWon(){
        this.levelnumber++;
    }


    @Override
    public List<Player> getPlayers() {
        return ImmutableList.of(player);
    }

    public int getLevelnumber(){
        return levelnumber;
    }

    public int levelsleft(){
        return levels.size() -1;
    }
}


