/**
 * 
 */
package lab04_la07;

import weka.associations.FPGrowth;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * @author NguyenHung
 *
 * 
 */
public class FPGrowthModel {
	DataSource dataSource;
	FPGrowth fpGrowth;

	/**
	 * 
	 */
	public FPGrowthModel() {
		fpGrowth = new FPGrowth();
	}

	@Override
	public String toString() {
		return fpGrowth.toString();
	}
	
	/**
	 *  Khai thác dữ liệu sử dụng thuật toán FP-Growth
	 * @param model_opt tham số để tìm luật
	 * @param data
	 * @throws Exception
	 */
	public void mineFPGrowth(String model_opt, Instances data) throws Exception {
		String[] option = Utils.splitOptions(model_opt);

		fpGrowth.setOptions(option);
		fpGrowth.buildAssociations(data);
	}
	
	/**
	 *  lấy file dữ liệu, mặc định là file .arff
	 * @param fileName đư�?ng dẫn của file
	 * @return
	 * @throws Exception
	 */
	public Instances loadData(String fileName) throws Exception {
		dataSource = new DataSource(fileName);
		return dataSource.getDataSet();
	}
}
