package optimization;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Machine;

/**
 * A Class that constructs optimization instances from a file.
 *
 */
public class OptimizationInstanceFileBuilder {

	private static final Logger LOG = LoggerFactory.getLogger(OptimizationInstanceFileBuilder.class);

	public static List<OptimizationInstance> buildInstances(String filePath) {

		// This will reference one line at a time
		String line = null;
		List<OptimizationInstance> instances = new ArrayList<>();

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(filePath);

			// Always wrap FileReader in BufferedReader to improve efficiency.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			int nbMachines = 0;
			int budget = 0;
			int nbDays = 0;
			int index = 0;
			List<Machine> machines = new ArrayList<Machine>();

			while ((line = bufferedReader.readLine()) != null) {
				
				if (line.equals("0 0 0")) {
					if (nbMachines > 0 || budget > 0 || nbDays > 0) {
						instances.add(new OptimizationInstance("case " + index, nbMachines, budget, nbDays, machines));
					}
					break;
				}

				String[] splitLine = line.split(" ");
				if (splitLine.length == 3) {

					if (nbMachines > 0 || budget > 0 || nbDays > 0) {
						instances.add(new OptimizationInstance("case " + index, nbMachines, budget, nbDays, machines));
					}
					nbMachines = Integer.parseInt(splitLine[0]);
					budget = Integer.parseInt(splitLine[1]);
					nbDays = Integer.parseInt(splitLine[2]);
					machines = new ArrayList<Machine>();
					index++;

				} else if (splitLine.length == 4) {

					int saleDay = Integer.parseInt(splitLine[0]);
					int salePrice = Integer.parseInt(splitLine[1]);
					int resalePrice = Integer.parseInt(splitLine[2]);
					int profit = Integer.parseInt(splitLine[3]);

					machines.add(new Machine(saleDay, salePrice, resalePrice, profit));

				}
			}

			// Always close files.
			bufferedReader.close();

		} catch (FileNotFoundException ex) {
			LOG.error("Unable to open file '" + filePath + "'");
		} catch (NumberFormatException ex) {
			LOG.error("Wrong integer format in file '" + filePath + "'");
		} catch (IOException ex) {
			LOG.error("Error reading file '" + filePath + "'");
		}

		return instances;
	}
}
