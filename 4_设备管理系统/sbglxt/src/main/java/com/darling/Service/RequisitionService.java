package com.darling.Service;

import com.darling.pojo.Requisition;
import com.darling.vo.RequisitionVo;

import java.util.List;

public interface RequisitionService {
    /**
     * 查找申领信息
     * @param rv
     * @return
     */
    public List<Requisition> findRequisitionList(RequisitionVo rv);

    /**
     * 提交申请
     * @param rt
     * @return
     */
    public boolean add(Requisition rt);

    /**
     * 撤销申请
     * @param rid
     * @return
     */
    public boolean revoke(String rid);

    /**
     * 查看待审核的领用申请
     * @param rv
     * @return
     */
    public List<Requisition> findApproveList(RequisitionVo rv);

    /**
     * 审核申请，修改进度状态
     * @param rt
     * @return
     */
    public boolean updateRstatus(Requisition rt);

    /**
     * 领用登记
     * @param rt
     * @return
     */
    public boolean received(Requisition rt);

    /**
     * 查找全部的领用记录
     * @param rv
     * @return
     */
    public List<Requisition> findAll(RequisitionVo rv);

    /**
     * 发布物资领取任务
     * @param rt
     * @return
     */
    public boolean give(Requisition rt);
}
