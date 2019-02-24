package com.example.jack.retrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyResult implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("alpha2_code")
    @Expose
    private String alpha2Code;
    @SerializedName("alpha3_code")
    @Expose
    private String alpha3Code;
    @SerializedName("image")
    @Expose
    private String image;


    protected MyResult(Parcel in) {
        name = in.readString();
        alpha2Code = in.readString();
        alpha3Code = in.readString();
        image = in.readString();
    }

    public static final Creator<MyResult> CREATOR = new Creator<MyResult>() {
        @Override
        public MyResult createFromParcel(Parcel in) {
            return new MyResult(in);
        }

        @Override
        public MyResult[] newArray(int size) {
            return new MyResult[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(alpha2Code);
        parcel.writeString(alpha3Code);
        parcel.writeString(image);
    }
}
