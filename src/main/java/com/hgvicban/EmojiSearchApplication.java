package com.hgvicban;

import com.hgvicban.model.EmojiKeyword;
import com.hgvicban.parser.EmojiJsonParser;
import com.hgvicban.repository.EmojiKeywordRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class EmojiSearchApplication {

    public static void main(String[] args) { SpringApplication.run(EmojiSearchApplication.class, args); }

    @Bean
    ApplicationRunner init(EmojiKeywordRepository repository) {

        EmojiJsonParser parser = new EmojiJsonParser();

        String filename = "emoji-en-US-subset.json";
        Map<String, List<String>> emojiJsonMap = parser.parse(filename);
        Map<String, List<String>> keywordMap = parser.groupByKeyword(emojiJsonMap);

        List<EmojiKeyword> data = new ArrayList<>(keywordMap.size());
        for (Map.Entry<String, List<String>> pair : keywordMap.entrySet()) {
            EmojiKeyword emojiKeyword = new EmojiKeyword(pair.getKey(), pair.getValue());
            data.add(emojiKeyword);
        }
        return args -> repository.saveAll(data);
    }

}
