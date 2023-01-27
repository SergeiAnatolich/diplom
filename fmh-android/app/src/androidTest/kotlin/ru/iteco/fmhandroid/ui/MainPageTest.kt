package ru.iteco.fmhandroid.ui

import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import junit.framework.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*

@RunWith(AllureAndroidJUnit4::class)
class MainPageTest {

    private val appBarAllPage = AppBarAllPage()
    private val authorizationPage = AuthorizationPage()
    private val claimPage = ClaimPage()
    private val mainPage = MainPage()
    private val device = Device()

    @Before
    fun beforeEachTest() {
        device.startLauncher()
        try {
            authorizationPage.login()
        } catch (e: Throwable) {
            println("the user is already logged in")
        }
    }

    @After
    fun afterEachTest() {
        try {
            appBarAllPage.logOut()
        } catch (e: Throwable) {
            println("the authorization image button is not available")
        }
    }

    @Test
    fun testCollapsingAndUnfoldingTheNewsSection() {
        val viewGroup = mainPage.getGroupNews()
        viewGroup.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        mainPage.clickArrowButtonNewsSection()
        viewGroup.check(ViewAssertions.doesNotExist())
        mainPage.clickArrowButtonNewsSection()
        val textView = mainPage.getTextViewNews()
        textView.check(ViewAssertions.matches(ViewMatchers.withText(mainPage.allNews)))
    }

    @Test
    fun testCollapsingAndUnfoldingTheNews() {
        mainPage.clickArrowButtonNews().waitAllNewsCardsBlock()
        assertTrue(mainPage.checkingNewsDescription())
        mainPage.clickArrowButtonNews().waitAllNewsCardsBlock()
        assertFalse(mainPage.checkingNewsDescription())
    }

    @Test
    fun testCollapsingAndUnfoldingTheClaimsSection() {
        mainPage.clickArrowButtonNewsSection()
        val viewGroup = mainPage.getViewGroupClaims()
        viewGroup.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        mainPage.clickArrowButtonClaimsSection()
        viewGroup.check(ViewAssertions.doesNotExist())
        mainPage.clickArrowButtonClaimsSection()
        val textView = mainPage.getTextViewClaims()
        textView.check(ViewAssertions.matches(ViewMatchers.withText(mainPage.allClaims)))
    }

    @Test
    fun testCollapsingAndUnfoldingTheClaims() {
        mainPage.clickArrowButtonNewsSection()
        val textTopic = mainPage.getTopic()
        mainPage.clickClaimListCard().waitDescriptionCard()
        val textTitle = mainPage.getTitleClaim()
        mainPage.scrollPage(mainPage.addCommentButton).clickCloseButton()
        assertEquals(textTopic, textTitle)
    }

    @Test
    fun testOpenAllNews() {
        mainPage.clickAllNewsButton().waitNewsPage().checkingNewsList()
    }

    @Test
    fun testOpenAllClaims() {
        mainPage.clickAllClaimsButton().waitClaimPage().checkingPage()
    }

    @Test
    fun testOpenPageCreateClaims() {
        mainPage.newClaimButtonClick().waitClaimsCreatingPage()
        val text1 = claimPage.getCreatingTitle()
        assertEquals(claimPage.creating, text1)
        val text2 = claimPage.getClaimsTitle()
        assertEquals(claimPage.claims, text2)
    }
}