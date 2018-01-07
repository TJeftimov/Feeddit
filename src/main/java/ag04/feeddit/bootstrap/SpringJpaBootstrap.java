package ag04.feeddit.bootstrap;

import ag04.feeddit.entities.User;
import ag04.feeddit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
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

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        loadUsers();
    }
}
