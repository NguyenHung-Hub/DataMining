/**
 * 
 */
package demo;

import java.io.BufferedWriter;
import java.io.FileWriter;


import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Debug.Random;
import weka.core.Instance;
import weka.core.Instances;

/**
 * @author NguyenHung
 *
 * 
 */
public class NaiBayesModel {
	private NaiveBayes naiveBayes;
	private Evaluation evaluation;

	private Instances dataTrain;

	public NaiBayesModel() {

	}

	public void buildNaiBayes(Instances data) throws Exception {
		this.dataTrain = data;
		naiveBayes = new NaiveBayes();
		dataTrain.setClassIndex(dataTrain.numAttributes() - 1);
		naiveBayes.buildClassifier(dataTrain);
	}

	public void evaluteNB(Instances dataTest) throws Exception {
		dataTest.setClassIndex(dataTest.numAttributes() - 1);
		evaluation = new Evaluation(dataTrain);
		evaluation.evaluateModel(naiveBayes, dataTest);
	}

	public void  crossValidationNB(Instances dataTest, int k) throws Exception {
		dataTest.setClassIndex(dataTest.numAttributes() - 1);
		evaluation = new Evaluation(dataTrain);
		
		Random random = new Random(1);
		evaluation.crossValidateModel(naiveBayes, dataTest, k, random);
	}

	public boolean predictClass(Instances data, String fileName) throws Exception {
		data.setClassIndex(data.numAttributes() - 1);
		for (Instance i : data) {
			double predict = naiveBayes.classifyInstance(i);
			i.setClassValue(predict);
		}

		BufferedWriter output = new BufferedWriter(new FileWriter(fileName));
		output.write(data.toString());
		output.flush();
		output.close();

		return true;
	}

	public String outputNaiBayes() {
		return naiveBayes.toString();
	}

	public String outputEvaluate() {
		return evaluation.toSummaryString();
	}
}
