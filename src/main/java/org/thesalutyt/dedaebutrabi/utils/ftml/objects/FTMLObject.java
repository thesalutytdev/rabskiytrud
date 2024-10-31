package org.thesalutyt.dedaebutrabi.utils.ftml.objects;

import org.thesalutyt.dedaebutrabi.utils.ftml.interfaces.IObject;

import java.util.ArrayList;

public record FTMLObject(String key, Object value, ObjectType type) implements IObject {
    public static final ArrayList<FTMLObject> objects = new ArrayList<>();

    public static FTMLObject fromString(String string) {
        String[] split = string.split(":");
        String key = split[0].strip();
        Object value = split[1].strip();
        ObjectType type = null;

        try {
            for (FTMLObject object : objects) {
                if (object.key().equals(value)) {
                    value = object.value();
                    type = object.type();
                    break;
                }
            }
        } catch (Exception ignored) {}

        if (type == null) {
            type = ObjectType.fromString(split[1].strip());
        }

        value = switch (type) {
            case Integer -> Integer.parseInt(value.toString());
            case Float -> Float.parseFloat(value.toString());
            case Double -> Double.parseDouble(value.toString());
            case Boolean -> Boolean.parseBoolean(value.toString());
            default -> value.toString().strip();
        };

        FTMLObject object = new FTMLObject(key, value, type);

        objects.add(object);

        return object;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String str() {
        return String.format("FTMLObject{key: %s, value: %s, type: %s}", key, value(), type);
    }

    @Override
    public Object value() {
        if (type == ObjectType.List) {
            return ListObject.of(this);
        } else {
            return this.value.toString();
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s", key, value);
    }
}
