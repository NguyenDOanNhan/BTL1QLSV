package com.example.nguyendoannhan.Model;

public class Student {
    private Integer mId;
    private String mName;
    private String mAddress;
    private String mEmail;
    private String mPhone;

    public Student() {
    }

    public Student(int mId, String mName, String mAddress, String mEmail, String mPhone) {
        this.mId = mId;
        this.mName = mName;
        this.mAddress = mAddress;
        this.mEmail = mEmail;
        this.mPhone = mPhone;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mPhone='" + mPhone + '\'' +
                '}';
    }
}
