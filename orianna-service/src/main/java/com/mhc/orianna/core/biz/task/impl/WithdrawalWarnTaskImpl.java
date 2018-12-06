package com.mhc.orianna.core.biz.task.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.camaro.message.dto.DingTalkMsgRequest;
import com.camaro.message.enums.DingMsgTypeEnum;
import com.camaro.message.enums.MessageChannelEnum;
import com.camaro.message.service.MessageService;
import com.mhc.acura.dubbo.IUserService;
import com.mhc.acura.dubbo.model.User;
import com.mhc.orianna.core.biz.task.WithdrawalWarnTask;
import com.mhc.orianna.dal.domain.Asset;
import com.mhc.orianna.dal.manager.AssetManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class WithdrawalWarnTaskImpl implements WithdrawalWarnTask {
    @Autowired
    private AssetManager assetManager;

    @Reference(interfaceClass = com.camaro.message.service.MessageService.class,version = "1.0_camaro_dev_docker")
    MessageService messageService;
    @Resource
    IUserService iUserService;

    @Override
    public void sendMessage() {
        //实现逻辑
        //1.获取当前日期
        Date dayNow=new Date();
        Calendar calendarRent = Calendar.getInstance();
        calendarRent.setTime(dayNow);

        //2.当前日期晚5天
        calendarRent.add(Calendar.DAY_OF_MONTH, 5);
        Date dayLaterRent = calendarRent.getTime();

        Calendar calendarReturn = Calendar.getInstance();
        calendarReturn.setTime(dayNow);
        calendarReturn.add(Calendar.DAY_OF_MONTH, 3);
        Date dayLaterReturn = calendarRent.getTime();

        Wrapper<Asset> ew1 = new EntityWrapper<>();
        ew1.eq("asset_source",1).eq("is_deleted",0);
        List<Asset> list1 = assetManager.selectList(ew1);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        for (Asset asset :list1){
            //3.租赁日期与晚5天日期比较
            Date assetRentEndDate = asset.getAssetRentEndDate();
            if(assetRentEndDate!=null){
                //租赁日期比当前时间晚5天早
                if(assetRentEndDate.before(dayLaterRent)){
                    if(asset.getAssetStatus().equals(0) || asset.getAssetStatus().equals(1)){
                        //给管理员发送短信
                        messageService.sendMessage(DingTalkMsgRequest
                                .dBuilder()
                                .channel(MessageChannelEnum.DTE_DEFAULT)
                                .dingMsgTypeEnum(DingMsgTypeEnum.TEXT)
                                .textContent("固资租赁到期通知\n" +
                                        "\n" +
                                        "资产编号："+asset.getAssetNo()+"\n" +
                                        "\n" +
                                        "资产类型："+asset.getAssetTypeName()+"\n" +
                                        "\n" +
                                        "租赁到期时间："+formatter.format(asset.getAssetRentEndDate())+"\n" +
                                        "\n" +
                                        "租金："+asset.getAssetOriginalValue()+"元/月\n" +
                                        "\n" +
                                        "领用人："+asset.getAuthStaffName()+"")
                                .ids(Collections.singletonList("04502443471137133"))
                                .build());
                    }
                }
            }
        }


        Wrapper<Asset> ew2 = new EntityWrapper<>();
        ew2.eq("is_deleted",0).eq("asset_status",1).eq("asset_flow_type",0);
        List<Asset> list2 = assetManager.selectList(ew2);
        for (Asset asset :list2){
            //4.归还日期与晚5天日期比较
            Date assetPredictReturnDate = asset.getAssetPredictReturnDate();
            if(assetPredictReturnDate!=null){
                //归还日期比当前时间晚3天早
                if(assetPredictReturnDate.before(dayLaterReturn)){
                    //给用户发送短信
                    User user = iUserService.findUserByRealNameOrNickName(asset.getAuthStaffName()).getData().get(0);
                    user = iUserService.findBy(Arrays.asList(user.getUserId())).getData().get(0);
                    messageService.sendMessage(DingTalkMsgRequest
                            .dBuilder()
                            .channel(MessageChannelEnum.DTE_DEFAULT)
                            .dingMsgTypeEnum(DingMsgTypeEnum.TEXT)
                            .textContent("借用到期通知\n" +
                                    "\n" +
                                    "资产编号："+asset.getAssetNo()+"\n" +
                                    "\n" +
                                    "资产类型："+asset.getAssetTypeName()+"\n" +
                                    "\n" +
                                    "借用到期时间："+formatter.format(asset.getAssetPredictReturnDate())+"\n" +
                                    "\n" +
                                    "领用人："+asset.getAuthStaffName()+"")
                            .ids(Collections.singletonList("04502443471137133"))
                            .build());

                    messageService.sendMessage(DingTalkMsgRequest
                            .dBuilder()
                            .channel(MessageChannelEnum.DTE_DEFAULT)
                            .dingMsgTypeEnum(DingMsgTypeEnum.TEXT)
                            .textContent("借用到期通知\n" +
                                    "\n" +
                                    "请及时归还以下借用设备\n"+
                                    "\n"+
                                    "资产编号："+asset.getAssetNo()+"\n" +
                                    "\n" +
                                    "资产类型："+asset.getAssetTypeName()+"\n" +
                                    "\n" +
                                    "借用到期时间："+formatter.format(asset.getAssetPredictReturnDate())+"")
                            .ids(Collections.singletonList(user.getDingdingUserId()))
                            .build());
                }
            }
        }
    }
}
