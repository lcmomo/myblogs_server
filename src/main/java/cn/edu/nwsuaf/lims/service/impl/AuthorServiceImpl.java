package cn.edu.nwsuaf.lims.service.impl;

import cn.edu.nwsuaf.lims.dao.AuthorMapper;
import cn.edu.nwsuaf.lims.model.Author;
import cn.edu.nwsuaf.lims.service.AuthorService;
import cn.edu.nwsuaf.lims.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by liuchao Li on 2019/09/10.
 */
@Service
@Transactional
public class AuthorServiceImpl extends AbstractService<Author> implements AuthorService {
    @Resource
    private AuthorMapper authorMapper;

}
