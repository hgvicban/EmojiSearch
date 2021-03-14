package com.hgvicban.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.*;

public class EmojiJsonParser {

    private static final Gson gson = new Gson();

    String readFile (String fileName) {
        StringBuilder result = new StringBuilder();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result.append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return result.toString();
    }

    public Map<String, List<String>> parse(String fileName) {
        String emojiJsonString = readFile(fileName);

        Type typeOfHashMap = new TypeToken<Map<String, List<String>>>(){}.getType();
        return gson.fromJson(emojiJsonString, typeOfHashMap);
    }

    public Map<String, List<String>> groupByKeyword(Map<String, List<String>> inputMap) {

        Map<String, List<String>> result = new HashMap<>();
        for (Map.Entry<String, List<String>> pair : inputMap.entrySet()) {

            List<String> wordList = pair.getValue();
            for (String word : wordList) {
                if (result.containsKey(word)) {
                    result.get(word).add(pair.getKey());
                } else {
                    List<String> tmpList = new ArrayList<>();
                    tmpList.add(pair.getKey());
                    result.put(word, tmpList);
                }
            }
        }

        return result;
    }

}