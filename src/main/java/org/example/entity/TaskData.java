package org.example.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String assignee) {

        switch (assignee) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            default:
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                return allTasks;
        }
    }

    public Set<Task> getUnion(Set<Task>... sets) {

        Set<Task> result = new HashSet<>();

        for (Set<Task> taskSet : sets) {
            result.addAll(taskSet);
        }

        return result;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {

        // Yeni bir kopya alalim, originali genelde degistirmemeliyiz
        Set<Task> result = new HashSet<>(set1);

        // result'ta sadece set2'de olanlar kalsin
        result.retainAll(set2);

        // Sonuc -> Kesisim
        return result;
    }

    public Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {

        Set<Task> result = new HashSet<>(set1);

        result.removeAll(set2);

        return result;
    }
}
