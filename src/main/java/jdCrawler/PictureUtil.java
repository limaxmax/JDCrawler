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
 * @author limaxmax 图片的工具类
 */
public class PictureUtil {
	/**
	 * 该方法是根据参数截取图片，并保存至本地，返回文件路径
	 * 
	 * @param x
	 *            图片左上顶点的x坐标
	 * @param y
	 *            图片左上顶点的y坐标
	 * @param length
	 *            图片的长度
	 * @param width
	 *            图片的宽度
	 * @return 图片的保存地址
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

	// 页面元素截图
	public static File captureElement(WebDriver driver,WebElement element) throws Exception {
		
		//WrapsDriver wrapsDriver = (WrapsDriver) element;
		// 截图整个页面
		//File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
		OutputStream os=new FileOutputStream("d:\\jdCrawler\\a.png");
		File screen=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,os);
		//FileUtils.copyFile(screen,new File("d:\\jdCrawler\\a.png"));
		BufferedImage img = ImageIO.read(screen);
		// 获得元素的高度和宽度
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		// 创建一个矩形使用上面的高度，和宽度
		Rectangle rect = new Rectangle(width, height);
		// 得到元素的坐标
		Point p = element.getLocation();
		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
		// 存为png格式
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
