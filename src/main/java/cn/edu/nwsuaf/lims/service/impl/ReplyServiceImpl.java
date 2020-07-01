package cn.edu.nwsuaf.lims.service.impl;

import cn.edu.nwsuaf.lims.dao.ReplyMapper;

import cn.edu.nwsuaf.lims.model.Reply;
import cn.edu.nwsuaf.lims.service.ReplyService;
import cn.edu.nwsuaf.lims.core.AbstractService;
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
public class ReplyServiceImpl extends AbstractService<Reply> implements ReplyService {
    @Resource
    private ReplyMapper replyMapper;

    @Override
    public List<Reply> findReplyByArticleIdAndCommentId(Integer commentId) {
        Condition condition = new Condition(Reply.class);
        System.out.println(commentId);
        condition.createCriteria().andEqualTo("commentId",commentId);
        List<Reply> list = findByCondition(condition);
        if(!list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }
}
