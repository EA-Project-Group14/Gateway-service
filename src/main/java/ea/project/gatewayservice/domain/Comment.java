package ea.project.gatewayservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private int id;
    private String comment;
    private int postId;
    private String createDate;

}
