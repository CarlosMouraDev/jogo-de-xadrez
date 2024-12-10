package boardGame;

public class Board {

    private int rows;
    private int columns;
    private final Piece[][] pieces;

    public Board( int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating Board: there must be at least 1 row and 1 column.");
        }
        this.columns = columns;
        this.rows = rows;
        pieces = new Piece[rows][columns];
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Piece piece(int row , int column) {
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Error creating Piece: there is no such position.");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (!thereIsAPiece(position)) {
            throw new BoardException("Error creating Piece: there is already a piece at the position: " + position);
        }
        pieces[position.getColumn()][position.getRow()] = piece;
        piece.position = position;
    }

    private boolean positionExsists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExsists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Error creating Piece: there is no such position.");
        }
        return piece(position) != null;
    }
}
