package cn.edu.nwsuaf.lims.service.impl;

import cn.edu.nwsuaf.lims.dao.TagMapper;
import cn.edu.nwsuaf.lims.model.Tag;
import cn.edu.nwsuaf.lims.service.TagService;
import cn.edu.nwsuaf.lims.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by liuchao Li on 2020/03/21.
 */
@Service
@Transactional
public class TagServiceImpl extends AbstractService<Tag> implements TagService {
    @Resource
    private TagMapper tagMapper;

}
