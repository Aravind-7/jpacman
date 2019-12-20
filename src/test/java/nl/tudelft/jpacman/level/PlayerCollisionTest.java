package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PlayerCollisionTest {
    private Player player = mock(Player.class);
    private Pellet pellet = mock(Pellet.class);
    private Ghost ghost = mock(Ghost.class);
    private PointCalculator pointCalculator = new DefaultPointCalculator();
    private PlayerCollisions playerCollisions = new PlayerCollisions(pointCalculator);


/**
 * case: PLayer meets Ghost, Player dies
  */
@Test
void PlayerMeetsGhost() {
    playerCollisions.collide(player, ghost);
    verify(player).setAlive(false);
}


/**
 * case: Player meets Pellet, Player eats Pellet
 */
@Test
void PlayerMeetsPellet(){
    playerCollisions.collide(player,pellet);
    verify(player).addPoints(pellet.getValue());
    verify(pellet).leaveSquare();
    }

/**
 * case: Ghost meets Player, Player dies
  */
@Test
void GhostMeetsPlayer(){
    playerCollisions.collide(ghost,player);
    verify(player).setAlive(false);
}


/**
 * case: Pellet meets Player, Player eats Pellet
 */
@Test
    void PelletMeetsPlayer(){
    playerCollisions.collide(pellet,player);
    verify(player).addPoints(pellet.getValue());
    verify(pellet).leaveSquare();
}

    /**
     * case: Ghost Meets Pellet, no interactions
     */
    @Test
    void GhostMeetsPellet(){
    playerCollisions.collide(ghost,pellet);
    verifyZeroInteractions(pellet);
    verifyZeroInteractions(ghost);
}

/**
 * case:Ghost meets Ghost, no Interactions
 */
@Test
    void GhostMeetsGhost(){
    playerCollisions.collide(ghost,ghost);
    verifyZeroInteractions(ghost);
}

/**
 * case: Pellet meets Pellet, no interactions
 */
@Test
    void PelletMeetsPellet(){
    playerCollisions.collide(pellet,pellet);
    verifyZeroInteractions(pellet);
}
}
