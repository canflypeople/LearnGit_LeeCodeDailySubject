package com.test;

import java.util.*;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/8/9 下午3:23
 **/
public class Solution3 {

  public static String excelStr = "account-permission,,,,,,,,,,,,,,,accountlink,,,,,,,,,,,,,,,adam,,,,,,,,,,,,,,,aimt-admin-frontend,,,,,,,,,,,,,,,aimt-asr-comparison,,,,,,,,,,,,,,,aimt-asr-switch,,,,,,,,,,,,,,aimt-asr-switch-huiyi,,,,,,,,,,,,,,aimt-asr-switch-shenxun,,,,,,,,,,,,,,aimt-auth,,,,,,,,,,,,,,aimt-business,,,,,,,,,,,,,,aimt-business-admin,,,,,,,,,,,,,,aimt-cloud-admin-frontend,,,,,,,,,,,,,,aimt-cloud-asr-switch,,,,,,,,,,,,,,aimt-cloud-auth,,,,,,,,,,,,,,aimt-cloud-business,,,,,,,,,,,,,,aimt-cloud-business-admin,,,,,,,,,,,,,,aimt-cloud-frontend,,,,,,,,,,,,,,aimt-cloud-ot,,,,,,,,,,,,,,aimt-company-frontend,,,,,,,,,,,,,,aimt-device-activation,,,,,,,,,,,,,,aimt-external-admin,,,,,,,,,,,,,,aimt-external-controller,,,,,,,,,,,,,,aimt-frontend,,,,,,,,,,,,,,aimt-frontend-huiyi,,,,,,,,,,,,,,aimt-frontend-shenxun,,,,,,,,,,,,,,aimt-hymf-mp,,,,,,,,,,,,,,aimt-kong,,,,,,,,,,,,,,aimt-kong-dashboard,,,,,,,,,,,,,,aimt-newsmy-web,,,,,,,,,,,,,,aimt-ot-server,,,,,,,,,,,,,,aimt-ota-admin,,,,,,,,,,,,,,aimt-otg-activation,,,,,,,,,,,,,,aimt-temperature-server,,,,,,,,,,,,,,aimt-transfer,,,,,,,,,,,,,,aimt-xytt-member,,,,,,,,,,,,,,aiot-account-permission,,,,,,,,,,,,,,,aiot-common-functions,,,,,,,,,,,,,,aiot-smarthome-3rd-ys,,,,,,,,,,,,,,ama-demo,,,,,,,,,,,,,,ama-lowcode,,,,,,,,,,,,,,apisix,,,,,,,,,,,,,,apisix-gray-tool,,,,,,,,,,,,,,apisix-ingress-controller,,,,,,,,,,,,,,apisix-manager,,,,,,,,,,,,,,builtInWebhook,,,,,,,,,,,,,,cdmserver,,,,,,,,,,,,,,CInfoServer,,,,,,,cloud-license-admin,,,,,,,,,,,,,,cnluserver,,,,,,,,,,,,,,content,,,,,,,,,,,,,,content-service-platform,,,,,,,,,,,,,,content-web,,,,,,,,,,,,,,corridor,,,,,,,,,,,,,,corridormonitor,,,,,,,,,,,,,,dca-app,,,,,,,,,,,,,,dcmp,,,,,,,,,,,,,,DDSServer,,,,,,,,,,,,,,ddsserver2,,,,,,,dm-dispatch-server,,,,,,,dm-dispatch-server-old,,,,,,,Dolphin Scheduler,,,,,,,,,,,,,,Dui Ai,,,,,,,,,,,,,,dui-ai,,,,,,,,,,,,,,dui-authentication,,,,,,,,,,,,,,dui-static,,,,,,,,,,,,,,duilite-for-car-hotwords,,,,,,,,,,,,,,en-skill-class,,,,,,,ezml-core-hotword,,,,,,,,,,,,,,ezmt-asr-analysis-api,,,,,,,,,,,,,,ezmt-datamove,,,,,,,,,,,,,,ezmt-hotword,,,,,,,,,,,,,,ezmt-japi,,,,,,,,,,,,,,ezmt-japi-private,,,,,,,,,,,,,,ezmt-local-ebnf,,,,,,,,,,,,,,ezmt-model-remake,,,,,,,,,,,,,,ezmt-modeleval,,,,,,,ezmt-private-hotword,,,,,,,,,,,,,,ezmt-pyapi,,,,,,,,,,,,,,ezmt-pyapi-analysis,,,,,,,,,,,,,,ezmt-pyapi-private-inverse,,,,,,,,,,,,,,ezmt-pyapi-private-patslot,,,,,,,,,,,,,,ezmt-pyapi-private-sensitive,,,,,,,,,,,,,ezmt-pyapi-private-text,,,,,,,,,,,,,,ezwk-api,,,,,,,,,,,,,,ezwk-core,,,,,,,,,,,,,,fed-webhook-test,,,,,,,,,,,,,,gitlab-jenkins-webhook-proxy,,,,,,,,,,,,,,green_edu,,,,,,,,,,,,,,hotword,,,,,,,hotword-tool,,,,,,,,,,,,,,image-classify,,,,,,,IoT-Hub,,,,,,,jddsserver,,,,,,,,,,,,,,jddsserverflux,,,,,,,,,,,,,,kong-dashboard,,,,,,,,,,,,,,kong-grace,,,,,,,,,,,,,,kong-gray-dashboard,,,,,,,,,,,,,,lowpower-wakeup-demo,,,,,,,,,,,,,,lyra-dsk,,,,,,,,,,,,,,lyra-h5,,,,,,,,,,,,,,lyra-web2img,,,,,,,,,,,,,,lyra_web_cloud,,,,,,,,,,,,,,me-hotword-offline-service,,mscp-admin-gw,,,,,,,,,,,,,,mscp-admin-permission,,,,,,,,,,,,,,mscp-auth-admin,,,,,,,,,,,,,,mscp-boss-billing,,,,,,,,,,,,,,mscp-boss-control,,,,,,,,,,,,,,mscp-boss-customer,,,,,,,,,,,,,,mscp-boss-metering,,,,,,,,,,,,,,mscp-boss-metering-api,,,,,,,,,,,,,,mscp-boss-order,,,,,,,,,,,,,,mscp-boss-pricing,,,,,,,,,,,,,,mscp-boss-product,,,,,,,,,,,,,,mscp-captcha,,,,,,,,,,,,,,mscp-commerce-commodity,,,,,,,,,,,,,,mscp-commerce-order,,,,,,,,,,,,,,mscp-commerce-order-admin,,,,,,,,,,,,,,mscp-commerce-pay,,,,,,,,,,,,,,mscp-common-product,,,,,,,,,,,,,,mscp-crm,,,,,,,,,,,,,,mscp-custom-resource-admin,,,,,,,,,,,,,,mscp-developer-tools,,,,,,,,,,,,,,mscp-dsl,,,,,,,,,,,,,,mscp-gw-v3,,,,,,,,,,,,,,mscp-member-central,,,,,,,,,,,,,,mscp-message-push,,,,,,,,,,,,,,mscp-organization-admin,,,,,,,,,,,,,,mscp-owl,,,,,,,,,,,,,,mscp-owl-api,,,,,,,,,,,,,,mscp-owl-dbtest,,,,,,,,,,,,,,mscp-owl-diagnostic,,,,,,,,,,,,,,mscp-owl-job,,,,,,,,,,,,,,mscp-owl-native,,,,,,,,,,,,,,mscp-owl-sideserver,,,,,,,,,,,,,,mscp-resource-goods,,,,,,,,,,,,,,mscp-resource-rule,,,,,,,,,,,,,,mscp-server-detect,,,,,,,,,,,,,,mscp-skill-admin,,,,,,,,,,,,,,mscp-skill-core,,,,,,,,,,,,,,mscp-skill-router,,,,,,,,,,,,,,mscp-skyline-api,,,,,,,,,,,,,,mscp-skyline-backend,,,,,,,,,,,,,,mscp-table-resource,,,,,,,,,,,,,,mscp-ums,,,,,,,,,,,,,,msfc-gw,,,,,,,,,,,,,,msfc-organization,,,,,,,,,,,,,,msfc-registry,,,,,,,,,,,,,,msfc-skill,,,,,,,,,,,,,,msfc-skillStore,,,,,,,,,,,,,,nlq-server,,,,,,,,,,,,,,Nlu Platform Service,,,,,,,,,,,,,,nlu-platform-service,,,,,,,,,,,,,,odcp-admin-boss,,,,,,,,,,,,,,odcp-admin-customer-manager,,,,,,,,,,,,,,odcp-admin-dashboard,,,,,,,,,,,,,,odcp-admin-editor,,,,,,,,,,,,,,odcp-admin-frontend,,,,,,,,,,,,,,odcp-admin-login,,,,,,,,,,,,,,odcp-admin-mall,,,,,,,,,,,,,,odcp-admin-oauth,,,,,,,,,,,,,,odcp-admin-permission,,,,,,,,,,,,,,odcp-boss-frontend,,,,,,,,,,,,,,odcp-console,,,,,,,,,,,,,,odcp-console-account,,,,,,,,,,,,,,odcp-console-base,,,,,,,,,,,,,,odcp-console-basic-skill,,,,,,,,,,,,,,odcp-console-boss,,,,,,,,,,,,,,odcp-console-capital,,,,,,,,,,,,,,odcp-console-custom-resource,,,,,,,,,,,,,,odcp-console-data,,,,,,,,,,,,,,odcp-console-feedback,,,,,,,,,,,,,,odcp-console-home,,,,,,,,,,,,,,odcp-console-knowledge,,,,,,,,,,,,,,odcp-console-message,,,,,,,,,,,,,,odcp-console-product,,,,,,,,,,,,,,odcp-console-product2-已遗弃,,,,,,,,,,,,,,odcp-console-resource,,,,,,,,,,,,,,odcp-console-resource-old,,,,,,,,,,,,,,odcp-console-simulation,,,,,,,,,,,,,,odcp-console-train,,,,,,,,,,,,,,odcp-custom-resources,,,,,,,,,,,,,,odcp-dui,,,,,,,,,,,,,,odcp-finance-center,,,,,,,,,,,,,,odcp-flow-skill,,,,,,,,,,,,,,odcp-goods-order-h5,,,,,,,,,,,,,,odcp-midway,,,,,,,,,,,,,,odcp-open-home,,,,,,,,,,,,,,odcp-private-integrates,,,,,,,,,,,,,,odcp-product-authorization,,,,,,,,,,,,,,odcp-quality-test,,,,,,,,,,,,,,odcp-skill-store,,,,,,,,,,,,,,pcs-cls,,,,,,,scheduler,,,,,,,,,,,,,,scptrainer,,,,,,,,,,,,,,sichuanhua2putonghua4dui,,,,,,,skyline-frontend,,,,,,,,,,,,,,smarthome-3rdProxy,,,,,,,,,,,,,,smarthome-proxy,,,,,,,,,,,,,,softhardware-h5,,,,,,,,,,,,,,thacp-web,,,,,,,,,,,,,,tonghuashun-spider,,,,,,,,,,,,,,training-scheduler,,,,,,,,,,,,,,tts-kf,,,,,,,,,,,,,,weather-cn-spider,,,,,,,,,,,,,,WebContentAPI,,,,,,,,,,,,,,Webhook,,,,,,,,,,,,,,webhook-console-client,,,,,,,,,,,,,,webhook-measure,,,,,,,,,,,,,,yueyu2putonghua4dui,,,,,,";

  public static String projectOwnerStr = "account-permission,hongkai.wen,accountlink,keqiang.zhong,adam,bo.li,content-admin,bo.li,content-web,bo.li,ctriphotel,bo.li,dcmp,bo.li,dcmp,bo.li,aimt-admin-frontend,yilong.zhou,aimt-asr-comparison,haibo.guo,aimt-asr-switch,yilong.zhou,,yilong.zhou,aimt-business,yilong.zhou,,yilong.zhou,aimt-cloud-admin-frontend,yijun.zhu,aimt-cloud-asr-switch,yilong.zhou,aimt-cloud-auth,yilong.zhou,aimt-cloud-business,yilong.zhou,aimt-cloud-business-admin,yilong.zhou,aimt-cloud-frontend,yilong.zhou,aimt-cloud-kong,yilong.zhou,aimt-cloud-ot,yilong.zhou,aimt-company-frontend,yilong.zhou,aimt-device-activation,yilong.zhou,,yilong.zhou,aimt-external-controller,yilong.zhou,aimt-frontend,yilong.zhou,,gang.yao,aimt-kong,yilong.zhou,,yilong.zhou,aimt-newsmy-web,yilong.zhou,aimt-ot-server,yilong.zhou,aimt-ota-admin,yilong.zhou,aimt-otg-activation,yilong.zhou,aimt-temperature-server,dazhu.zhang,aimt-transfer,yilong.zhou,,dazhu.zhang,aimt-xytt-member,yilong.zhou,,dazhu.zhang,,yilong.zhou,AiRobotAdapter,chengya.zhu,,xiaoyuan.wang,,wenjie.yin,all-independent-page,ge.tang,,ge.tang,ama-demo,xinyu.lu,,guo.wang,,xinyu.lu,AISpeechMobileAdminWeb,xinyu.lu,AISpeechMobileServer,xinyu.lu,AISpeechMobileAdminServer,xinyu.lu,AISpeechMobileH5,guo.wang,,guo.wang,,guo.wang,wxprogram,guo.wang,wxprogram,guo.wang,AIspeechWebTool,guo.wang,AISpeechReadServer,xinyu.lu,AISpeechResourceServer,xinyu.lu,,xin.xie,,cheng.sun,,cheng.sun,,cheng.sun,,cheng.sun,apisix-ingress-controller,cheng.sun,apisix-ingress-controller,cheng.sun,,cheng.sun,,cheng.sun,apisix-manager,xin.xie,,cheng.sun,apisix,cheng.sun,apisix,cheng.sun,asrcp_backend,xin.xie,asr-api,lilin.cao,autoSyncServer,wang.wu,boss-product-simulator,hongkai.wen,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,casrserver,wenjie.yin,,wenjie.yin,casrserver,wenjie.yin,,wenjie.yin,,wenjie.yin,casrserver,wenjie.yin,cdmserver,chengya.zhu,,shaohua.zhu,,shaohua.zhu,,shaohua.zhu,CInfoServer,yichao.guo,function-router,wang.wu,cloud-license-admin,baorong.fan,translation-server,wang.wu,asr-api,lilin.cao,,gaofeng.zhang,content,bo.li,content,bo.li,,bo.li,,yunxia.wang,,yunxia.wang,,yunxia.wang,,yunxia.wang,,yunxia.wang,,yunxia.wang,,yunxia.wang,,yunxia.wang,,yunxia.wang,,yunxia.wang,,yunxia.wang,dca-app,lutian.li,dcaserver,keqiang.zhong,ddsTtsLite,gaofeng.zhang,ddsserver2,wang.wu,ddsserver2,wang.wu,dm-dispatch-server,chengya.zhu,dm-dispatch-server,chengya.zhu,dui-dsk-dm,yongkai.lin,dui-ai,zhen.liu,,ge.tang,dui-authentication,ge.tang,,ge.tang,dui-static,zhen.liu,DuiLiteDocAndroid,lutian.li,duisys-nlu-hotword,yichao.guo,pasc-server,yichao.guo,,yichao.guo,dui-resource-mover,wang.wu,en-skill-class,qinpei.zhu,ezmt-asr-analysis-api,lang.zhang,ezmt-datamove,lang.zhang,ezmt-japi,xiaoshuang.wang,ezmt-pyapi,lang.zhang,ezmt-model-remake,lang.zhang,ezmt-pyapi,lang.zhang,ezmt_publish,xiaoshuang.wang,ezmt-pyapi,lang.zhang,ezmt-pyapi-analysis,lang.zhang,ezmt-pyapi,lang.zhang,ezmt-tfs,lang.zhang,ezmt-pyapi,lang.zhang,ezmt-pyapi,lang.zhang,ezmt-pyapi,lang.zhang,ezmt-pyapi,lang.zhang,ezmt-pyapi,lang.zhang,ezwk-api,meng.shi,ezwk-core,lang.zhang,,cheng.sun,,cheng.sun,resync2,cheng.sun,,cheng.sun,,yichao.guo,gluster-prometheus,cheng.sun,hotword,wang.wu,httpserver,cheng.sun,image-classify,wang.wu,IoT-Hub,xinyu.lu,,pengliang.guo,WebContentAPI,dazhu.zhang,kong-plugins,bo.li,kong-dashboard,bo.li,dopc-bin,kai.li,,lei.zhong,vertx-lasr,lei.zhong,,lei.zhong,vertx-lasr,lei.zhong,vertx-lasr,lei.zhong,,lei.zhong,vertx-lasr,lei.zhong,vertx-lasr,lei.zhong,asr-api,lei.zhong,vertx-lasr,lei.zhong,asr-api,lei.zhong,vertx-lasr,lei.zhong,,maosen.xu,,maosen.xu,,jinxiong.hou,lyra_webapi,maosen.xu,,maosen.xu,lyra_web_cloud,maosen.xu,mscp-account,xiaoyu.wang,mscp-admin-gw,kan.yao,mscp-admin-permission,kan.yao,mscp-auth-admin,xiaoyu.wang,mscp-component-auth,lili.jin,mscp-boss-billing,hongkai.wen,mscp-boss-control,kan.yao,mscp-boss-customer,hongkai.wen,mscp-boss-metering,xiaoyu.wang,mscp-boss-metering-api,xiaoyu.wang,,lili.jin,mscp-boss-pricing,hongkai.wen,mscp-boss-product,kan.yao,mscp-boss-sideserver,lili.jin,mscp-captcha,kan.yao,mscp-advance-config,baorong.fan,mscp-cms,kan.yao,mscp-commerce-commodity,xiaoyu.wang,mscp-commerce-order,kan.yao,mscp-commerce-order-admin,kan.yao,mscp-commerce-pay,kan.yao,mscp-common-product,baorong.fan,mscp-component-oauth2,xiaoyu.wang,mscp-crm,xiaoyu.wang,mscp-custom-resource-admin,lili.jin,,xiaoyu.wang,,lili.jin,mscp-dsl,lili.jin,mscp-email,lili.jin,mscp-gw-v3,baorong.fan,mscp-member-central,zhiyi.chen,mscp-message-push,kan.yao,mscp-advance-config,baorong.fan,,lili.jin,mscp-order,baorong.fan,,lili.jin,mscp-organization,lili.jin,mscp-owl,hongkai.wen,mscp-owl-api,hongkai.wen,mscp-owl-diagnostic,xiaoyu.wang,mscp-owl-job,xiaoyu.wang,,baorong.fan,mscp-product-admin,baorong.fan,mscp-product-authorization,xiaoyu.wang,mscp-product,lili.jin,,baorong.fan,,baorong.fan,,baorong.fan,mscp-server-detect,zhiyi.chen,mscp-skill-admin,baorong.fan,mscp-skill-core,lili.jin,mscp-skill,lili.jin,mscp-skyline-api,kan.yao,,kan.yao,mscp-table-resource,lili.jin,mscp-ums,baorong.fan,msfc-gw,baorong.fan,,baorong.fan,,baorong.fan,,baorong.fan,msfc-skillStore,baorong.fan,,bo.li,nlq-server,lecun.li,nludispatchserver,gaofeng.zhang,nludispatchserver,gaofeng.zhang,odcp-admin-boss,ge.tang,odcp-admin-customer-manager,qi.xu,odcp-admin-dashboard,qi.xu,,ge.tang,odcp-admin-frontend,zhen.liu,odcp-admin-login,ge.tang,odcp-admin-mall,ge.tang,odcp-admin-oauth,ge.tang,odcp-admin-permission,ge.tang,boss,yichao.guo,,kai.sun,cdmserver,chengya.zhu,cnluserver,gaofeng.zhang,odcp-console,yichao.guo,odcp-console-account,ge.tang,,ge.tang,odcp-console-base,zhen.liu,odcp-console-basic-skill,zhen.liu,odcp-console-data,zhen.liu,,ge.tang,,ge.tang,odcp-console-header,zhen.liu,odcp-console-home,ge.tang,,ge.tang,,kai.sun,,ge.tang,odcp-console-product,zhen.liu,,ge.tang,,yijun.zhu,,yijun.zhu,,ge.tang,odcp-console-skill2,zhen.liu,,zhen.liu,odcp-console-train,zhen.liu,odcp-custom-resources,zhen.liu,,wang.wu,dm-dispatch-server,chengya.zhu,Help-Documentation,ge.tang,,ge.tang,,ge.tang,,yijun.zhu,,yijun.zhu,odcp-finance-center,qi.xu,odcp-flow-skill,zhen.liu,function-controller,wang.wu,odcp-goods-order-h5,ge.tang,,yijun.zhu,odcp-midway,ge.tang,nludispatchserver,gaofeng.zhang,,yilong.zhou,,gaofeng.zhang,,gaofeng.zhang,odcp-open-home,ge.tang,odcp-private-integrates,zhen.liu,odcp-product-authorization,ge.tang,,zhen.liu,,ge.tang,,gaofeng.zhang,,gaofeng.zhang,,gaofeng.zhang,,gaofeng.zhang,dialect,gaofeng.zhang,dialect,gaofeng.zhang,,gaofeng.zhang,,xiaoyu.wang,Private,lili.jin,recommendation,lecun.li,recommendation,lecun.li,recommendation,lecun.li,recommendation,lecun.li,RESServer,keqiang.zhong,,wenjie.yin,,wenjie.yin,scheduler,bo.li,scp_backend,xin.xie,scptrainer,xin.xie,scptrainer,xin.xie,sichuanhua2putonghua4dui,qinpei.zhu,,ge.tang,smarthome-3rdProxy,dazhu.zhang,smarthome-proxy,xinyu.lu,softhardware-h5,jinxiong.hou,asr-api,lilin.cao,streaming-media,keqiang.zhong,thacp-services,lilin.cao,thacp-web,zhikai.ni,tonghuashun-spider,bo.li,trafficlimit-server,wang.wu,tts-kf,gaofeng.zhang,docker_img_faq,feng.ouyang,cms_rc,qiang.wang1,,bin.lian,objectbeats,bin.lian,,kai.li,xinping,wenjie.yin,xinping,wenjie.yin,xinping,wenjie.yin,,lilin.cao,xinping,wenjie.yin,,lilin.cao,xinping,wenjie.yin,asr-api,lilin.cao,asr-api,lilin.cao,awakening-words-trainer,xin.xie,weather-cn-spider,bo.li,builtInWebhook,dazhu.zhang,,dazhu.zhang,webhookConsole,dazhu.zhang,webhook-source,dazhu.zhang,webhook,dazhu.zhang,groupTalk,keqiang.zhong,yueyu2putonghua4dui,qinpei.zhu";

  public static void main(String[] args) {
//    String[] excelProjects = excelStr.split(",");
//    Map<String , String> projectOwnerMap = new LinkedHashMap<>();
//    Set<String> projectSet = new LinkedHashSet<>();
//    for (String project : excelProjects) {
//      if (Objects.equals(project, ",") || Objects.equals(project, "")) {
//        continue;
//      }
//      projectSet.add(project);
//    }
//    String[] projectOwnArr = projectOwnerStr.split(",");
//    int index = 0;
//    while (index < projectOwnArr.length) {
//      if (Objects.equals(projectOwnArr[index], "")) {
//        index += 2;
//        continue;
//      }
//      projectOwnerMap.put(projectOwnArr[index], projectOwnArr[index + 1]);
//      index += 2;
//    }
//    for (String project : projectSet) {
//      System.out.println(projectOwnerMap.get(project));
//    }

    String str = "项目名,account-permission,,,,,,,,,,,,,,,accountlink,,,,,,,,,,,,,,,adam,,,,,,,,,,,,,,,aimt-admin-frontend,,,,,,,,,,,,,,,aimt-asr-comparison,,,,,,,,,,,,,,,aimt-asr-switch,,,,,,,,,,,,,,aimt-asr-switch-huiyi,,,,,,,,,,,,,,aimt-asr-switch-shenxun,,,,,,,,,,,,,,aimt-auth,,,,,,,,,,,,,,aimt-business,,,,,,,,,,,,,,aimt-business-admin,,,,,,,,,,,,,,aimt-cloud-admin-frontend,,,,,,,,,,,,,,aimt-cloud-asr-switch,,,,,,,,,,,,,,aimt-cloud-auth,,,,,,,,,,,,,,aimt-cloud-business,,,,,,,,,,,,,,aimt-cloud-business-admin,,,,,,,,,,,,,,aimt-cloud-frontend,,,,,,,,,,,,,,aimt-cloud-ot,,,,,,,,,,,,,,aimt-company-frontend,,,,,,,,,,,,,,aimt-device-activation,,,,,,,,,,,,,,aimt-external-admin,,,,,,,,,,,,,,aimt-external-controller,,,,,,,,,,,,,,aimt-frontend,,,,,,,,,,,,,,aimt-frontend-huiyi,,,,,,,,,,,,,,aimt-frontend-shenxun,,,,,,,,,,,,,,aimt-hymf-mp,,,,,,,,,,,,,,aimt-kong,,,,,,,,,,,,,,aimt-kong-dashboard,,,,,,,,,,,,,,aimt-newsmy-web,,,,,,,,,,,,,,aimt-ot-server,,,,,,,,,,,,,,aimt-ota-admin,,,,,,,,,,,,,,aimt-otg-activation,,,,,,,,,,,,,,aimt-temperature-server,,,,,,,,,,,,,,aimt-transfer,,,,,,,,,,,,,,aiot-account-permission,,,,,,,,,,,,,,,aiot-common-functions,,,,,,,,,,,,,,aiot-smarthome-3rd-ys,,,,,,,,,,,,,,apisix,,,,,,,,,,,,,,apisix-gray-tool,,,,,,,,,,,,,,apisix-ingress-controller,,,,,,,,,,,,,,apisix-manager,,,,,,,,,,,,,,builtInWebhook,,,,,,,,,,,,,,cdmserver,,,,,,,,,,,,,,CInfoServer,,,,,,,cnluserver,,,,,,,,,,,,,,content,,,,,,,,,,,,,,content-service-platform,,,,,,,,,,,,,,content-web,,,,,,,,,,,,,,corridor,,,,,,,,,,,,,,corridormonitor,,,,,,,,,,,,,,dca-app,,,,,,,,,,,,,,dcmp,,,,,,,,,,,,,,DDSServer,,,,,,,,,,,,,,ddsserver2,,,,,,,dm-dispatch-server,,,,,,,dm-dispatch-server-old,,,,,,,Dolphin Scheduler,,,,,,,,,,,,,,Dui Ai,,,,,,,,,,,,,,dui-ai,,,,,,,,,,,,,,dui-authentication,,,,,,,,,,,,,,dui-static,,,,,,,,,,,,,,duilite-for-car-hotwords,,,,,,,,,,,,,,en-skill-class,,,,,,,ezml-core-hotword,,,,,,,,,,,,,,ezmt-asr-analysis-api,,,,,,,,,,,,,,ezmt-datamove,,,,,,,,,,,,,,ezmt-hotword,,,,,,,,,,,,,,ezmt-japi,,,,,,,,,,,,,,ezmt-japi-private,,,,,,,,,,,,,,ezmt-local-ebnf,,,,,,,,,,,,,,ezmt-model-remake,,,,,,,,,,,,,,ezmt-modeleval,,,,,,,ezmt-private-hotword,,,,,,,,,,,,,,ezmt-pyapi,,,,,,,,,,,,,,ezmt-pyapi-analysis,,,,,,,,,,,,,,ezmt-pyapi-private-inverse,,,,,,,,,,,,,,ezmt-pyapi-private-patslot,,,,,,,,,,,,,,ezmt-pyapi-private-sensitive,,,,,,,,,,,,,ezmt-pyapi-private-text,,,,,,,,,,,,,,ezwk-api,,,,,,,,,,,,,,ezwk-core,,,,,,,,,,,,,,fed-webhook-test,,,,,,,,,,,,,,gitlab-jenkins-webhook-proxy,,,,,,,,,,,,,,green_edu,,,,,,,,,,,,,,hotword,,,,,,,hotword-tool,,,,,,,,,,,,,,image-classify,,,,,,,IoT-Hub,,,,,,,jddsserver,,,,,,,,,,,,,,jddsserverflux,,,,,,,,,,,,,,kong-dashboard,,,,,,,,,,,,,,kong-grace,,,,,,,,,,,,,,kong-gray-dashboard,,,,,,,,,,,,,,lowpower-wakeup-demo,,,,,,,,,,,,,,lyra-dsk,,,,,,,,,,,,,,lyra-h5,,,,,,,,,,,,,,lyra-web2img,,,,,,,,,,,,,,me-hotword-offline-service,,mscp-admin-gw,,,,,,,,,,,,,,mscp-auth-admin,,,,,,,,,,,,,,mscp-boss-billing,,,,,,,,,,,,,,mscp-boss-control,,,,,,,,,,,,,,mscp-boss-metering,,,,,,,,,,,,,,mscp-boss-metering-api,,,,,,,,,,,,,,mscp-boss-order,,,,,,,,,,,,,,mscp-boss-pricing,,,,,,,,,,,,,,mscp-boss-product,,,,,,,,,,,,,,mscp-captcha,,,,,,,,,,,,,,mscp-commerce-commodity,,,,,,,,,,,,,,mscp-commerce-order,,,,,,,,,,,,,,mscp-commerce-order-admin,,,,,,,,,,,,,,mscp-commerce-pay,,,,,,,,,,,,,,mscp-common-product,,,,,,,,,,,,,,mscp-custom-resource-admin,,,,,,,,,,,,,,mscp-developer-tools,,,,,,,,,,,,,,mscp-gw-v3,,,,,,,,,,,,,,mscp-message-push,,,,,,,,,,,,,,mscp-organization-admin,,,,,,,,,,,,,,mscp-owl,,,,,,,,,,,,,,mscp-owl-api,,,,,,,,,,,,,,mscp-owl-dbtest,,,,,,,,,,,,,,mscp-owl-diagnostic,,,,,,,,,,,,,,mscp-owl-job,,,,,,,,,,,,,,mscp-owl-native,,,,,,,,,,,,,,mscp-owl-sideserver,,,,,,,,,,,,,,mscp-resource-goods,,,,,,,,,,,,,,mscp-resource-rule,,,,,,,,,,,,,,mscp-server-detect,,,,,,,,,,,,,,mscp-skill-admin,,,,,,,,,,,,,,mscp-skill-core,,,,,,,,,,,,,,mscp-skill-router,,,,,,,,,,,,,,mscp-skyline-api,,,,,,,,,,,,,,mscp-skyline-backend,,,,,,,,,,,,,,mscp-table-resource,,,,,,,,,,,,,,mscp-ums,,,,,,,,,,,,,,msfc-gw,,,,,,,,,,,,,,msfc-organization,,,,,,,,,,,,,,msfc-registry,,,,,,,,,,,,,,msfc-skill,,,,,,,,,,,,,,msfc-skillStore,,,,,,,,,,,,,,nlq-server,,,,,,,,,,,,,,Nlu Platform Service,,,,,,,,,,,,,,nlu-platform-service,,,,,,,,,,,,,,odcp-admin-boss,,,,,,,,,,,,,,odcp-admin-customer-manager,,,,,,,,,,,,,,odcp-admin-dashboard,,,,,,,,,,,,,,odcp-admin-editor,,,,,,,,,,,,,,odcp-admin-frontend,,,,,,,,,,,,,,odcp-admin-login,,,,,,,,,,,,,,odcp-admin-mall,,,,,,,,,,,,,,odcp-admin-oauth,,,,,,,,,,,,,,odcp-admin-permission,,,,,,,,,,,,,,odcp-boss-frontend,,,,,,,,,,,,,,odcp-console,,,,,,,,,,,,,,odcp-console-account,,,,,,,,,,,,,,odcp-console-base,,,,,,,,,,,,,,odcp-console-basic-skill,,,,,,,,,,,,,,odcp-console-boss,,,,,,,,,,,,,,odcp-console-capital,,,,,,,,,,,,,,odcp-console-custom-resource,,,,,,,,,,,,,,odcp-console-data,,,,,,,,,,,,,,odcp-console-feedback,,,,,,,,,,,,,,odcp-console-home,,,,,,,,,,,,,,odcp-console-knowledge,,,,,,,,,,,,,,odcp-console-message,,,,,,,,,,,,,,odcp-console-product,,,,,,,,,,,,,,odcp-console-product2-已遗弃,,,,,,,,,,,,,,odcp-console-resource,,,,,,,,,,,,,,odcp-console-resource-old,,,,,,,,,,,,,,odcp-console-simulation,,,,,,,,,,,,,,odcp-console-train,,,,,,,,,,,,,,odcp-custom-resources,,,,,,,,,,,,,,odcp-dui,,,,,,,,,,,,,,odcp-finance-center,,,,,,,,,,,,,,odcp-flow-skill,,,,,,,,,,,,,,odcp-goods-order-h5,,,,,,,,,,,,,,odcp-midway,,,,,,,,,,,,,,odcp-open-home,,,,,,,,,,,,,,odcp-private-integrates,,,,,,,,,,,,,,odcp-product-authorization,,,,,,,,,,,,,,odcp-quality-test,,,,,,,,,,,,,,odcp-skill-store,,,,,,,,,,,,,,pcs-cls,,,,,,,scheduler,,,,,,,,,,,,,,scptrainer,,,,,,,,,,,,,,sichuanhua2putonghua4dui,,,,,,,skyline-frontend,,,,,,,,,,,,,,smarthome-3rdProxy,,,,,,,,,,,,,,smarthome-proxy,,,,,,,,,,,,,,softhardware-h5,,,,,,,,,,,,,,thacp-web,,,,,,,,,,,,,,tonghuashun-spider,,,,,,,,,,,,,,training-scheduler,,,,,,,,,,,,,,tts-kf,,,,,,,,,,,,,,weather-cn-spider,,,,,,,,,,,,,,WebContentAPI,,,,,,,,,,,,,,Webhook,,,,,,,,,,,,,,webhook-console-client,,,,,,,,,,,,,,webhook-measure,,,,,,,,,,,,,,yueyu2putonghua4dui,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";
    String[] arr = str.split(",");
    StringBuilder sb = new StringBuilder();
    int count = 0;
    for (String id : arr) {
      if (Objects.equals(id, "")) {
        continue;
      }
      sb.append(id + ",");
      count++;
    }
    System.out.println(sb);

    System.out.println(count);
  }
}