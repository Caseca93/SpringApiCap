package org.github.caseca.domain.entity;

import javax.persistence.*;

@Entity
@Table( name = "movie" )
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "id" )
    private Long id;

    @Column( name = "name", length = 100)
    private String name;

    @Column( name = "url", length = 100)
    private String url;

    @Column( name = "gender", length = 100)
    private String gender;

    @Column( name = "description", length = 1000)
    private String description;

    public Movie(){

    }

    public Movie(String name, String url, String gender, String description) {
        this.name = name;
        this.url = url;
        this.gender = gender;
        this.description = description;
    }

    public Movie(Long id, String name, String url, String gender, String description) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.gender = gender;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
