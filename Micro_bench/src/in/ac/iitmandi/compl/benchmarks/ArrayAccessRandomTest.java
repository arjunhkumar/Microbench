package in.ac.iitmandi.compl.benchmarks;

import java.util.ArrayList;

import in.ac.iitmandi.compl.objects.NonPrimitiveObject;
import in.ac.iitmandi.compl.objects.PrimitiveValueObject;

public class ArrayAccessRandomTest {

	public void testLoadArray(boolean isPrimitiveObject){
		long startTime = System.currentTimeMillis();
		long limit = 10000L;
		if(isPrimitiveObject) {
			for(long i=0;i<limit;i++) {
				runArrayLoadTestPrimitive();
			}
		}else {
			for(long i=0;i<limit;i++) {
				runArrayLoadTestNonPrimitive();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time for loop bench: "+(endTime-startTime));
	}
	
	public void runArrayLoadTestPrimitive() {
		ArrayList<PrimitiveValueObject.ref> primitiveList = new ArrayList();
		long limit = 1000000L;
			for(long i=0;i<limit;i++) {
				primitiveList.add(new PrimitiveValueObject(i, i, "test", 't'));
			}
			PrimitiveValueObject.ref[] array = new PrimitiveValueObject[primitiveList.size()];
			array = primitiveList.toArray(array);
		
		
		for(long i=0;i<limit;i++) {
			testRandArrayAccess(1000000,1000000,array);
		}
	}
	

	public static Long testRandArrayAccess(int maxAccess, int size,PrimitiveValueObject.ref[] rand) {
		long sum = 0;
		int andSize = size - 1;
		for (int i = 0; i < maxAccess; i++) {
			PrimitiveValueObject pos = rand[i & andSize];
			sum += pos.numdata;
		}
		return sum;
	}
	
	public void runArrayLoadTestNonPrimitive() {
		ArrayList<NonPrimitiveObject> nonPrimitiveList = new ArrayList();
		long limit = 1000000L;
			for(long i=0;i<limit;i++) {
				nonPrimitiveList.add(new NonPrimitiveObject(i, i, "test", 't'));
			}
			
			NonPrimitiveObject[] array = new NonPrimitiveObject[nonPrimitiveList.size()];
			array = nonPrimitiveList.toArray(array);
			
		for(long i=0;i<limit;i++) {
			testRandArrayAccessNP(1000000,1000000,array);
		}
	}
	

	public static Long testRandArrayAccessNP(int maxAccess, int size,NonPrimitiveObject[] rand) {
		long sum = 0;
		int andSize = size - 1;
		for (int i = 0; i < maxAccess; i++) {
			NonPrimitiveObject pos = rand[i & andSize];
			sum += pos.getNumdata();
		}
		return sum;
	}
	
}
