package in.ac.iitmandi.compl.benchmarks;

import java.util.ArrayList;
import java.util.List;

import in.ac.iitmandi.compl.objects.NonPrimitiveObject;
import in.ac.iitmandi.compl.objects.NonPrimitiveObjectContainer;
import in.ac.iitmandi.compl.objects.PrimitiveObjectContainer;

public class ArrayAccessRandomTest {

	public void testLoadArray(boolean isPrimitiveObjectTest){
		long startTime = System.currentTimeMillis();
		long limit = 5000;
		if(isPrimitiveObjectTest) {
			for(long i=0;i<limit;i++) {
				runArrayLoadTestPrimitive();
			}
		}else {
			for(long i=0;i<limit;i++) {
				runArrayLoadTestNonPrimitive();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time for ArrayAccessRandomTest bench: "+(endTime-startTime));
	}
	
	public void runArrayLoadTestPrimitive() {
		List<PrimitiveObjectContainer> primitiveList = new ArrayList<>();
		long limit = 1000;
			for(long i=0;i<limit;i++) {
				primitiveList.add(new PrimitiveObjectContainer(i, i, 't'));
			}
			PrimitiveObjectContainer[] array = new PrimitiveObjectContainer[primitiveList.size()];
			array = primitiveList.toArray(array);
		
		
		for(long i=0;i<limit;i++) {
			testRandArrayAccess(20000,20000,array);
		}
	}
	

	public static Long testRandArrayAccess(int maxAccess, int size,PrimitiveObjectContainer[] rand) {
		long sum = 0;
		int andSize = size - 1;
		for (int i = 0; i < maxAccess; i++) {
			PrimitiveObjectContainer pos = rand[i & andSize];
			sum += pos.getPvo().getNumdata();
		}
		return sum;
	}
	
	public void runArrayLoadTestNonPrimitive() {
		List<NonPrimitiveObjectContainer> nonPrimitiveList = new ArrayList<>();
		long limit = 1000;
			for(long i=0;i<limit;i++) {
				nonPrimitiveList.add(new NonPrimitiveObjectContainer(i, i, 't'));
			}
			
			NonPrimitiveObjectContainer[] array = new NonPrimitiveObjectContainer[nonPrimitiveList.size()];
			array = nonPrimitiveList.toArray(array);
			
		for(long i=0;i<limit;i++) {
			testRandArrayAccessNP(20000,20000,array);
		}
	}
	

	public static Long testRandArrayAccessNP(int maxAccess, int size,NonPrimitiveObjectContainer[] rand) {
		long sum = 0;
		int andSize = size - 1;
		for (int i = 0; i < maxAccess; i++) {
			NonPrimitiveObjectContainer pos = rand[i & andSize];
			sum += pos.getNpvo().getNumdata();
		}
		return sum;
	}
	
}
