package com.feicuiedu.junittestdemo_20170420;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by gqq on 2017/4/20.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    /**
     * 1. 需要指定一下运行的环境@RunWith(AndroidJUnit4.class)
     * 2. 指定一下启动测试的Activity
     * 3. 完善测试方法
     */

    // 2. 指定启动测试的Activity
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void login() throws Exception {

        /**
         * 1. 找到两个EditText，分别往里面加入文本信息
         * 2. 找到登录的按钮，并且给按钮设置点击事件
         */
        onView(withId(R.id.etName)).perform(typeText("123456"),closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText("123456"),closeSoftKeyboard());

        onView(withId(R.id.btnLogin)).perform(click());

        Thread.sleep(5000);// 如果视图涉及到耗时，都可以通过足够的睡眠时间等待结果
    }
}