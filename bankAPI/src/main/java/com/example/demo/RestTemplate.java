package com.example.demo;

public class RestTemplate {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
	    String url = "https://kengp3.github.io/blog/coindesk.json";
	    try {
	        String result = restTemplate.getForObject(url, String.class);
	        System.out.println("✅ 成功取得資料：" + result);
	    } catch (Exception e) {
	        System.out.println("❌ 無法取得資料：" + e.getMessage());
	        e.printStackTrace();
	    }
	}

	private String getForObject(String url, Class<String> class1) {
		// TODO Auto-generated method stub
		return null;
	}

}
