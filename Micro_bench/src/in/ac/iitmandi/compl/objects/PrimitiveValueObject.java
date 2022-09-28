/**
 * 
 */
package in.ac.iitmandi.compl.objects;

/**
 * @author arjun
 *
 */
public primitive class PrimitiveValueObject {

	public double decdata;
	public long numdata;
	public char chardata;
	
	public PrimitiveValueObject(double decdata, long numdata, char chardata) {
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
	 * @return the numdata
	 */
	public long getNumdata() {
		return numdata;
	}

	/**
	 * @return the chardata
	 */
	public char getChardata() {
		return chardata;
	}
	
}
