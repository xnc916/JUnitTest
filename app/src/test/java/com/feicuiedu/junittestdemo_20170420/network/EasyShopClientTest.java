package com.feicuiedu.junittestdemo_20170420.network;

import com.feicuiedu.junittestdemo_20170420.model.UserResult;
import com.google.gson.Gson;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import okhttp3.Call;
import okhttp3.Response;

import static org.junit.Assert.*;

/**
 * Created by gqq on 2017/4/20.
 * EasyShopClient的测试类
 * 确定你要测试类或方法
 * 1. 创建测试类：GO TO --> Test
 * 2. 完善测试方法
 * 3. 运行测试
 */
public class EasyShopClientTest {

    /**
     * @BeforeClass：只会执行一次的静态方法：数据库连接等
     * @Before：测试方法之前都会执行，作用：实现一些初始化的功能
     * @Test：要测试的方法
     * @After：测试方法之后都会执行，作用：资源释放、对象置空等
     * @AfterClass：只会执行一次的静态方法：数据库断开连接等
     * 执行顺序为：@BeforeClass --> @Before --> @Test --> @After --> @AfterClass
     *
     * 断言方法：断言类提供的一些方法，作用：验证测试的内容
     * 如果不能直接调出来：Assert.assertEquals();
     */

//    @BeforeClass
//    public static void beforeclass(){
//
//    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void register() throws Exception {
        // 完善测试方法
        Call call = EasyShopClient.getInstance().register("123456", "123456");
        Response response = call.execute();
        String json = response.body().string();
        UserResult userResult = new Gson().fromJson(json, UserResult.class);
        assertEquals(2,userResult.getCode());
    }

    @Test
    public void register1() throws Exception {
        // 完善测试方法
        Call call = EasyShopClient.getInstance().register("zzzzzz", "123456");
        Response response = call.execute();
        String json = response.body().string();
        UserResult userResult = new Gson().fromJson(json, UserResult.class);
        assertEquals(2,userResult.getCode());
    }

    @Test
    public void login() throws Exception {
        Call login = EasyShopClient.getInstance().login("123456", "11111");
        Response execute = login.execute();
        assertNotNull(execute);
    }

    @After
    public void tearDown() throws Exception {

    }

//    @AfterClass
//    public static void afterClass(){
//
//    }
}