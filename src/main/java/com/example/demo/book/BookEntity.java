package com.example.demo.book;

import javax.persistence.*;

@Entity
@Table(name = "book", schema = "public", catalog = "testdb")
public class BookEntity {
    private long id;
    private String title;
    private String overview;
    private Double price;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "overview")
    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (overview != null ? !overview.equals(that.overview) : that.overview != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (overview != null ? overview.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    public BookEntity() {
    }

    public BookEntity(String title, String overview, Double price) {
        this.title = title;
        this.overview = overview;
        this.price = price;
    }

    public BookEntity(long id, String title, String overview, Double price) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.price = price;
    }
}
