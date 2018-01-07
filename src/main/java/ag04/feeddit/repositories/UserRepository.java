package ag04.feeddit.repositories;

import ag04.feeddit.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>
{
    User findByUsername(String username);
}
