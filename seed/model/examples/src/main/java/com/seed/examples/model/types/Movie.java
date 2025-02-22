/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.examples.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.examples.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Movie.Builder.class)
public final class Movie implements IMovie {
    private final String id;

    private final String title;

    private final String from;

    private final double rating;

    private final String tag;

    private final Optional<String> book;

    private Movie(String id, String title, String from, double rating, String tag, Optional<String> book) {
        this.id = id;
        this.title = title;
        this.from = from;
        this.rating = rating;
        this.tag = tag;
        this.book = book;
    }

    @JsonProperty("id")
    @Override
    public String getId() {
        return id;
    }

    @JsonProperty("title")
    @Override
    public String getTitle() {
        return title;
    }

    @JsonProperty("from")
    @Override
    public String getFrom() {
        return from;
    }

    /**
     * @return The rating scale is one to five stars
     */
    @JsonProperty("rating")
    @Override
    public double getRating() {
        return rating;
    }

    @JsonProperty("type")
    @Override
    public String getType() {
        return "movie";
    }

    @JsonProperty("tag")
    @Override
    public String getTag() {
        return tag;
    }

    @JsonProperty("book")
    @Override
    public Optional<String> getBook() {
        return book;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Movie && equalTo((Movie) other);
    }

    private boolean equalTo(Movie other) {
        return id.equals(other.id)
                && title.equals(other.title)
                && from.equals(other.from)
                && rating == other.rating
                && tag.equals(other.tag)
                && book.equals(other.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.from, this.rating, this.tag, this.book);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        TitleStage id(String id);

        Builder from(Movie other);
    }

    public interface TitleStage {
        FromStage title(String title);
    }

    public interface FromStage {
        RatingStage from(String from);
    }

    public interface RatingStage {
        TagStage rating(double rating);
    }

    public interface TagStage {
        _FinalStage tag(String tag);
    }

    public interface _FinalStage {
        Movie build();

        _FinalStage book(Optional<String> book);

        _FinalStage book(String book);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, TitleStage, FromStage, RatingStage, TagStage, _FinalStage {
        private String id;

        private String title;

        private String from;

        private double rating;

        private String tag;

        private Optional<String> book = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(Movie other) {
            id(other.getId());
            title(other.getTitle());
            from(other.getFrom());
            rating(other.getRating());
            tag(other.getTag());
            book(other.getBook());
            return this;
        }

        @Override
        @JsonSetter("id")
        public TitleStage id(String id) {
            this.id = id;
            return this;
        }

        @Override
        @JsonSetter("title")
        public FromStage title(String title) {
            this.title = title;
            return this;
        }

        @Override
        @JsonSetter("from")
        public RatingStage from(String from) {
            this.from = from;
            return this;
        }

        /**
         * <p>The rating scale is one to five stars</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("rating")
        public TagStage rating(double rating) {
            this.rating = rating;
            return this;
        }

        @Override
        @JsonSetter("tag")
        public _FinalStage tag(String tag) {
            this.tag = tag;
            return this;
        }

        @Override
        public _FinalStage book(String book) {
            this.book = Optional.of(book);
            return this;
        }

        @Override
        @JsonSetter(value = "book", nulls = Nulls.SKIP)
        public _FinalStage book(Optional<String> book) {
            this.book = book;
            return this;
        }

        @Override
        public Movie build() {
            return new Movie(id, title, from, rating, tag, book);
        }
    }
}
