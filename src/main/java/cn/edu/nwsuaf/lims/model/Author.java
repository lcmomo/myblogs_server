package cn.edu.nwsuaf.lims.model;

import javax.persistence.*;

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "link_to")
    private String linkTo;

    private String author;

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
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
}