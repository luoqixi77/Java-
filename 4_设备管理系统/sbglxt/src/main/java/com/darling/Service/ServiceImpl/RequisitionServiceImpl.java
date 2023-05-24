package com.darling.Service.ServiceImpl;


import com.darling.Dao.RequisitionMapper;
import com.darling.Dao.StoreMapper;
import com.darling.Service.RequisitionService;
import com.darling.pojo.Requisition;
import com.darling.pojo.Store;
import com.darling.vo.RequisitionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisitionServiceImpl implements RequisitionService {
    @Autowired
    private RequisitionMapper requisitionMapper;

    @Autowired
    private StoreMapper storeMapper;

    /**
     * 查看领用申请记录
     *
     * @param rv
     * @return
     */
    @Override
    public List<Requisition> findRequisitionList(RequisitionVo rv) {
        return requisitionMapper.findRequisitionList(rv);
    }

    /**
     * 提交申请
     *
     * @param rt
     * @return
     */
    @Override
    public boolean add(Requisition rt) {
        try {
            int result = requisitionMapper.add(rt);
            if (result > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 撤销申请
     *
     * @param rid
     * @return
     */
    @Override
    public boolean revoke(String rid) {
        try {
            int result = requisitionMapper.revoke(rid);
            if (result > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查看待审核的领用申请
     *
     * @param rv
     * @return
     */
    @Override
    public List<Requisition> findApproveList(RequisitionVo rv) {
        return requisitionMapper.findApproveList(rv);
    }

    /**
     * 审核申请，修改进度状态
     *
     * @param rt
     * @return
     */
    @Override
    public boolean updateRstatus(Requisition rt) {
        try {
            int result = requisitionMapper.updateRstatus(rt);
            if (result > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 领用登记
     * 1.判断库存够不够
     * 2.修改库存量
     * 3.更改申请状态为 已发放
     *
     * @param rt
     * @return
     */
    @Override
    public boolean received(Requisition rt) {
        try {
            // 1.判断库存够不够
            String mid = rt.getMid();
            int total = storeMapper.getTotal(mid);
            Integer rnum = rt.getRnum();
            if (total >= rnum) {
                // 2.修改库存量，取相反数
                Integer num = rnum * (-1);
                int result1 = storeMapper.updateTotal(new Store(mid, num));
                if (result1 > 0) {
                    // 3.更改申请状态为 已发放
                    int result2 = requisitionMapper.received(rt);
                    if (result2 > 0) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查找全部的领用记录
     * @param rv
     * @return
     */
    @Override
    public List<Requisition> findAll(RequisitionVo rv){
        return requisitionMapper.findAll(rv);
    }

    /**
     * 发布设备领取任务
     * @param rt
     * @return
     */
    @Override
    public boolean give(Requisition rt){
        try {
            int result = requisitionMapper.give(rt);
            if (result > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
