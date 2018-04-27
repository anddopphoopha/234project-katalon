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

WebUI.setText(findTestObject('User/User Cart/input_username'), 'user')

WebUI.setText(findTestObject('User/User Cart/input_password'), 'user')

WebUI.click(findTestObject('User/User Cart/button_Login'))

WebUI.click(findTestObject('User/User Cart/button_add to cart'))

WebUI.click(findTestObject('User/User Cart/button_add to cart'))

WebUI.click(findTestObject('User/User Cart/button_add to cart'))

WebUI.click(findTestObject('User/User Cart/button_add to cart'))

WebUI.click(findTestObject('User/User Cart/button_add to cart'))

WebUI.click(findTestObject('User/User Cart/span_5'))

WebUI.setText(findTestObject('User/User Cart/input_amount'), '2')

WebUI.click(findTestObject('User/User Cart/td_150 THB'))

WebUI.setText(findTestObject('User/User Cart/input_amount'), '2')

WebUI.click(findTestObject('User/User Cart/div_Shopping Cart'))

WebUI.setText(findTestObject('User/User Cart/input_amount'), '2')

WebUI.click(findTestObject('User/User Cart/td_12 THB'))

WebUI.setText(findTestObject('User/User Cart/input_amount'), '5')

WebUI.click(findTestObject('User/User Cart/div_col-4 center-block'))

WebUI.setText(findTestObject('User/User Cart/input_amount'), '4')

WebUI.click(findTestObject('User/User Cart/p_Total price  41000 THB'))

WebUI.click(findTestObject('User/User Cart/button_confirm'))

WebUI.click(findTestObject('User/User Cart/div_Well done You successfully'))

WebUI.closeBrowser()

