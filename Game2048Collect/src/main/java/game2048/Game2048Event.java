package game2048;

public enum Game2048Event {
    UP, DOWN, LEFT, RIGHT;

    public Game2048 buildNewGame2048StateOnKeyEvent(Game2048 game2048) {
        switch(this) {
            case UP:
                return game2048.handleUpEvent().getUpdatedGame2048();
            case DOWN:
                return game2048.handleDownEvent().getUpdatedGame2048();
            case RIGHT:
                return game2048.handleRightEvent().getUpdatedGame2048();
            case LEFT:
                return game2048.handleLeftEvent().getUpdatedGame2048();
            default:
                return null;
        }
    }

}
