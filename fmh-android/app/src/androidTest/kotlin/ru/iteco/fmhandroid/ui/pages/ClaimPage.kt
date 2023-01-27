package ru.iteco.fmhandroid.ui.pages

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.Device

open class ClaimPage : Device() {
    val claims = "Claims"
    val fieldComment = "Comment"
    val creating = "Creating"
    val filter = "Filtering"
    val latin = "qwerty"
    val cyrillic = "абвгд"
    val digits = "123"
    val specSymbols = "!@#$%"
    val executor = "Ivanov Ivan Ivanovich"
    val textMessageEmpty = "Fill empty fields"
    val comment = "test comment"
    val editComment = "test edit comment"
    val claimList = "container_list_claim_include"
    val filterDialog = "claim_filter_dialog_title"
    val titleStatus = "title"
    val statusOpen = "Open"
    val editText = "editText"
    val status = "status_icon_image_view"
    val commentDescription = "comment_description_text_view"
    val appBarTitle = "custom_app_bar_title_text_view"
    val subTitle = "custom_app_bar_sub_title_text_view"
    val message = "message"
    val statusLabel = "status_label_text_view"
    val descriptionText = "description_material_text_view"
    val descriptionCard = "description_material_card_view"
    val descriptionEditText = "description_edit_text"
    val claimListCard = "claim_list_card"
    val title = "title_text_view"
    val titleEdit = "title_edit_text"
    val executorDropMenu = "executor_drop_menu_auto_complete_text_view"
    val commentsList = "claim_comments_list_recycler_view"

    val commentTextInput = "comment_text_input_layout"
    val dateInput = "date_in_plan_text_input_edit_text"
    val timeInput = "time_in_plan_text_input_edit_text"

    val addCommentButton = "add_comment_image_button"
    val saveButton = "save_button"
    val closeButton = "close_image_button"
    val editCommentButton = "edit_comment_image_button"
    val cancelButton = "cancel_button"
    val buttonOk = "button1"
    val addNewClaimButton = "add_new_claim_material_button"
    val filtersButton = "filters_material_button"
    val statusProcessingButton = "status_processing_image_button"

    fun waitClaimsCreatingPage(): ClaimPage {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, title)), TIMEOUT)
        return this
    }

    fun dateClick(): Calendar {
        device.findObject(By.res(MODEL_PACKAGE, dateInput)).click()
        return Calendar()
    }

    fun clickCancelButton(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, cancelButton)).click()
        return this
    }

    fun getDate(): String {
        return device.findObject(By.res(MODEL_PACKAGE, dateInput)).text
    }

    fun waitMessage(): ClaimPage {
        device.wait(Until.hasObject(By.res(ANDROID_PACKAGE, message)), TIMEOUT)
        return this
    }

    fun getMessageText(): String {
        return device.findObject(By.res(ANDROID_PACKAGE, message)).text
    }

    fun clickButtonOk() {
        device.findObject(By.res(ANDROID_PACKAGE, buttonOk)).click()
    }

    fun waitClaimPage(): ClaimPage {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, claimList)), TIMEOUT)
        return this
    }

    fun checkingPage() {
        device.findObject(By.res(MODEL_PACKAGE, claimList)).isChecked
    }

    fun selectClaim(): ClaimPage {
        val recyclerView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.claim_list_recycler_view),
                childAtPosition(
                    ViewMatchers.withId(R.id.all_claims_cards_block_constraint_layout),
                    4
                )
            )
        )
        recyclerView.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                ViewActions.click()
            )
        )
        return this
    }

    fun scrollPage(res: String): ClaimPage {
        val page = UiScrollable(UiSelector().scrollable(true))
        page.scrollIntoView(UiSelector().resourceId(res))
        return this
    }

    fun getCountComments(): Int {
        return device.findObject(By.res(MODEL_PACKAGE, commentsList)).childCount
    }

    fun clickAddCommentButton(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, addCommentButton)).click()
        return this
    }

    fun waitCommentTextInput(): ClaimPage {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, commentTextInput)), TIMEOUT)
        return this
    }

    fun inputText(): ClaimPage {
        device.findObject(By.text(fieldComment)).text = comment
        return this
    }

    fun clickSaveButton(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, saveButton)).click()
        return this
    }

    fun getDescriptionComment(): String {
        return device.findObject(By.res(MODEL_PACKAGE, commentDescription)).text
    }

    fun clickEditCommentButton(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, editCommentButton)).click()
        return this
    }

    fun inputEditComment(text: String): ClaimPage {
        device.findObject(By.text(text)).text = editComment
        return this
    }

    fun waitClaim(): ClaimPage {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, closeButton)), TIMEOUT)
        return this
    }

    fun clickCloseButton(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, closeButton)).click()
        return this
    }

    fun getClaimStatus(): String {
        return device.findObject(By.res(MODEL_PACKAGE, statusLabel)).text
    }

    fun clickStatusProcessingButton(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, statusProcessingButton)).click()
        return this
    }

    fun waitStatusMenu(): ClaimPage {
        device.wait(Until.hasObject(By.res(ANDROID_PACKAGE, content)), TIMEOUT)
        return this
    }

    fun selectStatus() {
        device.findObject(By.res(ANDROID_PACKAGE, titleStatus)).click()
    }

    fun waitInputComment(): ClaimPage {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, editText)), TIMEOUT)
        return this
    }

    fun inputComment(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, editText)).text = comment
        return this
    }

    fun waitClaimStatus() {
        device.wait(Until.hasObject(By.res(ANDROID_PACKAGE, status)), TIMEOUT)
    }

    fun clickTimeInput(): Clock {
        device.findObject(By.res(MODEL_PACKAGE, timeInput)).click()
        return Clock()
    }

    fun clickFiltersButton(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, filtersButton)).click()
        return this
    }

    fun waitFiltering(): ClaimPage {
        device.wait(Until.hasObject(By.res(ANDROID_PACKAGE, filterDialog)), TIMEOUT)
        return this
    }

    fun getFiltering(): String {
        return device.findObject(By.res(MODEL_PACKAGE, filterDialog)).text
    }

    fun clickAddNewClaimButton(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, addNewClaimButton)).click()
        return this
    }

    fun getCreatingTitle(): String {
        return device.findObject(By.res(MODEL_PACKAGE, appBarTitle)).text
    }

    fun getClaimsTitle(): String {
        return device.findObject(By.res(MODEL_PACKAGE, subTitle)).text
    }

    fun getTopic(): String {
        return device.findObject(By.res(MODEL_PACKAGE, descriptionText)).text
    }

    fun clickClaimListCard(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, claimListCard)).click()
        return this
    }

    fun waitDescriptionCard() {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, descriptionCard)), TIMEOUT)
    }

    fun getTitleClaim(): String {
        return device.findObject(By.res(MODEL_PACKAGE, title)).text
    }

    fun titleEdit(text: String) {
        device.findObject(By.res(MODEL_PACKAGE, titleEdit)).text = text
    }

    fun getTitleInput(): String {
        return device.findObject(By.res(MODEL_PACKAGE, titleEdit)).text
    }

    fun inputExecutor(text: String) {
        device.findObject(By.res(MODEL_PACKAGE, executorDropMenu)).text = text
    }

    fun getExecutorText(): String {
        return device.findObject(By.res(MODEL_PACKAGE, executorDropMenu)).text
    }

    fun inputDescription(text: String) {
        device.findObject(By.res(MODEL_PACKAGE, descriptionEditText)).text = text
    }

    fun getTextDescription(): String {
        return device.findObject(By.res(MODEL_PACKAGE, descriptionEditText)).text
    }

    fun clickDropMenuExecutor(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, executorDropMenu)).click()
        return this
    }

    fun getTextDropMenuExecutor(): String {
        return device.findObject(By.res(MODEL_PACKAGE, executorDropMenu)).text
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}