package org.milan.moviecatalogservice.models;

/**
 * Pojo of Movie Info
 *
 * @author Milan Rathod
 */
public class MovieInfo {

    private String id;

    private String name;

    private String desc;

    public MovieInfo() {
    }

    public MovieInfo(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


