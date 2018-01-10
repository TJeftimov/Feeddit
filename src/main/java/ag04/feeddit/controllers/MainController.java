package ag04.feeddit.controllers;

import ag04.feeddit.entities.Article;
import ag04.feeddit.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController
{
    private ArticleService articleService;
    @Autowired
    public void setArticleService(ArticleService articleService)
    {
        this.articleService = articleService;
    }

    @RequestMapping("/")
    ModelAndView mainFeed(Pageable pageable)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView("mainFeed");
        modelAndView.addObject("articles", articleService.findAllPageable(pageable));
        return modelAndView;
    }

    @RequestMapping(value="downvote", method = RequestMethod.POST)
    public ModelAndView downvote(Article article, Pageable pageable)
    {
        ModelAndView modelAndView = new ModelAndView("mainFeed");
        article.setVotes(article.getVotes() - 1);
        articleService.saveArticle(article);
        modelAndView.addObject("articles", articleService.findAllPageable(pageable));
        return modelAndView;
    }
}
