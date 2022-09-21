/**
 * 
 */
package in.ac.iitmandi.compl.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;


/**
 * @author arjun
 *
 */
public class CommonUtils {

	static CommonUtils commonUtils = null;
	private String benchName = null;
	/**
	 * Private Constructor for singleton implementation
	 */
	private CommonUtils() {
//		globalEnv = new MiniSchemeEnvironment();
	}
	
	
	/**
	 * @return the benchName
	 */
	public String getBenchName() {
		return benchName;
	}


	/**
	 * @param benchName the benchName to set
	 */
	public void setBenchName(String benchName) {
		this.benchName = benchName;
	}



	public static CommonUtils getInstance() {
		if(null==commonUtils) {
			commonUtils = new CommonUtils();
		}
		return commonUtils;
	}

	
	public static boolean isNotNull(String str) {
		return !(null==str || "".equalsIgnoreCase(str));
	}
	
	public static boolean isNotNull(List<?> list) {
		return (null!=list && !list.isEmpty());
	}
	
	public static boolean isNotNull(Map<?, ?> map) {
		return (null!=map && !map.isEmpty());
	}
	
	public static boolean isNotNull(Set<?> set) {
		return (null!=set && !set.isEmpty());
	}
	
	public static boolean isNotNull(Vector<?> vector) {
		return (null!=vector && !vector.isEmpty());
	}
	
	public static Map<String,List<String>> populateJGFSectionMap() {
		Map<String,List<String>> jgfMap = new HashMap<>();
		List<String> section1List = Arrays.asList("JGFBarrierBench","JGFForkJoinBench","JGFSyncBench");
		List<String> section2List = Arrays.asList("JGFCryptBenchSizeA","JGFCryptBenchSizeB","JGFCryptBenchSizeC",
				"JGFLUFactBenchSizeA","JGFLUFactBenchSizeB","JGFLUFactBenchSizeC",
				"JGFSORBenchSizeA","JGFSORBenchSizeB","JGFSORBenchSizeC",
				"JGFSparseMatmultBenchSizeA","JGFSparseMatmultBenchSizeB","JGFSparseMatmultBenchSizeC",
				"JGFSeriesBenchSizeA","JGFSeriesBenchSizeB","JGFSeriesBenchSizeC");
		List<String> section3List = Arrays.asList("JGFMolDynBenchSizeA","JGFMolDynBenchSizeB","JGFMonteCarloBenchSizeA",
				"JGFMonteCarloBenchSizeB","JGFRayTracerBenchSizeA","JGFRayTracerBenchSizeB");
		jgfMap.put("SECTION1", section1List);
		jgfMap.put("SECTION2", section2List);
		jgfMap.put("SECTION3", section3List);
		return jgfMap;
	}
	
	public static String getBenchmark() {
		return getInstance().getBenchName();
	}
	
}
