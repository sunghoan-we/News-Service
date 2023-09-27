package springboot.demo.newsService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanMetadataElement;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto {

    private Long newsId;
    private String title;
    private String content;
    private Long userId;
    private Date createTime;
}
