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
    private static final Map<String, List<String>> inverseEmojiJsonMap = new HashMap<>() {
        {
            put("grinning_face", Collections.singletonList("😀"));
            put("face", Arrays.asList("😀", "😃", "😄"));
            put("smile", Arrays.asList("😀", "😃"));
            put("happy", Arrays.asList("😀", "😃", "😄"));
            put("joy", Arrays.asList("😀", "😃", "😄"));
            put(":D", Arrays.asList("😀", "😃", "😄"));
            put("grin", Collections.singletonList("😀"));
            put("grinning_face_with_big_eyes", Collections.singletonList("😃"));
            put("haha", Arrays.asList("😃", "😄"));
            put("funny", Arrays.asList("😃", "😄"));
            put("grinning_face_with_smiling_eyes", Collections.singletonList("😄"));
            put("laugh", Collections.singletonList("😄"));
            put("like", Collections.singletonList("😄"));
            put(":)", Arrays.asList("😃", "😄"));
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

    @Test
    void parserShouldInverseMap() {
        String filename = "emoji-en-US-subset.json";
        Map<String, List<String>> map = parser.parse(filename);

        Map<String, List<String>> result = parser.reverseMap(map);

        assertEquals(inverseEmojiJsonMap, result);
    }
}