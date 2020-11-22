package cn.edu.nwsuaf.lims.service;
import cn.edu.nwsuaf.lims.model.Article;
import cn.edu.nwsuaf.lims.core.Service;

import java.util.List;


/**
 * Created by liuchao Li on 2020/02/17.
 */
public interface ArticleService extends Service<Article> {
 public List<Article> findByKeywords(Integer page, String keywords);
 public List<Article> findAllArticle();
 public Article findAritcleById(Integer id);
}
