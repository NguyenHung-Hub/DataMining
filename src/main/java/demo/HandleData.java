/**
 * 
 */
package demo;

import weka.core.Instances;
import weka.core.Utils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToBinary;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.RemoveByName;
import weka.filters.unsupervised.instance.RemovePercentage;

/**
 * @author NguyenHung
 *
 * 
 */

public class HandleData {

	/**
	 * 
	 */
	public HandleData() {
	}

	/**
	 * 
	 * @param data
	 * @param opt tham số để chuyển từ Numeric sang Nominal
	 * @return
	 * @throws Exception
	 */
	public Instances numericToNominal(Instances data, String opt) throws Exception {
		NumericToNominal numericToNominal = new NumericToNominal();

		String[] option = Utils.splitOptions(opt);
		numericToNominal.setOptions(option);
		numericToNominal.setInputFormat(data);

		return Filter.useFilter(data, numericToNominal);
	}

	/**
	 * 
	 * @param data
	 * @param opt tham số để chuyển từ Numeric sang Binary
	 * @return
	 * @throws Exception
	 */
	public Instances numericToBinary(Instances data, String opt) throws Exception {
		NumericToBinary numericToBinary = new NumericToBinary();

		String[] option = Utils.splitOptions(opt);
		numericToBinary.setOptions(option);
		numericToBinary.setInputFormat(data);

		return Filter.useFilter(data, numericToBinary);

	}

	/**
	 * 
	 * @param data
	 * @param opt tham số để chuyển từ Nominal sang Binary
	 * @return
	 * @throws Exception
	 */
	public Instances nominalToBinary(Instances data, String opt) throws Exception {
		NominalToBinary nominalToBinary = new NominalToBinary();

		String[] option = Utils.splitOptions(opt);
		nominalToBinary.setOptions(option);
		nominalToBinary.setInputFormat(data);

		return Filter.useFilter(data, nominalToBinary);
	}
	
	/**
	 * 
	 * @param data
	 * @param opt tham số để loại bỏ dữ liệu
	 * @return
	 * @throws Exception
	 */
	public Instances removeData(Instances data, String opt) throws Exception {
		Remove remove = new Remove();
		String[] option = Utils.splitOptions(opt);
		remove.setOptions(option);
		remove.setInputFormat(data);
		return Filter.useFilter(data, remove);
		
	}
	/**
	 * 
	 * @param data
	 * @param regex biểu thức chính quy để loại bỏ dữ liệu
	 * @return
	 * @throws Exception
	 */
	public Instances removeByName(Instances data, String regex) throws Exception {
		RemoveByName removeByName = new RemoveByName();
		removeByName.setExpression(regex);
		removeByName.setInputFormat(data);
		return Filter.useFilter(data, removeByName);
		
	}
	
	/**
	 * 
	 * @param data
	 * @param percentage
	 * @param isTest == true => là tập dữ liệu test, isTest == false => là tập dữ liệu train
	 * @return
	 * @throws Exception
	 */
	public Instances createTrainTest(Instances data, double percentage, boolean isTest) throws Exception {
		RemovePercentage remove = new RemovePercentage();
		remove.setPercentage(percentage);
		remove.setInvertSelection(isTest);
		remove.setInputFormat(data);
		return Filter.useFilter(data, remove);
	}
	
}
