package org.thesalutyt.dedaebutrabi.utils.ftml;

import org.thesalutyt.dedaebutrabi.utils.ftml.objects.FTMLObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Builder {
    private final File file;
    private final ArrayList<FTMLObject> fileObjects = new ArrayList<>();

    public Builder(File file) {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (!file.isFile()) {
            throw new IllegalArgumentException("File is not a file");
        }

        this.file = file;
    }

    public Builder addObject(FTMLObject object) {
        fileObjects.add(object);
        return this;
    }

    public Builder dump() {
        FTMLObject[] objects = new FTMLObject[fileObjects.size()];
        fileObjects.toArray(objects);
        try {
            File file = this.file;
            FileWriter writer = new FileWriter(file);

            for (FTMLObject object : objects) {
                writer.write(object.toString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return this;
    }

    public boolean delete() {
        return this.file.delete();
    }

    public FTMLObject[] getObjects() {
        return fileObjects.toArray(new FTMLObject[0]);
    }

    public Builder get() {
        return this;
    }

    public File getFile() {
        return file;
    }
}
