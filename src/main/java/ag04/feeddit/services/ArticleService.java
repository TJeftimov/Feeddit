package ag04.feeddit.services;

import ag04.feeddit.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService
{
    Iterable<Article> listAllArticles();
    Article getArticleById(Long id);
    Article saveArticle(Article article);
    void deleteArticle(Long id);
    Page<Article> findAllPageable(Pageable pageable);
}
