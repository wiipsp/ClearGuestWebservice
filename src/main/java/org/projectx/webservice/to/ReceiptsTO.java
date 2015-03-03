package org.projectx.webservice.to;

public class ReceiptsTO extends BaseTO {

	private static final long serialVersionUID = 6220921354936621713L;
	private String receiptsId;
	private String productId;
	private String userId;
	private float  receiptsPrice;
	private float  originalPrice;
	public String getReceiptsId() {
		return receiptsId;
	}
	public void setReceiptsId(String receiptsId) {
		this.receiptsId = receiptsId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public float getReceiptsPrice() {
		return receiptsPrice;
	}
	public void setReceiptsPrice(float receiptsPrice) {
		this.receiptsPrice = receiptsPrice;
	}
	public float getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	
}
