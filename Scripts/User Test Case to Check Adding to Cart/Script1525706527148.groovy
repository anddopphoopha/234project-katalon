import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import javax.lang.model.element.VariableElement

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

WebDriver driver = DriverFactory.getWebDriver()

WebUI.waitForElementPresent(findTestObject('User/User Cart/add to cart1'), 0)

WebElement products = driver.findElement(By.xpath('/html/body/app-root/app-product-list/div/div[2]/div'))

List<WebElement> productList = products.findElements(By.className('farmer-card'))

println(productList.size())

List<VariableElement> variables = new ArrayList<>()


for(def i: 1..productList.size()){
	for(def j: 1..i){
		WebUI.click(findTestObject('User/User Cart/add to cart' + j))

		WebUI.verifyElementText(findTestObject('User/User Cart/added_' + j), 'already added')
		
	}
	
	WebUI.verifyElementText(findTestObject('User/User Cart/cart_icon'), Integer.toString(i))
	
}

WebUI.closeBrowser()

