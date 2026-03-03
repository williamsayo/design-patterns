package state.game;

public enum Actions {
        TRAIN(1),
        MEDITATE(2),
        FIGHT(3),
        DEFAULT(-1);

    private final int value;

    Actions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Actions fromValue(int value) {
        for (Actions action : values()) {
            if (action.value == value) return action;
        }
        return DEFAULT;
    }
}