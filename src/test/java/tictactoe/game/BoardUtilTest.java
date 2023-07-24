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
    void getAllLines_Call_ExpectedEightLines() {
        List<List<String>> rows = Arrays.asList(//@formatter:off
                Arrays.asList("", "", ""),
                Arrays.asList("", "", ""),
                Arrays.asList("", "", "")
        );//@formatter:on

        final List<List<String>> allPossibleLines = BoardUtil.getAllPossibleLines(rows);
        assertThat(allPossibleLines).hasSize(8);
    }

    @Test
    void getAllLines_Call_ReturnsCorrectLines() {
        List<List<String>> rows = Arrays.asList(//@formatter:off
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i")
        );//@formatter:on

        final List<List<String>> lines = BoardUtil.getAllPossibleLines(rows);

        // rows
        assertThat(lines.get(0)).containsExactly("a", "b", "c");
        assertThat(lines.get(1)).containsExactly("d", "e", "f");
        assertThat(lines.get(2)).containsExactly("g", "h", "i");

        // columns
        assertThat(lines.get(3)).containsExactly("a", "d", "g");
        assertThat(lines.get(4)).containsExactly("b", "e", "h");
        assertThat(lines.get(5)).containsExactly("g", "h", "i");

        // diagonals
        assertThat(lines.get(6)).containsExactly("a", "e", "i");
        assertThat(lines.get(7)).containsExactly("c", "e", "g");
    }
}
