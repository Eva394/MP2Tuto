package ch.epfl.cs107.play.game.tutos;

import ch.epfl.cs107.play.game.areagame.AreaBehavior;
import ch.epfl.cs107.play.game.areagame.Cell;
import ch.epfl.cs107.play.game.areagame.actor.Interactable;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.window.Window;

/**
 * Represents the behaviours of a cell depending on its type
 */
public class Tuto2Behaviour extends AreaBehavior {
	
	/**
	 * Default AreaBehavior Constructor
	 *
	 * @param window (Window): graphic context, not null
	 * @param name   (String): name of the behavior image, not null
	 */
	public Tuto2Behaviour( Window window, String name ) {
		super( window, name );
		int height = getHeight();
		int width = getWidth();
		Tuto2Cell[][] grid = new Tuto2Cell[height][width];
		for ( int col = 0 ; col < height ; col++ ) {
			for ( int row = 0 ; row < width ; row++ ) {
				Tuto2CellType cellType = Tuto2CellType.toType( getRGB( height - 1 - col, row ) );
				Tuto2Cell cell = new Tuto2Cell( row, col, cellType );
				setCell( row, col, cell );
			}
		}
		
	}
	
	/**
	 * Represents the cell types
	 */
	public enum Tuto2CellType {
		/**
		 * default cell type
		 */
		NULL( 0, false ),
		/**
		 * cell type for a wall (black)
		 */
		WALL( -16777216, false ),
		/**
		 * cell type for an impassable (grey)
		 */
		IMPASSABLE( -8750470, false ),
		/**
		 * interactable cell type (yellow)
		 */
		INTERACT( -256, true ),
		/**
		 * cell type for a door (red)
		 */
		DOOR( -195580, true ),
		/**
		 * cell type for the walkable space (white)
		 */
		WALKABLE( -1, true ),
		;
		
		final int type;
		final boolean isWalkable;
		
		Tuto2CellType( int type, boolean isWalkable ) {
			this.type = type;
			this.isWalkable = isWalkable;
		}
		
		private static Tuto2CellType toType( int type ) {
			for ( Tuto2CellType cellType : Tuto2CellType.values() ) {
				if ( cellType.type == type ) {
					return cellType;
				}
				return NULL;
			}
			
			return switch ( type ) {
				case -16777216 -> WALL;
				case -8750470 -> IMPASSABLE;
				case -256 -> INTERACT;
				case -195580 -> DOOR;
				case -1 -> WALKABLE;
				default -> NULL;
			};
		}
		
	}
	
	
	/**
	 * Represents a cell
	 */
	public class Tuto2Cell extends Cell {
		
		private int x;
		private int y;
		private Tuto2CellType cellType;
		
		/**
		 * Constructor. Builds an instance of Tuto2Cell
		 *
		 * @param x        x coordinate of this instance of the cell
		 * @param y        y coordinate of this instance of the cell
		 * @param cellType type of this instance of the cell
		 */
		public Tuto2Cell( int x, int y, Tuto2CellType cellType ) {
			super( x, y );
			this.x = x;
			this.y = y;
			this.cellType = cellType;
		}
		
		/**
		 * @return (boolean): true if this is able to have cell interactions
		 */
		@Override
		public boolean isCellInteractable() {
			return true;
		}
		
		/**
		 * @return (boolean): true if this is able to have view interactions
		 */
		@Override
		public boolean isViewInteractable() {
			return false;
		}
		
		/**
		 * Call directly the interaction on this if accepted
		 *
		 * @param v                 (AreaInteractionVisitor) : the visitor
		 * @param isCellInteraction
		 */
		@Override
		public void acceptInteraction( AreaInteractionVisitor v, boolean isCellInteraction ) {
		}
		
		/**
		 * Indicate if the given Interactable can leave this Cell
		 *
		 * @param entity (Interactable), not null
		 * @return (boolean): true if entity can leave
		 */
		@Override
		protected boolean canLeave( Interactable entity ) {
			return false;
		}
		
		/**
		 * Indicate if the given Interactable can enter this Cell
		 *
		 * @param entity (Interactable), not null
		 * @return (boolean): true if entity can enter
		 */
		@Override
		protected boolean canEnter( Interactable entity ) {
			return false;
		}
	}
	
}
