package ag04.feeddit.repositories;

import ag04.feeddit.entities.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long>
{
}
