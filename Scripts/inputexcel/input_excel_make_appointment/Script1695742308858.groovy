import java.io.*
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.LocalDateTime as LocalDateTime
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword as Keyword
import org.openqa.selenium.interactions.Actions as Action
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.awt.List as List
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions
import org.apache.commons.lang3.StringUtils as StringUtils
import java.text.DecimalFormat as DecimalFormat
import java.text.NumberFormat as NumberFormat
//additional
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import groovy.json.JsonSlurper as JsonSlurper
import groovy.json.JsonOutput as JsonOutput
import com.kms.katalon.core.util.KeywordUtil


//define test case name to generate excel report name
String testcase_name = 'make_appointment'

//define number report
//int number_test_case = Integer.parseInt(Number)
//def number_testcase_string = number_test_case.toString()
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/input_Username_username'), 
    Username)

//WebUI.setText(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/input_Demo account_form-control'), 
//    'ThisIsNotAPassword')
//
//WebUI.click(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/span_Demo account_glyphicon glyphicon-lock'))
WebUI.setEncryptedText(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/input_Password_password'), 
    Password)

//Click submit button login
WebUI.click(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/button_Login'))

//select option value
WebUI.selectOptionByValue(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/select_Tokyo CURA Healthcare Center        _5b4107'), 
    SelectHealthcareCenter, true)

//WebUI.verifyOptionSelectedByLabel(findTestObject('input_and_select/Page_CURA Healthcare Service/select_CURA Healthcare'), 
//    'Hongkong CURA Healthcare Center', false, 0)
//WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/select_Tokyo CURA Healthcare Center        _5b4107'),
//	'Hongkong CURA Healthcare Center', false, 0)
//Hospital readmission
if (ApplyForHospitalReadmission == 'Yes') {
    WebUI.click(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/input_Apply for hospital readmission_hospit_63901f'))
} else if (ApplyForHospitalReadmission == 'No') {
    WebUI.click(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/input_Apply for hospital readmission_hospit_63901f'))

    WebUI.click(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/input_Apply for hospital readmission_hospit_63901f'))
} else {
    WebUI.click(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/input_Apply for hospital readmission_hospit_63901f'))

    WebUI.click(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/input_Apply for hospital readmission_hospit_63901f'))
}

//Healthcare Program
if (HealthcareProgram == 'Medicare') {
    WebUI.click(findTestObject('input_and_select/Page_CURA Healthcare Service/input_Medicare_programs'))
} else if (HealthcareProgram == 'Medicaid') {
    WebUI.click(findTestObject('input_and_select/Page_CURA Healthcare Service/input_Medicaid_programs'))
} else if (HealthcareProgram == 'None') {
    WebUI.click(findTestObject('input_and_select/Page_CURA Healthcare Service/input_None_programs'))
} else {
    WebUI.click(findTestObject('input_and_select/Page_CURA Healthcare Service/input_None_programs'))
}

//Visit date
WebUI.setText(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/input_Visit Date (Required)_visit_date'), 
    VisitDate)

//Comment
WebUI.setText(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/textarea_Comment_comment'), 
    Comment)

WebUI.takeFullPageScreenshot()

//Button Appointment
WebUI.click(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/button_Book Appointment'))

//Confirmation
//WebUI.click(findTestObject('Object Repository/MakeAppointment/Page_CURA Healthcare Service/h2_Appointment Confirmation'))

if (WebUI.verifyElementVisible(findTestObject('MakeAppointment/Page_CURA Healthcare Service/h2_Appointment Confirmation'))) {
	KeywordUtil.markPassed("Success submit form")
} else {
	KeywordUtil.markFailed("Failed submit form")
}

WebUI.takeFullPageScreenshot()

WebUI.closeBrowser()

