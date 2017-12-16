package com.java.vmware;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//****This class navigate to the vmware folders in driverRepo and check the ReadMe file and redirect to Navigate Driver in Function Execute folder*******
public class DriverIsoAll {
	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner s = new Scanner(System.in);
		//file:/10.126.141.46/DriverFirmwareInventory/Driver_ISO_Extracted/FPMR2/ucs-cxxx-drivers-combo.3.0.3.21/Drivers/
		DriverIsoAll all = new DriverIsoAll();
		System.out.println("Enter the Url");
		String url = s.nextLine();
		System.out.println("Enter your CEC ID");
		String name = s.nextLine();
		all.getDriverIsoOutput(url,name);
	}

	public String getDriverIsoOutput(String drurl, String name) throws InterruptedException, IOException {
		FunctionsExecute execute = new FunctionsExecute();
		String version;
		String handle;

		VmwareCopy copy = new VmwareCopy();
		Scanner s = new Scanner(System.in);
		String[] os = { "VMware/" };
		String[] protocol = { "Network/", "Storage/" };
	//	String[] protocol = { "Storage/" };
		
		// String drurl = s.nextLine();
		// drurl = drurl.replace("\\", "/");

		System.out.println(drurl);
		WebDriver driver = execute.getDriver(name);
		driver.get(drurl);
		Thread.sleep(2000);
		// driver.get("file:/10.126.141.46/DriverFirmwareInventory/Driver_ISO_Extracted/EPMR12/ucs-cxxx-drivers-combo.2.0.13.20/Drivers/");
		// System.out.println("Enter ur CecId");
		// String name = s.nextLine();
		// String name = execute.getCecId();
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file1_driverIso_network.txt");
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file1_driverIso_Storage.txt");
		for (int i = 0; i < os.length; i++) {
			driver.findElement(By.linkText(os[i])).click();
			System.out.println("protocol length is" + protocol.length);
			for (int j = 0; j < protocol.length; j++) {
				String pro = protocol[j];
				driver.findElement(By.linkText(protocol[j])).click();
				execute.listdriverIsoelements(driver, name);
				List<String> adap = execute.driverIsoReadFinal(name);
				execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
				for (int k = 1; k < adap.size(); k++) {
					System.out.println("in main" + adap.get(k));
					
					driver.findElement(By.linkText(adap.get(k))).click();
				//	driver.findElement(By.linkText("PMC-Sierra/")).click();
					

					execute.listdriverIsoelements(driver, name);
					List<String> indadap = execute.driverIsoReadFinal(name);

					execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
					for (int l = 1; l < indadap.size(); l++) {
						if (adap.get(k).equals("FusionIO/")) {
							System.out.println("inside fio");
							indadap.remove("README.html");

						}
					
						
						
						driver.findElement(By.linkText(indadap.get(l))).click();
					//	driver.findElement(By.linkText("12GSAS-HBA/")).click();
						execute.listdriverIsoelements(driver, name);
						List<String> otheros = execute.driverIsoReadFinal(name);
						execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");

						String ur = driver.getCurrentUrl();
						// execute.CreateDriverFile(ur, pro, name);

						if (os[i] != "Linux/") {
							for (int mn = 1; mn < otheros.size(); mn++) {
								String vmos = otheros.get(mn);
								// execute.CreateDriverFile(vmos, pro, name);

							}
						}

						for (int m = 1; m < otheros.size(); m++) {
							String otos = otheros.get(m);
							
							if(otheros.get(m).equals("Readme.html")){
								System.out.println("inside readme...");
								driver.findElement(By.linkText(otheros.get(m))).click();
								driver.navigate().back();
							}
							else{
							driver.findElement(By.linkText(otheros.get(m))).click();
							System.out.println("otheros get of m is" + otheros.get(m));
							execute.listdriverIsoelements(driver, name);
							List<String> otheroscontent = execute.driverIsoReadFinal(name);
							execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
							String othercontenturl = driver.getCurrentUrl();
							// execute.CreateDriverFile(othercontenturl, pro,
							// name);
							// String cont = otheroscontent.get(othlinos);
							for (int t = 0; t < otheroscontent.size(); t++) {
								System.out.println(otheroscontent.get(t));
							}
							for (int n = 1; n < otheroscontent.size(); n++) {	
								System.out.println("content is" + otheroscontent.get(n));
								if (otheroscontent.get(n).equals("iSCSI/")) {
									System.out.println("inside if oscont");
									String title = "Iscsi version is :";
									// execute.createFile(title, pro, name);
									 version = execute.navigateiscsi(driver,name);
									// copy.copyDrivers(driver, version);
									// execute.createFile(version, pro, name);
								} else {
									System.out.println("inside else of navigate driver");
									 version = execute.navigate(driver,name);

									// System.out.println("version is"+version);
									// copy.copyDrivers(driver, version);
									// execute.createFile(version, pro, name);
								}
								// execute.CreateDriverFile(cont, pro, name);

							}
							// zero.clearTextfile("C:/Users/pyogaraj/Desktop/rohit.txt");
						//	driver.findElement(By.xpath("//*[@id=\"tbody\"]/tr[1]/td[1]/a")).click();
							driver.navigate().back();
						}
						} // indos for
							// zero.clearTextfile("C:/Users/pyogaraj/Desktop/rohit.txt");
					//	driver.findElement(By.xpath("//*[@id=\"tbody\"]/tr[1]/td[1]/a")).click();
						driver.navigate().back();
					} // indadap for
						// zero.clearTextfile("C:/Users/pyogaraj/Desktop/rohit.txt");
				//	driver.findElement(By.xpath("//*[@id=\"tbody\"]/tr[1]/td[1]/a")).click();
					driver.navigate().back();

				} // adap for
					// zero.clearTextfile("C:/Users/pyogaraj/Desktop/rohit.txt");
			//	driver.findElement(By.xpath("//*[@id=\"tbody\"]/tr[1]/td[1]/a")).click();
				driver.navigate().back();
			} // protocol for end
		//	driver.findElement(By.xpath("//*[@id=\"tbody\"]/tr[1]/td[1]/a")).click();
			driver.navigate().back();
		} // os for end
		return name;

	}

}
