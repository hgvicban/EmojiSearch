package com.hgvicban.controller;

import com.hgvicban.repository.EmojiKeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmojiKeywordController {

    @Autowired
    EmojiKeywordRepository repository;

    @RequestMapping("/search/{keyword}")
    public String search(@PathVariable String keyword){
        return "Hello world!";
    }
}
