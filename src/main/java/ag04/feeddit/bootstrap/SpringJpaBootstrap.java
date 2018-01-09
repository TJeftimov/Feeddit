package ag04.feeddit.bootstrap;

import ag04.feeddit.entities.Article;
import ag04.feeddit.entities.User;
import ag04.feeddit.services.ArticleService;
import ag04.feeddit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    private ArticleService articleService;
    @Autowired
    public void setArticleService(ArticleService articleService)
    {
        this.articleService = articleService;
    }

    private void loadUsers()
    {
        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("password1");
        userService.saveOrUpdate(user1);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("password2");
        userService.saveOrUpdate(user2);
    }

    private void loadArticles()
    {
        for(int i = 0; i < 100; i++)
        {
            Article article = new Article();
            article.setTitle("Title" + i);
            article.setUrl("Url" + i);
            article.setVotes(0);
            article.setAuthorName("user1");
            article.setAuthorId(1);
            article.setDateCreated(new Date());
            articleService.saveArticle(article);
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        loadUsers();
        loadArticles();
    }
}
