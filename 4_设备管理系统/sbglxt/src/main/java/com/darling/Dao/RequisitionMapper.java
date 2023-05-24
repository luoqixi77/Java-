package com.darling.Dao;

import com.darling.pojo.Requisition;
import com.darling.vo.RequisitionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RequisitionMapper {

    /**
     * 查看领用申请记录
     * @param rv
     * @return
     */
    public List<Requisition> findRequisitionList(RequisitionVo rv);

    /**
     * 提交申请
     * @param rt
     * @return
     */
    public int add(Requisition rt);

    /**
     * 撤销申请
     * @param rid
     * @return
     */
    public int revoke(String rid);


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
    public int updateRstatus(Requisition rt);

    /**
     * 领用登记
     * @param rt
     * @return
     */
    public int received(Requisition rt);

    /**
     * 查找全部的领用记录
     * @param rv
     * @return
     */
    public List<Requisition> findAll(RequisitionVo rv);

    /**
     * 发布设备领取任务
     * @param rt
     * @return
     */
    public int give(Requisition rt);
}
