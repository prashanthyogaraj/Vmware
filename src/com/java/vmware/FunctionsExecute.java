package com.java.vmware;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

//****listelements collect data from the VDS Page and Store it in tmp_file******
public class FunctionsExecute {

	public void listelements(WebDriver driver, String name) throws IOException {
		
		
		List<String> li = new ArrayList<String>();
		List<String> lis = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("/html/body/ul"));

		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).getText());
			String rock = list.get(i).getText();
			File file = new File("C:/Users/" + name + "/Desktop/tmp_file.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("C:/Users/" + name + "/Desktop/tmp_file.txt", true));
			writer.write(rock);
			writer.newLine();
			writer.close();
			// System.out.println("string successfully writed into file");
		}
		

	}

	 //*******readfinal function read content of webpage from tmp_file and store it in a list and it was used in code for processing*******
	public List readfinal(String name) throws IOException {
		String str;

		List<String> lists = new ArrayList<String>();
		List<String> fl = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new FileReader("C:/Users/" + name + "/Desktop/tmp_file.txt"));
		while ((str = in.readLine()) != null) {
			str = str.replaceAll("Parent Directory", "");
			str = str.replaceAll("PMD/", "");
			str = str.replaceAll(".DS_Store", "");

			// str = str.replaceAll("README.html", "");

			str = str.replaceAll("DRV-SOURCE-ADAP/", "");
			lists.add(str);
			lists.remove("");
		}
		String[] st = lists.toArray(new String[0]);
		for (int k = 0; k < st.length; k++) {
			// System.out.println("latest st[" + k + "]" + st[k]);

			fl.add(st[k]);

		}
		return lists;

	}

	//****listdriverisoelements collects data from the DriverRepository(Share) Page and Store it in tmp_file******
/*	public void listdriverIsoelements(WebDriver driver, String name) throws IOException {

		List<String> li = new ArrayList<String>();
		List<String> lis = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("/html/body/table"));

		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).getText());

			String rock = list.get(i).getText();
			File file = new File("C:/Users/" + name + "/Desktop/tmp_file.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("C:/Users/" + name + "/Desktop/tmp_file.txt", true));
			writer.write(rock);
			writer.newLine();
			writer.close();
			// System.out.println("string successfully writed into file");
		}

	}
	//*******driverIsoreadfinal function read content of driver repo from tmp_file and store it in a list *******	
	public List driverIsoReadFinal(String name) throws IOException {
		String str;

		List<String> lists = new ArrayList<String>();
		List<String> fl = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new FileReader("C:/Users/" + name + "/Desktop/tmp_file.txt"));
		while ((str = in.readLine()) != null) {
			str = str.replaceAll("Name Size Date Modified", "");
			str = str.split(" ")[0];
			str = str.replaceAll("Parent Directory", "");
		
			str = str.replaceAll(".DS_Store", "");
			str = str.replaceAll("Cisco/", "");

			// str = str.replaceAll("README.html", "");

			str = str.replaceAll("DRV-SOURCE-ADAP/", "");
			lists.add(str);
			lists.remove("");
		}
		String[] st = lists.toArray(new String[0]);
		for (int k = 0; k < st.length; k++) {
			// System.out.println("latest st[" + k + "]" + st[k]);

			fl.add(st[k]);

		}
		return lists;

	} */
	public void listdriverIsoelements(WebDriver driver, String name) throws IOException {

		List<String> li = new ArrayList<String>();
		List<String> lis = new ArrayList<String>();
	//	List<WebElement> list = driver.findElements(By.xpath("/html/body/table"));
		List<WebElement> list = driver.findElements(By.tagName("a"));
	//	List<WebElement> list = driver.findElements(By.xpath("/html/body/pre"));
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).getText());

			String rock = list.get(i).getText();
			File file = new File("C:/Users/" + name + "/Desktop/tmp_file.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("C:/Users/" + name + "/Desktop/tmp_file.txt", true));
			writer.write(rock);
			writer.newLine();
			writer.close();
			// System.out.println("string successfully writed into file");
		}

	}

	public List driverIsoReadFinal(String name) throws IOException {
		String str;

		List<String> lists = new ArrayList<String>();
		List<String> fl = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new FileReader("C:/Users/" + name + "/Desktop/tmp_file.txt"));
		while ((str = in.readLine()) != null) {
			str = str.replaceAll("Name Size Date Modified", "");
			str = str.split(" ")[0];
			str = str.replaceAll("Parent Directory", "");
			str = str.replaceAll(".DS_Store", "");

			// str = str.replaceAll("README.html", "");

			str = str.replaceAll("DRV-SOURCE-ADAP/", "");
			lists.add(str);
			lists.remove("");
		}
		String[] st = lists.toArray(new String[0]);
		for (int k = 0; k < st.length; k++) {
			// System.out.println("latest st[" + k + "]" + st[k]);

			fl.add(st[k]);

		}
		return lists;

	}


	public void clearTextfile(String file) throws FileNotFoundException {
		Scanner s = new Scanner(System.in);

		PrintWriter writer = new PrintWriter(file);
		writer.print("");
		writer.close();
	}
	
	public void clearAllTextFile(String name) throws FileNotFoundException{
		Scanner s = new Scanner(System.in);
		PrintWriter writer = new PrintWriter("C:/Users/" + name + "/Desktop/file1_network.txt");
		writer.println("");
		PrintWriter writer1 = new PrintWriter("C:/Users/" + name + "/Desktop/file1_storage.txt");
		writer1.println("");
		PrintWriter writer2 = new PrintWriter("C:/Users/" + name + "/Desktop/file2_network.txt");
		writer2.println("");
		PrintWriter writer3 = new PrintWriter("C:/Users/" + name + "/Desktop/file2_storage.txt");
		writer3.println("");
		PrintWriter writer4 = new PrintWriter("C:/Users/" + name + "/Desktop/file1_driverIso_network.txt");
		writer4.println("");
		PrintWriter writer5 = new PrintWriter("C:/Users/" + name + "/Desktop/file1_driverIso_Storage.txt");
		writer5.println("");
		PrintWriter writer6 = new PrintWriter("C:/Users/"+name+"/Desktop/Discrepency_storage.txt");
		writer6.println("");
		PrintWriter writer7 = new PrintWriter("C:/Users/"+name+"/Desktop/Discrepency_storage.txt");
		writer7.println("");
		System.out.println("Files are Cleared Successfully");
	}
	//******getDriver return instance of driver	
	public WebDriver getDriver(String name) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\"+name+"\\Desktop\\chromedriver.exe");
		String downloadFilepath = "C:/Users/"+name+"/Downloads/vmware";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 1);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		WebDriver driver = new ChromeDriver(cap);
		return driver;

	}
	
	public String getCecId() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your CECID");
		String name = s.nextLine();
		return name;
	}
	//******createfile is to write content of Vds in file1_network and file1_storage******* 
	public void createFile(String text, String protocol, String name) throws IOException {
		if (protocol.equals("Network/")) {
			System.out.println("Inside file create");
			System.out.println("protocol is " + protocol);
			try {
				File file = new File("C:/Users/" + name + "/Desktop/file1_network.txt");
				if (!file.exists()) {
					file.createNewFile();
				}

				BufferedWriter writer = new BufferedWriter(
						new FileWriter("C:/Users/" + name + "/Desktop/file1_network.txt", true));
				writer.write(text);
				writer.newLine();
				writer.newLine();
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (protocol.equals("Storage/")) {
			try {
				File file = new File("C:/Users/" + name + "/Desktop/file1_storage.txt");
				if (!file.exists()) {
					file.createNewFile();
				}

				BufferedWriter writer = new BufferedWriter(
						new FileWriter("C:/Users/" + name + "/Desktop/file1_storage.txt", true));
				writer.write(text);
				writer.newLine();
				writer.newLine();
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (protocol.equals("Video/")) {
			try {
				File file = new File("C:/Users/" + name + "/Desktop/file1_storage.txt");
				if (!file.exists()) {
					file.createNewFile();
				}

				BufferedWriter writer = new BufferedWriter(
						new FileWriter("C:/Users/" + name + "/Desktop/file1_storage.txt", true));
				writer.write(text);
				writer.newLine();
				writer.newLine();
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//******createfile2 is to write content of Vds in file2_network and file2_storage*******
	public void createFile2(String text, String protocol, String name) throws IOException {
		if (protocol.equals("Network/")) {
			System.out.println("Inside file create");
			System.out.println("protocol is " + protocol);
			try {
				File file = new File("C:/Users/" + name + "/Desktop/file2_network.txt");
				if (!file.exists()) {
					file.createNewFile();
				}

				BufferedWriter writer = new BufferedWriter(
						new FileWriter("C:/Users/" + name + "/Desktop/file2_network.txt", true));
				writer.write(text);
				writer.newLine();
				writer.newLine();
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (protocol.equals("Storage/")) {
			try {
				File file = new File("C:/Users/" + name + "/Desktop/file2_storage.txt");
				if (!file.exists()) {
					file.createNewFile();
				}

				BufferedWriter writer = new BufferedWriter(
						new FileWriter("C:/Users/" + name + "/Desktop/file2_storage.txt", true));
				writer.write(text);
				writer.newLine();
				writer.newLine();
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (protocol.equals("Video/")) {
			try {
				File file = new File("C:/Users/" + name + "/Desktop/file2_storage.txt");
				if (!file.exists()) {
					file.createNewFile();
				}

				BufferedWriter writer = new BufferedWriter(
						new FileWriter("C:/Users/" + name + "/Desktop/file2_storage.txt", true));
				writer.write(text);
				writer.newLine();
				writer.newLine();
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//***navigate class clicks Readme.html and redirects into vmware website and calls vmware copy for download and copy the drivers***** 	
	public String navigate(WebDriver driver,String cec) throws InterruptedException, IOException {
		FunctionsExecute execute = new FunctionsExecute();
		VmwareCopy copy=new VmwareCopy();
		int i = 0;
		int r=1;
		String version = null;
		String handle = null;
		driver.findElement(By.linkText("README.html")).click();
		Thread.sleep(5000);
		 version = driver.getCurrentUrl(); 
		List<WebElement> list = driver.findElements(By.tagName("a"));
		int size = list.size();
		System.out.println("size is "+size);
	//	if(size==0){
	//		driver.findElement(By.xpath("/html/body/h3")).getText();
	//	}
		for(int h=0;h<list.size();h++){
			System.out.println("inside for in tag a loop");
		handle = driver.getWindowHandle();
		
		
			String name = list.get(h).getText();
			if((size>1)&&(name.equals("location"))){
				System.out.println("inside size gretaer if");
				List<WebElement> list1 = driver.findElements(By.tagName("p"));
				int size1 = list1.size();
				System.out.println("tag p size is"+size1);
				//String tmp = list.get(1).getText();
				//System.out.println(list.get(1).getText());
				for(int j=1;j< list1.size();j++)
				{
					System.out.println("j is "+j);
					System.out.println("inside for in tag p loop");
					if(list1.get(j).getText().contains("location"))
						Thread.sleep(2000);
					{
						System.out.println("inside xpath if");
						String xp = "/html/body/p["+j+"]/a";			
						try{
								driver.findElement(By.xpath(xp)).click();
								System.out.println(xp);	
								Thread.sleep(10000);
						}
						catch(Exception e){continue;}
						if (i == 0) {
							for (String winHandle : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle);
							} 
							// System.out.println(driver.getCurrentUrl());
							String ur = driver.getCurrentUrl();
							System.out.println(driver.getCurrentUrl());
							if (ur.contains("vmware/login?contextType=external&username=string&OverrideRetryLimit=1&action=%2F&password=sercure_string")) {
								driver.findElement(By.id("username")).sendKeys("mr.y.prashanth@gmail.com");
								driver.findElement(By.id("password")).sendKeys("Prashanth@123");
								driver.findElement(By.id("button-login")).click();
								System.out.println("login button was pressed");
								Thread.sleep(10000);
							}
							Thread.sleep(5000);
							copy.copyDrivers(driver, version,handle,cec);
						/*	version = driver.findElement(By.xpath("//*[@id='portlet_TagDescriptionPortlet_WAR_itdownloadsportlet']/div/div/div/section/div/table/tbody/tr[1]/td")).getText();
							System.out.println("Version :" + version);*/
							driver.switchTo().window(handle);
						}
					
					}
				}
			}
			
			else{
				System.out.println("inside else of a tag for loop");
				try {
			driver.findElement(By.linkText(name)).click();
			}catch (Exception e) {
				i = 1;
				driver.findElement(By.xpath("/html/body/h3")).getText();
				System.out.println(version);			
				driver.navigate().back();
		} 
		
			
			// driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
//		}
		// System.out.println(driver.getCurrentUrl());
			if (i == 0) {
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			} 
			// System.out.println(driver.getCurrentUrl());
			String ur = driver.getCurrentUrl();
			System.out.println(driver.getCurrentUrl());
			if (ur.contains("vmware/login?contextType=external&username=string&OverrideRetryLimit=1&action=%2F&password=sercure_string")) {
				driver.findElement(By.id("username")).sendKeys("mr.y.prashanth@gmail.com");
				driver.findElement(By.id("password")).sendKeys("Prashanth@123");
				driver.findElement(By.id("button-login")).click();
				System.out.println("login button was pressed");
				Thread.sleep(10000);
			}
			Thread.sleep(5000);
			copy.copyDrivers(driver, version,handle,cec);
		/*	version = driver.findElement(By.xpath("//*[@id='portlet_TagDescriptionPortlet_WAR_itdownloadsportlet']/div/div/div/section/div/table/tbody/tr[1]/td")).getText();
			System.out.println("Version :" + version);*/
			driver.switchTo().window(handle);
		} 
			}
			// System.out.println(driver.getCurrentUrl());
			
			// System.out.println(driver.getCurrentUrl());
		}
		
		driver.navigate().back();
		// driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
		// System.out.println(driver.getCurrentUrl());
		return version;
	}
	
//****To download drivers for iscsi folders in some adapters navigate iscsi will be called********************	
	public String  navigateiscsi(WebDriver driver,String cec) throws InterruptedException, IOException{
		FunctionsExecute execute = new FunctionsExecute();
		
		driver.findElement(By.linkText("iSCSI/")).click();
		
		String version =  execute.navigate(driver,cec);
	//	String version1 = "iscsi version is "+version;
	//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
	//	driver.findElement(By.xpath("//*[@id=\"tbody\"]/tr[1]/td[1]/a")).click();
		driver.navigate().back();
		return version;
	}
	//******createdriverfile is to write content of driverrepo in file2_network and file2_storage*******	
	public void CreateDriverFile(String text, String protocol, String name) {
		if (protocol.equals("Network/")) {
			System.out.println("Inside file create");
			System.out.println("protocol is " + protocol);
			try {
				File file = new File("C:/Users/" + name + "/Desktop/file1_driverIso_network.txt");
				if (!file.exists()) {
					file.createNewFile();
				}

				BufferedWriter writer = new BufferedWriter(
						new FileWriter("C:/Users/" + name + "/Desktop/file1_driverIso_network.txt", true));
				writer.write(text);
				writer.newLine();
				writer.newLine();
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (protocol.equals("Storage/")) {
			try {
				File file = new File("C:/Users/" + name + "/Desktop/file1_driverIso_Storage.txt");
				if (!file.exists()) {
					file.createNewFile();
				}

				BufferedWriter writer = new BufferedWriter(
						new FileWriter("C:/Users/" + name + "/Desktop/file1_driverIso_Storage.txt", true));
				writer.write(text);
				writer.newLine();
				writer.newLine();
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
