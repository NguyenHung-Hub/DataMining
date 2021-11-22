/**
 * 
 */
package lab09;

import weka.clusterers.HierarchicalClusterer;
import weka.core.EuclideanDistance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;

/**
 * @author NguyenHung
 *
 * 
 */
public class HierarchicalModel {

	HierarchicalClusterer hierarchicalClusterer;
	
	public HierarchicalModel() {
	}
	
	public void build_Cluster_Hierarchical(Instances data, String option) throws Exception {
		hierarchicalClusterer = new HierarchicalClusterer();
		String[] modelOption = Utils.splitOptions(option);
		
		hierarchicalClusterer.setOptions(modelOption);
		hierarchicalClusterer.setDistanceFunction(new EuclideanDistance());
		hierarchicalClusterer.buildClusterer(data);
	}

	public void predictInstance(Instances data) throws Exception {
		for (Instance i : data) {
			int x = hierarchicalClusterer.clusterInstance(i);
			System.out.println(i.toString() + " thuộc cluster " + x);
		}
	}
	
	public String outputHierarchical() {
		return hierarchicalClusterer.toString();
	}
}
