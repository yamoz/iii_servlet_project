package service;

public class statusCode {
	public static String statusCodeTrans( Integer statusCode ) {
		String statusStr = null;
		if ( statusCode == -1 ) {
			statusStr = "訂單已取消";
		} else {
			statusStr = "已訂購";
		}
		return statusStr;
	}
}
