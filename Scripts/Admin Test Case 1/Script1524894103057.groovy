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

WebDriver driver = DriverFactory.getWebDriver()

WebUI.navigateToUrl('http://18.188.55.188:8085/')

WebUI.setText(findTestObject('Admin/input_username'), 'admin')

WebUI.setText(findTestObject('Admin/input_password'), 'admin')

WebUI.click(findTestObject('Admin/button_Login'))

WebUI.click(findTestObject('Admin/div_Products'))

WebUI.click(findTestObject('Admin/a_Total Transaction'))

WebUI.waitForAngularLoad(0, FailureHandling.STOP_ON_FAILURE)

WebElement TransactionTable = driver.findElement(By.xpath('//*[@id="add-row"]/div/table/tbody'))

List<WebElement> oldRows = TransactionTable.findElements(By.tagName('tr'))

def valueOfOldRows = oldRows.size()

println(valueOfOldRows)

WebUI.click(findTestObject('Admin/button_Logout'))

WebUI.setText(findTestObject('Admin/input_username'), 'user')

WebUI.setText(findTestObject('Admin/input_password'), 'user')

WebUI.click(findTestObject('Admin/button_Login'))

WebUI.click(findTestObject('Admin/add to cart1'))

WebUI.click(findTestObject('Admin/add to cart2'))

WebUI.click(findTestObject('Admin/add to cart3'))

WebUI.click(findTestObject('Admin/add to cart4'))

WebUI.click(findTestObject('Admin/add to cart5'))

WebUI.click(findTestObject('Admin/cart_icon'))

WebElement xpathOfElement = driver.findElement(By.xpath('//*[@id="add-row"]/div/div[2]/div/p'))

WebElement CartTable = driver.findElement(By.xpath('//*[@id="add-row"]/div/table/tbody'))

def tableSize = CartTable.findElements(By.tagName('tr')).size()

def List<String> products = new ArrayList<>()

for(def i: 1..tableSize){
	String temp = driver.findElement(By.xpath('//*[@id="add-row"]/div/table/tbody/tr[' + i + ']/td[1]')).getText()
	products.add(temp)
	println(temp)
}

def productsConcat = Arrays.toString(products)

productsConcat = productsConcat.replaceAll('\\[|\\]','')

println(productsConcat)

def totalPrice = xpathOfElement.getText().replaceAll('Total price: ', '')

println(totalPrice)

WebUI.click(findTestObject('Admin/button_confirm'))

WebUI.acceptAlert()

WebUI.click(findTestObject('Admin/button_Logout'))

WebUI.waitForPageLoad(1, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Admin/input_username'), 'admin')

WebUI.setText(findTestObject('Admin/input_password'), 'admin')

WebUI.click(findTestObject('Admin/button_Login'))

WebUI.click(findTestObject('Admin/div_Products'))

WebUI.click(findTestObject('Admin/a_Total Transaction'))

Table = driver.findElement(By.xpath('//*[@id="add-row"]/div/table/tbody'))

List<WebElement> newRows = Table.findElements(By.tagName('tr'))

println(newRows.size())

def newRowProducts = driver.findElement(By.xpath((('//*[@id="add-row"]/div/table/tbody/tr[' + newRows.size()) - 1) + ']/td[2]')).getText()

println(newRowProducts)

def newRowValue = driver.findElement(By.xpath((('//*[@id="add-row"]/div/table/tbody/tr[' + newRows.size()) - 1) + ']/td[3]')).getText()

println(newRowValue)

WebUI.verifyEqual(totalPrice, newRowValue)

WebUI.verifyEqual(productsConcat, newRowProducts)

println('No. of old rows ' + valueOfOldRows)

println('No. of new rows ' + newRows.size())

WebUI.verifyGreaterThan(newRows.size(), valueOfOldRows)

WebUI.closeBrowser()

