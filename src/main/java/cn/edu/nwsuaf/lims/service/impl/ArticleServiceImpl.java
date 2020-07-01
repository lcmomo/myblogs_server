package cn.edu.nwsuaf.lims.service.impl;

import cn.edu.nwsuaf.lims.dao.ArticleMapper;
import cn.edu.nwsuaf.lims.model.Article;
import cn.edu.nwsuaf.lims.model.Category;
import cn.edu.nwsuaf.lims.model.Comment;
import cn.edu.nwsuaf.lims.model.Tag;
import cn.edu.nwsuaf.lims.service.ArticleService;
import cn.edu.nwsuaf.lims.core.AbstractService;
import cn.edu.nwsuaf.lims.service.CategoryService;
import cn.edu.nwsuaf.lims.service.CommentService;
import cn.edu.nwsuaf.lims.service.TagService;
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

    @Resource
    private CommentService commentService;
    @Resource
    private TagService tagService;
    @Resource
    private CategoryService categoryService;

    @Override
    public List<Article> findByKeywords(Integer page, String keywords) {
        String keyres="%"+keywords+"%";
        Condition condition = new Condition(Article.class);
        System.out.println(keywords);
       condition.createCriteria().orLike("title",keyres).orLike("content",keyres);
        //condition.createCriteria().orLike("title",keyres);

        List<Article> list = findByCondition(condition);
        for (int i =0;i< list.size();i++) {
            list.get(i).setCommentList(commentService.findByArticleId(list.get(i).getId()));
        }
        return list;
    }
    @Override
    public List<Article> findAllArticle() {
      List <Article> list =  findAll();
        for (Article article: list) {
            System.out.println(article.getId());
            List <Comment> commitList = commentService.findByArticleId(article.getId());
            List <Tag> tagList = tagService.findTagByArticleId(article.getId());
            List <Category> categoryList = categoryService.findCategoryByArticleId(article.getId());
            article.setCommentList(commitList);
            article.setCategoryList(categoryList);
            article.setTagList(tagList);
        }
        return  list;
    }

}
