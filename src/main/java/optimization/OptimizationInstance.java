package optimization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Machine;
import model.TreeNode;

import java.util.Map.Entry;

/**
 * Class representing the optimization instance that will be used to maximize
 * ACM profit.
 */
public class OptimizationInstance {

	private static Logger LOG = LoggerFactory.getLogger(OptimizationInstance.class);

	private String instanceId;
	private int nbMachines;
	private int intialACMBudget;
	private int nbRestructuringDays;
	private List<Machine> machines;
	private List<List<Machine>> allPaths = new ArrayList<List<Machine>>();

	public OptimizationInstance(String instanceId, int nbMachines, int intialACMBudget, int nbRestructuringDays,
			List<Machine> machines) {

		this.instanceId = instanceId;
		this.nbMachines = nbMachines;
		this.intialACMBudget = intialACMBudget;
		this.nbRestructuringDays = nbRestructuringDays;
		this.machines = machines;
	}

	/**
	 * Method that maximizes the amount of money that ACM makes during the
	 * restructuring.
	 */
	public int maximizeProfit() {

		TreeMap<Integer, List<Machine>> filteredMachines = filterMachinesBySaleDay();

		contructDecisionTree(filteredMachines);
		
		int maxProfit = intialACMBudget;

		for (List<Machine> path : allPaths) {
			int profit = computeProfit(path);
			if (maxProfit < profit) {
				maxProfit = profit;
			}
		}

		LOG.info(instanceId + ": " + maxProfit);

		return maxProfit;
	}

	/**
	 * Method that constructs the decision tree and all possible paths that can
	 * be simulated.
	 * 
	 * @param filteredMachines
	 */
	private void contructDecisionTree(TreeMap<Integer, List<Machine>> filteredMachines) {

		Map<Machine, TreeNode> tree = new HashMap<>();

		// Construct decision tree.
		for (Entry<Integer, List<Machine>> oneDay : filteredMachines.entrySet()) {
			for (Machine parent : oneDay.getValue()) {
				List<Machine> children = new ArrayList<>();
				for (Entry<Integer, List<Machine>> entry2 : filteredMachines.entrySet()) {
					if (entry2.getKey() > oneDay.getKey()) {
						children.addAll(entry2.getValue());
					}
				}
				TreeNode node = new TreeNode(parent, children);
				tree.put(parent, node);
			}
		}

		// Looking for all possible paths.
		for (Entry<Machine, TreeNode> entry : tree.entrySet()) {
			List<Machine> path = new ArrayList<>();
			path.add(entry.getValue().getParent());
			allPaths.add(path);
			addChildren(tree, entry.getValue().getParent(), entry.getValue().getChildren(), path);
		}
	}

	/**
	 * Method that computes the profit of a given path. Infeasible paths have
	 * cost = 0.
	 * 
	 * @param path
	 * @return
	 */
	private int computeProfit(List<Machine> path) {

		int currentBudget = intialACMBudget;
		if (!path.isEmpty() && path.get(0).getSalePrice() <= currentBudget) {

			currentBudget -= path.get(0).getSalePrice();
			for (int index = 1; index < path.size(); index++) {

				int budgetOnResale = currentBudget + path.get(index - 1).getResalePrice();
				if (budgetOnResale < path.get(index).getSalePrice()) {
					return 0;
				} else {

					Machine oldMachine = path.get(index - 1);
					Machine newMachine = path.get(index);

					int diffDays = newMachine.getSaleDay() - oldMachine.getSaleDay() + 1;

					currentBudget += oldMachine.getResalePrice() + diffDays * oldMachine.getProfit()
							- newMachine.getSalePrice();
				}
			}

			int remainingDays = nbRestructuringDays - path.get(path.size() - 1).getSaleDay();
			Machine lastMachine = path.get(path.size() - 1);

			currentBudget += lastMachine.getResalePrice() + remainingDays * lastMachine.getProfit();
		}

		return currentBudget;
	}

	/**
	 * Recursive method to construct different possible paths.
	 * 
	 * @param tree
	 * 
	 * @param parent
	 * @param children
	 * @param path
	 */
	private void addChildren(Map<Machine, TreeNode> tree, Machine parent, List<Machine> children, List<Machine> path) {

		for (Machine child : children) {
			List<Machine> newPath = new ArrayList<Machine>();
			newPath.addAll(path);
			newPath.add(child);
			allPaths.add(newPath);
			if (!tree.get(child).getChildren().isEmpty()) {
				addChildren(tree, child, tree.get(child).getChildren(), newPath);
			}
		}
	}

	/**
	 * Method that filters different machines by day of sale.
	 */
	private TreeMap<Integer, List<Machine>> filterMachinesBySaleDay() {

		TreeMap<Integer, List<Machine>> filteredMachines = new TreeMap<Integer, List<Machine>>();

		for (Machine machine : machines) {

			if (filteredMachines.containsKey(machine.getSaleDay())) {
				List<Machine> linkedMachines = filteredMachines.get(machine.getSaleDay());
				linkedMachines.add(machine);

				filteredMachines.put(machine.getSaleDay(), linkedMachines);
			} else {
				List<Machine> linkedMachines = new ArrayList<>();
				linkedMachines.add(machine);

				filteredMachines.put(machine.getSaleDay(), linkedMachines);
			}
		}

		return filteredMachines;

	}

	public String getInstanceId() {
		return instanceId;
	}
}
