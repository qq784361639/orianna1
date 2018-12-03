package com.mhc.orianna.api.dto;

import com.mhc.orianna.api.enums.AssetStatusEnum;
import lombok.Data;

import java.util.Date;
@Data
public class ReturnRecordDTO {

    /**
     * 资产id
     */
    private Integer assetId;
    /**
     * 资产编号
     */
    private String assetNo;
    /**
     * 归还时间
     */

    private Date returnDate;
    /**
     * 归还备注
     */

    private String returnRemark;
    /**
     * 资产状态
     */
    private AssetStatusEnum assetStatusEnum;


}
