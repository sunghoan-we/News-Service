package springboot.demo.newsService.service;

import springboot.demo.newsService.dto.NewsDto;

import java.util.List;

public interface NewsService {
    public NewsDto getNews(Long newsId);
    public List<NewsDto> getNewsByUserId(Long newsId);
    public NewsDto addNews(NewsDto newsDto);
}
