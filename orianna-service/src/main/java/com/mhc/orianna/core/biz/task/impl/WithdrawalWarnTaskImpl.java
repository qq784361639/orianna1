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
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dayNow);

        //2.当前日期晚5天
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        Date dayLater = calendar.getTime();

        Wrapper<Asset> ew1 = new EntityWrapper<>();
        ew1.eq("asset_source",1).eq("is_deleted",0);
        List<Asset> list1 = assetManager.selectList(ew1);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        for (Asset asset :list1){
            //3.租赁日期与晚5天日期比较
            Date assetRentEndDate = asset.getAssetRentEndDate();
            if(assetRentEndDate!=null){
                //租赁日期比当前时间晚5天早
                if(assetRentEndDate.before(dayLater)){
                    if(asset.getAssetStatus().equals(0)){
                        //给管理员发送短信
                        messageService.sendMessage(DingTalkMsgRequest
                                .dBuilder()
                                .channel(MessageChannelEnum.DTE_DEFAULT)
                                .dingMsgTypeEnum(DingMsgTypeEnum.TEXT)
                                .textContent("现在是"+dateString+",有"+asset.getAssetTypeName()+"编号为："+asset.getAssetNo()+"的"+asset.getCatalogModel()+"即将到期，请在"+formatter.format(asset.getAssetRentEndDate())+"之前退租。")
                                .ids(Collections.singletonList("04502443471137133"))
                                .build());
                    }

                }
                    if(asset.getAssetStatus().equals(1)){
                        //给用户发送短信
                        User user = iUserService.findUserByRealNameOrNickName(asset.getAuthStaffName()).getData().get(0);
                        user = iUserService.findBy(Arrays.asList(user.getUserId())).getData().get(0);
                        messageService.sendMessage(DingTalkMsgRequest
                                .dBuilder()
                                .channel(MessageChannelEnum.DTE_DEFAULT)
                                .dingMsgTypeEnum(DingMsgTypeEnum.TEXT)
                                .textContent("现在是"+dateString+",有"+asset.getAssetTypeName()+"编号为："+asset.getAssetNo()+"的"+asset.getCatalogModel()+"即将到期，请在"+formatter.format(asset.getAssetRentEndDate())+"之前退租。")
                                .ids(Collections.singletonList("04502443471137133"))
                                .build());
                        messageService.sendMessage(DingTalkMsgRequest
                                .dBuilder()
                                .channel(MessageChannelEnum.DTE_DEFAULT)
                                .dingMsgTypeEnum(DingMsgTypeEnum.TEXT)
                                .textContent("现在是"+dateString+",您的"+asset.getAssetTypeName()+"编号为："+asset.getAssetNo()+"的"+asset.getCatalogModel()+"即将到期，请在"+formatter.format(asset.getAssetPredictReturnDate())+"之前归还。")
                                .ids(Collections.singletonList(user.getDingdingUserId()))
                                .build());
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
                //归还日期比当前时间晚5天早
                if(assetPredictReturnDate.before(dayLater)){
                    //给用户发送短信
                    User user = iUserService.findUserByRealNameOrNickName(asset.getAuthStaffName()).getData().get(0);
                    user = iUserService.findBy(Arrays.asList(user.getUserId())).getData().get(0);
                    messageService.sendMessage(DingTalkMsgRequest
                            .dBuilder()
                            .channel(MessageChannelEnum.DTE_DEFAULT)
                            .dingMsgTypeEnum(DingMsgTypeEnum.TEXT)
                            .textContent("现在是"+dateString+",您的"+asset.getAssetTypeName()+"编号为："+asset.getAssetNo()+"的"+asset.getCatalogModel()+"尚未归还，请在"+formatter.format(asset.getAssetPredictReturnDate())+"之前归还。")
                            .ids(Collections.singletonList(user.getDingdingUserId()))
                            .build());
                }
            }
        }

    }
}
