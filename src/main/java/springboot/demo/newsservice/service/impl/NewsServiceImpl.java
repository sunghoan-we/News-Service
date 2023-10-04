package springboot.demo.newsservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.demo.newsservice.dto.NewsDto;
import springboot.demo.newsservice.entity.News;
import springboot.demo.newsservice.repository.NewsRepository;
import springboot.demo.newsservice.service.NewsService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NewsServiceImpl implements NewsService {
    NewsRepository newsRepository;

    @Override
    public NewsDto getNews(Long newsId) {
        Optional<News> newsOpt = newsRepository.findById(newsId);
        News news = newsOpt.get();
        NewsDto newsDto = new NewsDto(news.getNewsId(),
                news.getTitle(),
                news.getContent(),
                news.getUserId(),
                news.getCreateTime());
        return newsDto;
    }

    @Override
    public List<NewsDto> getNewsByUserId(Long userId) {
        List<News> list = newsRepository.findAllByUserId(userId);
        List<NewsDto> userDtoList = list.stream()
                .map(news -> {
                    NewsDto newsDto = new NewsDto(news.getNewsId(), news.getTitle(), news.getContent(), news.getUserId(), news.getCreateTime());
                    return newsDto;
                })
                .collect(Collectors.toList());

        return userDtoList;
    }

    @Override
    public NewsDto addNews(NewsDto newsDto) {
        News news = new News(newsDto.getNewsId(), newsDto.getTitle(), newsDto.getContent(), newsDto.getUserId(), newsDto.getCreateTime());
        News addedNews = newsRepository.save(news);
        NewsDto addedNewsDto = new NewsDto(addedNews.getNewsId(),
                addedNews.getTitle(),
                addedNews.getContent(),
                addedNews.getUserId(),
                addedNews.getCreateTime());
        return addedNewsDto;
    }
}
