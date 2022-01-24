package playgame;

import javalib.worldimages.Posn;
import models.game2048.Game2048;
import models.game2048.Scoreboard;
import models.grid2048.Grid2048;
import models.square.EmptySquare;
import models.square.Square;
import models.square.Tile;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayGameTest {

    Square[][] squareArrayGameOver, squareArrayGameContinuesWithUpOrLeft, squareArrayGameContinuesWithDownOrRight;
    Game2048 game2048GameOver, game2048GameContinuesWithUpOrLeft, game2048GameContinuesWithDownOrRight;
    PlayGame gameOver, gameContinuesWithUpOrLeft, gameContinuesWithDownOrRight;

    void initData() {
        squareArrayGameOver = new Square[][]{
                new Square[]{
                        new Tile(4, new Posn(0, 0)),
                        new Tile(2, new Posn(0, 1)),
                        new Tile(4, new Posn(0, 2)),
                        new Tile(2, new Posn(0, 3))},
                new Square[]{
                        new Tile(2, new Posn(1, 0)),
                        new Tile(4, new Posn(1, 1)),
                        new Tile(2, new Posn(1, 2)),
                        new Tile(4, new Posn(1, 3))},
                new Square[]{
                        new Tile(4, new Posn(2, 0)),
                        new Tile(2, new Posn(2, 1)),
                        new Tile(4, new Posn(2, 2)),
                        new Tile(2, new Posn(2, 3))},
                new Square[]{
                        new Tile(2, new Posn(3, 0)),
                        new Tile(4, new Posn(3, 1)),
                        new Tile(2, new Posn(3, 2)),
                        new Tile(4, new Posn(3, 3))}
        };
        squareArrayGameContinuesWithUpOrLeft = new Square[][]{
                new Square[]{
                        new EmptySquare(new Posn(0, 0)),
                        new Tile(2, new Posn(0, 1)),
                        new Tile(4, new Posn(0, 2)),
                        new Tile(2, new Posn(0, 3))},
                new Square[]{
                        new Tile(2, new Posn(1, 0)),
                        new Tile(4, new Posn(1, 1)),
                        new Tile(2, new Posn(1, 2)),
                        new Tile(4, new Posn(1, 3))},
                new Square[]{
                        new Tile(4, new Posn(2, 0)),
                        new Tile(2, new Posn(2, 1)),
                        new Tile(4, new Posn(2, 2)),
                        new Tile(2, new Posn(2, 3))},
                new Square[]{
                        new Tile(2, new Posn(3, 0)),
                        new Tile(4, new Posn(3, 1)),
                        new Tile(2, new Posn(3, 2)),
                        new Tile(4, new Posn(3, 3))}
        };
        squareArrayGameContinuesWithDownOrRight = new Square[][]{
                new Square[]{
                        new Tile(4, new Posn(0, 0)),
                        new Tile(2, new Posn(0, 1)),
                        new Tile(4, new Posn(0, 2)),
                        new Tile(2, new Posn(0, 3))},
                new Square[]{
                        new Tile(2, new Posn(1, 0)),
                        new Tile(4, new Posn(1, 1)),
                        new Tile(2, new Posn(1, 2)),
                        new Tile(4, new Posn(1, 3))},
                new Square[]{
                        new Tile(4, new Posn(2, 0)),
                        new Tile(2, new Posn(2, 1)),
                        new Tile(4, new Posn(2, 2)),
                        new Tile(2, new Posn(2, 3))},
                new Square[]{
                        new Tile(2, new Posn(3, 0)),
                        new Tile(4, new Posn(3, 1)),
                        new Tile(2, new Posn(3, 2)),
                        new EmptySquare(new Posn(3, 3))}
        };

        game2048GameOver = new Game2048 (new Grid2048(squareArrayGameOver), new Scoreboard(0));
        game2048GameContinuesWithUpOrLeft = new Game2048(new Grid2048(squareArrayGameContinuesWithUpOrLeft), new Scoreboard(0));
        game2048GameContinuesWithDownOrRight = new Game2048(new Grid2048(squareArrayGameContinuesWithDownOrRight), new Scoreboard(0));

        gameOver = new PlayGame(game2048GameOver);
        gameContinuesWithUpOrLeft = new PlayGame(game2048GameContinuesWithUpOrLeft);
        gameContinuesWithDownOrRight = new PlayGame(game2048GameContinuesWithDownOrRight);

    }

    @Test
    public void itComparesEachAvailableKeyEventGrid2048StateForGameOverCondition() {
        this.initData();
        assertThat(gameOver.isGameOver()).isTrue();
        assertThat(gameContinuesWithUpOrLeft.isGameOver()).isFalse();
        assertThat(gameContinuesWithDownOrRight.isGameOver()).isFalse();
    }
}
