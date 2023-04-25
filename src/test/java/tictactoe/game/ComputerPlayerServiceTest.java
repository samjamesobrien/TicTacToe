package tictactoe.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tictactoe.game.entity.Game;
import tictactoe.game.entity.Game.PlayerNumber;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ComputerPlayerServiceTest {

    private ComputerPlayerService computerPlayerService;

    @Mock
    private Game game;

    @Mock
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        computerPlayerService = new ComputerPlayerService(gameService);
        List<List<String>> rows = Arrays.asList(//@formatter:off
                Arrays.asList("", "", ""),
                Arrays.asList("", "", ""),
                Arrays.asList("", "", "")
        );//@formatter:on
        lenient().when(game.getRows()).thenReturn(rows);
    }

    @Test
    void testTakeTurn() {
        final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        computerPlayerService.takeTurn(game);
        verify(gameService).takeTurn(any(), captor.capture());
        final String tileId = captor.getValue();
        assertThat(tileId).isNotNull();
    }

    @Test
    void testGetBlockingTileNoBlockingMove() {
        lenient().when(game.getNextMove()).thenReturn(PlayerNumber.PLAYER_1);
        String blockingTile = computerPlayerService.getBlockingTile(game);
        // There is no blocking move
        assertThat(blockingTile).isNull();
    }

    @Test
    void testGetBlockingTileDiagonalBlockingMove() {
        when(game.getNextMove()).thenReturn(PlayerNumber.PLAYER_1);
        List<List<String>> rows = Arrays.asList(//@formatter:off
                Arrays.asList("o", "", "x"),
                Arrays.asList("", "o", ""),
                Arrays.asList("x", "", "")
        );//@formatter:on
        when(game.getRows()).thenReturn(rows);

        String blockingTile = computerPlayerService.getBlockingTile(game);
        // There is a blocking move at bottom right
        assertThat(blockingTile).isEqualTo("2-2");
    }

    @Test
    void testGetWinningTileNoWinningMove() {
        lenient().when(game.getNextMove()).thenReturn(PlayerNumber.PLAYER_1);
        String winningTile = computerPlayerService.getWinningTile(game);
        // There is no winning move
        assertThat(winningTile).isNull();
    }

    @Test
    void testGetWinningTileDiagonalWinningMove() {
        when(game.getNextMove()).thenReturn(PlayerNumber.PLAYER_1);
        List<List<String>> rows = Arrays.asList(//@formatter:off
                Arrays.asList("", "o", ""),
                Arrays.asList("", "x", ""),
                Arrays.asList("", "o", "x")
        );//@formatter:on
        when(game.getRows()).thenReturn(rows);

        String winningTile = computerPlayerService.getWinningTile(game);
        // There is a winning move at top left
        assertThat(winningTile).isEqualTo("0-0");
    }

    @Test
    void testGetRandomEmptyTile() {
        String tileId = computerPlayerService.getRandomEmptyTile(game);
        assertThat(tileId).isNotNull();
    }

    @Test
    void getRandomAvailableTile_OnlyCenterTileAvailable_PickCenterTile() {
        List<List<String>> rows = Arrays.asList(//@formatter:off
                Arrays.asList("x", "o", "x"),
                Arrays.asList("o", "", "o"),
                Arrays.asList("x", "o", "x")
        );//@formatter:on
        when(game.getRows()).thenReturn(rows);

        String tileId = computerPlayerService.getRandomEmptyTile(game);
        assertThat(tileId).isEqualTo("1-1");
    }

    @Test
    void getRandomAvailableTile_AllTilesTaken_ReturnNull() {
        List<List<String>> rows = Arrays.asList(//@formatter:off
                Arrays.asList("x", "o", "x"),
                Arrays.asList("o", "x", "o"),
                Arrays.asList("x", "o", "x")
        );//@formatter:on
        when(game.getRows()).thenReturn(rows);

        String tileId = computerPlayerService.getRandomEmptyTile(game);
        assertThat(tileId).isNull();
    }
}
