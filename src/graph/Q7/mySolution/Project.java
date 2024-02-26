package graph.Q7.mySolution;

import java.util.LinkedList;

public class Project {
    private String name;
    private LinkedList<Project> dependencies;
    private boolean marked;

    public Project(String name) {
        this.name = name;
        this.marked = false;
        this.dependencies = new LinkedList<>();
    }

    public void addDependency(Project project) {
        if (!dependencies.contains(project)) {
            dependencies.add(project);
        }
    }

    public LinkedList<Project> getDependencies() {
        return this.dependencies;
    }

    public String getName() {
        return this.name;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean getMarked() {
        return this.marked;
    }
}

