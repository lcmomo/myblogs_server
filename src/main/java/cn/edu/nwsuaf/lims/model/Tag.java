package cn.edu.nwsuaf.lims.model;

import javax.persistence.*;

public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tag_id")
    @Transient
    private String tagId;

    @Column(name = "tag_name")
    private String tagName;

    @Column(name = "article_id")
    private String articleId;

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
     * @return tag_id
     */
    public String getTagId() {
        return tagId;
    }

    /**
     * @param tagId
     */
    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    /**
     * @return tag_name
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * @param tagName
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
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
}