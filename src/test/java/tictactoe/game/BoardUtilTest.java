package tictactoe.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BoardUtilTest {

    @Test
    void createEmpty_Call_Empty3x3Board() {
        List<List<String>> rows = BoardUtil.createEmpty();
        assertThat(rows).hasSize(3);
        assertThat(rows.get(0)).hasSize(3).containsExactly("", "", "");
        assertThat(rows.get(1)).hasSize(3).containsExactly("", "", "");
        assertThat(rows.get(2)).hasSize(3).containsExactly("", "", "");
    }

    @Test
    void getAllLines_Call_ReturnsCorrectLines() {
        List<List<String>> gameStateAsRows = Arrays.asList(//@formatter:off
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i")
        );//@formatter:on

        final List<List<String>> allPossibleLines = BoardUtil.getAllPossibleLines(gameStateAsRows);

        assertThat(allPossibleLines).isEqualTo(Arrays.asList(//@formatter:off
                // rows
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i"),
                // columns
                Arrays.asList("a", "d", "g"),
                Arrays.asList("b", "e", "h"),
                Arrays.asList("c", "f", "i"),
                // diagonals
                Arrays.asList("a", "e", "i"),
                Arrays.asList("c", "e", "g")
        ));//@formatter:on
    }
}
