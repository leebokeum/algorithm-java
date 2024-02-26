package graph.Q7.mySolution;

import java.util.HashMap;

public class ProjectManager {
    private HashMap<String, Project> projects;

    public ProjectManager(String[] names, String[][] dependencies) {
        buildProjects(names);
        addDependencies(dependencies);
    }

    public void buildProjects(String[] names) {
        projects = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            projects.put(names[i], new Project(names[i]));
        }
    }

    public void addDependencies(String[][] dependencies) {
        for (String[] dependency : dependencies) {
            Project before = findProject(dependency[0]);
            Project after = findProject(dependency[1]);
            after.addDependency(before);
        }
    }

    private int index;

    public Project[] buildOrder() {
        initMarkingFlages();
        Project[] ordered = new Project[this.projects.size()];
        index = 0;
        for (Project project : this.projects.values()) {
            buildOrder(project, ordered);
        }
        return ordered;
    }

    public void buildOrder(Project project, Project[] ordered) {
        if (!project.getDependencies().isEmpty()) {
            for (Project p : project.getDependencies()) {
                buildOrder(p, ordered);
            }
        }

        if (!project.getMarked()) {
            project.setMarked(true);
            ordered[index] = project;
            index++;
        }
    }

    private void initMarkingFlages () {
        for (Project project : this.projects.values()) {
            project.setMarked(false);
        }
    }

    public Project findProject(String name) {
        return projects.get(name);
    }
}

