package org.thesalutyt.dedaebutrabi.utils.ftml.converter;

import org.thesalutyt.dedaebutrabi.utils.ftml.objects.FTMLObject;
import org.thesalutyt.dedaebutrabi.utils.ftml.objects.ListObject;
import org.thesalutyt.dedaebutrabi.utils.ftml.parser.FTMLParser;

public class FTMLToJson {
    public static String toJson(FTMLObject object) {
        return String.format("\"%s\": %s", object.key(), object.value());
    }

    public static String toJson(ListObject object) {
        StringBuilder sb = new StringBuilder();

        sb.append("\"").append(object.key()).append("\": [");
        for (Object o : object.toArray()) {
            sb.append(o.toString());
            sb.append(", ");
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public static String toJson(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (FTMLObject object : FTMLParser.parseFile(path)) {
            sb.append(toJson(object));
            sb.append(", ");
        }

        sb.deleteCharAt(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }
}
