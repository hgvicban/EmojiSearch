package com.hgvicban.repository;

import com.hgvicban.model.EmojiKeyword;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmojiKeywordRepository extends CrudRepository<EmojiKeyword, String> {
    List<EmojiKeyword> findEmojisByKeywordContaining(String keyword);
}
