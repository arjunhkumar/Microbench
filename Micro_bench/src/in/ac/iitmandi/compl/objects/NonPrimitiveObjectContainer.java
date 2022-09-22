/**
 * 
 */
package in.ac.iitmandi.compl.objects;

/**
 * @author arjun
 *
 */
public class NonPrimitiveObjectContainer {

	NonPrimitiveObject npvo;

	/**
	 * @param npvo
	 */
	public NonPrimitiveObjectContainer(double decdata, long numdata, String stringdata, char chardata) {
		this.npvo = new NonPrimitiveObject(decdata, numdata, stringdata, chardata);
	}

	/**
	 * @return the npvo
	 */
	public NonPrimitiveObject getNpvo() {
		return npvo;
	}

	/**
	 * @param npvo the npvo to set
	 */
	public void setNpvo(NonPrimitiveObject npvo) {
		this.npvo = npvo;
	}
	
	
	
}
