package ea.project.gatewayservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    private long userId;
    private String content;
    private List<Attachment> attachments;
}
