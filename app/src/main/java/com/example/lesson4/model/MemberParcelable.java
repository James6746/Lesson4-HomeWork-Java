package com.example.lesson4.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MemberParcelable implements Parcelable {
    private String name;
    private int age;

    public MemberParcelable(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<MemberParcelable> CREATOR = new Creator<MemberParcelable>() {
        @Override
        public MemberParcelable createFromParcel(Parcel in) {
            return new MemberParcelable(in);
        }

        @Override
        public MemberParcelable[] newArray(int size) {
            return new MemberParcelable[size];
        }
    };

    public MemberParcelable() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
    }
}
