package com.yif.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yif.security.entity.vo.UserRoleVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
@Schema(description = "系统用户表")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @Schema(description = "主键id")
    private String id;

    @Schema(description = "用户名")
    private String userName;

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "账号状态（0正常 1停用）")
    private String status;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "用户性别（0男，1女，2未知）")
    private String gender;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "创建人id")
    private String createId;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新人id")
    private String updateId;
    
    @Schema(description = "更新时间")
    private Date updateTime;

    @TableField(exist = false)
    @Schema(description = "用户角色信息")
    private List<UserRoleVo> userRoleVoList;
}
