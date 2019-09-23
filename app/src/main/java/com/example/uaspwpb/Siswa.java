package com.example.uaspwpb;

import android.os.Parcel;
import android.os.Parcelable;

public class Siswa implements Parcelable {
    private String judul;
    private String deskripsi;

    public Siswa() {
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul= judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
    }

    protected Siswa(Parcel in) {
        this.judul = in.readString();
        this.deskripsi = in.readString();
    }

    public static final Parcelable.Creator<Siswa> CREATOR = new Parcelable.Creator<Siswa>() {
        @Override
        public Siswa createFromParcel(Parcel source) {
            return new Siswa(source);
        }

        @Override
        public Siswa[] newArray(int size) {
            return new Siswa[size];
        }
    };
}
