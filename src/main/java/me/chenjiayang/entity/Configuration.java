package me.chenjiayang.entity;

/**
 * create by chenjiayang on 2018/3/30
 */
public class Configuration {
    private Integer id;
    private Integer indexMaxBlogShownNumber;
    private Integer indexMaxActivityShownNumber;
    private String personalSignature;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndexMaxBlogShownNumber() {
        return indexMaxBlogShownNumber;
    }

    public void setIndexMaxBlogShownNumber(Integer indexMaxBlogShownNumber) {
        this.indexMaxBlogShownNumber = indexMaxBlogShownNumber;
    }

    public Integer getIndexMaxActivityShownNumber() {
        return indexMaxActivityShownNumber;
    }

    public void setIndexMaxActivityShownNumber(Integer indexMaxActivityShownNumber) {
        this.indexMaxActivityShownNumber = indexMaxActivityShownNumber;
    }

    public String getPersonalSignature() {
        return personalSignature;
    }

    public void setPersonalSignature(String personalSignature) {
        this.personalSignature = personalSignature;
    }
}
