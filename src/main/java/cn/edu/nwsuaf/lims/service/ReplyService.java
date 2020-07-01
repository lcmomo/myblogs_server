package cn.edu.nwsuaf.lims.service;
import cn.edu.nwsuaf.lims.model.Reply;
import cn.edu.nwsuaf.lims.core.Service;

import java.util.List;


/**
 * Created by liuchao Li on 2020/06/28.
 */
public interface ReplyService extends Service<Reply> {

    public List<Reply> findReplyByArticleIdAndCommentId(Integer commentId);
}
