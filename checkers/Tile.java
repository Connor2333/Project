package checkers;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class is painting the board
 *Citation:  https://github.com/AlmasB/FXTutorials/tree/master/src/com/almasb/checkers
 * @author Group 29
 */
public class Tile extends Rectangle {

    private Piece piece;
/**
 * determine if the box have a piece
 * @return
 */
    public boolean hasPiece() {
        return piece != null;
    }
/**
 * get the existing pieces
 * @return
 */
    public Piece getPiece() {
        return piece;
    }
/**
 * set up pieeces
 * @param piece
 */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
/**
 * setup the background
 * @param light
 * @param x
 * @param y
 */
    public Tile(boolean light, int x, int y) {
        setWidth(CheckersApp.TILE_SIZE);
        setHeight(CheckersApp.TILE_SIZE);

        relocate(x * CheckersApp.TILE_SIZE, y * CheckersApp.TILE_SIZE);

        setFill(light ? Color.valueOf("#c1984a") : Color.valueOf("#853c00"));
    }
}
