/**
 * Created by heathcliff on 11/3/16.
 */
public class Code39
{
    private static String ereaseChar(String src)
    {
        for (int i = 0; i < src.length(); ++i)
        {
            char c = src.charAt(i);
            if (!(     (c >= 'A' && c <= 'Z')
                    || (c >= '0' && c <= '9')
                    || c == ' '
                    || c == '-'
                    || c == '$'
                    || c == '%'
                    || c == '.'
                    || c == '/'
                    || c == '+'))
            {
                src = src.substring(0, i) + src.substring(i + 1);
                --i;
            }
        }
        return src;
    }

    private static String addStars(String src)
    {
        return '*' + src + '*';
    }

    private static String lastChar(String src)
    {
        String dict = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
        int res = 0;
        for (int i = 0; i < src.length(); ++i)
        {
            assert (dict.indexOf(src.charAt(i)) != -1);
            res += dict.indexOf(src.charAt(i));
        }
        return (src + dict.charAt(res%43));
    }

    public static String encoder(String src)
    {
        String code39 = src.toUpperCase();
        code39 = ereaseChar(code39);
        code39 = addStars(code39);

        return code39;
    }

    public static String encoder2(String src)
    {
        String code39 = src.toUpperCase();
        code39 = ereaseChar(code39);
        code39 = lastChar(code39);
        code39 = addStars(code39);

        return code39;
    }
}
