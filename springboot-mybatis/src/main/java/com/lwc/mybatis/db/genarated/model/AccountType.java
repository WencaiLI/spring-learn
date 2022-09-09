package com.lwc.mybatis.db.genarated.model;

import java.io.Serializable;
import java.util.Date;

public class AccountType implements Serializable {
    private Integer id;

    private String name;

    private Integer pid;

    private Integer createdUser;

    private Date createdDate;

    private Integer modifiedUser;

    private Date modifedDate;

    private Integer isDelete;

    private Integer isManual;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public Date getModifedDate() {
        return modifedDate;
    }

    public void setModifedDate(Date modifedDate) {
        this.modifedDate = modifedDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsManual() {
        return isManual;
    }

    public void setIsManual(Integer isManual) {
        this.isManual = isManual;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", pid=").append(pid);
        sb.append(", createdUser=").append(createdUser);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", modifiedUser=").append(modifiedUser);
        sb.append(", modifedDate=").append(modifedDate);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isManual=").append(isManual);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}