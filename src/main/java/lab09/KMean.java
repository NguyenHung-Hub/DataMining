/**
 * 
 */
package lab09;

import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instance;
import weka.core.Instances;

/**
 * @author NguyenHung
 *
 * 
 */
public class KMean {

	SimpleKMeans kMeans;

	public KMean() {
	}

	public void build_Cluster_KMeans(Instances data, int k) throws Exception {
		kMeans = new SimpleKMeans();
		kMeans.setNumClusters(k);
		kMeans.setDistanceFunction(new EuclideanDistance());
		kMeans.buildClusterer(data);
	}

	public void predictInstance(Instances data) throws Exception {
		for (Instance i : data) {
			int x = kMeans.clusterInstance(i);
			System.out.println(i.toString() + " thuộc cluster " + x);
		}
	}

	public String ouptCluster() {
		return kMeans.toString();
	}
}
