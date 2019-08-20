package com.juiceman.ihatehibernate.ihatehiberatedemo.model;



import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="Book")
public class Book implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2223151942742857389L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="BOOK_ID", nullable=false)
    private int id;

    @Column(name="PRICE", nullable=false)
    private BigDecimal price;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="book")
    private Set<BookTitle> titles;

    public void addTitle(String title, Language language) {
        if (titles == null) {
            titles = new LinkedHashSet<>();
        }

        BookTitle bookTitle = new BookTitle();
        bookTitle.setBook(this);
        bookTitle.setId(new BookTitleId());
        bookTitle.setLanguage(language);
        bookTitle.setTitle(title);
        titles.add(bookTitle);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /*
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    */


    public Set<BookTitle> getTitles() {
        return titles;
    }

    public void setTitles(Set<BookTitle> titles) {
        this.titles = titles;
    }
}