package com.example.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author yerong
 * @since 2019-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbContent implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 内容类目ID
     */
    private Long categoryId;

    /**
     * 内容标题
     */
    private String title;

    /**
     * 子标题
     */
    private String subTitle;

    /**
     * 标题描述
     */
    private String titleDesc;

    /**
     * 链接
     */
    private String url;

    /**
     * 图片绝对路径
     */
    private String pic;

    /**
     * 图片2
     */
    private String pic2;

    /**
     * 内容
     */
    private String content;

    @JsonFormat(pattern = DATE_FORMAT, timezone="GMT+8") // 添加此注解以解决在 swagger-ui.html页面中返回 date 格式错误
    private LocalDateTime created;

    @JsonFormat(pattern = DATE_FORMAT, timezone="GMT+8")
    private LocalDateTime updated;


}
