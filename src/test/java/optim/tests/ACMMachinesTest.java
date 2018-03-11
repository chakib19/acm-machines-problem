package optim.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import model.Machine;
import optimization.OptimizationInstance;
import optimization.OptimizationInstanceFileBuilder;

public class ACMMachinesTest {

	private static final Logger LOG = LoggerFactory.getLogger(ACMMachinesTest.class);

	@Test
	public void test1() {

		LOG.info("Testing case1:\n6 10 20\n6 12 1 3\n1 9 1 2\n3 2 1 2\n8 20 5 4\n4 11 7 4\n2 10 9 1");
		// 6 10 20
		// 6 12 1 3
		// 1 9 1 2
		// 3 2 1 2
		// 8 20 5 4
		// 4 11 7 4
		// 2 10 9 1

		int nbMachines = 6;
		int intialACMBudget = 10;
		int nbRestructuringDays = 20;

		List<Machine> machines = new ArrayList<>();
		machines.add(new Machine(6, 12, 1, 3));
		machines.add(new Machine(1, 9, 1, 2));
		machines.add(new Machine(3, 2, 1, 2));
		machines.add(new Machine(8, 20, 5, 4));
		machines.add(new Machine(4, 11, 7, 4));
		machines.add(new Machine(2, 10, 9, 1));

		OptimizationInstance optimInstance = new OptimizationInstance("case 1", nbMachines, intialACMBudget,
				nbRestructuringDays, machines);

		int maxProfit = optimInstance.maximizeProfit();

		Assert.assertEquals("max profit", maxProfit, 44);
	}

	@Test
	public void test2() {

		LOG.info("Testing case2:\n0 11 30");
		// 0 11 30

		int nbMachines = 0;
		int intialACMBudget = 11;
		int nbRestructuringDays = 30;

		List<Machine> machines = new ArrayList<>();

		OptimizationInstance optimInstance = new OptimizationInstance("case 2", nbMachines, intialACMBudget,
				nbRestructuringDays, machines);

		int maxProfit = optimInstance.maximizeProfit();

		Assert.assertEquals("max profit", maxProfit, 11);
	}

	@Test
	public void test3() {

		LOG.info("Testing case3:\n1 12 30\n30 10 5 3");		
		// 1 12 30
		// 30 10 5 3

		int nbMachines = 1;
		int intialACMBudget = 12;
		int nbRestructuringDays = 30;

		List<Machine> machines = new ArrayList<>();
		machines.add(new Machine(30, 10, 5, 3));

		OptimizationInstance optimInstance = new OptimizationInstance("case 3", nbMachines, intialACMBudget,
				nbRestructuringDays, machines);

		int maxProfit = optimInstance.maximizeProfit();

		Assert.assertEquals("max profit", maxProfit, 12);
	}

	@Test
	public void test4() {

		LOG.info("Testing case4:\n1 10 2\n1 10 2 1");

		int nbMachines = 1;
		int intialACMBudget = 10;
		int nbRestructuringDays = 2;

		List<Machine> machines = new ArrayList<>();
		machines.add(new Machine(1, 10, 2, 1));

		OptimizationInstance optimInstance = new OptimizationInstance("case 4", nbMachines, intialACMBudget,
				nbRestructuringDays, machines);

		int maxProfit = optimInstance.maximizeProfit();

		Assert.assertEquals("max profit", maxProfit, 10);
	}

	@Test
	public void test5() {

		LOG.info("Testing case5:\n2 10 11\n1 10 4 3\n1 10 9 3");
		// 2 10 11
		// 1 10 4 3
		// 1 10 9 3

		int nbMachines = 2;
		int intialACMBudget = 10;
		int nbRestructuringDays = 11;

		List<Machine> machines = new ArrayList<>();
		machines.add(new Machine(1, 10, 4, 3));
		machines.add(new Machine(1, 10, 9, 3));

		OptimizationInstance optimInstance = new OptimizationInstance("case 5", nbMachines, intialACMBudget,
				nbRestructuringDays, machines);

		int maxProfit = optimInstance.maximizeProfit();

		Assert.assertEquals("max profit", maxProfit, 39);
	}

	@Test
	public void test6() {

		LOG.info("Testing case6:\n2 10 11\n1 10 9 3\n1 10 4 3");
		// 2 10 11
		// 1 10 9 3
		// 1 10 4 3

		int nbMachines = 2;
		int intialACMBudget = 10;
		int nbRestructuringDays = 11;

		List<Machine> machines = new ArrayList<>();
		machines.add(new Machine(1, 10, 9, 3));
		machines.add(new Machine(1, 10, 4, 3));

		OptimizationInstance optimInstance = new OptimizationInstance("case 6", nbMachines, intialACMBudget,
				nbRestructuringDays, machines);

		int maxProfit = optimInstance.maximizeProfit();

		Assert.assertEquals("max profit", maxProfit, 39);
	}

	@Test
	public void testFromFile() {

		String filePath = "src/test/resources/scenarios.txt";

		LOG.info("Testing from file: " + filePath);

		List<OptimizationInstance> instances = OptimizationInstanceFileBuilder.buildInstances(filePath);

		Map<String, Integer> expectedResults = new HashMap<String, Integer>();
		expectedResults.put("case 1", 44) ;
		expectedResults.put("case 2", 11) ;
		expectedResults.put("case 3", 12) ;
		expectedResults.put("case 4", 10) ;
		expectedResults.put("case 5", 39) ;
		expectedResults.put("case 6", 39) ;


		
       
		for (OptimizationInstance instance : instances) {
			instance.maximizeProfit();
		}
	}
}
