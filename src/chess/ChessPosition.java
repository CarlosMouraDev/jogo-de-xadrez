package chess;

import boardGame.Position;

public record ChessPosition(char column, int row) {
    public ChessPosition {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Invalid chess position");
        }
    }

    Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
