/**
 * 
 */
package lab09;

import lab04_la07.HandleFile;
import weka.core.Instances;

/**
 * @author NguyenHung
 *
 * 
 */
public class Lab09 {
	public static void main(String[] args) throws Exception {
		HandleFile handleFile = new HandleFile();

//		KMean kMean = new KMean();
//		Instances data1 = handleFile.loadArff(".\\data\\dataUser\\mushroom.arff");
//		kMean.build_Cluster_KMeans(data1, 2);
//		System.out.println(kMean.ouptCluster());
//
//		Instances dataPredict1 = handleFile.loadArff(".\\data\\dataUser\\mushroom.test.arff");
//		kMean.predictInstance(dataPredict1);
		
		HierarchicalModel hierarchical = new HierarchicalModel();
		Instances data2 = handleFile.loadArff(".\\data\\dataWeka\\weather.nominal.arff");
		hierarchical.build_Cluster_Hierarchical(data2, "-N 2 -L SINGLE -P -A \"weka.core.EuclideanDistance -R first-last\"");
		System.out.println(hierarchical.outputHierarchical());
		
		Instances dataPredict2 = handleFile.loadArff(".\\data\\dataUser\\weather.test.arff");
		hierarchical.predictInstance(dataPredict2);
		
		
	}
}
