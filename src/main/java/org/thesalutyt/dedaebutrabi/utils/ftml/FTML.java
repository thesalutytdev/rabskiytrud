package org.thesalutyt.dedaebutrabi.utils.ftml;

import org.thesalutyt.dedaebutrabi.utils.ftml.converter.FTMLToJson;
import org.thesalutyt.dedaebutrabi.utils.ftml.objects.FTMLObject;
import org.thesalutyt.dedaebutrabi.utils.ftml.parser.FTMLParser;

public class FTML {
    public static void main(String[] args) {
        FTMLObject[] objects = FTMLParser.parseFile("src/main/resources/test.ftml");
        for (FTMLObject object : objects) {
            System.out.println(object.str());
        }

        System.out.println(FTMLToJson.toJson("src/main/resources/test.ftml"));
    }
}
