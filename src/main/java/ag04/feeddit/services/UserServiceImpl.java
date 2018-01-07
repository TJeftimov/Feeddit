package ag04.feeddit.services;

import ag04.feeddit.entities.User;
import ag04.feeddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    private EncryptionService encryptionService;
    @Autowired
    public void setEncryptionService(EncryptionService encryptionService)
    {
        this.encryptionService = encryptionService;
    }

    @Override
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> listAll()
    {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getById(Integer id)
    {
        return userRepository.findOne(id);
    }

    @Override
    public User saveOrUpdate(User entity)
    {
        if(entity.getPassword() != null)
        {
            entity.setEncryptedPassword(encryptionService.encryptString(entity.getPassword()));
        }
        return userRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id)
    {
        userRepository.delete(id);
    }
}
