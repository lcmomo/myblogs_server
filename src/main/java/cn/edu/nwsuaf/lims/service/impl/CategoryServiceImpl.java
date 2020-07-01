package cn.edu.nwsuaf.lims.service.impl;

import cn.edu.nwsuaf.lims.dao.CategoryMapper;
import cn.edu.nwsuaf.lims.model.Category;
import cn.edu.nwsuaf.lims.service.CategoryService;
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
public class CategoryServiceImpl extends AbstractService<Category> implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findCategoryByArticleId(Integer articleId) {
        Condition condition = new Condition(Category.class);
        System.out.println(articleId);
        condition.createCriteria().andEqualTo("articleId",articleId);
        List<Category> list = findByCondition(condition);
        if(!list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }
}
