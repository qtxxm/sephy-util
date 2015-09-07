package net.sephy.util;

import java.util.regex.Pattern;

/**
 * @author Sephy
 * @since: 2015-09-07
 */
public abstract class EmailUtils {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");

    /**
     * 判断是否是一个电子邮件地址
     * @param email
     * @return
     */
    public static final boolean isEmail(final String email) {
        if (email == null) {
            return false;
        }

        return EMAIL_PATTERN.matcher(email).matches();
    }
}
