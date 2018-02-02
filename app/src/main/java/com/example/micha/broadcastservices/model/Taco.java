package com.example.micha.broadcastservices.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by micha on 2/1/2018.
 */

public class Taco implements Parcelable{
    private String meat,cheese,shell, salsa;

    public Taco(String meat, String cheese, String shell, String salsa) {
        this.meat = meat;
        this.cheese = cheese;
        this.shell = shell;
        this.salsa = salsa;
    }

    @Override
    public String toString() {
        return "Taco{" +
                "meat='" + meat + '\'' +
                ", cheese='" + cheese + '\'' +
                ", shell='" + shell + '\'' +
                ", salsa='" + salsa + '\'' +
                '}';
    }

    protected Taco(Parcel in) {
        meat = in.readString();
        cheese = in.readString();
        shell = in.readString();
        salsa = in.readString();
    }

    public static final Creator<Taco> CREATOR = new Creator<Taco>() {
        @Override
        public Taco createFromParcel(Parcel in) {
            return new Taco(in);
        }

        @Override
        public Taco[] newArray(int size) {
            return new Taco[size];
        }
    };

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(meat);
        parcel.writeString(cheese);
        parcel.writeString(shell);
        parcel.writeString(salsa);
    }
}
