package cn.edu.nwsuaf.lims.service.impl;

import cn.edu.nwsuaf.lims.dao.ModelMapper;
import cn.edu.nwsuaf.lims.model.Model;
import cn.edu.nwsuaf.lims.service.ModelService;
import cn.edu.nwsuaf.lims.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by liuchao Li on 2019/09/08.
 */
@Service
@Transactional
public class ModelServiceImpl extends AbstractService<Model> implements ModelService {
    @Resource
    private ModelMapper modelMapper;

}
