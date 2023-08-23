package ch.epfl.cs107.play.game.tutos.area.tuto1;

import ch.epfl.cs107.play.game.tutos.actor.SimpleGhost;
import ch.epfl.cs107.play.game.tutos.area.SimpleArea;
import ch.epfl.cs107.play.math.Vector;

/**
 * Represents a farm area
 */
public class Ferme extends SimpleArea {
	
	
	private static final String SPRITE_NAME = "ghost.2";
	private static final String VILLAGE_TITLE = "zelda/Ferme";
	private static final Vector SPRITE_POSITION = new Vector( 18, 7 );
	private final SimpleGhost player = new SimpleGhost( SPRITE_POSITION, SPRITE_NAME );
	
	
	/**
	 * Getter for game title
	 * Note: Need to be Override
	 *
	 * @return (String) the game title
	 */
	@Override
	public String getTitle() {
		return VILLAGE_TITLE;
	}
	
	/**
	 * Create the area by adding all its actors
	 * called by the begin method, when the area starts to play
	 */
	@Override
	protected void createArea() {
		// registerActor( player );
	}
}
