package com.iqbal.submission2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int poster;
    private String title, overview, runtime, genre, cast, language;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.title);
        dest.writeString(this.overview);
        dest.writeString(this.runtime);
        dest.writeString(this.genre);
        dest.writeString(this.cast);
        dest.writeString(this.language);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.poster = in.readInt();
        this.title = in.readString();
        this.overview = in.readString();
        this.runtime = in.readString();
        this.genre = in.readString();
        this.cast = in.readString();
        this.language = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
