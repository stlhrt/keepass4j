package pl.sind.keepass;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.FileOutputStream;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import pl.sind.keepass.util.Utils;

@RunWith(JUnit4.class)
public class UtilTest {

	byte[] referenceBytes = new byte[] { 0x01, -49, -22, -75, -128, -75, 127,
			88, -74, -122, 67, -41, 59, 24, 22, -101, -79, 88, -35, 111, 123,
			-115, 40, 68, -75, -69, -34, -9, 98, 101, 0x00, (byte) 0xe3 };

	String referenceString = "01cfeab580b57f58b68643d73b18169bb158dd6f7b8d2844b5bbdef7626500e3";

	@Test
	public void checkToHex() throws Exception {
		String ret = Utils.toHexString(referenceBytes);
		assertEquals(referenceString,ret);
		FileOutputStream fos = new FileOutputStream("cos.dat");
		fos.write(referenceBytes);
		fos.close();
	}

	@Test
	public void checkFromHex() throws Exception {
		byte[] ret = Utils.fromHexString(referenceString);
		assertArrayEquals(referenceBytes, ret);
	}

	@Test
	public void checkRoundTrip() throws Exception {
		Random r = new Random();
		byte[] source = new byte[r.nextInt(512)+128];
		r.nextBytes(source);
		String testString = Utils.toHexString(source);
		byte[] result = Utils.fromHexString(testString);
		assertArrayEquals(source, result);
	}

}
