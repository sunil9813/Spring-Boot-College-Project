package com.bismdhr.bankmgmtsystem.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
//
//@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//public class Post {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(unique = true)
//    @NotBlank(message = "Title is required.")
//    private String title;
//    @NotBlank(message = "Description is required.")
//    private String description;
//    @NotBlank(message = "Author is required.")
//    private String author;
//    @NotBlank(message = "Category is required.")
//    private String category;
//    @NotNull(message = "Date is required.")
//    //private int Date;
//    @JsonFormat(pattern = "yyyy/MM/dd")
//    private Date Date;
//
//
//  /*  @OneToMany
//    @JoinColumn(name = "user_id")
//    List<ResourceFile> files;
//
//    @ManyToMany
//    private List<Post> roles;
//*/
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public java.util.Date getDate() {
//        return Date;
//    }
//
//    public void setDate(java.util.Date date) {
//        Date = date;
//    }
///*
//    public List<Post> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<Post> roles) {
//        this.roles = roles;
//    }*/
//}


@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String author;
    private String category;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date Date;
    private String sphoto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getSphoto() {
        return sphoto;
    }

    public void setSphoto(String sphoto) {
        this.sphoto = sphoto;
    }
}
