import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://18.188.55.188:8085/')

WebUI.setText(findTestObject('User/User Cart/input_username'), username)

WebUI.setText(findTestObject('User/User Cart/input_password'), password)

WebUI.click(findTestObject('User/User Cart/button_Login'))

WebUI.click(findTestObject('User/User Cart/add to cart1'))

WebUI.verifyElementText(findTestObject('User/User Cart/button_added'), 'already added')

WebUI.click(findTestObject('User/User Cart/add to cart2'))

WebUI.verifyElementText(findTestObject('User/User Cart/button_added'), 'already added')

WebUI.click(findTestObject('User/User Cart/add to cart3'))

WebUI.verifyElementText(findTestObject('User/User Cart/button_added'), 'already added')

WebUI.click(findTestObject('User/User Cart/add to cart4'))

WebUI.verifyElementText(findTestObject('User/User Cart/button_added'), 'already added')

WebUI.click(findTestObject('User/User Cart/add to cart5'))

WebUI.verifyElementText(findTestObject('User/User Cart/button_added'), 'already added')

WebUI.click(findTestObject('User/User Cart/cart_icon'))

WebUI.verifyElementText(findTestObject('User/User Cart/cart_icon'), '5')

WebUI.setText(findTestObject('User/User Cart/input_amount'), input_amount)

WebUI.setText(findTestObject('User/User Cart/input_amount2'), input_amount2)

WebUI.setText(findTestObject('User/User Cart/input_amount3'), input_amount3)

WebUI.setText(findTestObject('User/User Cart/input_amount4'), input_amount4)

WebUI.setText(findTestObject('User/User Cart/input_amount5'), input_amount5)

WebUI.waitForElementPresent(findTestObject('User/User Cart/p_Total price'), 0)

WebUI.verifyElementText(findTestObject('User/User Cart/p_Total price'), totalprice)

WebDriver driver = DriverFactory.getWebDriver()

WebElement Table = driver.findElement(By.xpath('//*[@id="add-row"]/div/table/tbody'))

List<WebElement> Rows = Table.findElements(By.tagName('tr'))

println('No. of rows ' + Rows.size())

'Compare the value'
WebUI.verifyEqual(5, Rows.size)

WebUI.click(findTestObject('User/User Cart/button_confirm'))

WebUI.acceptAlert()

WebUI.click(findTestObject('User/User Cart/div_Well done You successfully'))

WebUI.closeBrowser()

