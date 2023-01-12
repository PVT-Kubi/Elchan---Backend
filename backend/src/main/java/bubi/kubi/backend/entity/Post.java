package bubi.kubi.backend.entity;

import jakarta.persistence.*;
import org.hibernate.engine.jdbc.BinaryStream;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private String password;
    private String dateOfPost;
    private String wichBoard;

    @Lob
    private String image;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();

    public Post() {
    }

    public Post(Long id, String title, String description, String password, String dateOfPost, List<Comment> commentList, String wichBoard, String image) throws SQLException, IOException {
        this.title = title;
        this.description = description;
        this.password = password;
        this.dateOfPost = dateOfPost;
        this.wichBoard = wichBoard;
        this.commentList = commentList;

        this.image = image;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) throws SQLException {
        System.out.println(image);
        this.image = image;
    }

    public String getWichBoard() {
        return wichBoard;
    }

    public void setWichBoard(String wichBoard) {
        this.wichBoard = wichBoard;
    }

    public String getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(String dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
