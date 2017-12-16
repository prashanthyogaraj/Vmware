package com.java.vmware;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;


//********Vmware Copy class download the driver and store it in a folder named vmware in local machine******
public class VmwareCopy {

	public void copyDrivers(WebDriver driver, String url, String handle,String name) throws InterruptedException, IOException {
		VmwareCopy copy = new VmwareCopy();
		int a = 0;
		System.out.println("inside copy drivers");
		String slash;
	//	String name = "pyogaraj";
		String id = "C:/Users/" + name + "/Desktop/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", id);
		System.setProperty("webdriver.chrome.driver", "C://Users/"+name+"/Desktop/chromedriver.exe");

		String ur = driver.getCurrentUrl();
		if (ur.contains("https://my.vmware.com/web/")) {
			List<WebElement> list = driver.findElements(By.className("downloadCol"));
			try {
				list.get(0).click();
			} catch (Exception e) {
				a = 1;
				System.out.println("no download button found");
				// driver.switchTo().window(handle);
			}
		}
		String ur1 = driver.getCurrentUrl();
		int i = 0;
		if (a != 1) {
			if (ur1.contains("https://my.vmware.com/web/vmware/login?bmctx=4C976C546DE4E8BA7BD58B8EEADF25A5B418821E70E4480C483939EC36F11A86&contextType=external&username=string")) {
				i = 1;
				System.out.println("inside username nd passwd");
				driver.findElement(By.id("username")).sendKeys("mr.y.prashanth@gmail.com");
				driver.findElement(By.id("password")).sendKeys("Prashanth@123");
				driver.findElement(By.id("button-login")).click();
				System.out.println("login button was pressed");
				Thread.sleep(10000);
			}
		}
		System.out.println("i value is" + i);
		ur = driver.getCurrentUrl();
		if (a != 1) {
			if (ur.contains("https://my.vmware.com/group/vmware/details?downloadGroup") && (i != 1)) {
				System.out.println("x is inside seconf iff");
				List<WebElement> list = driver.findElements(By.className("md"));
				try {
					list.get(0).click();
				} catch (Exception e) {
					System.out.println("no download button found");
					// driver.navigate().back();

				}

				System.out.println("Download now clicked");
			}
		}
		if (a != 1) {
			File f = new File("C://Users/"+name+"/Downloads/vmware/");
			if(!f.exists()){
				f.mkdir();
			}
		//	String file = url.replaceAll("file:", "");
			String file = url.replaceAll("http:", "");
			System.out.println("the value of url inside url change is" + url);
			System.out.println(file);
			String newUrl = file.replaceAll("10.126.141.53", "");
		//	String readme = newUrl.replaceAll("README.html", "");
			String finalUrl = newUrl.replaceAll("README.html", "");
			// slash=readme.replace("\\","/");
		//	String finalUrl = readme.replaceAll("DriverFirmware Inventory", "DriverFirmwareInventory");
			System.out.println(finalUrl);
			System.out.println("The value of finalURl is" + finalUrl);
			Thread.sleep(40000);
			copy.secureCopy(finalUrl,name);
			Thread.sleep(10000);
			
			
			if (f.exists()) {
				File[] list1 = f.listFiles();
				for (int j = 0; j < list1.length; j++) {
					System.out.println("The content of list is " + list1[j].getName());
					list1[j].delete();
					System.out.println(list1[j].getName() + "is deleted Successfully");
				}
			}
		}
	}

//Secure Copy copies the driver from local system to Driver Repo	
	public void secureCopy(String copyTo,String name) {
		System.out.println("code is executing securecopy");
		System.out.println(System.getProperty("os.name"));
		String hostname = "10.126.141.53";
		String username = "root";
		String password = "Nbv12345";
		String copyFrom = "C://Users/"+name+"/Downloads/vmware/*";
		// String copyTo =
		// "/DriverFirmwareInventory/Driver_ISO_Extracted/EPMR12/ucs-cxxx-drivers-combo.2.0.13.20/Drivers/VMware/Network/Intel/I350/ESXi_5.5U3";
		JSch jsch = new JSch();
		Session session = null;
		System.out.println("Trying to connect.....");
		try {

			session = jsch.getSession(username, hostname, 22);
			session.setConfig("StrictHostKeyChecking", "no");
			System.out.println("password passed is "+password);	
			session.setPassword(password);
			session.connect();
			Channel channel = session.openChannel("sftp");

			channel.connect();
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			System.out.println("The URL of COPY TO is" + copyTo);
			sftpChannel.put(copyFrom, copyTo);
			// sftpChannel.get(copyFrom, copyTo);
			sftpChannel.exit();
			session.disconnect();
		} catch (JSchException e) {
			e.printStackTrace();
		} catch (SftpException e) {
			e.printStackTrace();
		}
		System.out.println("Done !!");
	}
}