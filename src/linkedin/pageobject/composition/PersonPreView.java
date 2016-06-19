package linkedin.pageobject.composition;

import linkedin.pageobject.validators.Validator;

import org.openqa.selenium.WebElement;

public class PersonPreView {
	private WebElement actionBtn = null;
	private WebElement graphic = null;
	private WebElement currentJob = null;
	private String expectedCurrentJob = null;
	
	public PersonPreView(WebElement actionBtn, WebElement graphic,
			WebElement currentJob, String expectedCurrentJob) {
		this.actionBtn = actionBtn;
		this.graphic = graphic;
		this.currentJob = currentJob;
		this.expectedCurrentJob = expectedCurrentJob;
	}
	
	public boolean clickConnect(){
		String demographic =this.graphic.getText();
		String acutalCurrentJob = this.currentJob.getText();
		String textOfBtn = this.actionBtn.getText();
		
		if (Validator.toCheckCurrentJob(this.expectedCurrentJob,
				acutalCurrentJob)
				&& Validator.toCheckDemographicIsValidate(demographic)
				&& Validator.toCheckBtnIsForConnect(textOfBtn)) {
			this.actionBtn.click();
			return true;
		}
		
		return false;
	}
	
}
