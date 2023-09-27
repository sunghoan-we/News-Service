package springboot.demo.newsService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsId;
    private String title;
    @Lob
    private String content;
    private Long userId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    // to generate create time
    @PrePersist
    protected void onCreate() {
        createTime = new Date();
    }
}
