package ag04.feeddit.controllers;

import ag04.feeddit.entities.Article;
import ag04.feeddit.services.ArticleService;
import ag04.feeddit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Pageable;


@Controller
public class AddNewArticleController
{
    ArticleService articleService;
    @Autowired
    public void setArticleService(ArticleService articleService)
    {
        this.articleService = articleService;
    }

    UserService userService;
    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    @RequestMapping("/addNewArticle")
    public ModelAndView addNewArticle()
    {
        ModelAndView modelAndView = new ModelAndView("addNewArticle");
        Article article = new Article();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        article.setUserId(userService.findByUsername(auth.getName()).getId());
        article.setVotes(0);
        modelAndView.addObject("article",   article);
        return modelAndView;
    }

    @RequestMapping(value="article", method = RequestMethod.POST)
    public ModelAndView saveArticle(Article article, Pageable pageable)
    {
        articleService.saveArticle(article);
        ModelAndView modelAndView = new ModelAndView("mainFeed");
        modelAndView.addObject("articles", articleService.findAllPageable(pageable));
        return modelAndView;
    }
}
