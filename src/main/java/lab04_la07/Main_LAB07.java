/**
 * 
 */
package lab04_la07;

import weka.core.Instances;

/**
 * @author NguyenHung
 *
 * 
 */
public class Main_LAB07 {
	public static void main(String[] args) throws Exception {
		// Khai báo chung
		HandleData handleData = new HandleData();
		HandleFile handleFile = new HandleFile();

//		______________LAB 07-LẬP TRÌNH PHÂN LỚP DỮ LIỆU______________________

//		NaiBayesModel nb = new NaiBayesModel();
//		Instances dataTrain = handleFile.loadArff(".\\data\\dataUser\\mushroom.train.arff");
//		nb.buildNaiBayes(dataTrain);
//		System.out.println(nb.outputNaiBayes());
//
//		Instances dataTest = handleFile.loadArff(".\\data\\dataUser\\mushroom.test.arff");
//		nb.evaluteNaiBayes(dataTest);
//		System.out.println(nb.outputEvaluate());

//		______________________________________________________
		NaiBayesModel nb2 = new NaiBayesModel();
		Instances dataTrain2 = handleFile.loadArff(".\\data\\dataUser\\iris.train.arff");
		nb2.buildNaiBayes(dataTrain2);
		System.out.println(nb2.outputNaiBayes());

		System.out.println("--Evalute-----------------------------------");
		Instances dataTest2 = handleFile.loadArff(".\\data\\dataUser\\iris.test.arff");
		nb2.evaluteNB(dataTest2);
		System.out.println(nb2.outputEvaluate());

		System.out.println("--Cross Validation--------------------------");
		nb2.crossValidationNB(dataTest2, 5);
		System.out.println(nb2.outputEvaluate());

		Instances dataPredict = handleFile.loadArff(".\\data\\dataUser\\iris.predict.arff");
		boolean rs = nb2.predictClass(dataPredict, ".\\data\\result\\iris.predict_class.arff");
		if (rs) {
			System.out.println("Dự đoán xong.");
		} else {
			System.out.println("lỗi.");

		}

//		______________________________________________________

		Instances data3 = handleFile.loadArff(".\\data\\dataWeka\\iris.arff");
		Instances dataTrain3 = handleData.createTrainTest(data3, 30, false);
		Instances dataTest3 = handleData.createTrainTest(data3, 30, true);

		NaiBayesModel nb3 = new NaiBayesModel();
		nb3.buildNaiBayes(dataTrain3);
		System.out.println(nb3.outputNaiBayes());

		System.out.println("--Evalute-----------------------------------");
		nb3.evaluteNB(dataTest3);
		System.out.println(nb3.outputEvaluate());

		System.out.println("--Cross Validation--------------------------");
		nb3.crossValidationNB(dataTest3, 5);
		System.out.println(nb3.outputEvaluate());
		
		
//		Bài 2 Decision Tree
		System.out.println("\n\n--Decision Tree--------------------------");
		
		Instances data4 = handleFile.loadArff(".\\data\\dataWeka\\iris.arff");
		Instances dataTrain4 = handleData.createTrainTest(data4, 20, false);
		Instances dataTest4 = handleData.createTrainTest(data4, 20, true);
		
		DecisionTreeJ48 tree = new DecisionTreeJ48();
		tree.buildDT_J48(dataTrain4, "-C 0.25 -M 2");
		System.out.println(tree.outputDecisionTree());
		
		
		tree.crossValidationDT(dataTest4, 5);
		System.out.println(tree.outputEvaluate());
		
//		tree.graphTree();

	}
}
