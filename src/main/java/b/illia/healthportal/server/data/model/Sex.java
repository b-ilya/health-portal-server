package b.illia.healthportal.server.data.model;

public enum Sex {
    MALE('M'),
    FEMALE('F'),
    OTHER('O');

    private final char code;

    Sex(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Sex fromCode(char code) {
        for (Sex sex : Sex.values()) {
            if (sex.code == code) {
                return sex;
            }
        }
        throw new IllegalArgumentException("Invalid sex code: " + code);
    }
}
