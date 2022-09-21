/**
 * 
 */
package in.ac.iitmandi.compl.benchmarks;

import java.util.ArrayList;

import in.ac.iitmandi.compl.objects.NonPrimitiveObject;
import in.ac.iitmandi.compl.objects.NonPrimitiveObjectContainer;
import in.ac.iitmandi.compl.objects.PrimitiveObjectContainer;
import in.ac.iitmandi.compl.objects.PrimitiveValueObject;

/**
 * @author arjun
 *
 */
public class SingleObjectLoopTest {

	public void testPrimitiveLoadLoop(boolean isPrimitiveObject){
		long startTime = System.currentTimeMillis();
		long limit = 20000;
		for(long i=0;i<limit;i++) {
			executeTest(isPrimitiveObject);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time for SingleObjectLoopTest bench: "+(endTime-startTime));
	}

	private void executeTest(boolean isPrimitiveObject) {
		long limit = 20000;
		if(isPrimitiveObject) {
			PrimitiveObjectContainer primObj = new PrimitiveObjectContainer(1, 1, "test", 't');
			long sum = 0L;
			for(long i=0;i<limit;i++) {
				sum+=primObj.getPvo().getNumdata() + primObj.getPvo().getDecdata();
			}
		} else {
			NonPrimitiveObjectContainer nonPrimObj = new NonPrimitiveObjectContainer(1, 1, "test", 't');
			long sum = 0L;
			for(long i=0;i<limit;i++) {
				sum+=nonPrimObj.getNpvo().getNumdata() + nonPrimObj.getNpvo().getDecdata();
			}
		}
	}
	
}
