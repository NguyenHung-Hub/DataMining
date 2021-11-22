/**
 * 
 */
package lab04_la07;

import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * @author NguyenHung
 *
 * 
 */
public class AprioriModel {
	DataSource dataSource;
	Apriori apriori;

	/**
	 * 
	 */
	public AprioriModel() {
		apriori = new Apriori();
	}

	@Override
	public String toString() {
		return apriori.toString();
	}

	/**
	 * @param model_opt tham số để tìm luật
	 * @param data
	 * @throws Exception
	 */
	public void mineApriori(String model_opt, Instances data) throws Exception {
		String[] model_option = weka.core.Utils.splitOptions(model_opt);

		apriori.setOptions(model_option);
		apriori.buildAssociations(data);
	}

	/**
	 * lấy file dữ liệu, mặc định là file .arff
	 * @param fileName đư�?ng dẫn của file
	 * @return
	 * @throws Exception
	 */
	public Instances loadData(String fileName) throws Exception {
		dataSource = new DataSource(fileName);
		return dataSource.getDataSet();
	}

//	public Instances convertNumericToNominal(Instances data, String opt) throws Exception {
//		NumericToNominal numericToNominal = new NumericToNominal();
//
//		String[] option = Utils.splitOptions(opt);
//		numericToNominal.setOptions(option);
//		numericToNominal.setInputFormat(data);
//
//		return Filter.useFilter(data, numericToNominal);
//	}
}
