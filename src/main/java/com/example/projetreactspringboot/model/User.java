package com.example.projetreactspringboot.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="username",unique = true)
    private String username;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name="photoUrl")
    private String photoUrl;
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Content> contentList;

    public User(Long id, String username, String phoneNumber, String photoUrl, String email, List<Content> contentList) {
        this.id = id;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.photoUrl = photoUrl;
        this.email = email;
        this.contentList = contentList;
    }

    public User(String username, String phoneNumber, String photoUrl, String email, List<Content> contentList) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.photoUrl = photoUrl;
        this.email = email;
        this.contentList = contentList;
    }

    public User(String username, String phoneNumber, String email) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }
}
