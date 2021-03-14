package com.hgvicban.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "emojikeyword")
public class EmojiKeyword {

    @Id
    @Column(name = "keyword")
    private String keyword;

    @ElementCollection
    @CollectionTable(name="emojikeyword_emojis", joinColumns=@JoinColumn(name="emojikeyword_keyword"))
    @Column(name = "emojis")
    private List<String> emojis;

    protected EmojiKeyword() {
    }

    public EmojiKeyword(String keyword, List<String> emojis) {
        this.keyword = keyword;
        this.emojis = emojis;
    }

    @Override
    public String toString() {
        return "EmojiKeyword{" +
                "keyword='" + keyword + '\'' +
                ", emojis='" + emojis + '\'' +
                '}';
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getEmojis() {
        return emojis;
    }

    public void setEmojis(List<String> emoji) {
        this.emojis = emoji;
    }
}
