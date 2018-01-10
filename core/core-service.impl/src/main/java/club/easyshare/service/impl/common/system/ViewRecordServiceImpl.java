package club.easyshare.service.impl.common.system;

import club.easyshare.glue.system.ViewRecordGlue;
import club.easyshare.service.common.system.ViewRecordService;
import club.easyshare.service.impl.common.BaseServiceImpl;
import club.easysharing.model.parameter.system.ViewRecordParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ViewRecordServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 14:45:50
 */
@Service("viewRecordService")
public class ViewRecordServiceImpl extends BaseServiceImpl implements ViewRecordService {

    @Autowired
    private ViewRecordGlue viewRecordGlue;

    @Override
    public void saveViewRecord(ViewRecordParameter viewRecordParameter) {
        viewRecordGlue.saveViewRecord(viewRecordParameter);
    }
}
