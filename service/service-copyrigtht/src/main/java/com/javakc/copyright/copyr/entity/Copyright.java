package com.javakc.copyright.copyr.entity;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:版权类
 * @Date:2021/1/15 001517:39
 **/
@Setter
@Getter
@Entity
@Table(name="cms_copyright_in_copyright")
@EntityListeners(AuditingEntityListener.class)
public class Copyright{
    /** 主键 */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(name="主键id")
    private Integer id ;
    /** 版权名 */
    @Column(name="版权名称")
    @ApiModelProperty(value="版权名称")
    private String copyrightName ;
    /** 公司名 */
    @Column(name="公司名称")
    @ApiModelProperty(value="公司名称")
    private String companyName ;
    /** 备注名 */
    @Column(name="备注名")
    @ApiModelProperty(value="备注名")
    private String reasonName ;
    /** 合作状态 */
    @Column(name="合作状态")
    @ApiModelProperty(value="合作状态")
    private Byte isEffect ;
    /** 版权简介 */
    @Column(name="版权简介")
    @ApiModelProperty(value="版权简介")
    private String copyrightIntroduction ;
    /** 乐观锁 */
    @Column(name="乐观锁")
    @ApiModelProperty(value="乐观锁")
    private Integer revision ;
    /** 创建人 */
    @Column(name="创建人")
    @ApiModelProperty(value="创建人")
    private String createdBy ;
    /** 创建时间 */
    @Column(name="创建时间")
    @ApiModelProperty(value="创建时间")
    private Date gmtCreated ;
    /** 更新人 */
    @Column(name="更新人")
    @ApiModelProperty(value="更新人")
    private String updatedBy ;
    /** 更新时间 */
    @Column(name="更新时间")
    @ApiModelProperty(value="更新时间")
    private Date gmtModified ;
}

