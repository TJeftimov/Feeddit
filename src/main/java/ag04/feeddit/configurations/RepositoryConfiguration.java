package ag04.feeddit.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"ag04.feeddit.entities"})
@EnableJpaRepositories(basePackages = {"ag04.feeddit.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration
{

}
