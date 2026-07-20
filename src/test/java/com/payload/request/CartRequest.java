package com.payload.request;

public class CartRequest {
	
	private int productId;
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductId()
	{
		return productId;
		
	}
	
	public void setProductId(int productId)
	{
		this.productId=productId;
	}

}
