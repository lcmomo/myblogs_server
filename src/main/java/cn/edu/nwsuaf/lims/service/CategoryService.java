package cn.edu.nwsuaf.lims.service;
import cn.edu.nwsuaf.lims.model.Category;
import cn.edu.nwsuaf.lims.core.Service;

import java.util.List;


/**
 * Created by liuchao Li on 2020/06/28.
 */
public interface CategoryService extends Service<Category> {
    public List<Category> findCategoryByArticleId(Integer articleId);
}
