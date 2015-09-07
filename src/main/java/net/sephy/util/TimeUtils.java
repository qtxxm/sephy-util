package net.sephy.util;

/**
 * @author Sephy
 * @since: 2015-09-02
 */
public abstract class TimeUtils {

    /**
     * 获取unix格式时间搓，精确到秒
     * @return
     */
	public static final int unixTime() {
		return (int) (System.currentTimeMillis() / 1000);
	}
}
