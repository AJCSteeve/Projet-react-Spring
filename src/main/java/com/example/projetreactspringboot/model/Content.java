package com.example.projetreactspringboot.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="birthdate")
    private LocalDate birthdate;

    @Column(name = "contentname")
    private String contentName;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "contentData")
    private byte[] contentData;

    @Enumerated(EnumType.STRING)
    @Column(name = "content_type",nullable = true)
    private ContentType contentType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Content(Long id, LocalDate birthdate, String contentName, String description, byte[] contentData, ContentType contentType, User user) {
        this.id = id;
        this.birthdate = birthdate;
        this.contentName = contentName;
        this.description = description;
        this.contentData = contentData;
        this.contentType = contentType;
        this.user = user;
    }

    public Content(LocalDate birthdate, String contentName, String description, byte[] contentData, ContentType contentType, User user) {
        this.birthdate = birthdate;
        this.contentName = contentName;
        this.description = description;
        this.contentData = contentData;
        this.contentType = contentType;
        this.user = user;
    }

    public Content(String contentName, String description, byte[] contentData, ContentType contentType) {
        this.contentName = contentName;
        this.description = description;
        this.contentData = contentData;
        this.contentType = contentType;
    }

    public Content(String contentName, byte[] contentData, ContentType contentType) {
        this.contentName = contentName;
        this.contentData = contentData;
        this.contentType = contentType;
    }

    public Content(String contentName) {
        this.contentName = contentName;
    }

    public Content() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentName() {return contentName;}

    public void setContentName(String contentName) {this.contentName = contentName;}

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getContentData() {
        return contentData;
    }

    public void setContentData(byte[] contentData) {
        this.contentData = contentData;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public User getUser() {return user;}

    public void setUser(User user) {
        this.user = user;
    }

    public enum ContentType {
        PHOTO,
        VIDEO
    }

}
