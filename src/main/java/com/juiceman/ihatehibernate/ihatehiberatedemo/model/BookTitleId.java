package com.juiceman.ihatehibernate.ihatehiberatedemo.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author buhake.sindi
 *
 */
@Embeddable
public class BookTitleId implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3246039946807996563L;

    @Column(name = "BOOK_ID")
    private int bookId;

    @Column(name = "LANGUAGE_ID")
    private String languageCode;

    public BookTitleId() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BookTitleId(int bookId, String languageCode) {
        super();
        this.bookId = bookId;
        this.languageCode = languageCode;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bookId;
        result = prime * result + ((languageCode == null) ? 0 : languageCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BookTitleId other = (BookTitleId) obj;
        if (bookId != other.bookId)
            return false;
        if (languageCode == null) {
            if (other.languageCode != null)
                return false;
        } else if (!languageCode.equals(other.languageCode))
            return false;
        return true;
    }
}