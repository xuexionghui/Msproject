package com.junlaninfo.pay;

/**
 * ֧��
 * @author Administrator
 *
 */
public interface Ordertopay {
	
	/**
	 * 
	 * 支付接口
	 */
	public int paywithorder(String tradeserialnumber, int payamount);
	
	/**
	 * �˿�
	 * @param tradeserialnumber
	 * @param payamount
	 * @return 1 ����֧���ɹ� 2������֧��ʧ��
	 */
	public int refundwithorder(String tradeserialnumber, int payamount);
}
