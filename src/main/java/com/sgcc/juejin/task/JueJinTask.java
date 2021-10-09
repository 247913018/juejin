package com.sgcc.juejin.task;

import com.alibaba.fastjson.JSONObject;
import com.sgcc.juejin.config.Http;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 掘金定时任务调用
 */
@Component
@EnableScheduling
@EnableAsync
public class JueJinTask {

    static String cookie = "填入你的cookie";
    static String todayStatus = "/growth_api/v1/get_today_status";
    static String checkIn = "/growth_api/v1/check_in";
    static String lotteryConfig = "/growth_api/v1/lottery_config/get";
    static String drawLottery = "/growth_api/v1/lottery/draw";

    /**
     * 每天零点零分零秒开始签到和用调免费抽奖机会
     * @throws IOException
     */
    @Async
//    @Scheduled(cron = "0 0 0 * * ? ")
    public void send() throws IOException {
        //查询是否签到
//        getTodayCheck();
//        if (!getTodayCheck()){
//            //签到
//            if (getTodayCheckStatus()){
//                //抽奖
//                getTodayDrawStatus();
//            }
//        }
//        System.out.println(1);
    }


    /**
     * 查询今日是否已经签到
     *
     * @return
     * @throws IOException
     */
    public  Boolean getTodayCheck() throws IOException {
        JSONObject jsonObject = Http.HttpPostOrGet(todayStatus,"GET",cookie);
        return jsonObject.getString("err_no").equals("0") ? true : false;
    }


    /**
     * 签到
     *
     * @return
     * @throws IOException
     */
    public  Boolean getTodayCheckStatus() throws IOException {
        JSONObject jsonObject = Http.HttpPostOrGet(checkIn,"POST",cookie);
        return jsonObject.getString("err_no").equals("0") ? true : false;
    }

    /**
     * 获取免费抽奖次数
     *
     * @return
     * @throws IOException
     */
    public  Integer getLotteryConfig() throws IOException {
        JSONObject jsonObject = Http.HttpPostOrGet(lotteryConfig,"GET",cookie);
        return jsonObject.getJSONObject("dara").getInteger("free_count");
    }

    /**
     * 抽奖
     *
     * @return
     * @throws IOException
     */
    public  Boolean getTodayDrawStatus() throws IOException {
        JSONObject jsonObject = Http.HttpPostOrGet(drawLottery,"POST",cookie);
        return jsonObject.getString("err_no").equals("0") ? true : false;
    }



}
