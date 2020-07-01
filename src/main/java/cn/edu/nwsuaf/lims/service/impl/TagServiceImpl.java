package cn.edu.nwsuaf.lims.service.impl;

import cn.edu.nwsuaf.lims.dao.TagMapper;
import cn.edu.nwsuaf.lims.model.Reply;
import cn.edu.nwsuaf.lims.model.Tag;
import cn.edu.nwsuaf.lims.service.TagService;
import cn.edu.nwsuaf.lims.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by liuchao Li on 2020/03/21.
 */
@Service
@Transactional
public class TagServiceImpl extends AbstractService<Tag> implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<Tag> findTagByArticleId(Integer articleId) {
        Condition condition = new Condition(Tag.class);
        System.out.println(articleId);
        condition.createCriteria().andEqualTo("articleId",articleId);
        List<Tag> list = findByCondition(condition);
        if(!list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }
}
