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
     * There are 8 lines in tic tac toe, 3 horizontal, 3 vertical & 2 diagonal. Any of those 8 may win a game.
     * @param rows the rows that represent a game in progress.
     * @return all possible lines of strings.
     */
    public static List<List<String>> getAllLines(List<List<String>> rows) {
        final List<List<String>> lines = new ArrayList<>();

        // Add all rows
        for (int rowIndex = 0; rowIndex < NUMBER_ROWS; rowIndex++) {
            lines.add(rows.get(rowIndex));
        }

        // todo - add all columns


        // todo - add all diagonals

        return lines;
    }
}
