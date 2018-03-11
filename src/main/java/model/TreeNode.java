package model;

import java.util.List;

public class TreeNode {

	private Machine parent;
	private List<Machine> children;

	public TreeNode(Machine parent, List<Machine> children) {
		this.parent = parent;
		this.children = children;
	}

	public Machine getParent() {
		return parent;
	}

	public List<Machine> getChildren() {
		return children;
	}

	@Override
	public String toString() {
		return parent.toString() + children.toString();
	}
}
