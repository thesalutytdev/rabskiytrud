package org.thesalutyt.dedaebutrabi.utils.ftml.objects;

import org.thesalutyt.dedaebutrabi.utils.ftml.exceptions.UnknownType;

public enum ObjectType {
    String,
    Integer,
    Double,
    Float,
    Boolean,
    List;

    public static ObjectType fromString(String value) {
        java.lang.String parse = value.strip();

        if (parse.startsWith("\"") && parse.endsWith("\"")
                || parse.endsWith("'") && parse.startsWith("'")
                || parse.startsWith("`") && parse.endsWith("`")) {
            return ObjectType.String;
        } else if (parse.matches("-?\\d+")) {
            return ObjectType.Integer;
        } else if (parse.matches("-?\\d+\\.?\\d")) {
            return ObjectType.Float;
        } else if (parse.matches("-?\\d+\\.?\\d*")) {
            return ObjectType.Double;
        } else if (parse.equalsIgnoreCase("true") || parse.equalsIgnoreCase("false")) {
            return ObjectType.Boolean;
        } else if (parse.startsWith("[") && parse.endsWith("]")) {
            return ObjectType.List;
        } else {
            throw new UnknownType(parse);
        }
    }
}
