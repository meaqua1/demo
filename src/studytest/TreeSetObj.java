package studytest;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetObj {


    public static void main(String[] args) {
        TreeSet<person> ts = new TreeSet(new Mycom());
        ts.add(new person("a"));
        ts.add(new student("aa"));
        ts.add(new student("aaa"));
        print(ts);
    }

    public static void print(TreeSet<? extends person> treeSet) {
        Iterator<? extends person> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }

    }

}

class Mycom implements Comparator<person> {


    @Override
    public int compare(person o1, person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class nvwa{

}

class person extends nvwa{
    private String name;

    public person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class student extends person {

    public student(String name) {
        super(name);
    }

}