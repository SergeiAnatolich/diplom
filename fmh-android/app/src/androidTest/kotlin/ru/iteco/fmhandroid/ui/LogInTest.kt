package ru.iteco.fmhandroid.ui

import io.qameta.allure.android.runners.AllureAndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*

@RunWith(AllureAndroidJUnit4::class)
class AuthorizationTest {

    private val appBarAllPage = AppBarAllPage()
    private val authorizationPage = AuthorizationPage()
    private val device = Device()

    @Before
    fun beforeEachTest() {
        device.startLauncher()
        authorizationPage.waitAuthorizationPage()
    }

    @Test
    fun testSuccessAuthorisation() {
        authorizationPage.inputSuccessLogin().inputSuccessPassword().clickSignIn().waitTrademark()
        appBarAllPage.checkingPage()
        appBarAllPage.logOut()
    }

    @Test
    fun testFailLoginAndPassword() {
        authorizationPage.inputFailLogin().inputFailPassword().clickSignIn()
        //TODO
        //не удалось перехватить всплывающие сообщения
    }

    @Test
    fun testFailLoginAndSuccessPassword() {
        authorizationPage.inputFailLogin().inputSuccessPassword().clickSignIn()
        //TODO
        //не удалось перехватить всплывающие сообщения
    }

    @Test
    fun testSuccessLoginAndFailPassword() {
        authorizationPage.inputSuccessLogin().inputFailPassword().clickSignIn()
        //TODO
        //не удалось перехватить всплывающие сообщения
    }

    @Test
    fun testEmptyLoginAndPassword() {
        authorizationPage.clickSignIn()
        //TODO
        //не удалось перехватить всплывающие сообщения
    }

    @Test
    fun testEmptyLoginAndSuccessPassword() {
        authorizationPage.inputSuccessPassword().clickSignIn()
        //TODO
        //не удалось перехватить всплывающие сообщения
    }

    @Test
    fun testSuccessLoginAndEmptyPassword() {
        authorizationPage.inputSuccessLogin().clickSignIn()
        //TODO
        //не удалось перехватить всплывающие сообщения
    }
}