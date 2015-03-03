 /**
 *  Copyright 2012 NCS Pte. Ltd. All Rights Reserved
 *
 *  This software is confidential and proprietary to NCS Pte. Ltd. You shall
 *  use this software only in accordance with the terms of the license
 *  agreement you entered into with NCS.  No aspect or part or all of this
 *  software may be reproduced, modified or disclosed without full and
 *  direct written authorisation from NCS.
 *
 *  NCS SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. NCS MAKES NO
 *  REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 *  SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. NCS SHALL NOT BE LIABLE
 *  FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 *  MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
package org.projectx.webservice.util;


import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberUtil{
     
    private NumberUtil () {
    }

    /**
     * Format the given value to the number of decimal places specified.
     * The output string will group the numbers using the thousand-separator.
     * Eg. the number "12345" -&gt; "12,345" as the result.
     *
     * @param value The value that needs to be formatted.
     * @param decimalPlace Number of decimal places to be formatted.
     * @return The formatted string.
     */
    public static String format(double value, int decimalPlace) {
        NumberFormat nft = NumberFormat.getInstance();

        nft.setMinimumFractionDigits(decimalPlace);
        nft.setMaximumFractionDigits(decimalPlace);

        return nft.format( value );
    }

    /**
     * Format the given value to the number pattern specified.
     *
     * The pattern should use the following symbols.
     *
     * that the result produces "$1,234.40" with "1234.4".
     *
     * <blockquote>
     * <table border >
     *   <th>Symbol</th>
     *   <th>Description</th>
     * </tr>
     *
     * <tr> <td>0</td> <td>a digit</td> </tr>
     * <tr> <td>#</td> <td>a digit, zero shows as absent</td> </tr>
     * <tr> <td>.</td> <td>placeholder for decimal separator</td> </tr>
     * <tr> <td>,</td> <td>placeholder for grouping separator</td> </tr>
     * <tr> <td>E</td> <td>separates mantissa and exponent for exponential formats</td> </tr>
     * <tr> <td>;</td> <td>separates formats</td> </tr>
     * <tr> <td>-</td> <td>default negative prefix</td> </tr>
     * <tr> <td>%</td> <td>multiply by 100 and show as percentage</td> </tr>
     * <tr> <td>?</td> <td>multiply by 1000 and show as per mille</td> </tr>
     * <tr> <td>&curren;</td> <td>currency sign; replaced by currency symbol; if doubled, replaced by international currency symbol;  if present in a pattern, the monetary decimal separator is used instead of the decimal separator </td> </tr>
     * <tr> <td>X</td> <td>any other characters can be used in the prefix or suffix</td> </tr>
     * <tr> <td>'</td> <td>used to quote special characters in a prefix or suffix</td> </tr>
     *
     * </table >
     * </blockquote>
     *
     * @param value The value that needs to be formatted.
     * @param pattern The pattern string to be applied to double value.
     * @return The formatted string.
     */
    public static String format(double value, String pattern) {
        NumberFormat nft = NumberFormat.getInstance();

        ((DecimalFormat) nft).applyPattern(pattern);

        return nft.format( value );
    }

    /**
     * Parse the integer value into a byte array (8 bytes).
     *
     * @param value	The value of the integer.
     * @return The byte array.
     */
    public static byte[] getByte(int value) {
        // 8 bytes required because Java does not have unsigned byte.
        byte buffer[] = new byte[8];
        short val;

        for (int i = 6; i >= 0; i -= 2) {
            val = (short) ( value & 255 );
            buffer[i + 1] = (byte) ( val & 127 );
            buffer[i] = (byte) ( val >> 7 );
            value >>>= 8;
        }

        return buffer;
    }

    /**
     * Combines the integral and decimal strings to return a double.
     *
     * @param integral The integral part of the double.
     * @param decimal The decimal part of the double.
     * @return The double value.
     */
    public static double getDouble(int integral, int decimal) {
        String str = integral + "." + decimal;
        return Double.parseDouble(str);
    }

    /**
     * Combines the integral and decimal strings to return a float.
     *
     * @param integral The integral part of the float.
     * @param decimal The decimal part of the float.
     * @return The float value.
     */
    public static float getFloat(int integral, int decimal) {
        String str = integral + "." + decimal;
        return Float.parseFloat(str);
    }

    /**
     * Converts a byte array (8 bytes) to an integer.
     *
     * @param buffer	The byte array containing the value of the integer.
     * @return The integer value.
     */
    public static int getInt(byte[] buffer) {
        int value = 0;
        short val;

        for (int i = 0; i < 6; i += 2) {
            val = (short) buffer[i];
            val <<= 7;
            val = (short) ( val | buffer[i + 1] );
            value |= val;
            value <<= 8;
        }

        val = (short) buffer[6];
        val <<= 7;
        val = (short) ( val | buffer[7] );
        value |= val;

        return value;
    }

    /**
     * Pads a number to the specified length with leading zeroes.
     *
     * @param num The number to be padded.
     * @param len The minimum length of the String to be returned.
     * @return The padded string of the number.
     */
    public static String lPad(int num, int len) {
        String s = String.valueOf(num);
        int length = s.length();
        if (length >= len)
            return s;

        StringBuffer sb = new StringBuffer();
        for (int i = length; i < len; i++)
            sb.append("0");
        sb.append( s );
        return sb.toString();
    }

    /**
     * Pads a number to the specified length with trailing zeroes.
     *
     * @param num The number to be padded.
     * @param len The minimum length of the String to be returned.
     * @return The padded string of the number.
     */
    public static String rPad(int num, int len) {
        StringBuffer s = new StringBuffer( String.valueOf( num ) );
        int length = s.length();
        if (length >= len)
            return s.toString();

        for (int i = length; i < len; i++)
            s.append("0");
        return s.toString();
    }

    /**
     * Checks if a string value is a valid number. A valid number should only
     * contain digits and decimal point (if it is a double or long value).
     * <p>
     * @param value The String value to check if it is a valid number
     * @param isFraction true if it is a double or float; false otherwise
     * @return true if the value is a valid number; false otherwise
     */
    public static boolean isNumber(String value, boolean isFraction) {
        try {
            
            // To prevent String ending with D, F or L to be parsed as valid number.
            if (value.trim().toUpperCase().endsWith("D") || value.trim().toUpperCase().endsWith("F") || value.trim().toUpperCase().endsWith("L")) {
                return false;
            }
            
            if (isFraction) {
                // this could be either a double or float value
            	// Begin modify by chen haun on 2012-01-10 for PVD-208 
                //double dnum = Double.parseDouble(value);
            	Double.parseDouble(value);
                // End modify by chen haun on 2012-01-10 for PVD-208 
            } else {
                // an integer or a long value
            	// Begin modify by chen haun on 2012-01-10 for PVD-208 
                //long lnum = Long.parseLong(value);
            	Long.parseLong(value);
                // End modify by chen haun on 2012-01-10 for PVD-208 
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Check if a String value is a valid number and tests the input string to ensure that 
     * a valid Number instance can be created from it according to the format provided.
     * 
     * @param value The string value to check if it is a valid number and in valid format.
     * @param isFraction true if it is a valid number.
     * @param format Number format to conform to.
     * @return true if the value is a valid number and conform to specified format; false otherwise
     */
    public static boolean isValidNumber(String value, boolean isFraction, String format) {
        int wholeNo = 0;
		int decimalPlace = 0;

		if(!isNumber(value, isFraction)) 
            return false;
		

		int index = format.indexOf(".");

		if(index != -1) {
			wholeNo =  Integer.parseInt(format.substring(0,index));
			decimalPlace = Integer.parseInt(format.substring(index+1, format.length()));					
		}
		else
			wholeNo = Integer.parseInt(format);
						

		index = value.indexOf(".");
		
		if(index != -1) {
            String part1 = value.substring(0,index);
            
            if(part1.charAt(0) == '-') {
            	part1 = part1.substring(1);
            }
            
			if(part1.length() > wholeNo)
				return false;
                
			String part2 = value.substring(index+1, value.length());
			if(part2.length() > decimalPlace)
                return false;			
		}
		else {
			if(value.length() > wholeNo)
				return false;
		}		
		return true;
    }
        
}