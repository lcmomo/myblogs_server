package cn.edu.nwsuaf.lims.model;

import javax.persistence.*;

public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "link_to")
    private String linkTo;

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
}