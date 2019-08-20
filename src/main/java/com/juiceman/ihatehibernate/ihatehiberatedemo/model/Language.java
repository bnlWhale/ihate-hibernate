package com.juiceman.ihatehibernate.ihatehiberatedemo.model;


import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Language")
public class Language {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LANGUAGE_ID", nullable = false)
    private int id;

    @Id
    @Column(name = "LANGUAGE_CODE", nullable = false)
    private String languageCode;


    @OneToMany(cascade=CascadeType.ALL, mappedBy="language")
    private Set<BookTitle> titles;

    public void addTitle(String title, Language language) {

    }

    public Set<BookTitle> getTitles() {
        return titles;
    }

    public void setTitles(Set<BookTitle> titles) {
        this.titles = titles;
    }



    public Language() {
        super();
    }

    public Language(String languageCode) {

        setLanguageCode(languageCode);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
}
