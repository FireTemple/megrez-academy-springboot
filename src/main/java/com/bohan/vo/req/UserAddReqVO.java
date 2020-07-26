package com.bohan.vo.req;

import lombok.Data;

@Data
public class UserAddReqVO {

    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;
}
