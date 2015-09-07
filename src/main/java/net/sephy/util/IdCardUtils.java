package net.sephy.util;

/**
 * @author Sephy
 * @since: 2015-09-07
 */
public abstract class IdCardUtils {

    /**
     * 检测是否为身份证号码，目前检测规则如下：
     * 1.长度是否为15或18位
     * 2.是否为纯数字
     * @param number
     * @return
     */
	public static final boolean isIdCardNumber(final String number) {
		if (number == null) {
			return false;
		}

		int len = number.length();
		if (len != 15 && len != 18) { // 长度验证
			return false;
		}

		char[] chars = number.toCharArray(); // 数字检测
		for (char c : chars) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		return true;
	}
}
