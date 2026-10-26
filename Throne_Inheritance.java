import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ThroneInheritance {
    class Person {
        String name;
        boolean isDead;
        List<Person> children;
        
        public Person(String name) {
            this.name = name;
            this.isDead = false;
            this.children = new ArrayList<>();
        }
    }
    
    private Person king;
    private Map<String, Person> familyTree;

    public ThroneInheritance(String kingName) {
        king = new Person(kingName);
        familyTree = new HashMap<>();
        familyTree.put(kingName, king);
    }
    
    public void birth(String parentName, String childName) {
        Person parent = familyTree.get(parentName);
        Person child = new Person(childName);
        parent.children.add(child);
        familyTree.put(childName, child);
    }
    
    public void death(String name) {
        familyTree.get(name).isDead = true;
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }
    
    private void dfs(Person current, List<String> order) {
        if (!current.isDead) {
            order.add(current.name);
        }
        for (Person child : current.children) {
            dfs(child, order);
        }
    }
}
