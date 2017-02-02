package com.yamenrbdgmail.flickerbrowser;

/**
 * Created by German Center on 01/02/2017.
 */

public class Photo {
    private String mtitle;
    private String mAuthor;
    private String mAuthorID;
    private String mLink;
    private String mTags;
    private String mImage;

    public Photo(String mtitle, String mAuthor, String mAuthorID, String mLink, String mTags, String mImage) {
        this.mtitle = mtitle;
        this.mAuthor = mAuthor;
        this.mAuthorID = mAuthorID;
        this.mLink = mLink;
        this.mTags = mTags;
        this.mImage = mImage;
    }

    public String getMtitle() {
        return mtitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmAuthorID() {
        return mAuthorID;
    }

    public String getmLink() {
        return mLink;
    }

    public String getmTags() {
        return mTags;
    }

    public String getmImage() {
        return mImage;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "mtitle='" + mtitle + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mAuthorID='" + mAuthorID + '\'' +
                ", mLink='" + mLink + '\'' +
                ", mTags='" + mTags + '\'' +
                ", mImage='" + mImage + '\'' +
                '}';
    }
}
