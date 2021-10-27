package twentyOnes.studyshare.domain.hashtag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import twentyOnes.studyshare.domain.posts.Post;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long tagId;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private List<TagPost> tagPostList = new ArrayList<>();

    private String tagName;
}