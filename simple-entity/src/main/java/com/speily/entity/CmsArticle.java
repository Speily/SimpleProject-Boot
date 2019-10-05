package com.speily.entity;

import com.speily.entity.base.BaseEntity;
import com.speily.entity.base.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 文章对象 cms_article
 *
 * @author spl
 * @date 2019-10-03
 */
public class CmsArticle extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 文章主键 */
    private Long articleId;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String articleTittle;

    /** null */
    @Excel(name = "null")
    private String articleContext;

    /** 显示排序 */
    @Excel(name = "显示排序")
    private Integer orderNum;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setArticleId(Long articleId){
        this.articleId = articleId;
    }

    public Long getArticleId(){
        return articleId;
    }
    public void setArticleTittle(String articleTittle){
        this.articleTittle = articleTittle;
    }

    public String getArticleTittle(){
        return articleTittle;
    }
    public void setArticleContext(String articleContext){
        this.articleContext = articleContext;
    }

    public String getArticleContext(){
        return articleContext;
    }
    public void setOrderNum(Integer orderNum){
        this.orderNum = orderNum;
    }

    public Integer getOrderNum(){
        return orderNum;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
    public void setDelFlag(String delFlag){
        this.delFlag = delFlag;
    }

    public String getDelFlag(){
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("articleId", getArticleId())
            .append("articleTittle", getArticleTittle())
            .append("articleContext", getArticleContext())
            .append("orderNum", getOrderNum())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
