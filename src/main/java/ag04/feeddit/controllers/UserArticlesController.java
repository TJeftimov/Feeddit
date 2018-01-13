package ag04.feeddit.controllers;

import ag04.feeddit.entities.Article;
import ag04.feeddit.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserArticlesController
{
    ArticleService articleService;
    @Autowired
    public void setArticleService(ArticleService articleService)
    {
        this.articleService = articleService;
    }

    @RequestMapping("/userArticles")
    public ModelAndView userArticles(Pageable pageable)
    {
        ModelAndView modelAndView = new ModelAndView("userArticles");
        modelAndView.addObject("articles", articleService.findAllPageable(pageable));
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(Article article, Pageable pageable)
    {
        ModelAndView modelAndView = new ModelAndView("userArticles");
        articleService.deleteArticle(article.getId());
        modelAndView.addObject("articles", articleService.findAllPageable(pageable));
        return modelAndView;
    }
}
