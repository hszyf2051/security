package com.yif.security.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yif
 * @date 2023/7/24 10:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "VO-用户角色信息")
public class UserRoleVo {

    @Schema(description = "角色")
    private String role;

    @Schema(description = "角色名称")
    private String roleName;

}
