package ag04.feeddit.converters;

import ag04.feeddit.entities.User;
import ag04.feeddit.services.UserDetailsImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDetails implements Converter<User, UserDetails>
{
    @Override
    public UserDetails convert(User user)
    {
        UserDetailsImpl userDetails = new UserDetailsImpl();

        if(user != null)
        {
            userDetails.setUsername(user.getUsername());
            userDetails.setPassword(user.getEncryptedPassword());
            userDetails.setEnabled(user.isEnabled());
        }

        return userDetails;
    }
}
