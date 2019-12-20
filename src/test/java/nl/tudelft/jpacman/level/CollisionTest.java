package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.npc.Ghost;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public abstract class CollisionTest {
    private Player player = mock(Player.class);
    private Pellet pellet = mock(Pellet.class);
    private Ghost ghost = mock(Ghost.class);


    private CollisionMap collisionMap = null;


    /**
     * @param collisionMap
     *                    this is CollisionMap type
     */
    public void setCollisionMap(CollisionMap collisionMap){
        this.collisionMap = collisionMap;
    }

    /**
     * an Abstract method to set collisionMap
     */
    abstract void setCollisions();

    /**
     * case: PLayer meets Ghost, Player dies
     */
    @Test
    void PlayerMeetsGhost() {
        collisionMap.collide(player, ghost);
        verify(player).setAlive(false);
    }


    /**
     * case: Player meets Pellet, Player eats Pellet
     */
    @Test
    void PlayerMeetsPellet(){
        collisionMap.collide(player,pellet);
        verify(player).addPoints(pellet.getValue());
        verify(pellet).leaveSquare();
    }

    /**
     * case: Ghost meets Player, Player dies
     */
    @Test
    void GhostMeetsPlayer(){
        collisionMap.collide(ghost,player);
        verify(player).setAlive(false);
    }


    /**
     * case: Pellet meets Player, Player eats Pellet
     */
    @Test
    void PelletMeetsPlayer(){
        collisionMap.collide(pellet,player);
        verify(player).addPoints(pellet.getValue());
        verify(pellet).leaveSquare();
    }

    /**
     * case: Ghost Meets Pellet, no interactions
     */
    @Test
    void GhostMeetsPellet(){
        collisionMap.collide(ghost,pellet);
        verifyZeroInteractions(pellet);
        verifyZeroInteractions(ghost);
    }

    /**
     * case:Ghost meets Ghost, no Interactions
     */
    @Test
    void GhostMeetsGhost(){
        collisionMap.collide(ghost,ghost);
        verifyZeroInteractions(ghost);
    }

    /**
     * case: Pellet meets Pellet, no interactions
     */
    @Test
    void PelletMeetsPellet(){
        collisionMap.collide(pellet,pellet);
        verifyZeroInteractions(pellet);
    }
}
