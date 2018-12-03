package com.mhc.orianna.api.query;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author maihe
 */
@Data
public class BaseDubboRequest implements Serializable {
    private static final long serialVersionUID = 2438689815399026883L;

    public static int DEFAULT_PAGE_SIZE = 20;
    public static int MAX_PAGE_SIZE = 100;
    public static int DEFAULT_PAGE = 1;
    private HashMap<String, Object> extInfo;
    protected String correlationID = UUID.randomUUID().toString();
    private Date beginTime;
    private Date endTime;
    protected boolean distinct;
    protected String orderByClause;
    protected Integer pageOffset;
    protected Integer pageNo;
    protected Integer pageSize;

    public BaseDubboRequest() {
        this.pageNo = DEFAULT_PAGE;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.calPageOffset();
    }

    public void clearPage() {
        this.pageSize = null;
        this.pageNo = null;
        this.pageOffset = null;
    }

    public Integer getPageOffset() {
        return this.pageOffset;
    }

    public void setPageOffset(Integer pageOffset) {
        this.pageOffset = pageOffset;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize != null && pageSize > 0) {
            if (pageSize > MAX_PAGE_SIZE) {
                this.pageSize = MAX_PAGE_SIZE;
            } else {
                this.pageSize = pageSize;
            }
        } else {
            this.clearPage();
        }

        this.calPageOffset();
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo != null && pageNo >= DEFAULT_PAGE) {
            this.pageNo = pageNo;
        } else {
            this.clearPage();
        }

        this.calPageOffset();
    }

    protected void calPageOffset() {
        if (null != this.pageSize && null != this.pageNo) {
            this.pageOffset = (this.pageNo - 1) * this.pageSize;
        } else {
            this.pageOffset = null;
        }

    }
}
