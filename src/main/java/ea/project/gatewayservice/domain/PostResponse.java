package ea.project.gatewayservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private long id;
    private long userId;
    private String content;
    private String lastUpdate;
    private List<Attachment> attachments;
    private List<Comment> comments;
}