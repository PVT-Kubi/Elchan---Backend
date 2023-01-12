package bubi.kubi.backend.controller;

import bubi.kubi.backend.entity.Comment;
import bubi.kubi.backend.entity.Post;
import bubi.kubi.backend.repository.CommentRepository;
import bubi.kubi.backend.repository.PostRepository;
import bubi.kubi.backend.request.AddCommentRequest;
import bubi.kubi.backend.request.AddPostRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/posts")
public class PostController {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public PostController(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @CrossOrigin(origins = "http://192.168.21.2:5173")
    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId){
        return postRepository.findById(postId).orElseThrow(() -> new NoSuchElementException());
    }

    @CrossOrigin(origins = "http://192.168.21.2:5173")
    @GetMapping("/allPosts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @CrossOrigin(origins = "http://192.168.21.2:5173")
    @PostMapping
    public Post addPost(@RequestBody AddPostRequest postRequest) throws SQLException {
        Post post = new Post();

        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        post.setWichBoard(postRequest.getWichBoard());
        post.setPassword(postRequest.getPassword());
        post.setDateOfPost(postRequest.getDateOfPost());
        post.setImage(postRequest.getImage());

        return postRepository.save(post);
    }

    @CrossOrigin(origins = "http://192.168.21.2:5173")
    @PostMapping("{postId}/comments")
    public Comment addComment(@PathVariable Long postId, @RequestBody AddCommentRequest commentRequest) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new NoSuchElementException());
        Comment comment = new Comment();
        comment.setContent(commentRequest.getContent());
        comment.setPassword(commentRequest.getPassword());
        comment.setPostId(commentRequest.getPostId());
        comment.setDateOfComment(commentRequest.getDateOfComment());
        comment.setImage(commentRequest.getImage());
        post.getCommentList().add(comment);
        Comment c = commentRepository.save(comment);
        postRepository.save(post);
        return c;
    }

    @CrossOrigin(origins = "http://192.168.21.2:5173")
    @DeleteMapping("{postId}/comments/{commentId}")
    public void deleteComment( @PathVariable Long postId, @PathVariable Long commentId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new NoSuchElementException());
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NoSuchElementException());
        post.getCommentList().remove(comment);
        commentRepository.delete(comment);
    }

    @CrossOrigin(origins = "http://192.168.21.2:5173")
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new NoSuchElementException());
        postRepository.delete(post);
    }
}
