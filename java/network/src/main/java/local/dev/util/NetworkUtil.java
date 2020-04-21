package local.dev.util;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkUtil
{
	/***
	 * 현재 컴퓨터에 설정 된 호스트이름을 조회합니다.
	 * @return hostname
	 * @throws UnknownHostException
	 * @author wkkim
	 */
	public static String getHostName() throws UnknownHostException 
	{
		return InetAddress.getLocalHost().getHostName();
	}
	
	/***
	 * 현재 컴퓨터에 매핑 된 네트워크 아이피를 조회합니다.
	 * @return
	 * @throws UnknownHostException
	 * @author wkkim
	 */
	public static String getIpAddress() throws UnknownHostException
	{
		return InetAddress.getLocalHost().getHostAddress();
	}
	
	/***
	 * 문자열 형태의 16진수 배열을 byte[] 형태로 변환합니다.
	 * 입력 예 : 
	 * -. hexStrValue : "00 a5 72 84"
	 * -. delemiter : " "
	 * @param 문자열 형태의 16진수 배열
	 * @param 문자열 사이의 구분자
	 * @return
	 * @author wkkim
	 */
	public static byte[] stringHexArrToByteArr(String hexStrValues, String delimiter)
	{
		String[] hexStringArr = hexStrValues.split(delimiter);
		
		byte[] result = new byte[hexStringArr.length];
		
		for(int n=0; n<hexStringArr.length; n++)
		{
			result[n] = (byte) (Integer.parseInt(hexStringArr[n], 16));
		}
		
		return result;
	}
	
	/***
	 * 문자열 형태의 IP Address를 byte[4] 형태로 변환합니다.
	 * 입력 예 :
	 * -. addr : "192.168.0.0"
	 * @param addr
	 * @return byte[4]
	 * @throws UnknownHostException
	 */
	public static byte[] stringAddrToByteArr(String addr) throws UnknownHostException
	{
		return InetAddress.getByName(addr).getAddress();
	}
	
	public static void main(String[] args)
	{
		try
		{
			System.out.println(NetworkUtil.getHostName());
			System.out.println(NetworkUtil.getIpAddress());
			System.out.println(NetworkUtil.stringAddrToByteArr("192.168.3.31"));
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
	}
}
