package club.easyshare.glue.system;

import club.easyshare.dao.data.system.ViewRecordDO;
import club.easyshare.dao.jpa.system.ViewRecordDAO;
import club.easyshare.glue.base.BaseGlue;
import club.easysharing.model.bean.system.ViewRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ViewRecordGlue
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 14:37:31
 */
@Component
public class ViewRecordGlue extends BaseGlue {

    @Autowired
    private ViewRecordDAO viewRecordDAO;

    /**
     * 保存浏览记录
     *
     * @param viewRecord
     */
    public ViewRecord saveViewRecord(ViewRecord viewRecord) {
        ViewRecordDO viewRecordDO=convertIgnoreNullProperty(viewRecord,ViewRecordDO.class);
        viewRecordDO=viewRecordDAO.save(viewRecordDO);
        ViewRecord viewRecordSaved = convertIgnoreNullProperty(viewRecordDO, ViewRecord.class);
        return viewRecordSaved;
    }
}
