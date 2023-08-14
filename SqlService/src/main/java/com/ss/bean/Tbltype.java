package com.ss.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("tblType")
public class Tbltype implements Serializable {
  @TableId(type = IdType.AUTO,value = "goodsTypeId")
  //@JsonSerialize(using= ToStringSerializer.class)
  @TableField("goodsTypeId")
  private long goodsTypeId;
  @TableField("typeName")
  private String typeName;
  @TableField("parentId")
  private Long parentId;
  @TableField("status")
  private Long status;

  public Tbltype() {
  }

  public Tbltype(long goodsTypeId, String typeName, Long parentId, Long status) {
    this.goodsTypeId = goodsTypeId;
    this.typeName = typeName;
    this.parentId = parentId;
    this.status = status;
  }

  public long getGoodsTypeId() {
    return goodsTypeId;
  }

  public void setGoodsTypeId(long goodsTypeId) {
    this.goodsTypeId = goodsTypeId;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Tbltype{" +
            "goodsTypeId=" + goodsTypeId +
            ", typeName='" + typeName + '\'' +
            ", parentId=" + parentId +
            ", status=" + status +
            '}';
  }
}
