package springboot.demo.newsservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.demo.newsservice.dto.NewsDto;
import springboot.demo.newsservice.service.NewsService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/news")
public class NewsController {
    NewsService newsService;

    @GetMapping
    public ResponseEntity<NewsDto> getNews(@RequestParam Long newsId){
        NewsDto newsDto = newsService.getNews(newsId);
        return ResponseEntity.ok(newsDto);
    }
    @GetMapping("listbyuser")
    public ResponseEntity<List<NewsDto>> getNewsByUserId(@RequestParam Long userId) {
        List<NewsDto> listNews = newsService.getNewsByUserId(userId);
        return ResponseEntity.ok(listNews);
    }

    @PostMapping
    public ResponseEntity<NewsDto> addNews(@RequestBody NewsDto newsDto) {
        NewsDto addedNewsDto = newsService.addNews(newsDto);
        return new ResponseEntity<>(addedNewsDto, HttpStatus.CREATED);
    }
}
