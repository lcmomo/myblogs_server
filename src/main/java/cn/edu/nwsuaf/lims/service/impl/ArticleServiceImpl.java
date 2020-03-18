package cn.edu.nwsuaf.lims.service.impl;

import cn.edu.nwsuaf.lims.dao.ArticleMapper;
import cn.edu.nwsuaf.lims.model.Article;
import cn.edu.nwsuaf.lims.service.ArticleService;
import cn.edu.nwsuaf.lims.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by liuchao Li on 2020/02/17.
 */
@Service
@Transactional
public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

}
