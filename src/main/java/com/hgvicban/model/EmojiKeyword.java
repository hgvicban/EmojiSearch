package com.hgvicban.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emojikeyword")
public class EmojiKeyword {

    @Id
    @Column(name = "keyword")
    private String keyword;

    @Column(name = "emoji")
    private String emoji;

    protected EmojiKeyword() {
    }

    public EmojiKeyword(String keyword, String emoji) {
        this.keyword = keyword;
        this.emoji = emoji;
    }

    @Override
    public String toString() {
        return "EmojiKeyword{" +
                "keyword='" + keyword + '\'' +
                ", emoji='" + emoji + '\'' +
                '}';
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
