package ag04.feeddit.services;

import ag04.feeddit.entities.User;

public interface UserService extends CRUDService<User>
{
    User findByUsername(String username);
}
