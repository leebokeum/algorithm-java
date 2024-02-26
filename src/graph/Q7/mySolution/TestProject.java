package graph.Q7.mySolution;

public class TestProject {
    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
            {"a", "d"},
            {"f", "b"},
            {"b", "d"},
            {"f", "a"},
            {"d", "c"}
        };

        // String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
        // String[][] dependencies = {
        //     {"f", "a"},
        //     {"f", "b"},
        //     {"f", "c"},
        //     {"b", "a"},
        //     {"c", "a"},
        //     {"a", "e"},
        //     {"b", "e"},
        //     {"d", "g"}
        // };

        ProjectManager pm = new ProjectManager(projects, dependencies);
        Project[] ps = pm.buildOrder();

        for (Project p : ps) {
            if (p != null) {
                System.out.print(p.getName() + " ");
            }
        }
    }
}
