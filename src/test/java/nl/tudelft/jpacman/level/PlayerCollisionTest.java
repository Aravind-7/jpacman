package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerCollisionTest {
    private Player player = mock(Player.class);
    private Pellet pellet = mock(Pellet.class);
    private Ghost ghost = mock(Ghost.class);
    private PointCalculator pointCalculator = mock(PointCalculator.class);
    private PlayerCollisions playerCollisions = new PlayerCollisions(pointCalculator);


/**
 * case: PLayer meets Ghost, Player dies
  */
@Test
void PlayerMeetsGhost() {
    playerCollisions.collide(player, ghost);
    verify(player).setAlive(false);
}


}
