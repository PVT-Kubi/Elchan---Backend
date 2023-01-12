package bubi.kubi.backend.request;

import jakarta.persistence.Lob;
import org.hibernate.engine.jdbc.BinaryStream;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

public class AddPostRequest {
    private String title;
    private String description;
    private String password;
    private String dateOfPost;
    private String wichBoard;

    private String image;

    public AddPostRequest() {
    }

    public AddPostRequest(String title, String description, String dateOfPost, String password, String wichBoard, String image) throws SQLException, IOException {
        this.title = title;
        this.description = description;
        this.password = password;
        this.wichBoard = wichBoard;
        this.dateOfPost = dateOfPost;
        this.image = image;
    }

    public String getImage() throws SQLException {
        return image;
    }

    public void setImage(String image) {
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
}
