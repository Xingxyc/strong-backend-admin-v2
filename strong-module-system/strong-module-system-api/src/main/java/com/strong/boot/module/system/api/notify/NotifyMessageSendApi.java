package com.strong.boot.module.system.api.notify;

import com.strong.boot.module.system.api.notify.dto.NotifySendSingleToUserReqDTO;
import com.strong.boot.module.system.api.notify.dto.NotifyTemplateReqDTO;

import javax.validation.Valid;

/**
 * 站内信发送 API 接口
 *
 * @author xrcoder
 */
public interface NotifyMessageSendApi {

    /**
     * 发送单条站内信给 Admin 用户
     *
     * @param reqDTO 发送请求
     * @return 发送消息 ID
     */
    Long sendSingleMessageToAdmin(@Valid NotifySendSingleToUserReqDTO reqDTO);

    /**
     * 发送单条站内信给 Member 用户
     *
     * @param reqDTO 发送请求
     * @return 发送消息 ID
     */
    Long sendSingleMessageToMember(@Valid NotifySendSingleToUserReqDTO reqDTO);


    boolean validateNotifyTemplate(String orderDelivery);

    void createNotifyTemplate(NotifyTemplateReqDTO templateReqDTO);
}
