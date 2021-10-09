package com.sgcc.juejin.controller;

import com.alibaba.fastjson.JSONObject;
import com.sgcc.juejin.config.Http;
import com.sgcc.juejin.config.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/jueJin")
public class JueJin {


    static String todayStatus = "/growth_api/v1/get_today_status";
    static String checkIn = "/growth_api/v1/check_in";
    static String lotteryConfig = "/growth_api/v1/lottery_config/get";
    static String drawLottery = "/growth_api/v1/lottery/draw";
    static String cookie = "填入你的cookie";
    /**
     * 查询今日是否已经签到
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/getTodayStatus", method = RequestMethod.POST, headers = "Content-type=application/json")
    public ResponseResult<JSONObject> getTodayStatus(@RequestBody JSONObject param) throws IOException {
        JSONObject jsonObject = null;
        switch (param.getString("status")) {
            /**
             *查询今日是否已经签到
             */
            case "1":
                jsonObject = Http.HttpPostOrGet(todayStatus, "GET", param.getString("cookie"));
                break;
            /**
             *签到
             */
            case "2":
                jsonObject = Http.HttpPostOrGet(checkIn, "POST", param.getString("cookie"));
                break;
            /**
             *获取免费抽奖次数
             */
            case "3":
                jsonObject = Http.HttpPostOrGet(lotteryConfig, "GET", param.getString("cookie"));
                break;
            /**
             *抽奖
             */
            case "4":
                jsonObject = Http.HttpPostOrGet(drawLottery, "POST", param.getString("cookie"));
                break;
            default:
                return ResponseResult.fail("暂无该功能");
        }
        return ResponseResult.success(jsonObject);
    }



}
