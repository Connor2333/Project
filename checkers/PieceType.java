package checkers;

/**
 * This Enumeration is determine the pieces type
* Citation:   https://github.com/AlmasB/FXTutorials/tree/master/src/com/almasb/checkers
 * @author Group 29
 */
public enum PieceType {
    RED(1), WHITE(-1),KING_RED(1);

    final int moveDir;

    PieceType(int moveDir) {
        this.moveDir = moveDir;
    }
}
