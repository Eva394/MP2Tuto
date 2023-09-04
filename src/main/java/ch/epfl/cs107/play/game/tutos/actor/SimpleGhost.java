package ch.epfl.cs107.play.game.tutos.actor;

import ch.epfl.cs107.play.game.actor.Entity;
import ch.epfl.cs107.play.game.actor.TextGraphics;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Audio;
import ch.epfl.cs107.play.window.Canvas;

import java.awt.*;

/**
 * Represents an actor that has a graphic representation
 */
public class SimpleGhost extends Entity {
	
	private static final float DELTA = .5f;
	private static final int BASE_HP = 10;
	private float hp;
	private final Sprite sprite;
	private final TextGraphics hpText;
	
	/**
	 * Constructor. Builds an instance of SimpleGhost
	 *
	 * @param position   position of the sprite
	 * @param spriteName name of the sprite
	 */
	public SimpleGhost( Vector position, String spriteName ) {
		super( position );
		sprite = new Sprite( spriteName, 1, 1.f, this );
		strengthen();
		hpText = new TextGraphics( Integer.toString( ( ( int ) hp ) ), 0.4f, Color.BLUE );
		hpText.setParent( this );
		this.hpText.setAnchor( new Vector( -0.3f, 0.1f ) );
	}
	
	
	/**
	 * @return true if {@link #hp} is zero or negative
	 */
	public boolean isWeak() {
		return hp <= 0;
	}
	
	/**
	 * Sets {@link #hp} to {@link #BASE_HP}
	 */
	public void strengthen() {
		hp = BASE_HP;
	}
	
	/**
	 * @param deltaTime elapsed time since last update, in seconds, non-negative
	 */
	@Override
	public void update( float deltaTime ) {
		super.update( deltaTime );
		hp = hp - deltaTime >= 0
		     ? hp - deltaTime
		     : 0;
		hpText.setText( Integer.toString( ( ( int ) hp ) ) );
	}
	
	/**
	 * @param audio (Audio) target, not null
	 */
	@Override
	public void bip( Audio audio ) {
		super.bip( audio );
	}
	
	/**
	 * Renders itself on specified canvas.
	 *
	 * @param canvas target, not null
	 */
	@Override
	public void draw( Canvas canvas ) {
		sprite.draw( canvas );
		hpText.draw( canvas );
	}
	
	/**
	 * Moves the player up
	 */
	public void moveUp() {
		setCurrentPosition( getPosition().add( 0.f, -DELTA ) );
	}
	
	/**
	 * Moves the player down
	 */
	public void moveDown() {
		setCurrentPosition( getPosition().add( 0.f, DELTA ) );
	}
	
	/**
	 * Moves the player right
	 */
	public void moveRight() {
		setCurrentPosition( getPosition().add( DELTA, 0.f ) );
	}
	
	/**
	 * Moves the player left
	 */
	public void moveLeft() {
		setCurrentPosition( getPosition().add( -DELTA, 0.f ) );
	}
}
