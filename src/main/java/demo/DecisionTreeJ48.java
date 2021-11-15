/**
 * 
 */
package demo;

import java.io.BufferedWriter;
import java.io.FileWriter;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Debug.Random;

/**
 * @author NguyenHung
 *
 * 
 */
public class DecisionTreeJ48 {

	private J48 tree;
	private Evaluation evaluation;
	private Instances data;

	public DecisionTreeJ48() {
	}

	public void buildDT_J48(Instances dataInput, String option) throws Exception {
		this.data = dataInput;
		tree = new J48();

		String[] modelOption = weka.core.Utils.splitOptions(option);
		data.setClassIndex(data.numAttributes() - 1);
		tree.setOptions(modelOption);

		tree.buildClassifier(data);
	}

	public void graphTree() throws Exception {
		System.out.println(tree.graph());
	}

	public void evaluteDT(Instances dataTest) throws Exception {
		dataTest.setClassIndex(dataTest.numAttributes() - 1);
		evaluation = new Evaluation(data);
		evaluation.evaluateModel(tree, dataTest);
	}

	public void crossValidationDT(Instances dataTest, int k) throws Exception {
		dataTest.setClassIndex(dataTest.numAttributes() - 1);
		evaluation = new Evaluation(data);

		Random random = new Random(1);
		evaluation.crossValidateModel(tree, dataTest, k, random);
	}

	public boolean predictClass(Instances data, String fileName) throws Exception {
		data.setClassIndex(data.numAttributes() - 1);
		for (Instance i : data) {
			double predict = tree.classifyInstance(i);
			i.setClassValue(predict);
		}

		BufferedWriter output = new BufferedWriter(new FileWriter(fileName));
		output.write(data.toString());
		output.flush();
		output.close();

		return true;
	}

	public String outputDecisionTree() {
		return tree.toString();
	}

	public String outputEvaluate() {
		return evaluation.toSummaryString();
	}

}
