package reverseBits_190;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
* @author 
* @createDate ：2020年3月30日
*/
public class ReverseBits_190 {
	// you need treat n as an unsigned value
    public int reverseBits(int n) {
        String string = Integer.toUnsignedString(n);
        char[] charArray = string.toCharArray();
        for(int i=0;i<charArray.length;i++){
        	char c = charArray[i];
        	charArray[i] = charArray[charArray.length-1-i];
        	charArray[charArray.length-1-i]=c;
        }
        return Integer.parseUnsignedInt(string);
    }
    @Test
    public void test(){
    	assertEquals(964176192, new ReverseBits_190().reverseBits(43261596));
    }
}
