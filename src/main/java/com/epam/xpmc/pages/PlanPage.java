package com.epam.xpmc.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlanPage extends BasePage {
	
	@FindBy(id="plan-link")
	public WebElement planButton;
		
//	keyboard shortcuts
	@FindBy(xpath="//a[text()='TA']")
	public WebElement rootFolder;
	
	@FindBy(xpath="//div[a[text()='TA']]//input")
	public WebElement editableElement;
	
//	ExpandCollapseAllTestCases
	@FindBy(xpath="//div[contains(@class, 'tm-plan-expand-button')]")
	public WebElement expandAllButton;
	
	@FindBy(xpath="//div[contains(@class, 'tm-plan-collapse-button')]")
	public WebElement collapseAllButton;
	
	public void open() {
		planButton.click();
	}	

	public void createRootFolder(String folderName) {
		simulateKeys(rootFolder, Keys.CONTROL, "=");//on Windows machine change back to Keys.CONTROL
		simulateKeys(editableElement, folderName);
		rootFolder.click();
		
	}

	public void cleanAllFoldersAndTestCases() throws InterruptedException {
		List<WebElement> foldersAndTestCases = getDriver().findElements(By.xpath("(//div[contains(@id, 'tm-plan-testcase') or contains(@id, 'tm-plan-folder')]/a)"));
		int totalItems = foldersAndTestCases.size();
		
		WebElement lastItem;		

		for(int i=0; i<totalItems; i++){
//			System.out.println("Iteration " + i);
			lastItem = getDriver().findElement(By.xpath("(//div[contains(@id, 'tm-plan-testcase') or contains(@id, 'tm-plan-folder')]/a)[last()]"));
			lastItem.click();
			simulateKeys(lastItem, Keys.BACK_SPACE);
		}
		
	}

	public void createTestCaseInsideFolderCtrlPlusInsert(String existingFolder, String testCaseName) {
		WebElement existingFolderElement = getDriver().findElement(By.xpath("//a[text()='" + existingFolder + "']"));
		existingFolderElement.click();
		simulateKeys(existingFolderElement, Keys.COMMAND, Keys.INSERT);//on Windows machine change back to Keys.CONTROL
		simulateKeys(editableElement, testCaseName);
		rootFolder.click();	
		
	}

	public void createTestCase(String folderName, String testCaseName, String step, String expectedResult) {
		int foldersCount = getElementsCount(By.xpath("//a[text()='" + folderName + "']"));
		if(foldersCount==0){
			createRootFolder(folderName);
		}
		int testCasesCount = getElementsCount(By.xpath("(//div[contains(@id, 'tm-plan-testcase')]/a[text()='" + testCaseName + "'])"));
		if(testCasesCount==0){
			createTestCaseInsideFolderCtrlPlusInsert(folderName, testCaseName);
		}
		WebElement testCaseElement = getDriver().findElement(By.xpath("//div[contains(@id, 'tm-plan-testcase')]/a[text()='"+testCaseName+"']"));
		
		if(isElementPresent(testCaseElement)){
//			enter test steps
			testCaseElement.click();
			simulateKeys(testCaseElement, Keys.TAB);
			WebElement testCaseEditableElement = getDriver().findElement(By.xpath("//div[contains(@id, 'tm-plan-testcase')][a[text()='" + testCaseName + "']]//textarea"));
			simulateKeys(testCaseEditableElement, Keys.RETURN);
			simulateKeys(testCaseEditableElement, step);
			simulateKeys(testCaseEditableElement, Keys.TAB);
//			enter expected results
			WebElement testExpectedResultEditableElement = getDriver().findElement(By.xpath("//div[contains(@id, 'tm-plan-testcase')][a[text()='" + testCaseName + "']]//textarea"));
			simulateKeys(testExpectedResultEditableElement, Keys.RETURN);
			simulateKeys(testExpectedResultEditableElement, expectedResult);
			simulateKeys(testExpectedResultEditableElement, Keys.CONTROL, "s");//on Windows machine change back to Keys.CONTROL
		}
	}

	public void testStepsAreHidden() {
		if(isElementPresent(collapseAllButton)){
//			System.out.println("hide it");
			collapseAllButton.click();
		}
	}

	public void expandsAllTestSteps() {
		expandAllButton.click();
	}

	public void testStepsAreShown() {
		if(isElementPresent(expandAllButton)){
//			System.out.println("hide it");
			expandAllButton.click();
		}		
	}

	public void collapseAllTestSteps() {
		collapseAllButton.click();		
	}
}