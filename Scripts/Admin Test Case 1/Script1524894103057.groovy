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

WebUI.setText(findTestObject('Admin/input_username'), admin_username)

WebUI.setText(findTestObject('Admin/input_password'), admin_password)

WebUI.click(findTestObject('Admin/button_Login'))

WebUI.delay(5)

WebUI.click(findTestObject('Admin/a_Total Transaction'))

WebElement Table = driver.findElement(By.xpath('//*[@id="add-row"]/div/table/tbody'))

WebUI.delay(5)

def oldAdminTotalPrice = driver.findElement(By.xpath('//*[@id="add-row"]/div/div[2]/div/p')).getText()

oldAdminTotalPrice = oldAdminTotalPrice.replaceAll(' THB', '').replaceAll('Total price: ', '').replaceAll(',', '')

oldAdminTotalPrice = Integer.parseInt(oldAdminTotalPrice)

List<WebElement> oldRows = Table.findElements(By.tagName('tr'))

def valueOfOldRows = oldRows.size()

ArrayList<String> oldTransactionList = new ArrayList<String>()

for (def i : (1..oldRows.size())) {
    def tempString = ''

    tempString += driver.findElement(By.xpath(('//*[@id="add-row"]/div/table/tbody/tr[' + i) + ']/td[1]')).getText()

    tempString += driver.findElement(By.xpath(('//*[@id="add-row"]/div/table/tbody/tr[' + i) + ']/td[2]')).getText()

    tempString += driver.findElement(By.xpath(('//*[@id="add-row"]/div/table/tbody/tr[' + i) + ']/td[3]')).getText()

    oldTransactionList.add(tempString)
}

WebUI.click(findTestObject('Admin/button_Logout'))

WebUI.delay(5)

WebUI.setText(findTestObject('Admin/input_username'), user_username)

WebUI.setText(findTestObject('Admin/input_password'), user_password)

WebUI.click(findTestObject('Admin/button_Login'))

WebUI.click(findTestObject('Admin/add to cart1'))

WebUI.click(findTestObject('Admin/add to cart2'))

WebUI.click(findTestObject('Admin/add to cart3'))

WebUI.click(findTestObject('Admin/add to cart4'))

WebUI.click(findTestObject('Admin/add to cart5'))

WebUI.click(findTestObject('Admin/cart'))

WebUI.delay(5)

WebUI.setText(findTestObject('Admin/input_amount1'), input_amount1)

WebUI.setText(findTestObject('Admin/input_amount2'), input_amount2)

WebUI.setText(findTestObject('Admin/input_amount3'), input_amount3)

WebUI.setText(findTestObject('Admin/input_amount4'), input_amount4)

WebUI.setText(findTestObject('Admin/input_amount5'), input_amount5)

WebElement xpathOfElement = driver.findElement(By.xpath('//*[@id="add-row"]/div/div[2]/div/p'))

WebElement UserTable = driver.findElement(By.xpath('//*[@id="add-row"]/div/table/tbody'))

List<WebElement> userRows = UserTable.findElements(By.tagName('tr'))

def userProducts = ''

for (def i : (1..userRows.size())) {
    userProducts += driver.findElement(By.xpath(('//*[@id="add-row"]/div/table/tbody/tr[' + i) + ']/td[1]')).getText()
}

def userTotalPrice = xpathOfElement.getText().replaceAll('Total price: ', '')

def valueOfUserTotalPrice = Integer.parseInt(userTotalPrice.replaceAll(' THB', '').replaceAll(',', ''))

WebUI.click(findTestObject('Admin/button_confirm'))

WebUI.acceptAlert()

WebUI.click(findTestObject('Admin/button_Logout'))

WebUI.delay(5)

WebUI.setText(findTestObject('Admin/input_username'), admin_username)

WebUI.setText(findTestObject('Admin/input_password'), admin_password)

WebUI.click(findTestObject('Admin/button_Login'))

WebUI.click(findTestObject('Admin/div_Products'))

WebUI.click(findTestObject('Admin/a_Total Transaction'))

Table = driver.findElement(By.xpath('//*[@id="add-row"]/div/table/tbody'))

WebUI.delay(5)

List<WebElement> newRows = Table.findElements(By.tagName('tr'))

ArrayList<String> newTransactionList = new ArrayList<String>()

for (def i : (1..newRows.size() - 1)) {
    def tempString = ''

    tempString += driver.findElement(By.xpath(('//*[@id="add-row"]/div/table/tbody/tr[' + i) + ']/td[1]')).getText()

    tempString += driver.findElement(By.xpath(('//*[@id="add-row"]/div/table/tbody/tr[' + i) + ']/td[2]')).getText()

    tempString += driver.findElement(By.xpath(('//*[@id="add-row"]/div/table/tbody/tr[' + i) + ']/td[3]')).getText()

    newTransactionList.add(tempString)

    println(tempString)
}

def newRowValue = driver.findElement(By.xpath(('//*[@id="add-row"]/div/table/tbody/tr[' + newRows.size()) + ']/td[3]')).getText()

def newTranscation = driver.findElement(By.xpath(('//*[@id="add-row"]/div/table/tbody/tr[' + newRows.size()) + ']/td[2]')).getText().replaceAll(
    ', ', '')

def newAdminTotalPrice = driver.findElement(By.xpath('//*[@id="add-row"]/div/div[2]/div/p')).getText()

newAdminTotalPrice = newAdminTotalPrice.replaceAll(' THB', '').replaceAll('Total price: ', '').replaceAll(',', '')

newAdminTotalPrice = Integer.parseInt(newAdminTotalPrice)

println('Total Price of All Transaction before: ' + oldAdminTotalPrice)

println('Total Price that User Bought: ' + userTotalPrice)

println('Total Price of all Transaction after: ' + newAdminTotalPrice)

println('Size of Rows after: ' + newRows.size())

println('Total Price of Last Transaction: ' + newRowValue)

WebUI.verifyEqual(userTotalPrice, newRowValue)

WebUI.verifyEqual(valueOfUserTotalPrice + oldAdminTotalPrice, newAdminTotalPrice)

WebUI.verifyEqual(Arrays.toString(oldTransactionList), Arrays.toString(newTransactionList))

WebUI.verifyEqual(userProducts, newTranscation)

println('No. of old rows ' + valueOfOldRows)

println('No. of new rows ' + newRows.size())

WebUI.verifyGreaterThan(newRows.size(), valueOfOldRows)

WebUI.closeBrowser()

