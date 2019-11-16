package cn.edu.nwsuaf.lims.service.impl;

import cn.edu.nwsuaf.lims.dao.Poem2Mapper;
import cn.edu.nwsuaf.lims.model.Poem2;
import cn.edu.nwsuaf.lims.service.Poem2Service;
import cn.edu.nwsuaf.lims.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by liuchao Li on 2019/10/27.
 */
@Service
@Transactional
public class Poem2ServiceImpl extends AbstractService<Poem2> implements Poem2Service {
    @Resource
    private Poem2Mapper poem2Mapper;

}
