package com.feicuiedu.junittestdemo_20170420;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gqq on 2017/4/20.
 */
public class RegexUtilsTest {

    private RegexUtils mRegexUtils;

    @Before
    public void setUp() throws Exception {
        mRegexUtils = new RegexUtils();
    }

    @After
    public void tearDown() throws Exception {
        mRegexUtils = null;
    }

    @Test
    public void verifyUsername() throws Exception {
        int verifyUsername = mRegexUtils.verifyUsername("123456");
        assertEquals(0,verifyUsername);
    }

    @Test
    public void verifyUsername1() throws Exception {
        int verifyUsername = mRegexUtils.verifyUsername("123");
        assertEquals(1,verifyUsername);
    }

    @Test
    public void verifyPassword() throws Exception {

    }

    @Test
    public void verifyNickname() throws Exception {

    }

}