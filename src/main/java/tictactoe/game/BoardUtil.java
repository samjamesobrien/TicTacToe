package tictactoe.game;

import java.util.ArrayList;
import java.util.List;

class BoardUtil {

    private static final int NUMBER_ROWS = 3;
    private static final int NUMBER_COLUMNS = 3;

    public static List<List<String>> createEmpty() {
        List<List<String>> rows = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < NUMBER_ROWS; rowIndex++) {
            List<String> row = new ArrayList<>();
            for (int columnIndex = 0; columnIndex < NUMBER_COLUMNS; columnIndex++) {
                row.add(BoardTile.EMPTY.toString());

            }
            rows.add(row);
        }

        return rows;
    }

    /**
     * There are 8 possible lines in tic tac toe, 3 horizontal, 3 vertical & 2 diagonal. Any of those 8 may win a game.
     * @param gameStateAsRows the list of list of strings that represents a game in progress's state. e.g.
     *         [
     *             ["x", "o", ""],
     *             ["x", "o", ""],
     *             ["", "", ""]
     *         ]
     * @return all possible lines of strings through the game board.
     */
    public static List<List<String>> getAllPossibleLines(List<List<String>> gameStateAsRows) {
        final List<List<String>> allPossibleLines = new ArrayList<>();

        // todo - add all rows
        // hint - the gameStateAsRows are already rows, copy & add them to allPossibleLines


        // todo - add all columns
        // hint - we need to construct 3 columns

        // todo - add all diagonals
        // hint - we want top left through bottom right, then top right through bottom left

        return allPossibleLines;
    }
}
