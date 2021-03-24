package com.hgvicban.controller;

import com.hgvicban.model.EmojiKeyword;
import com.hgvicban.repository.EmojiKeywordRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class EmojiKeywordController {

    final EmojiKeywordRepository repository;

    public EmojiKeywordController(EmojiKeywordRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/emojis/{keyword}")
    public List<String> search(@PathVariable String keyword) {
        List<EmojiKeyword> result = repository.findEmojisByKeywordContaining(keyword);
        Set<String> emojis = new HashSet<>();
        for (EmojiKeyword entry : result) {
            List<String> emojisList = entry.getEmojis();
            emojis.addAll(emojisList);
        }
        return new ArrayList<>(emojis);
    }

}
