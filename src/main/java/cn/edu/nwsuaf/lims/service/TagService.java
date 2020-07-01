package cn.edu.nwsuaf.lims.service;
import cn.edu.nwsuaf.lims.model.Tag;
import cn.edu.nwsuaf.lims.core.Service;

import java.util.List;


/**
 * Created by liuchao Li on 2020/03/21.
 */
public interface TagService extends Service<Tag> {
    public List<Tag> findTagByArticleId(Integer articleId);
}
