package com.bohan.vo.req;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class TestReqVO {

    @ApiModelProperty(value = "name")
    @NotBlank(message = "name can't be empty")
    private String name;

    @ApiModelProperty(value = "age")
    @NotNull(message = "age can't be Null")
    private Integer age;

    @ApiModelProperty(value = "id collection")
    @NotEmpty(message = "id collection can't be empty")
    private List<String> ids;
}
