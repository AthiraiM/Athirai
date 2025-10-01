package model;

import java.util.HashSet;
import java.util.Set;

public class Assignment {
    private final String details;
    private final Set<String> submissions = new HashSet<>();

    public Assignment(String details) {
        if (details == null || details.isBlank()) {
            throw new IllegalArgumentException("Assignment details cannot be empty");
        }
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void submit(String studentId) {
        submissions.add(studentId);
    }

    public boolean isSubmittedBy(String studentId) {
        return submissions.contains(studentId);
    }

    public Set<String> getSubmissions() {
        return new HashSet<>(submissions); // defensive copy
    }

    @Override
    public String toString() {
        return "Assignment{" + "details='" + details + '\'' + ", submissions=" + submissions + '}';
    }
}
