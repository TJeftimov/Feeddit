package ag04.feeddit.services;

import ag04.feeddit.entities.Article;
import ag04.feeddit.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ArticleServiceImpl implements ArticleService
{
    private ArticleRepository articleRepository;
    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository)
    {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article getArticleById(Long id)
    {
        return articleRepository.findOne(id);
    }

    @Override
    public Article saveArticle(Article article)
    {
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id)
    {
        articleRepository.delete(id);
    }

    @Transactional
    @Override
    public Page<Article> findAllPageable(Pageable pageable)
    {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Iterable<Article> listAllArticles()
    {
        return articleRepository.findAll();
    }
}
