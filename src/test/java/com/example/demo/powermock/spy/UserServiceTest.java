package com.example.demo.powermock.spy;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
class UserServiceTest {

    /**
     * spy 如果满足断言条件 则使用mock
     *     如果不满足断言条件则使用 真实的方法
     */
    @Test
    public void testFoo(){
        UserService spy = PowerMockito.spy(new UserService());
//        spy.foo();
        String arg = "hello";
        Mockito.doNothing().when(spy).foo(arg);
//        spy.foo(arg);
        spy.foo("word");
    }

    @Test
    public void testExist() throws Exception{
        UserService spy = PowerMockito.spy(new UserService());
        PowerMockito.doReturn(true).when(spy,"checkExist", "alex");
        Assert.assertTrue(spy.checkExist("123"));
    }
}