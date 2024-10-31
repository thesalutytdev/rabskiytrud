package org.thesalutyt.dedaebutrabi.utils.ftml.parser;

import org.thesalutyt.dedaebutrabi.utils.ftml.objects.FTMLObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>Just a parser for .ftml files.</p>
 * Usage:
 * <blockquote><pre>{@code
 *     FTMLParser.parseFile("your/file/path/and/name.ftml");
 * }</pre></blockquote>
 *
 * <p>Or</p>
 * <blockquote><pre>{@code
 *     FTMLParser.parseFile(new File("your/file/path/and/name.ftml"));
 *}</pre></blockquote>
 *
 * @author TheSALUTYT
 *
 * @version 1.0
 * @since 1.0
 *
 *
 * */
public class FTMLParser {
    public static FTMLObject[] parseFile(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("File name cannot be null");
        }
        if (!fileName.endsWith(".ftml")) {
            throw new IllegalArgumentException("File name must end with .ftml");
        }
        if (!new File(fileName).exists()) {
            throw new IllegalArgumentException("Invalid path. File does not exist");
        }

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            ArrayList<FTMLObject> fileObjects = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (!(line.isEmpty() || line.startsWith("#")
                        || line.startsWith("!") || line.startsWith(" ")
                        || line.startsWith("\t") || line.startsWith("\n"))) {
                    fileObjects.add(parseObject(line));
                }

            }

            return fileObjects.toArray(FTMLObject[]::new);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static FTMLObject[] parseFile(File file) {
        return parseFile(file.getAbsolutePath());
    }

    public static FTMLObject parseObject(String string) {
        return FTMLObject.fromString(string);
    }
}
