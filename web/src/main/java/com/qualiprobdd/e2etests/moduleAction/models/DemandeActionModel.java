package com.qualiprobdd.e2etests.moduleAction.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import com.qualiprobdd.e2etests.moduleAction.pages.DemandeActionPage;
import com.qualiprobdd.e2etests.moduleAction.pages.FicheActionPage;
import com.qualiprobdd.e2etests.util.Common;
import com.qualiprobdd.e2etests.util.ExcelUtils;
import com.qualiprobdd.e2etests.util.RandomValue;



public class DemandeActionModel {
	public static String NumDemande;
	/* Public methods */
	private static String Path = "C:\\Users\\mootez\\eclipse-workspace\\testauto-web-mobile\\main\\src\\main\\resources\\testData\\TestData.xlsx";
	public static List<String> responsable;
	public static String Cpt_agenda;
	
	public static void consulter_Demande() throws InterruptedException {
		
		FicheActionPage.menuID.click();
		Thread.sleep(2000L);
		FicheActionPage.ActionSXpath.click();
		Thread.sleep(1000L);
		DemandeActionPage.ModuleDemandeActions.click();
		Thread.sleep(1000L);

	}
	
	public static void cliquer_Ajouter_Demande() {

		DemandeActionPage.BoutonAjoutID.click();
		Common.Exporter_visibilité("Nouvelle Fiche demande Action");
		Common.Exporter_champ_A_masquer("Nouvelle Fiche demande Action");
	}
	public static void  Selectionner_Source(int arg1) throws Throwable 
	{
		ExcelUtils.setExcelFile(Path, "DemandeAction");
		Select select = new Select(DemandeActionPage.SourceID);
		select.selectByVisibleText(ExcelUtils.getCellData(arg1, 0));
	}
	public static void  Selectionner_Type(int arg1) throws Throwable
	{
		ExcelUtils.setExcelFile(Path, "DemandeAction");
		Select select = new Select(DemandeActionPage.TypeID);
		select.selectByVisibleText(ExcelUtils.getCellData(arg1, 1));
	}
	public static void  Selectionner_Origine() 
	{
		
		try {
			DemandeActionPage.OrigineID.isDisplayed();
			Select select = new Select(DemandeActionPage.OrigineID);
			select.selectByVisibleText("TESTAUTO2");
			Common.Exporter_champ_A_masquer("le champ origine action est visible");
			}
			catch (NoSuchElementException e) {
				Common.Exporter_champ_A_masquer("le champ origine action est invisible");
			}
	
    	
    }
    
	public static void  Ajouter_Type_Cause(int arg1) throws Throwable
	{
		try {
			ExcelUtils.setExcelFile(Path, "DemandeAction");
			DemandeActionPage.AjoutTypeCauseID.isDisplayed();
			DemandeActionPage.AjoutTypeCauseID.click();
			 Thread.sleep(500L);
			 DemandeActionPage.RechTypeCauseID.sendKeys(ExcelUtils.getCellData(arg1, 2));
			 DemandeActionPage.GridTypeCauseID.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView9\"]/tbody/tr/td[1]")).findElement(By.tagName("input")).click();
			 DemandeActionPage.TypeCauseValideID.click();
			Common.Exporter_champ_A_masquer("le champ type cause est visible");
			}
			catch (NoSuchElementException e) {
				Common.Exporter_champ_A_masquer("le champ type cause est invisible");
			}
		
	}
	
	public static void  Ajouter_Produit() throws Throwable
	{
		try {
			DemandeActionPage.AjoutProduitID.isDisplayed();
			DemandeActionPage.AjoutProduitID.click();
			Thread.sleep(500L);
			DemandeActionPage.produitAjouteID.click();
			DemandeActionPage.produitValideID.click();
			Common.Exporter_champ_A_masquer("le champ produit est visible");
			}
			catch (NoSuchElementException e) {
				Common.Exporter_champ_A_masquer("le champ produit est invisible");
			}
	
	}
	public static void  Selectionner_Date_Creation()
	{
		DemandeActionPage.dateCreationID.click();
		DemandeActionPage.CalendrierID.click();	
	}
	
	public static void  Saisir_Designation() 
	{
		DemandeActionPage.DesignationID.sendKeys(RandomValue.randomString(10));
	}
	
	public static void  Saisir_Description() 
	{
		DemandeActionPage.DescriptionID.sendKeys("description demande action");
	}
	
	public static void  Saisir_Cause() 
	{
		DemandeActionPage.CauseID.sendKeys("Cause demande action");
	}
	
	public static void  Saisir_Objective() 
	{
		try {
			DemandeActionPage.ObjectiveID.isDisplayed();
			DemandeActionPage.ObjectiveID.sendKeys("Objective demande action");
			Common.Exporter_champ_A_masquer("le champ objectif est visible");
			}
			catch (NoSuchElementException e) {
				Common.Exporter_champ_A_masquer("le champ objectif est invisible");
			}
		
	}
	

	public static void Selectionner_Site(WebDriver driver,int arg1) throws Exception 
	{
		try {
			DemandeActionPage.SiteID.isDisplayed();
		    Common.Exporter_visibilité("le site est visible");
			String text=driver.findElement(By.id("ctl00_ContentPlaceHolder1_lbsite2")).getText();
			if(text.indexOf('*')!=-1) 
			{
				Common.Exporter_visibilité("le site est obligatoire");
			}else 
			{
				Common.Exporter_visibilité("le site n'est pas obligatoire");
				
			}
			ExcelUtils.setExcelFile(Path, "DemandeAction");
			Select select = new Select(DemandeActionPage.SiteID);
			select.selectByVisibleText(ExcelUtils.getCellData(arg1, 3));
			}
			catch (NoSuchElementException e) {
				Common.Exporter_visibilité("le site est invisible");
			}
		
		
	}
	
	public static void Selectionner_Processus(WebDriver driver, int arg1) throws Exception
	{
		try {
			DemandeActionPage.ProcessusID.isDisplayed();
			Common.Exporter_visibilité("le processus est visible");
			String text=driver.findElement(By.id("ctl00_ContentPlaceHolder1_LblProcessus_")).getText();
			if(text.indexOf('*')!=-1) 
			{
				Common.Exporter_visibilité("le processus est obligatoire");
			}else 
			{
				Common.Exporter_visibilité("le processus n'est pas obligatoire");
				
			}
			ExcelUtils.setExcelFile(Path, "DemandeAction");
			Select select = new Select(DemandeActionPage.ProcessusID);
			select.selectByVisibleText(ExcelUtils.getCellData(arg1,4));
			}
			catch (NoSuchElementException e) {
				Common.Exporter_visibilité("le processus est invisible");
			}
		
	}
	
	public static void Selectionner_Activite(WebDriver driver,int arg1) throws Exception 
	{
		try {
			DemandeActionPage.ActiviteID.isDisplayed();
			Common.Exporter_visibilité("l'activité est visible");
			String text=driver.findElement(By.id("ctl00_ContentPlaceHolder1_LblDomaine_")).getText();
			if(text.indexOf('*')!=-1) 
			{
				Common.Exporter_visibilité("l'activité est obligatoire");
			}else 
			{
				Common.Exporter_visibilité("l'activité n'est pas obligatoire");
				
			}
			ExcelUtils.setExcelFile(Path, "DemandeAction");
			Select select = new Select(DemandeActionPage.ActiviteID);
			select.selectByVisibleText(ExcelUtils.getCellData(arg1, 5));
			}
			catch (NoSuchElementException e) {
				Common.Exporter_visibilité("l'activité est invisible");
			}
		
	}
	
	public static void Selectionner_Direction(WebDriver driver, int arg1) throws Throwable
	{
	
		try {
			DemandeActionPage.DirectionID.isDisplayed();
			Common.Exporter_visibilité("la direction est visible");
			String text=driver.findElement(By.id("ctl00_ContentPlaceHolder1_LabelDir")).getText();
			if(text.indexOf('*')!=-1) 
			{
				Common.Exporter_visibilité("la direction est obligatoire");
			}else 
			{
				Common.Exporter_visibilité("la direction n'est pas obligatoire");
				
			}
			ExcelUtils.setExcelFile(Path, "DemandeAction");
			Select select = new Select(DemandeActionPage.DirectionID);
			select.selectByVisibleText(ExcelUtils.getCellData(arg1,6));
			}
			catch (NoSuchElementException e) {
				Common.Exporter_visibilité("la direction est invisible");
			}
	}
	
	public static void Selectionner_Service(WebDriver driver, int arg1) throws Throwable
	{
		
		try {
			DemandeActionPage.ServiceID.isDisplayed();
			Common.Exporter_visibilité("le service est visible");
			String text=driver.findElement(By.id("ctl00_ContentPlaceHolder1_LblService_")).getText();
			if(text.indexOf('*')!=-1) 
			{
				Common.Exporter_visibilité("le service est obligatoire");
			}else 
			{
				Common.Exporter_visibilité("le service n'est pas obligatoire");
			}
			ExcelUtils.setExcelFile(Path, "DemandeAction");
			Select select = new Select(DemandeActionPage.ServiceID);
			select.selectByVisibleText(ExcelUtils.getCellData(arg1, 7));	
			}
			catch (NoSuchElementException e) {
				Common.Exporter_visibilité("le service est invisible");
			}
		
	}
	
	public static void  valider_Demande() 
	{
		Cpt_agenda=DemandeActionPage.CompteurID.getText();
		DemandeActionPage.BoutonValideID.click();
	}
	
	public static void clickAjouterSAD()  throws Exception 
	{	
		DemandeActionPage.ObjetMenuID.click();
		Thread.sleep(1000L);
		DemandeActionPage.PlanMenuID.click();
		Thread.sleep(1000L);
		DemandeActionPage.btnAjouter_SAD_ID.click();
	}
	
	public static void saisirDesignationSAD() {

		DemandeActionPage.designation_SAD_ID.sendKeys(RandomValue.randomString(10));
	}
	
	public static void selectionnerResponsableRealisationSAD(int arg1) throws Throwable 
	{
		ExcelUtils.setExcelFile(Path, "DemandeAction");
		Select select = new Select(DemandeActionPage.responsableRealisation_SAD_ID);
		select.selectByVisibleText(ExcelUtils.getCellData(arg1, 10));
	}
	
	public static void selectionnerResponsableSuiviSAD(int arg1) throws Throwable {
		ExcelUtils.setExcelFile(Path, "DemandeAction");
		Select select = new Select(DemandeActionPage.responsableSuivi_SAD_ID);
		select.selectByVisibleText(ExcelUtils.getCellData(arg1, 11));
	}
	
	public static void choixDateSAD(WebDriver driver) throws Throwable {
		
		final DateFormat dateFormat;
		Cookie cookie1 = driver.manage().getCookieNamed("lan");
		if(cookie1.getValue().equals("en-US")) {
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		}else {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE,0);
		dt = c.getTime();
		String Sdate = dateFormat.format(dt);
		System.out.println(Sdate);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[1].value = arguments[0];",Sdate, DemandeActionPage.Date_real_txt_id);
		jse.executeScript("arguments[1].value = arguments[0];",Sdate, DemandeActionPage.Date_suivi_txt_id);
	}
	public static void Priorite(int arg1) throws Throwable {
		try {
			DemandeActionPage.PrioriteId.isDisplayed();
			ExcelUtils.setExcelFile(Path, "DemandeAction");
			Select select = new Select(DemandeActionPage.PrioriteId);
			select.selectByVisibleText(ExcelUtils.getCellData(arg1,9));
			Common.Exporter_champ_A_masquer("le champ priorite est visible");
			}
			catch (NoSuchElementException e) {
				Common.Exporter_champ_A_masquer("le champ priorite est invisible");
			}
	}
	
	public static void Gravite(int arg1) throws Throwable {
		try {
			DemandeActionPage.GraviteId.isDisplayed();
			ExcelUtils.setExcelFile(Path, "DemandeAction");
			Select select = new Select(DemandeActionPage.GraviteId);
			select.selectByVisibleText(ExcelUtils.getCellData(arg1,8));
			Common.Exporter_champ_A_masquer("le champ gravite est visible");
			}
			catch (NoSuchElementException e) {
				Common.Exporter_champ_A_masquer("le champ gravite est invisible");
			}
	}
	
	public static void Risque() {
		try {
			DemandeActionPage.RisqueId.isDisplayed();
			DemandeActionPage.RisqueId.sendKeys("Risque sous action");
			Common.Exporter_champ_A_masquer("le champ risque est visible");
			}
			catch (NoSuchElementException e) {
				Common.Exporter_champ_A_masquer("le champ risque est invisible");
			}
	}
	
	public static void Cout_Prev() {
		try {
			DemandeActionPage.CoutPrevId.isDisplayed();
			DemandeActionPage.CoutPrevId.sendKeys("1000");
			Common.Exporter_champ_A_masquer("le champ cout prévisionelle est visible");
			}
			catch (NoSuchElementException e) {
				Common.Exporter_champ_A_masquer("le champ cout prévisionelle est invisible");
			}
	}
	public static void validerSAD() {
		DemandeActionPage.btnValider_SAD_ID.click();
	}
	
	public static void Verifier_Demande_Ajout() throws Throwable
	{
		Thread.sleep(1000L);
		NumDemande =DemandeActionPage.NumeroDemandeID.getText();
		Common.Exporter_visibilité("Fiche Demande Action:"+NumDemande);
		Common.Exporter_champ_A_masquer("Fiche Demande Action: "+NumDemande);
		System.out.println("demande N:"+ NumDemande + "est Ajoute");
		asserttrue(true);
		
	}
	
	public static void recuperer_responsable()  throws Exception
	{
		responsable= new ArrayList();
		List<WebElement> rows_Table = DemandeActionPage.ResponsableTableID.findElements(By.tagName("tr"));
		int rowCount= rows_Table.size();
		for(int i=0;i<rowCount;i++) {
			List<WebElement> Column_Table = rows_Table.get(i).findElements(By.tagName("td"));
			if(Column_Table.size()!=0)
			{
			responsable.add(Column_Table.get(2).getText());
			System.out.println("responsable:" + Column_Table.get(2).getText() );
			}
		}
			
	}

	public static void incrementation_compteur_agenda_DA() throws Throwable {
		Boolean incrementation = false;
		int compteur;
		if (Cpt_agenda != "") {
			compteur = Integer.parseInt(Cpt_agenda);
			System.out.println("compteur: " + compteur);
		} else {
			compteur = 0;
			System.out.println("compteur: " + compteur);
		}
		DemandeActionPage.HomeID.click();
		Thread.sleep(2000L); 
		System.out.println("compteur1 : " + DemandeActionPage.CompteurID.getText());
		if (Integer.parseInt(DemandeActionPage.CompteurID.getText()) == compteur + 1) {
			incrementation = true;
		}
		asserttrue(incrementation);
	}
	
	private static void asserttrue(Boolean incrementation) {
		
	}
	
	public static void Deconnexion_Compte() throws Exception
	{
		DemandeActionPage.CompteID.click();
		DemandeActionPage.DeconnexionID.click();
		Thread.sleep(3000L);
    }
	
	
	
	public static void Acceder_Demande() throws Exception
	{
		DemandeActionPage.AgendaAcID.click();
		Thread.sleep(2000L);
		DemandeActionPage.MenuAgDaID.click();
		String demandID1=NumDemande;
		DemandeActionPage.FiltreAgendaID.sendKeys(demandID1);
		Thread.sleep(1000L);
		 //To find third row of table
		 WebElement tableRow = DemandeActionPage.TableID.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView3\"]/tbody/tr"));
		    
		    //to get 3rd row's 2nd column data
		    WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView3\"]/tbody/tr/td[1]"));
		    WebElement cellIneed1 = cellIneed.findElement(By.tagName("a"));
		    cellIneed1.click();
		Thread.sleep(3000L);
		DemandeActionPage.ObjetMenuID.click();
		Thread.sleep(1000L);
		DemandeActionPage.PlanMenuID.click();
	}
	
	public static String recuperer_current_reponsable() throws Exception
	{
		String curRes;
		if(!(responsable.isEmpty()) )
		{
		curRes= responsable.get(0);
		responsable.remove(0);
		}
		else{
			
			curRes="";
		}
		return curRes;
		
	}
		
	public static void Saisir_Numero_Demande() 
	{
		DemandeActionPage.FiltreNumeroID.sendKeys(NumDemande);
		
	}
	
	public static void Cliquer_rechercher_Demande()
	{
		DemandeActionPage.BoutonChercherID.click();
		
	}
	
	
	
	
}
