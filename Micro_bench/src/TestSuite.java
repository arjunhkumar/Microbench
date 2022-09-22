/**
 * 
 */


import in.ac.iitmandi.compl.benchmarks.ArrayAccessOffestTest;
import in.ac.iitmandi.compl.benchmarks.ArrayAccessRandomTest;
import in.ac.iitmandi.compl.benchmarks.LoopTest;
import in.ac.iitmandi.compl.benchmarks.SingleObjectLoopTest;
import in.ac.iitmandi.compl.helper.CommonConstants;
import in.ac.iitmandi.compl.helper.CommonUtils;

/**
 * @author arjun
 *
 */
public class TestSuite {

	/**
	 * @param args
	 */
	static String benchmark;
	static boolean isPrimitive;
	
	public static void main(String[] args) {
		if(args.length<2) {
			System.out.println("Incorrect input options.");
		}else {
			benchmark = args[0];
			isPrimitive = args[1].equalsIgnoreCase("true") ? true : false;
			if(CommonUtils.isNotNull(benchmark)) {
				if(benchmark.equalsIgnoreCase(CommonConstants.LOOPTEST)) {
					LoopTest lt = new LoopTest();
					lt.testPrimitiveLoadLoop(isPrimitive);
				}else if(benchmark.equalsIgnoreCase(CommonConstants.SINGLEOBJECTLOOPTEST)) {
					SingleObjectLoopTest solt = new SingleObjectLoopTest();
					solt.testPrimitiveLoadLoop(isPrimitive);
				}else if(benchmark.equalsIgnoreCase(CommonConstants.ARRAYACCESSOFFESTTEST)) {
					ArrayAccessOffestTest at = new ArrayAccessOffestTest();
					at.testLoadArray(isPrimitive);
				}else if(benchmark.equalsIgnoreCase(CommonConstants.ARRAYACCESSRANDOMTEST)) {
					ArrayAccessRandomTest at = new ArrayAccessRandomTest();
					at.testLoadArray(isPrimitive);
				}
			}
			
		}
	}
	

}
