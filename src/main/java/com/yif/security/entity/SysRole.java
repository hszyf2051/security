package com.yif.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 角色表;
 * @author : yif
 * @date : 2023-7-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "角色表")
@TableName("sys_role")
public class SysRole implements Serializable{

    /** 主键id */
    @Schema(description  = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id ;


    /** 角色 */
    @Schema(description  = "角色")
    private String role ;


    /** 角色名称 */
    @Schema(description  = "角色名称")
    private String roleName ;


}