package com.hgvicban.parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmojiJsonParserTest {

    private final EmojiJsonParser parser = new EmojiJsonParser();

    @Test
    void parserShouldReadFile() {
        String filename = "emoji-en-US-subset.json";

        String result = parser.readFile(filename);

        String emojiJson = "{\"\uD83D\uDE00\":[\"grinning_face\",\"face\",\"smile\",\"happy\",\"joy\",\":D\",\"grin\"],\"\uD83D\uDE03\":[\"grinning_face_with_big_eyes\",\"face\",\"happy\",\"joy\",\"haha\",\":D\",\":)\",\"smile\",\"funny\"],\"\uD83D\uDE04\":[\"grinning_face_with_smiling_eyes\",\"face\",\"happy\",\"joy\",\"funny\",\"haha\",\"laugh\",\"like\",\":D\",\":)\"]}";
        assertEquals(emojiJson, result);
    }
}
