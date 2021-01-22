package com.bohan.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageReqVO {

    @ApiModelProperty(value = "Current page")
    private Integer pageNum=1;

    @ApiModelProperty(value = "Records per page")
    private Integer pageSize=10;
}
