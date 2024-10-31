package org.thesalutyt.dedaebutrabi.utils.ftml.converter;


import org.thesalutyt.dedaebutrabi.utils.ftml.objects.FTMLObject;
import org.thesalutyt.dedaebutrabi.utils.ftml.objects.ListObject;
import org.thesalutyt.dedaebutrabi.utils.ftml.objects.ObjectType;

import java.util.List;

public class ObjectConverter {
    public static FTMLObject toFtml(Object object, String name) {
        if (object instanceof Integer) {
            return new FTMLObject(name, Integer.parseInt(object.toString()), ObjectType.Integer);
        } else if (object instanceof Double) {
            return new FTMLObject(name, Double.parseDouble(object.toString()), ObjectType.Double);
        } else if (object instanceof Float) {
            return new FTMLObject(name, Float.parseFloat(object.toString()), ObjectType.Float);
        } else if (object instanceof Boolean) {
            return new FTMLObject(name, Boolean.parseBoolean(object.toString()), ObjectType.Boolean);
        }
        else {
            return new FTMLObject(name, object.toString(), ObjectType.String);
        }
    }

    public static ListObject toFtmlList(Object object, String name) {
        if (!(object instanceof List<?> list)) throw new IllegalArgumentException();

        return ListObject.of(new FTMLObject(name, list.toString(), ObjectType.List));
    }
}
