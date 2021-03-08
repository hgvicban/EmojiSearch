package com.hgvicban.parser;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmojiJsonParserTest {

    private final EmojiJsonParser parser = new EmojiJsonParser();
    private static final String emojiJsonString = "{\"\uD83D\uDE00\":[\"grinning_face\",\"face\",\"smile\",\"happy\",\"joy\",\":D\",\"grin\"],\"\uD83D\uDE03\":[\"grinning_face_with_big_eyes\",\"face\",\"happy\",\"joy\",\"haha\",\":D\",\":)\",\"smile\",\"funny\"],\"\uD83D\uDE04\":[\"grinning_face_with_smiling_eyes\",\"face\",\"happy\",\"joy\",\"funny\",\"haha\",\"laugh\",\"like\",\":D\",\":)\"]}";
    private static final Map<String, List<String>> emojiJsonMap = new HashMap<>() {
        {
            put("😀", Arrays.asList("grinning_face","face","smile","happy","joy",":D","grin"));
            put("😃", Arrays.asList("grinning_face_with_big_eyes","face","happy","joy","haha",":D",":)","smile","funny"));
            put("😄", Arrays.asList("grinning_face_with_smiling_eyes","face","happy","joy","funny","haha","laugh","like",":D",":)"));
        }
    };

    @Test
    void parserShouldReadFile() {
        String filename = "emoji-en-US-subset.json";

        String result = parser.readFile(filename);

        assertEquals(emojiJsonString, result);
    }

    @Test
    void parserShouldPopulateMap() {
        String filename = "emoji-en-US-subset.json";

        Map<String, List<String>> result = parser.parse(filename);

        assertEquals(emojiJsonMap, result);
    }
}