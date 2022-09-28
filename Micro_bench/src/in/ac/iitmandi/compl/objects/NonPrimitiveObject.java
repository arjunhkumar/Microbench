/**
 * 
 */
package in.ac.iitmandi.compl.objects;

/**
 * @author arjun
 *
 */
public class NonPrimitiveObject {

	double decdata;
	long numdata;
//	String stringdata;
	char chardata;
	
	public NonPrimitiveObject(double decdata, long numdata, char chardata) {
		this.decdata = decdata;
		this.numdata = numdata;
		this.chardata = chardata;
	}

	/**
	 * @return the decdata
	 */
	public double getDecdata() {
		return decdata;
	}

	/**
	 * @param decdata the decdata to set
	 */
	public void setDecdata(double decdata) {
		this.decdata = decdata;
	}

	/**
	 * @return the numdata
	 */
	public long getNumdata() {
		return numdata;
	}

	/**
	 * @param numdata the numdata to set
	 */
	public void setNumdata(long numdata) {
		this.numdata = numdata;
	}


	/**
	 * @return the chardata
	 */
	public char getChardata() {
		return chardata;
	}

	/**
	 * @param chardata the chardata to set
	 */
	public void setChardata(char chardata) {
		this.chardata = chardata;
	}

	
}
