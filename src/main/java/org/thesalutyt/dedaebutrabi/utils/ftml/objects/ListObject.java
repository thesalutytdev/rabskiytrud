package org.thesalutyt.dedaebutrabi.utils.ftml.objects;

import org.thesalutyt.dedaebutrabi.utils.ftml.interfaces.IObject;

import java.util.Arrays;

public record ListObject(FTMLObject object) implements IObject {
    public Object[] toArray() {
        String[] split = this.object().getValue().toString()
                .strip()
                .replace("[", "")
                .replace("]", "")
                .split(",");
        Object[] array = new Object[split.length];
        for (int i = 0; i < split.length; i++) {
            boolean found = false;

            for (FTMLObject object : FTMLObject.objects) {
                if (object.key().equals(split[i].strip())) {
                    array[i] = object.getValue();
                    found = true;
                    break;
                }
            }

            if (!found) {
                array[i] = split[i].strip();
            }
        }
        return array;
    }

    public static ListObject of(FTMLObject object) {
        return new ListObject(object);
    }

    public String asFtmlString() {
        return key() + ": " + object().getValue().toString();
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public String str() {
        return String.format("ListObject:{key: %s, value: %s, type: %s}", object.key(),
                Arrays.toString(toArray()), object.type());
    }

    @Override
    public String key() {
        return this.object.key();
    }

    @Override
    public Object value() {
        return toArray();
    }
}
