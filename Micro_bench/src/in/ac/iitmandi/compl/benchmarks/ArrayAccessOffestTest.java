package in.ac.iitmandi.compl.benchmarks;

import java.util.ArrayList;
import java.util.List;

import in.ac.iitmandi.compl.objects.NonPrimitiveObject;
import in.ac.iitmandi.compl.objects.NonPrimitiveObjectContainer;
import in.ac.iitmandi.compl.objects.PrimitiveObjectContainer;

public class ArrayAccessOffestTest {

	
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
		System.out.println("Execution time for ArrayAccessOffestTest bench: "+(endTime-startTime));
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
			testOffsetArrayAccess(20000,20000,array);
		}
		
	}
	
	public static Long testOffsetArrayAccess(int maxAccess, int size, PrimitiveObjectContainer[] array) {
		long sum = 0;
		int andSize = size - 1;
		for (int i = 0; i < maxAccess; i++) {
			int pos = i & andSize;
			sum += array[pos].getPvo().getNumdata();
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
			testOffsetArrayAccessNP(20000,20000,array);
		}
		
	}
	
	public static Long testOffsetArrayAccessNP(int maxAccess, int size, NonPrimitiveObjectContainer[] array) {
		long sum = 0;
		int andSize = size - 1;
		for (int i = 0; i < maxAccess; i++) {
			int pos = i & andSize;
			sum += array[pos].getNpvo().getNumdata();
		}
		return sum;
	}


}
