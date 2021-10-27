package twentyOnes.studyshare.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twentyOnes.studyshare.domain.comment.Comment;
import twentyOnes.studyshare.dto.comment.CommentDto;
import twentyOnes.studyshare.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comment/{postid}")
    public ResponseEntity<?> selectcomment(@PathVariable Long postid)
    {
        List<Comment> commentList =  commentService.selectcomment(postid);
        return ResponseEntity.ok().body(commentList);
    }
    @PostMapping("/comment")
    public ResponseEntity<?> addcomment(@RequestBody CommentDto commentDto)
    {
        commentService.addcomment(commentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/comment/{id}")
    public ResponseEntity<?> deletecomment(@PathVariable Long id)
    {
        commentService.deletecomment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/comment/{id}")
    public ResponseEntity<?> updatecomment(@PathVariable Long id, @RequestBody CommentDto commentDto)
    {
        commentService.updatecomment(id,commentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
