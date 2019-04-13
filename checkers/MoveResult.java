package checkers;

/**
 * This class is determining the moving result
 *Citation: https://github.com/AlmasB/FXTutorials/tree/master/src/com/almasb/checkers
 * @author Group 29
 */
public class MoveResult {

    private MoveType type;
/**
 * get moving type
 * @return type
 */
    public MoveType getType() {
        return type;
    }

    private Piece piece;
/**
 * get a specific piece 
 * @return piece
 */
    public Piece getPiece() {
        return piece;
    }
/**
 * return the result of each move
 * @param type
 */
    public MoveResult(MoveType type) {
        this(type, null);
    }
/**
 * determine the moving result
 * @param type
 * @param piece
 */
    public MoveResult(MoveType type, Piece piece) {
        this.type = type;
        this.piece = piece;
    }
}
