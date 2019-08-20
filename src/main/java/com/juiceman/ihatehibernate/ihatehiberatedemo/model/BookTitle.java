package com.juiceman.ihatehibernate.ihatehiberatedemo.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author buhake.sindi
 *
 */
@Entity
@Table(name="BookTitle")
public class BookTitle implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1359397122293160199L;

    @EmbeddedId
    private BookTitleId id;

    @Column(name="TITLE", nullable=false)
    private String title;

    @MapsId("bookId")
    @ManyToOne
    @JoinColumn(name="BOOK_ID", insertable=false, updatable=false, nullable=false)
    private Book book;

    @MapsId("languageCode")
    @ManyToOne
    @JoinColumn(name="LANGUAGE_ID", insertable=false, updatable=false, nullable=false)
    private Language language;

    public BookTitleId getId() {
        return id;
    }

    public void setId(BookTitleId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}