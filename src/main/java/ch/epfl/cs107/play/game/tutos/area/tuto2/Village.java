package ch.epfl.cs107.play.game.tutos.area.tuto2;

import ch.epfl.cs107.play.game.areagame.actor.Background;
import ch.epfl.cs107.play.game.areagame.actor.Foreground;
import ch.epfl.cs107.play.game.tutos.actor.SimpleGhost;
import ch.epfl.cs107.play.game.tutos.area.Tuto2Area;
import ch.epfl.cs107.play.math.Vector;

/**
 * Represents a village area
 */
public class Village extends Tuto2Area {
	
	private static final String SPRITE_NAME = "ghost.2";
	private static final String VILLAGE_TITLE = "zelda/Village";
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
		registerActor( player );
		registerActor( new Background( this ) );
		registerActor( new Foreground( this ) );
	}
}
