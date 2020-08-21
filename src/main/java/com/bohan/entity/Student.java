package com.bohan.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private String id;

    private String pId;

    private String firstName;

    private String lastName;

    private String birth;

    private Byte gender;

    private String email;

    private Date createTime;

    private String status;

    private String curentSchool;

    private String curentGrade;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCurentSchool() {
        return curentSchool;
    }

    public void setCurentSchool(String curentSchool) {
        this.curentSchool = curentSchool == null ? null : curentSchool.trim();
    }

    public String getCurentGrade() {
        return curentGrade;
    }

    public void setCurentGrade(String curentGrade) {
        this.curentGrade = curentGrade == null ? null : curentGrade.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pId=").append(pId);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", birth=").append(birth);
        sb.append(", gender=").append(gender);
        sb.append(", email=").append(email);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", curentSchool=").append(curentSchool);
        sb.append(", curentGrade=").append(curentGrade);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}