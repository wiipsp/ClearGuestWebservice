package org.projectx.webservice.util;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class StringUtil {


    // Automatically generated variable: INT_39

    private static final int INT_39 = 39;

    // Automatically generated variable: INT_34

    private static final int INT_34 = 34;

    private static Vector<String> NON_KEY_WORDS = new Vector<String>(4);

    static {
        NON_KEY_WORDS.addElement("the");
        NON_KEY_WORDS.addElement("a");
        NON_KEY_WORDS.addElement("an");
        NON_KEY_WORDS.addElement("of");
    }

    /**
     * Utility class should not have public constructor.
     */
    private StringUtil () {
    }

    /**
     * Capitalizes a string, i.e. changing its first letter to uppercase.
     * 
     * @param str The String that needs to be capitalized.
     * @return The capitalized string.
     */
    public static String capitalize (String str) {
        if (str == null || str.length() == 0)
            return str;
        else
            return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * Fully capitalizes all words in a String, i.e. changing the first letter
     * of each and every word (except for non key words) in the string to
     * uppercase.
     * 
     * @param str The string to be fully capitalized.
     * @return The fully capitalized string.
     */
    public static String capitalizeAllWords (String str) {
        if (str == null || str.length() == 0)
            return str;

        StringTokenizer tokens = new StringTokenizer(str, " ");
        StringBuffer sb = new StringBuffer();
        String word;

        while (tokens.hasMoreTokens()) {
            word = tokens.nextToken();
            sb.append(' ');

            if (!NON_KEY_WORDS.contains(word)) {
                sb.append(word.substring(0, 1).toUpperCase());
                sb.append(word.substring(1));
            } else
                sb.append(word);
        }

        return sb.toString().substring(1);
    }

    /**
     * Combines the strings values in the string array into one single string,
     * delimited by the specified delimiter. An emtpy String is returned if the
     * given values array is of size 0.
     * 
     * @param values The strings to be combined.
     * @param delimiter The delimiter used to separate the different strings.
     * @return The resultant string combined from the string array separated by
     *         the specified delimiter. Return an emtpy String if the given
     *         values array is of size 0.
     */
    public static String combine (String[] values, String delimiter) {

        if (values == null) {
            throw new NullPointerException("values array is null");
        }

        if (values.length == 0) {
            return "";
        }

        StringBuffer result = new StringBuffer();

        for (int i = 1; i < values.length; i++) {
            result.append(delimiter);
            result.append(values[i]);
        }

        result.insert(0, values[0]);

        return result.toString();
    }

    /**
     * Removes redundant spaces (the second consecutive space onwards) from a
     * String.
     * 
     * @param str The String that needs to be compacted.
     * @return The String which has been compacted.
     */
    public static String compact (String str) {
        if (str == null || str.length() == 0)
            return str;

        int len = str.length();
        char[] buf = new char[len];
        StringBuffer sb = new StringBuffer();
        str.getChars(0, len, buf, 0);
        int i = 0;

        while (i < len) {
            if (buf[i] != ' ') /* Found the first space */
                sb.append(buf[i++]);
            else {
                sb.append(' ');
                while (i < len && buf[i] == ' ')
                    /* Skip the rest of the spaces */
                    i++;
            }
        }

        return sb.toString();
    }

    /**
     * If a string is null, return it as "".
     * 
     * @param str The String that needs to be checked for null value.
     * @return The String that is converted to appropriate string value.
     */
    public static String deNull (String str) {
        if (str == null)
            return "";
        return str;
    }

    /**
     * To return a string which is filled with a specified string. e.g.
     * duplicate("*", 5) returns "*****", duplicate("OK", 3) returns "OKOKOK"
     * repeated for given number of times
     * 
     * @param str String to be repeated/duplicated
     * @param times Number of time the string to be repeated/duplicated
     * @return The resulted string with <code>str</code> repeated the specified
     *         number of times.
     */
    public static String duplicate (String str, int times) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < times; i++) {
            result.append(str);
        }
        return (result.toString());
    }

    /**
     * Get the count of occurrences of the character in the target string.
     * 
     * @param str The String used to check for the character occurrenct count.
     * @param ch The character to be counted in the string.
     * @return Number of occurrences of the character in the target string.
     */
    public static int getCount (String str, char ch) {
        int pos;
        int count = 0;

        do {
            pos = str.indexOf(ch);

            if (pos != -1) {
                count++;

                if (pos != str.length())
                    str = str.substring(pos + 1, str.length());
                else
                    pos = -1;
            }

        } while (pos != -1);

        return count;
    }

    /**
     * Checks if the length of the string is of the length specified.
     * 
     * @param str The string to test for the length.
     * @param len The length that the string should conform to.
     * @return A boolean value that indicates if the string is of the length
     *         specified.
     */
    public static boolean isLengthEqual (String str, int len) {
        if (str == null) {
            return false;
        } // if (str == null)

        return (str.length() == len) ? true : false;
    }

    /**
     * Tests whether the specified string's length is less than or equal to the
     * specified length.
     * 
     * @param str The string to test for the length.
     * @param len The length that the string should conform to.
     * @return A boolean value that indicates if the string is at most the
     *         length specified.
     */
    public static boolean isLengthLessThan (String str, int len) {
        if (str == null) {
            return false;
        } // if (str == null)

        return (str.length() <= len) ? true : false;
    }

    /**
     * Returns true if the data is null or empty string.
     * 
     * @param data data
     * @return boolean
     */
    public static boolean isNullOrEmpty (String data) {
        return data == null || data.trim().length() == 0;
    }

    /**
     * Returns true if the data is null or empty string array (length == 0).
     * 
     * @param data data
     * @return boolean
     */
    public static boolean isNullOrEmpty (String[] data) {
        return data == null || data.length == 0;
    }
    
    public static boolean isBlank(String data){
    	return data.trim().length() == 0;
    }

    /**
     * Returns true if the data is null or blank string (with only whitespaces).
     * 
     * @param data data
     * @return boolean
     */
    public static boolean isNullOrBlank (String data) {
        return data == null || isBlank(data);
    }

    /**
     * Returns true if the data equals to data2 or both are null.
     * 
     * @param data1 data1
     * @param data2 data2
     * @return boolean
     */
    public static boolean isEqual (String data1, String data2) {
        if (data1 == null && data2 == null)
            return true;
        else if (data1 != null)
            return data1.equals(data2);
        else
            return data2.equals(data1);
    }

    /**
     * Returns true if the data equals to data2 or both are null.
     * 
     * @param data1 data1
     * @param data2 data2
     * @return boolean
     */
    public static boolean isEqualTrim (String data1, String data2) {
        data1 = data1 == null ? data1 : data1.trim();
        data2 = data2 == null ? data2 : data2.trim();
        return isEqual(data1, data2);

    }

    /**
     * Returns true if the data equals to data2.
     * 
     * @param data1 data1
     * @param data2 data2
     * @return boolean
     */
    public static boolean isEqualNotNull (String data1, String data2) {
        if (data1 == null || data1.length() == 0 || data2 == null
                || data2.length() == 0)
            return false;
        else
            return data2.equals(data1);
    }

    /**
     * Returns true if the data equals to data2.
     * 
     * @param data1 data1
     * @param data2 data2
     * @return boolean
     */
    public static boolean isBiggerThanZero (int data1, int data2) {
        return data1 > 0 || data2 > 0;

    }

    /**
     * add left space for input string.
     * 
     * @param data data
     * @return formatted string.
     */
    public static String padZeroFront (String data) {
        if (data.length() < 2) {
            data = "0" + data;
        }
        return data;
    }

    /**
     * Returns true if the data equals int 0.
     * 
     * @param data1 data1
     * @param data2 data2
     * @return boolean
     */
    public static boolean isEqualZero (int data1, int data2) {

        return data1 == 0 && data2 == 0;
    }

    /**
     * Returns true if the data equals to data2 or both are null.
     * 
     * @param data1 data1
     * @param data2 data2
     * @return boolean
     */
    public static boolean isEqualIgnoreCase (String data1, String data2) {
        if (data1 == null && data2 == null)
            return true;
        else if (data1 != null)
            return data1.equalsIgnoreCase(data2);
        else
            return data2.equalsIgnoreCase(data1);
    }

    /**
     * To pad the given string with a user specified character on the left up to
     * the given length. e.g. lPad("ABCD", 10, 'X') returns "XXXXXXABCD" which
     * has a length of 10. This method has built-in 'intelligence' to handle
     * cases where calling method If <I>str</I> already longer than
     * <I>length</I>, return <I>str</I> itself. tries to be funny and supply the
     * following : - lPad("abc", 10, "123") it will return, "1231231abc"
     * 
     * @param str String to be padded
     * @param length he required length of the resulted string.
     * @param padString The required padding string
     * @return The padded string
     */
    public static String lPad (String str, int length, String padString) {
        int lOriginal = str.length();
        int lPadStr = padString.length();
        int times2Pad = 0;
        int lPadded = 0;

        if (lOriginal >= length)
            return str;

        StringBuffer sb = new StringBuffer();
        String padded;

        times2Pad = (length - lOriginal) / lPadStr; // will give (1) if 3/2

        padded = duplicate(padString, times2Pad);
        lPadded = padded.length();
        sb.append(padded); // pad in the repetitive characters

        // if still insufficient by the modulus e.g. 30/20 is 10
        if (lOriginal + lPadded < length) {
            int more = length - (lOriginal + lPadded);

            // add in the difference which is less entire length of padStr
            sb.append(padString.substring(0, more));
        }

        sb.append(str); // pad the original string behind

        return sb.toString();
    }

    /**
     * Pads the string with prevailing spaces.
     * 
     * @param str String to be padded with spaces on the left.
     * @param len The number of spaces to pad to the left of the string.
     * @return The space-padded string.
     */
    public static String lPad (String str, int len) {
        return lPad(str, len, " ");
    }

    /**
     * Remove all occurrences of the match in the target string.
     * 
     * @param str The String to be checked and have the occurrences of the
     *            matching String removed.
     * @param match The matching string.
     * @return The resultant string with all matching string removed.
     */
    public static String removeAllMatch (String str, String match) {

        if (str == null || match == null || str.length() == 0
                || match.length() == 0) {
            return "";
        }

        StringBuffer newStr = new StringBuffer();

        int endpos = 0;
        for (int startpos = str.indexOf(match, endpos); startpos != -1; startpos = str
                .indexOf(match, endpos)) {
            newStr.append(str.substring(endpos, startpos));
            endpos = startpos + match.length();
        }

        newStr.append(str.substring(endpos));

        return newStr.toString();
    }

    /**
     * Replace the occurrence of a key within the existing string with the
     * required value.
     * 
     * @param str Existing String to be replace
     * @param key Key within the String to be searched and replaced
     * @param replacement The replaced value
     * @return The resulted string
     */
    public static String replaceAll (String str, String key, String replacement) {

        // Split the string with the key as the delimiter
        StringBuffer sb = new StringBuffer();
        if (!isNullOrBlank(str)) {
            String[] parts = StringUtil.split(str, key);
            sb.append(parts[0]);
            for (int i = 1; i < parts.length; i++) {
                sb.append(replacement + parts[i]);
            }
        }
        return sb.toString();
    }

    /**
     * Replaces the first substring of this string that matches the given key
     * with the given replacement.
     * 
     * @param str The String to be replaced
     * @param key Key within the String to be searched and replaced
     * @param replacement The String used to replace
     * @return The String with the first occurence of the key value replaced.
     */
    public static String replaceFirst (String str, String key,
            String replacement) {
        StringBuffer result = new StringBuffer(str);

        int pos = str.indexOf(key);

        if (pos >= 0) {
            result.replace(pos, pos + key.length(), replacement);
            // System.out.println( "result = " + result );
        }
        return result.toString();
    }

    /**
     * Replaces the last substring of this string that matches the given key
     * with the given replacement.
     * 
     * @param str The String to be replaced
     * @param key Key within the String to be searched and replaced
     * @param replacement The String used for replacement
     * @return The String with the last occurence of the key value replaced.
     */
    public static String replaceLast (String str, String key, String replacement) {
        StringBuffer result = new StringBuffer(str);

        int pos = str.lastIndexOf(key);

        if (pos >= 0) {
            result.replace(pos, pos + key.length(), replacement);
            // System.out.println("result = " + result);
        }
        return result.toString();
    }

    /**
     * To pad the given string with spaces up to the given length. <br>
     * e.g. rPad("ABCD", 10, ' ') returns "ABCD      " which has a length of 10.
     * <p/>
     * This method has built-in 'intelligence' to handle cases where calling
     * method tries to be funny and supply the following<br>
     * - rPad("abc", 10, "123") it will return, "abc1231231"
     * 
     * @param str String to be padded
     * @param length The required length of the resulted string
     * @param padString The required padding string.
     * @return The padded string. If str already <I>longer</I> than
     *         <I>length</I>, return str itself.
     */
    public static String rPad (String str, int length, String padString) {
        int lOriginal = str.length();
        int lPadStr = padString.length();
        int times2Pad = 0;
        int lPadded = 0;

        if (lOriginal >= length)
            return str;

        StringBuffer sb = new StringBuffer(str); // add the original str first
        String padded;

        times2Pad = (length - lOriginal) / lPadStr; // will give (1) if 3/2

        padded = duplicate(padString, times2Pad);
        lPadded = padded.length();
        sb.append(padded); // pad in the repetitive characters

        // if still insufficient by the modulus e.g. 30/20 is 10
        if (lOriginal + lPadded < length) {
            int more = length - (lOriginal + lPadded);

            // add in the difference which is less entire length of padStr
            sb.append(padString.substring(0, more));
        }

        return sb.toString();
    }

    /**
     * Pads the string with following spaces.
     * 
     * @param str The String to be padded with spaces on the right.
     * @param len The number of spaces to pad to the right of the string.
     * @return The resultant string with spaces padded on the right.
     */
    public static String rPad (String str, int len) {
        return rPad(str, len, " ");
    }

    /**
     * Parse a string and split into various parts by the specified delimiters.
     * 
     * @param str the string to be split
     * @param delimiter delimiting character(s)
     * @return The string array containing the parts delimited by the specified
     *         delimiter.
     */
    public static String[] split (String str, String delimiter) {
        // tentatively allocate only vector of size 3.
        // if not enough, vector will increment 3 each time.
        Vector<String> result = new Vector<String>(3, 3);

        int index = 0;
        int pos = 0;
        int count = 0;

        while (true) {
            pos = str.indexOf(delimiter, index);

            // no more parts
            if (pos == -1) {
                result.add(count, str.substring(index));
                count++;
                break;
            }

            // put into the array
            result.add(count, str.substring(index, pos));

            // increment count
            count++;

            // must cater for delimiter with length > 1
            // so cannot just + 1
            index = pos + delimiter.length();

        } // parseString()

        // compact the array
        String[] tmp = new String[count];
        System.arraycopy(result.toArray(), 0, tmp, 0, count);

        result = null;
        return tmp;
    }

    /**
     * &quot;normalize&quot; the given absolute path.
     * <p/>
     * <p>
     * This includes:
     * <ul>
     * <li>Uppercase the drive letter if there is one.</li>
     * <li>Remove redundant slashes after the drive spec.</li>
     * <li>resolve all ./, .\, ../ and ..\ sequences.</li>
     * <li>DOS style paths that start with a drive letter will have \ as the
     * separator.</li>
     * </ul>
     * 
     * @param path the absolute path
     * @return path
     */
    public static String normalize (String path) {
        String orig = path;

        path = path.replace('/', File.separatorChar).replace('\\',
                File.separatorChar);

        // make sure we are dealing with an absolute path
        int colon = path.indexOf(":");

        if (!path.startsWith(File.separator) && (colon == -1)) {
            throw new RuntimeException(path + " is not an absolute path");
        }

        boolean dosWithDrive = false;
        String root = null;
        // Eliminate consecutive slashes after the drive spec
        if (path.length() >= 2 && Character.isLetter(path.charAt(0))
                && path.charAt(1) == ':') {

            dosWithDrive = true;

            char[] ca = path.replace('/', '\\').toCharArray();
            StringBuffer sbRoot = new StringBuffer();
            for (int i = 0; i < colon; i++) {
                sbRoot.append(Character.toUpperCase(ca[i]));
            }
            sbRoot.append(':');
            if (colon + 1 < path.length()) {
                sbRoot.append(File.separatorChar);
            }
            root = sbRoot.toString();

            // Eliminate consecutive slashes after the drive spec
            StringBuffer sbPath = new StringBuffer();
            for (int i = colon + 1; i < ca.length; i++) {
                if ((ca[i] != '\\') || (ca[i] == '\\' && ca[i - 1] != '\\')) {
                    sbPath.append(ca[i]);
                }
            }
            path = sbPath.toString().replace('\\', File.separatorChar);

        } else {
            if (path.length() == 1) {
                root = File.separator;
                path = "";
            } else if (path.charAt(1) == File.separatorChar) {
                // UNC drive
                root = File.separator + File.separator;
                path = path.substring(2);
            } else {
                root = File.separator;
                path = path.substring(1);
            }
        }

        Stack<String> s = new Stack<String>();
        s.push(root);
        StringTokenizer tok = new StringTokenizer(path, File.separator);
        while (tok.hasMoreTokens()) {
            String thisToken = tok.nextToken();
            if (".".equals(thisToken)) {
                continue;
            } else if ("..".equals(thisToken)) {
                if (s.size() < 2) {
                    throw new RuntimeException("Cannot resolve path " + orig);
                } else {
                    s.pop();
                }
            } else { // plain component
                s.push(thisToken);
            }
        }
        // not before the filesystem root and not after it, since root
        // already contains one
        path = listToString(s, File.separator, 1); // sb.toString();
        if (dosWithDrive) {
            path = path.replace('/', '\\');
        }
        return path;
    }

    /**
     * convert list value to a string.
     * 
     * @param s input string list
     * @param separator separator
     * @return String
     */
    public static String listToString (List<String> s, String separator) {
        return listToString(s, separator, 0);
    }

    /**
     * convert list value to a string.
     * 
     * @param oList oList
     * @param separator separator
     * @param separatorFrPos separatorFrPos
     * @return String
     */
    public static String listToString (List<String> oList, String separator,
            int separatorFrPos) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < oList.size(); i++) {
            if (i > separatorFrPos) {
                sb.append(separator);
            }
            sb.append(oList.get(i));
        }
        return sb.toString();
    }

    /**
     * convert list value to a string array.
     * 
     * @param list
     * @return
     */
    public static String[] listToString (List<String> list) {

        if (list != null && !list.isEmpty()) {

            String[] str = new String[list.size()];

            for (int i = 0; i < list.size(); i++) {
                str[i] = list.get(i);
            }
            return str;
        }
        return null;
    }

    /**
     * check is the String array contain an input String.
     * 
     * @param array input array
     * @param s input String
     * @return boolean
     */
    public static boolean contains (String[] array, String s) {
        return (indexOf(array, s) > -1);
    }

    /**
     * get the index for input String from array.
     * 
     * @param array array
     * @param s string
     * @return index
     */
    public static int indexOf (String[] array, String s) {
        for (int i = 0; i < array.length; i++) {
            if (s != null && s.equals(array[i]))
                return i;
        }
        return -1;
    }

    /**
     * merge 2 input array.
     * 
     * @param array1 array1
     * @param array2 array2
     * @return merged array
     */
    public static String[] unite (String[] array1, String[] array2) {
        String[] result = new String[(array1 == null ? 0 : array1.length)
                + (array2 == null ? 0 : array2.length)];
        for (int i = 0; i < array1.length; i++)
            result[i] = array1[i];
        for (int i = 0; i < array2.length; i++)
            result[array1.length + i] = array2[i];

        return result;
    }

    /**
     * This method is used to escape SQL string in a like clause.
     * 
     * @param oldString oldString
     * @return escaped string
     */

    public static String escapeSQLString (String oldString) {
        if (oldString == null)
            return oldString;
        StringBuffer newString = new StringBuffer();
        char c;
        for (int i = 0; i < oldString.length(); i++) {
            c = oldString.charAt(i);
            switch (c) {
                case '\'':
                    // if( i+1== oldString.length() || i+1< oldString.length()
                    // &&
                    // oldString.charAt(i+1)!='\'')
                    newString.append("''");
                    break;
                case '%':
                    newString.append("/%");
                    break;
                case '_':
                    newString.append("/_");
                    break;
                case '/':
                    newString.append("//");
                    break;
                default:
                    newString.append(c);
            }
        }
        return "%" + newString + "%";
    }

    /**
     * escape xml.
     * 
     * @param obj input obj
     * @return formated String
     */
    public static String escapeXml (Object obj) {
        if (obj == null)
            return "";
        String data = String.valueOf(obj);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            switch (c) {
                case '>': // 62
                    buffer.append("&gt;");
                    break;
                case '<': // 60
                    buffer.append("&lt;");
                    break;
                case '&': // 38
                    buffer.append("&amp;");
                    break;
                case INT_34:
                    buffer.append("&#034;");
                    break;
                case INT_39:
                    buffer.append("&#039;");
                    break;
                default:
                    buffer.append(c);
            }
        }
        return buffer.toString();

    }

    /**
     * " => \" , \ => \\.
     * 
     * @param s s
     * @return formated String
     */
    public static String escapeJSONString (String s) {
        if (s == null)
            return null;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                default:
                    if (ch >= '\u0000' && ch <= '\u001F') {
                        String ss = Integer.toHexString(ch);
                        sb.append("\\u");
                        for (int k = 0; k < 4 - ss.length(); k++) {
                            sb.append('0');
                        }
                        sb.append(ss.toUpperCase());
                    } else {
                        sb.append(ch);
                    }
            }
        }// for
        return sb.toString();
    }

    /**
     * filter input String without convert.
     * 
     * @param input input
     * @return String
     */
    public static String filter (String input) {
        return StringUtil.filter(input, false);
    }

    /**
     * filter input String with convert.
     * 
     * @param input input
     * @param convert convert character.
     * @return formated String
     */
    public static String filter (String input, boolean convert) {
        if (input != null) {
            StringBuffer filtered = new StringBuffer(input.length());
            char c;
            for (int i = 0; i < input.length(); i++) {
                c = input.charAt(i);
                if (c == '<') {
                    filtered.append("&lt;");
                } else if (c == '>') {
                    filtered.append("&gt;");
                } else if (c == '"') {
                    filtered.append("&quot;");
                } else if (c == '&') {
                    filtered.append("&amp;");
                } else if (convert && c == '\n') {
                    filtered.append("<br>");
                } else {
                    filtered.append(c);
                }
            }
            return (filtered.toString());
        } else {
            return null;
        }
    }

    /**
     * shift last character.
     * 
     * @param id id
     * @return value after shift.
     */
    public static String shiftLastAlphabets (String id) {
        if (id == null || "".equals(id) || id.length() <= 1)
            return id;

        int firstNumberPosition = 0;
        int lastNumberPosition = id.length() - 1;

        while (firstNumberPosition < id.length()
                && Character.isLetter(id.charAt(firstNumberPosition)))
            firstNumberPosition++;
        while (lastNumberPosition >= 0
                && Character.isLetter(id.charAt(lastNumberPosition)))
            lastNumberPosition--;

        if (firstNumberPosition > lastNumberPosition)
            return id;

        StringBuffer sb = new StringBuffer();
        sb.append(id.substring(0, firstNumberPosition));
        sb.append(id.substring(lastNumberPosition + 1, id.length()));
        sb.append(id.substring(firstNumberPosition, lastNumberPosition + 1));
        return sb.toString();
    }

    /**
     * For removing specified value from a array.
     * 
     * @param fieldList fieldList
     * @param exludeElement exludeElement
     * @return formated array.
     */
    public static String[] removeFromArray (String[] fieldList,
            String exludeElement) {
        String[] newList = new String[fieldList.length - 1];
        List<String> oldList = null;
        int j = 0;

        oldList = Arrays.asList(fieldList);
		if (!oldList.contains(exludeElement)) {
		    return fieldList;
		}
		for (int i = 0; i < fieldList.length; i++) {
		    if (!exludeElement.equals(fieldList[i])) {
		        newList[j] = fieldList[i];
		        j++;
		    }
		}
		return newList;
    }

    /**
     * check is the String can convert to integer.
     * 
     * @param s s
     * @return boolean
     */
    public static boolean isConvertableToInteger (String s) {
        if (isNullOrBlank(s))
            return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c))
                return false;
        }

        return true;
    }

    /**
     * convert to uppercase.
     * 
     * @param list input list
     * @return converted array
     */
    public static String[] toUpperCase (String[] list) {
        if (isNullOrEmpty(list))
            return list;
        String[] newList = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i].toUpperCase();
        }
        return newList;
    }

    /**
     * The format method that for the String.
     * 
     * @param value the string value
     * @return the string format value, when the value is null, it returns empty
     *         string("")
     */
    public static String formatString (String value) {
        if (value == null) {
            value = "";
        }
        return value.trim();
    }

    /**
     * The format method that remove the single quote from string.
     * 
     * @param value the string value
     * @return the string format value, when the value is null, it returns empty
     *         string("")
     */
    public static String removeSingleQuote (String value) {
        if (value == null) {
            value = "";
        }
        return value.trim().replace("'", "");
    }

    /**
     * convert empty value to null.
     * 
     * @param str input String
     * @return converted value
     */
    public static String convertEmpty2Null (String str) {
        if (str == null || str.trim().equalsIgnoreCase(""))
            return null;
        return str;
    }

    /**
     * format String, use for common validation.
     * 
     * @param sa input string
     * @return formated string
     */
    public static String formatSToNPrecision (String sa) {
        // such as 123.0
        if (sa.substring(sa.length() - 2).equals(".0")) {
            sa = sa.substring(0, sa.length() - 2);
        }

        String sig = "";
        String saTmp = sa;
        // such as +/-123
        if ((sa.charAt(0) == '-') || (sa.charAt(0) == '+')) {
            sig += sa.charAt(0);
            saTmp = sa.substring(1);
        }

        int index = saTmp.indexOf("E");
        // such as 123
        if (index < 0) {
            String result = sa;
            // such as 0.123
            if (result.indexOf("0.") == 0) {
                // such as 0.123000
                while (result.charAt(result.length() - 1) == '0') {
                    result = result.substring(0, result.length() - 1);
                }
            }
            return result;
        } else {
            // such as 123E9
            String si = saTmp.substring(index + 1);
            int ii = Integer.parseInt(si);

            // such as E9
            if (ii > 0) {
                int indexDot = saTmp.indexOf(".");
                // such as 123E9
                if (indexDot < 0) {
                    String trailer = "";
                    for (int i = 0; i < ii; ++i) {
                        trailer += "0";
                    }
                    return sig + saTmp.substring(0, index) + trailer;
                } else {
                    // such as 1.23E9
                    int countCen = index - indexDot - 1;
                    // such as 1.23E3
                    if (ii - countCen >= 0) {
                        String trailer = "";
                        for (int i = 0; i < ii - countCen; ++i) {
                            trailer += "0";
                        }
                        return sig + saTmp.substring(0, indexDot)
                                + saTmp.substring(indexDot + 1, index)
                                + trailer;
                    } else {
                        // such as 1.23E1
                        return sig
                                + saTmp.substring(0, indexDot)
                                + saTmp.substring(indexDot + 1, indexDot + 1
                                        + ii) + "."
                                + saTmp.substring(indexDot + 1 + ii, index);
                    }
                }

            } else if (ii < 0) {
                // such as E-9
                int indexDot = saTmp.indexOf(".");
                // such as 123E-9
                if (indexDot < 0) {
                    // such as 123E-1
                    if (index + ii > 0) {
                        return sig + saTmp.substring(0, index + ii) + "."
                                + saTmp.substring(index + ii, index);
                    } else {
                        // such as 123E-4
                        int countCen = 0 - (index + ii);
                        String header = "0.";
                        for (int i = 0; i < countCen; ++i) {
                            header += "0";
                        }
                        return sig + header + saTmp.substring(0, index);
                    }
                } else {
                    // such as 1.23E-9
                    // such as 12.3E-1
                    if (indexDot + ii > 0) {
                        return sig + saTmp.substring(0, indexDot + ii) + "."
                                + saTmp.substring(indexDot + ii, indexDot)
                                + saTmp.substring(indexDot + 1, index);
                    } else {
                        // such as 12.3E-4
                        int countCen = 0 - (indexDot + ii);
                        String header = "0.";
                        for (int i = 0; i < countCen; ++i) {
                            header += "0";
                        }
                        return sig + header + saTmp.substring(0, indexDot)
                                + saTmp.substring(indexDot + 1, index);
                    }
                }
            } else {
                // such as E0
                return "";
            }
        }
    }

//    /**
//     * check the input is money or not.
//     * 
//     * @param str input string
//     * @return boolean
//     */
//    public static boolean isMoney (String str) {
//        PatternCompiler compiler = new Perl5Compiler();
//        Pattern pattern = null;
//        PatternMatcher matcher = new Perl5Matcher();
//        try {
//            pattern = compiler
//                    .compile("^(\\-?|\\+?)((\\d{1,3}((,\\d{3})*))|(\\d+))((\\.\\d{1,2}){0,1})$");
//        } catch (MalformedPatternException e) {
//            e.printStackTrace();
//        }
//        return matcher.matches(str, pattern);
//    }

    /**
     * Get the parameters from URL address.
     * 
     * @param paramStr the parameter String.
     * @return the parameter map.
     */
    public static Map<String, String> getParamMap (String paramStr) {
        if (isNullOrBlank(paramStr)) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        String[] params = paramStr.split("&");
        for (int i = 0; i < params.length; i++) {
            String[] tmpParam = params[i].split("=");
            if (tmpParam == null || tmpParam.length == 0) {
                continue;
            } else if (tmpParam.length == 1) {
                map.put(tmpParam[0].trim(), "");
            } else {
                map.put(tmpParam[0].trim(), tmpParam[1].trim());
            }
        }
        return map;
    }

    public static String urlEncode (String str) {
        if (str == null)
            return null;

        StringBuffer tmp = new StringBuffer();

        for (int i = 0; i < str.length(); ++i) {
            char a = str.charAt(i);
            if (((a < ':') && (a > '/')) || ((a < '[') && (a > '@'))
                    || ((a < '{') && (a > '`')) || (a == '_'))
                tmp.append(a);
            else if (a < '\16')
                tmp.append("%0" + Integer.toHexString(a));
            else
                tmp.append("%" + Integer.toHexString(a));
        }

        return tmp.toString();
    }


    /**
     * Compare two array lists, if any of the elements in elements1 matches to
     * either one of the element in elements2, return true else return false.
     * 
     * @param elements1
     * @param elements2
     * @return
     */
    public static boolean compareStringLists (List<String> elements1,
            List<String> elements2) {
        for (String element1 : elements1) {
            for (String element2 : elements2) {
                if (element1.equals(element2)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Return the dashed string "-" for Report when the data string is empty, or
     * return data string.
     * 
     * @param data the data string
     * @return String
     */
    public static String returnDashedWhenStrIsEmpty (String data) {
        return StringUtil.isNullOrBlank(data) ? "-" : data;
    }
    
    public static String returnEmptyWhenStrIsEmpty(String data){
    	return StringUtil.isNullOrBlank(data) ? "" : data;
    }

    public static String covertHtmlStr (String source) {
        if (source == null)
            return null;

        return source.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;").replaceAll("'", "&apos;")
                .replaceAll("\"", "&quote;").replaceAll(" ", "&nbsp;")
                .replaceAll("\n", "<br>");
    }

    /*
     * public static void main (String[] args) { System.out.print(StringUtil
     * .replaceWithSpecialChar("&amp;&test&sfa&ds&&amp;dfads&amp;;")); }
     */

    public static String replaceWithSpecialChar (String data) {

        return replaceWithSpecialChar(data, "&amp;");
    }

    /**
     * replace "&" with appointed.
     * 
     * @param data the data string
     * @return String
     */

    public static String replaceWithSpecialChar (String data,
            String replaceString) {

        if (StringUtil.isNullOrBlank(data)) {
            return null;
        }
        return data.replaceAll("&(?!amp;)", replaceString);
    }

}