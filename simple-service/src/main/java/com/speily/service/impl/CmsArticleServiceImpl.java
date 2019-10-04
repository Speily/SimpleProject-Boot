package com.speily.service.impl;

import com.speily.common.utils.DateUtils;
import com.speily.common.utils.text.Convert;
import com.speily.entity.CmsArticle;
import com.speily.mapper.CmsArticleMapper;
import com.speily.service.ICmsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章Service业务层处理
 *
 * @author spl
 * @date 2019-10-03
 */
@Service
public class CmsArticleServiceImpl implements ICmsArticleService {
    @Autowired
    private CmsArticleMapper cmsArticleMapper;

    /**
     * 查询文章
     *
     * @param articleId 文章ID
     * @return 文章
     */
    @Override
    public CmsArticle selectCmsArticleById(Long articleId) {
        return cmsArticleMapper.selectCmsArticleById(articleId);
    }

    /**
     * 查询文章列表
     *
     * @param cmsArticle 文章
     * @return 文章
     */
    @Override
    public List<CmsArticle> selectCmsArticleList(CmsArticle cmsArticle) {
        return cmsArticleMapper.selectCmsArticleList(cmsArticle);
    }

    /**
     * 新增文章
     *
     * @param cmsArticle 文章
     * @return 结果
     */
    @Override
    public int insertCmsArticle(CmsArticle cmsArticle) {
        cmsArticle.setCreateTime(DateUtils.getNowDate());
        return cmsArticleMapper.insertCmsArticle(cmsArticle);
    }

    /**
     * 修改文章
     *
     * @param cmsArticle 文章
     * @return 结果
     */
    @Override
    public int updateCmsArticle(CmsArticle cmsArticle) {
        cmsArticle.setUpdateTime(DateUtils.getNowDate());
        return cmsArticleMapper.updateCmsArticle(cmsArticle);
    }

    /**
     * 删除文章对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCmsArticleByIds(String ids) {
        return cmsArticleMapper.deleteCmsArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章信息
     *
     * @param articleId 文章ID
     * @return 结果
     */
    public int deleteCmsArticleById(Long articleId) {
        return cmsArticleMapper.deleteCmsArticleById(articleId);
    }
}
