/**
 * 
 */
package in.ac.iitmandi.compl.objects;

/**
 * @author arjun
 *
 */
public class PrimitiveObjectContainer {

	PrimitiveValueObject pvo;

	/**
	 * @param pvo
	 */
	public PrimitiveObjectContainer(double decdata, long numdata, String stringdata, char chardata) {
		this.pvo = new PrimitiveValueObject(decdata, numdata, stringdata, chardata);
	}

	/**
	 * @return the pvo
	 */
	public PrimitiveValueObject getPvo() {
		return pvo;
	}

	/**
	 * @param pvo the pvo to set
	 */
	public void setPvo(PrimitiveValueObject pvo) {
		this.pvo = pvo;
	}
	
	
	
}
