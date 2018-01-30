package jdCrawler;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.WrapsDriver;

/**
 * 
 * @author limaxmax ͼƬ�Ĺ�����
 */
public class PictureUtil {
	/**
	 * �÷����Ǹ��ݲ�����ȡͼƬ�������������أ������ļ�·��
	 * 
	 * @param x
	 *            ͼƬ���϶����x����
	 * @param y
	 *            ͼƬ���϶����y����
	 * @param length
	 *            ͼƬ�ĳ���
	 * @param width
	 *            ͼƬ�Ŀ��
	 * @return ͼƬ�ı����ַ
	 */
	public String getPic(int x, int y, int length, int width) {
		return null;
	}

	public int[] getPicSize(WebElement webEle) {

		return null;
	}

	public List<int[]> getPicsSize(List<WebElement> webEles) {
		return null;

	}

	// ҳ��Ԫ�ؽ�ͼ
	public static File captureElement(WebDriver driver,WebElement element) throws Exception {
		
		//WrapsDriver wrapsDriver = (WrapsDriver) element;
		// ��ͼ����ҳ��
		//File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
		OutputStream os=new FileOutputStream("d:\\jdCrawler\\a.png");
		File screen=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,os);
		//FileUtils.copyFile(screen,new File("d:\\jdCrawler\\a.png"));
		BufferedImage img = ImageIO.read(screen);
		// ���Ԫ�صĸ߶ȺͿ��
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		// ����һ������ʹ������ĸ߶ȣ��Ϳ��
		Rectangle rect = new Rectangle(width, height);
		// �õ�Ԫ�ص�����
		Point p = element.getLocation();
		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
		// ��Ϊpng��ʽ
		ImageIO.write(dest, "png", screen);
		return screen;
	}
	@Test  
	    public void testCaptureElement(){ 
			System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

	        WebDriver driver=new ChromeDriver();  
	        driver.manage().window().maximize();  
	        driver.get("https://www.baidu.com");  
	        WebElement wb = driver.findElement(By.id("su"));  
	        try {  
	            FileUtils.copyFile(captureElement(driver,wb), new File("d:\\a.png"));  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        driver.quit();  
	    }
	
}
