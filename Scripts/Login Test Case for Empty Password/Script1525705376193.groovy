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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

WebUI.openBrowser('')

WebUI.navigateToUrl('http://18.188.55.188:8085/')

WebUI.setText(findTestObject('Login/Login Fail 3/input_password'), password)

WebDriver driver = DriverFactory.getWebDriver()

def inputLength = password.toString().length()

println(inputLength)

while(inputLength > 0){
	WebUI.sendKeys(findTestObject('Login/Login Fail 3/input_password'), Keys.chord(Keys.BACK_SPACE))
	inputLength--
}

WebUI.setText(findTestObject('Login/Login Fail 3/input_username'), username)

WebUI.waitForElementPresent(findTestObject('Login/Login Fail 3/passwordNotification'), 0)

WebUI.waitForElementAttributeValue(findTestObject('Login/Login Fail 3/passwordNotification')
	, 'class' , 'text-danger', 0)

WebUI.verifyElementText(findTestObject('Login/Login Fail 3/passwordNotification'), 'Password is required')

WebUI.verifyEqual(WebUI.getUrl(), 'http://18.188.55.188:8085/')

WebUI.closeBrowser()

