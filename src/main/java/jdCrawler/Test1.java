package jdCrawler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class Test1 {
	
	
	@Test
	public void test1(){
		List<Good> neicuntiao=new ArrayList<Good>();
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.jd.com");
		driver.manage().window().maximize();
		String jdMainPageHandle=driver.getWindowHandle();
		WebElement searchInput = driver.findElement(By.id("key"));
		WebElement searchButton = driver.findElement(By.xpath("//*[@id='search']/div/div[2]/button"));
		searchInput.sendKeys("��ʿ��");
		searchButton.click();
		//����ȴ�ʱ��
		WebDriverWait waiter=new WebDriverWait(driver,10);
		waiter.until(ExpectedConditions.presenceOfElementLocated(By.linkText("�������")));
		driver.findElement(By.linkText("�������")).click();
		
		//��ת���µ�ҳ��window
		Set<String> windowHandles=driver.getWindowHandles();
		for(String windowHandle:windowHandles){
			if(windowHandle.equals(jdMainPageHandle)){
				
			}else {
				driver.switchTo().window(windowHandle);
			}
			System.out.println(windowHandle.toString());
		}
		WebElement searchInputStore = driver.findElement(By.id("key01"));
		System.out.println(searchInputStore.getSize().height+"    "+searchInputStore.getSize().width);
		System.out.println(searchInputStore.getLocation());
		
		WebElement searchButtonStore=driver.findElement(By.xpath("//*[@id='search-2013']/div[1]/div/input[3]"));
		searchInputStore.sendKeys("��������");
		searchButtonStore.click();
		
		waiter.until(ExpectedConditions.presenceOfElementLocated(By.className("jTotal")));
		//ҳ���ϵļ۸��������صģ������ϵ���Ʒ�ǣ�������ʾ
		Actions loadAll = new Actions(driver);
		loadAll.sendKeys(Keys.END).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadAll.sendKeys(Keys.HOME).perform();
		//ִ����һ�������ʱ��û�б������Ǿ����Ҳ���
		//WebElement goodsUl=driver.findElement(By.className("jCurrent"));
		WebElement goodsUl=driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div/div/div/div/div[2]/div[1]/div[3]/div[2]/ul"));
		List<WebElement> goodLis=goodsUl.findElements(By.className("jSubObject"));
		int picID=0;
		for(WebElement goodLi:goodLis){
			picID++;
			String picPath="d:\\jdCrawler\\"+picID+".png";
//			try {
//				FileUtils.copyFile(PictureUtil.captureElement(driver,goodLi), new File(picPath));  
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    WebElement goodPrice=goodLi.findElement(By.className("jPrice"));
		    //��������Ʒ������span����һ��span�ǵ�λ���ڶ��������֣�����д��
		    List<WebElement> priceSpans=goodPrice.findElements(By.tagName("span"));
		   
		    Good goodItem=new Good();
		    goodItem.setPrice(priceSpans.get(0).getText()+priceSpans.get(1).getText());
		    goodItem.setCommentsCount(goodLi.findElement(By.className("jCommentNum")).getText());
		    goodItem.setDescription(goodLi.findElement(By.className("jDesc")).getText());
		   // goodItem.setPictureFilePath(picPath);
		    
		    System.out.println(goodItem);
		    
		}	
	}
}
