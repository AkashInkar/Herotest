package com.example.jack.retrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.xml.transform.Result;

public class RestResponse implements Parcelable {

    @SerializedName("messages")
    @Expose
    private List<String> messages = null;
    @SerializedName("result")
    @Expose
    private List<MyResult> result = null;

    protected RestResponse(Parcel in) {
        messages = in.createStringArrayList();
    }

    public static final Creator<RestResponse> CREATOR = new Creator<RestResponse>() {
        @Override
        public RestResponse createFromParcel(Parcel in) {
            return new RestResponse(in);
        }

        @Override
        public RestResponse[] newArray(int size) {
            return new RestResponse[size];
        }
    };

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<MyResult> getResult() {
        return result;
    }

    public void setResult(List<MyResult> result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(messages);
    }
}
