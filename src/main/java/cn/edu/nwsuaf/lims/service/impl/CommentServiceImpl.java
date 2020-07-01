package cn.edu.nwsuaf.lims.service.impl;

import cn.edu.nwsuaf.lims.dao.CommentMapper;

import cn.edu.nwsuaf.lims.model.Comment;
import cn.edu.nwsuaf.lims.model.Reply;
import cn.edu.nwsuaf.lims.service.CommentService;
import cn.edu.nwsuaf.lims.core.AbstractService;
import cn.edu.nwsuaf.lims.service.ReplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by liuchao Li on 2020/06/28.
 */
@Service
@Transactional
public class CommentServiceImpl extends AbstractService<Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private ReplyService replyService;

    @Override
    public List<Comment> findByKeywords(String keywords) {
        String keyres="%"+keywords+"%";
        Condition condition = new Condition(Comment.class);
        System.out.println(keywords);
        condition.createCriteria().orLike("title",keyres);

        List<Comment> list = findByCondition(condition);
        return list;
    }

    @Override
    public List<Comment> findByArticleId(Integer articleId) {
        Condition condition = new Condition(Comment.class);
        System.out.println(articleId);
        condition.createCriteria().andEqualTo("articleId",articleId);
        List<Comment> list = findByCondition(condition);
        if(!list.isEmpty()) {
            for (Comment comment: list) {
                System.out.println(comment.getId());
                List <Reply> replyList = replyService.findReplyByArticleIdAndCommentId(comment.getId());
                comment.setReplyList(replyList);
            }
            return list;
        } else {
            return null;
        }
    }
}
