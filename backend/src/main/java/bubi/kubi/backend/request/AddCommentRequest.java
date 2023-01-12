package bubi.kubi.backend.request;

import java.util.Date;

public class AddCommentRequest {
    private String content;
    private String password;
    private String dateOfComment;
    private String image;
    private String postId;

    public AddCommentRequest() {
    }

    public AddCommentRequest(String content, String password, String dateOfComment , String image, String postId) {
        this.content = content;
        this.password = password;
        this.image = image;
        this.dateOfComment = dateOfComment;
        this.postId = postId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(String dateOfComment) {
        this.dateOfComment = dateOfComment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
