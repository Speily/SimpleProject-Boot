package com.speily.mapper;

import com.speily.entity.CmsArticle;

import java.util.List;

/**
 * 文章Mapper接口
 *
 * @author spl
 * @date 2019-10-03
 */
public interface CmsArticleMapper {
    /**
     * 查询文章
     *
     * @param articleId 文章ID
     * @return 文章
     */
    CmsArticle selectCmsArticleById(Long articleId);

    /**
     * 查询文章列表
     *
     * @param cmsArticle 文章
     * @return 文章集合
     */
    List<CmsArticle> selectCmsArticleList(CmsArticle cmsArticle);

    /**
     * 新增文章
     *
     * @param cmsArticle 文章
     * @return 结果
     */
    int insertCmsArticle(CmsArticle cmsArticle);

    /**
     * 修改文章
     *
     * @param cmsArticle 文章
     * @return 结果
     */
    int updateCmsArticle(CmsArticle cmsArticle);

    /**
     * 删除文章
     *
     * @param articleId 文章ID
     * @return 结果
     */
    int deleteCmsArticleById(Long articleId);

    /**
     * 批量删除文章
     *
     * @param articleIds 需要删除的数据ID
     * @return 结果
     */
    int deleteCmsArticleByIds(String[] articleIds);
}
