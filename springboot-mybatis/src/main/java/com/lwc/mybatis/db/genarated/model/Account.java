package com.lwc.mybatis.db.genarated.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Account implements Serializable {
    private Integer id;

    private String type;

    private String subdivide;

    private Date time;

    private BigDecimal money;

    private String comment;

    private Integer createdUser;

    private Date createdDate;

    private Integer modifiedUser;

    private Date modifiedDate;

    private Integer status;

    private Integer isDelete;

    private String levelOne;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSubdivide() {
        return subdivide;
    }

    public void setSubdivide(String subdivide) {
        this.subdivide = subdivide == null ? null : subdivide.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(Integer modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getLevelOne() {
        return levelOne;
    }

    public void setLevelOne(String levelOne) {
        this.levelOne = levelOne == null ? null : levelOne.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", subdivide=").append(subdivide);
        sb.append(", time=").append(time);
        sb.append(", money=").append(money);
        sb.append(", comment=").append(comment);
        sb.append(", createdUser=").append(createdUser);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", modifiedUser=").append(modifiedUser);
        sb.append(", modifiedDate=").append(modifiedDate);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", levelOne=").append(levelOne);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}