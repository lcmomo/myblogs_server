package cn.edu.nwsuaf.lims.service;
import cn.edu.nwsuaf.lims.model.Article;
import cn.edu.nwsuaf.lims.model.Comment;
import cn.edu.nwsuaf.lims.core.Service;

import java.util.List;


/**
 * Created by liuchao Li on 2020/06/28.
 */
public interface CommentService extends Service<Comment> {
    public List<Comment> findByKeywords(String keywords);
    public List<Comment> findByArticleId(Integer articleId);
}
