package twentyOnes.studyshare.domain.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import twentyOnes.studyshare.domain.childcomment.ChildComment;
import twentyOnes.studyshare.domain.childcomment.ChildCommentLike;
import twentyOnes.studyshare.domain.comment.CommentLike;
import twentyOnes.studyshare.domain.follw.Follow;
import twentyOnes.studyshare.domain.posts.PostLike;
import twentyOnes.studyshare.domain.todaycomment.TodayComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", length = 50)
    private Long memberId;

    @Column(name = "username")
    private String username;

    private String password;

    @Column(name = "nickname")
    private String nickname;

    private String email;

    @Column(name = "member_image")
    private String memberImage;

    @Column(name = "follower_count")
    private int followerCount;

    @Column(name = "followee_count")
    private int followeeCount;

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name = "member_authority",
            joinColumns = {@JoinColumn(name = "member_id", referencedColumnName = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    @OneToMany(mappedBy = "followerId", cascade = CascadeType.ALL)
    List<Follow> followerList = new ArrayList<>();

    @OneToMany(mappedBy = "followeeId", cascade = CascadeType.ALL)
    List<Follow> followeeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<ChildComment> childCommentList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<TodayComment> todayCommentList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<ChildCommentLike> childCommentLike = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<CommentLike> commentLike = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<PostLike> postLike = new ArrayList<>();
}
