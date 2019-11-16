package cn.edu.nwsuaf.lims.model;

import javax.persistence.*;

public class Poem2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "poem_name")
    private String poemName;

    @Column(name = "author_name")
    private String authorName;

    private String dynasty;

    @Column(name = "link_to")
    private String linkTo;

    private String content;

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
     * @return model_name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param modelName
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * @return poem_name
     */
    public String getPoemName() {
        return poemName;
    }

    /**
     * @param poemName
     */
    public void setPoemName(String poemName) {
        this.poemName = poemName;
    }

    /**
     * @return author_name
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return dynasty
     */
    public String getDynasty() {
        return dynasty;
    }

    /**
     * @param dynasty
     */
    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    /**
     * @return link_to
     */
    public String getLinkTo() {
        return linkTo;
    }

    /**
     * @param linkTo
     */
    public void setLinkTo(String linkTo) {
        this.linkTo = linkTo;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}