package ch.epfl.cs107.play.game.tutos.area;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.tutos.Tuto2Behaviour;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.window.Window;

public abstract class Tuto2Area extends Area {
	
	private Window window;
	
	@Override
	public boolean begin( Window window, FileSystem fileSystem ) {
		this.window = window;
		if ( super.begin( window, fileSystem ) ) {
			// Set the behavior map
			createArea();
			setBehavior( new Tuto2Behaviour( window, getTitle() ) );
			return true;
		}
		return false;
	}
	
	@Override
	public final float getCameraScaleFactor() {
		return 10.f;
	}
	
	/**
	 * Create the area by adding all its actors
	 * called by the begin method, when the area starts to play
	 */
	protected abstract void createArea();
	
	
}
