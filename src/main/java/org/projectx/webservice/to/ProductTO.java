package org.projectx.webservice.to;

public class ProductTO extends BaseTO {

	private static final long serialVersionUID = 2899749753900032119L;
	private String productId;
	private String promotionId;
	private String productCnName;
	private String productEnName;
	private float  productPrice;
	private String productType;
	private String isAllowed;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}
	public String getProductCnName() {
		return productCnName;
	}
	public void setProductCnName(String productCnName) {
		this.productCnName = productCnName;
	}
	public String getProductEnName() {
		return productEnName;
	}
	public void setProductEnName(String productEnName) {
		this.productEnName = productEnName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getIsAllowed() {
		return isAllowed;
	}
	public void setIsAllowed(String isAllowed) {
		this.isAllowed = isAllowed;
	}
	
	
}
