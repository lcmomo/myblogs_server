package cn.edu.nwsuaf.lims.model;

import java.util.Date;
import javax.persistence.*;

public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reply_id")
    private String replyId;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "comment_id")
    private String commentId;

    @Column(name = "article_id")
    private String articleId;

    private String userid;

    @Column(name = "reply_content")
    private String replyContent;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return reply_id
     */
    public String getReplyId() {
        return replyId;
    }

    /**
     * @param replyId
     */
    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    /**
     * @return create_at
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * @param createAt
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * @return update_at
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * @param updateAt
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * @return comment_id
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * @param commentId
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     * @return article_id
     */
    public String getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    /**
     * @return userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return reply_content
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * @param replyContent
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
}