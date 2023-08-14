package com.ss.bean;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@TableName("tblmanager")
public class Tblmanager {

  @TableId(value = "managerId",type = IdType.AUTO)
  private long managerId;
  @TableField("managerAcc")
  private String managerAcc;
  @TableField("managerPwd")
  private String managerPwd;
  @TableField("realName")
  private String realName;
  private long status;
  @Version
  private int version;


  public long getManagerId() {
    return managerId;
  }

  public void setManagerId(long managerId) {
    this.managerId = managerId;
  }


  public String getManagerAcc() {
    return managerAcc;
  }

  public void setManagerAcc(String managerAcc) {
    this.managerAcc = managerAcc;
  }


  public String getManagerPwd() {
    return managerPwd;
  }

  public void setManagerPwd(String managerPwd) {
    this.managerPwd = managerPwd;
  }


  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }
}
