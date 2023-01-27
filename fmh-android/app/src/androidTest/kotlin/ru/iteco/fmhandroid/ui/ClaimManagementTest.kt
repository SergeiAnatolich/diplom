package ru.iteco.fmhandroid.ui

import io.qameta.allure.android.runners.AllureAndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*


@RunWith(AllureAndroidJUnit4::class)
class ClaimManagementTest {

    private val appBarAllPage = AppBarAllPage()
    private val authorizationPage = AuthorizationPage()
    private val claimPage = ClaimPage()
    private val device = Device()

    @Before
    fun beforeEachTest() {
        device.startLauncher()
        try {
            authorizationPage.login()
        } catch (e: Throwable) {
            println("the user is already logged in")
        }
        appBarAllPage.clickButtonMainMenu().waitMenu().clickClaims().waitClaimPage().checkingPage()
        claimPage.selectClaim().waitClaim()
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
    fun testAddComment() {
        claimPage.scrollPage(claimPage.addCommentButton)
        val numberOfComments = claimPage.getCountComments()
        claimPage.clickAddCommentButton().waitCommentTextInput().inputText().clickSaveButton()
        claimPage.scrollPage(claimPage.addCommentButton)
        val newNumberOfComments = claimPage.getCountComments()
        assertEquals(numberOfComments + 1, newNumberOfComments)
    }

    @Test
    fun testEditComment() {
        claimPage.scrollPage(claimPage.addCommentButton)
        val text = claimPage.getDescriptionComment()
        claimPage.clickEditCommentButton().waitCommentTextInput().inputEditComment(text)
            .clickSaveButton().waitClaim().scrollPage(claimPage.addCommentButton)
        val editText = claimPage.getDescriptionComment()
        assertEquals(claimPage.editComment, editText)
    }

    @Test
    fun testBackToListClaims() {
        claimPage.scrollPage(claimPage.addCommentButton).clickCloseButton().checkingPage()
    }

    @Test
    fun testChangeStatus() {
        val currentStatus = claimPage.getClaimStatus()
        claimPage.scrollPage(ClaimPage().statusProcessingButton).clickStatusProcessingButton().waitStatusMenu().selectStatus()
        if (currentStatus != claimPage.statusOpen) {
            claimPage.waitInputComment().inputComment().clickButtonOk()
            claimPage.waitClaimStatus()
        }
        claimPage.scrollPage(device.MODEL_PACKAGE + ":id/" + claimPage.statusLabel)
        val newStatus = claimPage.getClaimStatus()
        assertNotEquals(currentStatus, newStatus)
    }
}