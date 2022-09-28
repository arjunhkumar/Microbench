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
public class LoopTest {

	public void testPrimitiveLoadLoop(boolean isPrimitiveObjectTest){
		long startTime = System.currentTimeMillis();
		long limit = 20000;
		for(long i=0;i<limit;i++) {
			executeTest(isPrimitiveObjectTest);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time for LoopTest bench: "+(endTime-startTime));
	}

	private void executeTest(boolean isPrimitiveObjectTest) {
		long limit = 20000;
		ArrayList<PrimitiveObjectContainer> primitiveList = new ArrayList();
		ArrayList<NonPrimitiveObjectContainer> nonPrimitiveList = new ArrayList();
		if(isPrimitiveObjectTest) {
			for(long i=0;i<limit;i++) {
				primitiveList.add(new PrimitiveObjectContainer(i, i, 't'));
			}
			long sum = 0L;
			for(PrimitiveObjectContainer pobj:primitiveList) {
				sum+=pobj.getPvo().getNumdata() + pobj.getPvo().getDecdata();
			}
		} else {
			for(long i=0;i<limit;i++) {
				nonPrimitiveList.add(new NonPrimitiveObjectContainer(i, i, 't'));
			}
			long sum = 0L;
			for(NonPrimitiveObjectContainer npobj:nonPrimitiveList) {
				sum+=npobj.getNpvo().getNumdata() + npobj.getNpvo().getDecdata();
			}
		}
	}
	
}
