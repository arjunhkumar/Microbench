/**
 * 
 */
package in.ac.iitmandi.compl.benchmarks;

import java.util.ArrayList;

import in.ac.iitmandi.compl.objects.NonPrimitiveObject;
import in.ac.iitmandi.compl.objects.PrimitiveValueObject;

/**
 * @author arjun
 *
 */
public class LoopTest {

	public void testPrimitiveLoadLoop(boolean isPrimitiveObject){
		long startTime = System.currentTimeMillis();
		long limit = 1000000L;
		for(long i=0;i<limit;i++) {
			executeTest(isPrimitiveObject);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time for loop bench: "+(endTime-startTime));
	}

	private void executeTest(boolean isPrimitiveObject) {
		long limit = 10000L;
		ArrayList<PrimitiveValueObject.ref> primitiveList = new ArrayList();
		ArrayList<NonPrimitiveObject> nonPrimitiveList = new ArrayList();
		if(isPrimitiveObject) {
			for(long i=0;i<limit;i++) {
				primitiveList.add(new PrimitiveValueObject(i, i, "test", 't'));
			}
			long sum = 0L;
			for(PrimitiveValueObject pobj:primitiveList) {
				sum+=pobj.numdata + pobj.decdata;
			}
//			System.out.println("Sum: "+sum);
		} else {
			for(long i=0;i<limit;i++) {
				nonPrimitiveList.add(new NonPrimitiveObject(i, i, "test", 't'));
			}
			long sum = 0L;
			for(NonPrimitiveObject npobj:nonPrimitiveList) {
				sum+=npobj.getNumdata() + npobj.getDecdata();
			}
//			System.out.println("Sum: "+sum);
		}
	}
	
}
