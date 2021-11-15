/**
 * 
 */
package demo;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.CSVSaver;

/**
 * @author NguyenHung
 *
 * 
 */
public class HandleFile {
	private CSVLoader csvLoader;
	private Instances dataset;

	public HandleFile() {

	}

	public Instances loadCsv(String fileName) throws IOException {

		csvLoader = new CSVLoader();
		csvLoader.setSource(new File(fileName));
		dataset = csvLoader.getDataSet();
		return dataset;
	}

	public Instances loadArff(String fileName) throws IOException {

		ArffLoader arffLoader = new ArffLoader();
		arffLoader.setSource(new File(fileName));
		dataset = arffLoader.getDataSet();
		return dataset;
	}

	public void saveArff(String fileName, Instances data) throws IOException {
		ArffSaver arffSaver = new ArffSaver();
		arffSaver.setInstances(data);
		arffSaver.setFile(new File(fileName));
		arffSaver.writeBatch();
	}
	
	public void saveCsv(String fileName, Instances data) throws IOException {
		CSVSaver csvSaver = new CSVSaver();
		csvSaver.setInstances(data);
		csvSaver.setFile(new File(fileName));
		csvSaver.writeBatch();
	}

	public String toStringCSV() {
		return dataset.toSummaryString();
	}

}
