package jdCrawler;

public class Good {
	private String pictureFilePath;
	private String price;
	private String commentsCount;
	private String description;
	public String getPictureFilePath() {
		return pictureFilePath;
	}
	public void setPictureFilePath(String pictureFilePath) {
		this.pictureFilePath = pictureFilePath;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCommentsCount() {
		return commentsCount;
	}
	public void setCommentsCount(String commentsCount) {
		this.commentsCount = commentsCount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Good [pictureFilePath=" + pictureFilePath + ", price=" + price + ", commentsCount=" + commentsCount
				+ ", description=" + description + "]";
	}
	
}
