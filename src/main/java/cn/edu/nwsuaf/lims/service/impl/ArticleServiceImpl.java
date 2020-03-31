package cn.edu.nwsuaf.lims.service.impl;

import cn.edu.nwsuaf.lims.dao.ArticleMapper;
import cn.edu.nwsuaf.lims.model.Article;
import cn.edu.nwsuaf.lims.service.ArticleService;
import cn.edu.nwsuaf.lims.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by liuchao Li on 2020/02/17.
 */
@Service
@Transactional
public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<Article> findByKeywords(Integer page, String keywords) {
        String keyres="%"+keywords+"%";
        Condition condition = new Condition(Article.class);
        System.out.println(keywords);
       condition.createCriteria().orLike("title",keyres).orLike("content",keyres);
        //condition.createCriteria().orLike("title",keyres);

        List<Article> list = findByCondition(condition);
        return list;
    }
}
