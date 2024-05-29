package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.assertj.core.api.Assertions.*;

class BishopBlackTest {
    @Test
    void whenSamePosition() {
        BishopBlack bb = new BishopBlack(Cell.F8);
        Cell result = bb.position();
        assertThat(result).isEqualTo(Cell.F8);
    }

    @Test
    void whenGoodPosition() {
        BishopBlack bb = new BishopBlack(Cell.F8);
        Figure result = bb.copy(Cell.F8);
        assertThat(result.position()).isEqualTo(Cell.F8);
    }

    @Test
    void whenWay() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] result = bb.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result).contains(expected);
    }

    @Test
    void whenDiagonalic() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell dest = Cell.G5;
        boolean result = bb.isDiagonal(bb.position(), dest);
        assertThat(result).isTrue();
    }

    @Test
    void whenNotDiagonalic() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        ImpossibleMoveException ex = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bb.way(Cell.C2);
                });
        assertThat(ex.getMessage()).isEqualTo("Could not move by diagonal from C1 to C2");
    }
}