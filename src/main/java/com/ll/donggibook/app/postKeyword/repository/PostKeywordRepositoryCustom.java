package com.ll.donggibook.app.postKeyword.repository;

import com.ll.donggibook.app.postKeyword.entity.PostKeyword;

import java.util.List;

public interface PostKeywordRepositoryCustom {
    List<PostKeyword> getQslAllByAuthorId(Long authorId);
}
