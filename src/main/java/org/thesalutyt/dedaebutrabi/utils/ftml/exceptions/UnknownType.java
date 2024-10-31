package org.thesalutyt.dedaebutrabi.utils.ftml.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class UnknownType extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    protected static String str = "[FTMLException::UnknownType] Unknown type of '%TYPE%'";
    protected String type;

    public UnknownType(String unknownType) {
        this.type = unknownType;
    }

    @Override
    public String toString() {
        return str.replace("%TYPE%", type);
    }
}
