package tictactoe.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tictactoe.game.entity.Game;
import tictactoe.game.entity.Game.PlayerNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
/**
 * The computer player who receives a {@link tictactoe.game.entity.Game} and makes a move.
 */
public class ComputerPlayerService {

    private final GameService gameService;

    @Autowired
    public ComputerPlayerService(final GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * For the given Game, try to make a play.
     * @param game {@link Game} the game state, including who plays next.
     */
    public void takeTurn(Game game) {
        String tileId = null;

        // todo - try to get winning turns

        // todo - try to get blocking turns

        tileId = this.getRandomEmptyTile(game);

        if (tileId != null) {
            this.gameService.takeTurn(game, tileId);
        }
    }

    /**
     * For the game in progress, is there a blocking tile we should play to prevent the oponent winning?
     * @param game {@link Game} the game state, including who plays next.
     * @return nullable {@link String} in the format "{row index}-{column index}".
     */
    String getBlockingTile(Game game) {
        final PlayerNumber playerNumber = game.getNextMove();
        final BoardTile boardTile = gameService.getPlayersBoardTile(playerNumber);

        // todo - try to get blocking turns

        return null;
    }

    /**
     * For the game in progress, is there a winning tile we should play?
     * @param game {@link Game} the game state, including who plays next.
     * @return nullable {@link String} in the format "{row index}-{column index}".
     */
    String getWinningTile(Game game) {

        // todo - try to get winning turns

        return null;
    }

    /**
     * Just return any random empty tile.
     * @param game {@link Game} the game state, including who plays next.
     * @return nullable {@link String} in the format "{row index}-{column index}".
     */
    String getRandomEmptyTile(Game game) {
        final List<List<String>> rows = game.getRows();

        List<String> available = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            List<String> row = rows.get(rowIndex);

            for (int columnIndex = 0; columnIndex < rows.size(); columnIndex++) {
                String tileValue = row.get(columnIndex);
                if (tileValue.isEmpty()) {
                    available.add(rowIndex + "-" + columnIndex);
                }
            }
        }

        if (available.isEmpty()) {
            return null;
        }

        int randomNum = new Random().nextInt(available.size());
        return available.get(randomNum);
    }
}
