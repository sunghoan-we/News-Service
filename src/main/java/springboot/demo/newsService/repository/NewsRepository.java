package springboot.demo.newsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.demo.newsService.entity.News;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    public List<News> findAllByUserId(Long UserId);

}
