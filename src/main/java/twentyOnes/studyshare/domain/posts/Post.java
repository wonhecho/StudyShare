package twentyOnes.studyshare.domain.posts;

import twentyOnes.studyshare.domain.comment.Comment;
import twentyOnes.studyshare.domain.hashtag.Tag;
import twentyOnes.studyshare.domain.hashtag.TagPost;
import twentyOnes.studyshare.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "post_text")
    private String postText;

    @Column(name = "post_image")
    private String postImage;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "comment_count")
    private int commentCount;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<TagPost> tagPostList = new ArrayList<>();
}
