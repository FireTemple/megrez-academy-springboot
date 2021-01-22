package com.bohan.vo.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class StudentAddReqVO {

    private String firstName;
    private String lastName;
    private String birth;
    private String gender;
    private String email;
    @JSONField(name="pId")
    private String pId;

    private String currentGrade;

    public void setpId(String pId) {
        this.pId = pId;
    }

    private String currentSchool;

    public String getpId() {
        return pId;
    }
}
