package ch.epfl.cs107.play.game.tutos;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.AreaGame;
import ch.epfl.cs107.play.game.tutos.actor.SimpleGhost;
import ch.epfl.cs107.play.game.tutos.area.tuto1.Ferme;
import ch.epfl.cs107.play.game.tutos.area.tuto1.Village;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Button;
import ch.epfl.cs107.play.window.Keyboard;
import ch.epfl.cs107.play.window.Window;

/**
 * Represents the game defined in the tutorial 1
 */
public class Tuto1 extends AreaGame {
	
	private static final Vector STARTING_POSITION = new Vector( 18, 7 );
	private static final String PLAYER_NAME = "ghost.1";
	private static final String GAME_NAME = "Tuto1";
	private static final String FERME = "zelda/Ferme";
	private static final String CURRENT_AREA = FERME;
	private static final String VILLAGE = "zelda/Village";
	private SimpleGhost player;
	
	@Override
	public void end() {
		super.end();
	}
	
	@Override
	public void update( float deltaTime ) {
		super.update( deltaTime );
		
		Keyboard keyboard = getWindow().getKeyboard();
		Button downKey = keyboard.get( Keyboard.UP );
		Button upKey = keyboard.get( Keyboard.DOWN );
		Button rightKey = keyboard.get( Keyboard.RIGHT );
		Button leftKey = keyboard.get( Keyboard.LEFT );
		if ( downKey.isDown() ) {
			player.moveDown();
		}
		if ( upKey.isDown() ) {
			player.moveUp();
		}
		if ( rightKey.isDown() ) {
			player.moveRight();
		}
		if ( leftKey.isDown() ) {
			player.moveLeft();
		}
		
		if ( player.isWeak() ) {
			switchArea();
		}
	}
	
	@Override
	public boolean begin( Window window, FileSystem fileSystem ) {
		if ( super.begin( window, fileSystem ) ) {
			createAreas();
			Area currentArea = setCurrentArea( CURRENT_AREA, true );
			
			player = new SimpleGhost( STARTING_POSITION, PLAYER_NAME );
			currentArea.setViewCandidate( player );
			currentArea.registerActor( player );
			
			return true;
		}
		return false;
	}
	
	/**
	 * Getter for the game frame rate
	 *
	 * @return (int): the desired number of frame per second
	 */
	@Override
	public int getFrameRate() {
		return super.getFrameRate();
	}
	
	/**
	 * Getter for game title
	 * Note: Need to be Override
	 *
	 * @return (String) the game title
	 */
	@Override
	public String getTitle() {
		return GAME_NAME;
	}
	
	/**
	 * Creates the areas
	 */
	private void createAreas() {
		addArea( new Ferme() );
		addArea( new Village() );
	}
	
	private void switchArea() {
		Area currentArea = getCurrentArea();
		currentArea.unregisterActor( player );
		
		switch ( currentArea.getTitle() ) {
			case FERME -> currentArea = setCurrentArea( VILLAGE, true );
			case VILLAGE -> currentArea = setCurrentArea( FERME, true );
			
		}
		currentArea.registerActor( player );
		currentArea.setViewCandidate( player );
		player.strengthen();
	}
	
	
}
