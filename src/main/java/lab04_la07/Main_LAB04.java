package lab04_la07;

import weka.core.Instances;

/**
 * @author NguyenHung
 *
 * 
 */
public class Main_LAB04 {
	public static void main(String[] args) throws Exception {

		// Khai báo chung
		HandleData handleData = new HandleData();
		HandleFile handleFile = new HandleFile();

//		______________________________________________________

		// weather
//		AprioriModel aprioriModel = new AprioriModel();
//		Instances dataApriori1 = handleFile.loadArff("C:\\Program Files\\Weka-3-8-5\\data\\weather.nominal.arff");
//		dataApriori1 = handleData.numericToNominal(dataApriori1, "-R first-last");
//		aprioriModel.mineApriori("-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1", dataApriori1);
//		System.out.println(aprioriModel.toString());

//		______________________________________________________

//		FPGrowthModel fpGrowth1 = new FPGrowthModel();
//		Instances dataCsv = handleFile.loadCsv(".\\data\\csv\\Tuan02.csv");
//		dataCsv = handleData.nominalToBinary(dataCsv, "-N -R first-last");
//		fpGrowth1.mineFPGrowth("-P 2 -I -1 -N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1", dataCsv);
//		System.out.println("fpGrowth 1: \n" + fpGrowth1.toString());
//		handleFile.saveCsv(".\\data\\result\\Tuan02.csv", dataCsv);

//		______________________________________________________

		// weather
//		FPGrowthModel fpGrowth2 = new FPGrowthModel();
//		Instances dataFP = handleFile.loadArff(".\\data\\dataWeka\\weather.nominal.arff");
//		dataFP = handleData.nominalToBinary(dataFP, "-N -R first-last");
//		fpGrowth2.mineFPGrowth("-P 2 -I -1 -N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1", dataFP);
//		System.out.println("fpGrowth 2: \n" + fpGrowth2.toString());
//		handleFile.saveArff(".\\data\\result\\weatherFP-Growth.arff", dataFP);

//		______________________________________________________

		// supermarket
		FPGrowthModel fpGrowth3 = new FPGrowthModel();
		Instances dataSupermarket = handleFile.loadArff(".\\data\\dataWeka\\supermarket.arff");
		dataSupermarket = handleData.removeByName(dataSupermarket, "^department\\d+$");
		dataSupermarket = handleData.nominalToBinary(dataSupermarket, "-N -R first-last");
		fpGrowth3.mineFPGrowth("-P 2 -I -1 -N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1", dataSupermarket);
		System.out.println("fpGrowth 3: \n" + fpGrowth3.toString());
		handleFile.saveArff(".\\data\\result\\supermarketFP.arff", dataSupermarket);

		
		
		
	}
}
