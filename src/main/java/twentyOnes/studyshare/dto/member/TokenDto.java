package twentyOnes.studyshare.dto.member;

import lombok.*;
import twentyOnes.studyshare.domain.posts.Post;
import twentyOnes.studyshare.domain.todolist.TodoList;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {

    private String token;
//    private List<Post> postLists = new ArrayList<>();
//    private List<TodoList> todoLists = new ArrayList<>();
}