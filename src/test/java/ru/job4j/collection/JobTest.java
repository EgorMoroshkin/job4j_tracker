package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    public void whenAscSortByName() {
        List<Job> jobs = Arrays.asList(
                new Job("fix bug", 40),
                new Job("send mail", 18),
                new Job("add task", 56)
        );
        List<Job> expected = Arrays.asList(
                new Job("add task", 56),
                new Job("fix bug", 40),
                new Job("send mail", 18)
        );
        jobs.sort(new SortAscByNameJob());
        assertEquals(expected, jobs);
    }

    @Test
    public void whenDescSortByName() {
        List<Job> jobs = Arrays.asList(
                new Job("send mail", 18),
                new Job("add task", 56),
                new Job("fix bug", 40)
        );
        List<Job> expected = Arrays.asList(
                new Job("send mail", 18),
                new Job("fix bug", 40),
                new Job("add task", 56)
        );
        jobs.sort(new SortDescByNameJob());
        assertEquals(expected, jobs);
    }

    @Test
    public void whenAscSortByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("send mail", 18),
                new Job("add task", 56),
                new Job("fix bug", 40)
        );
        List<Job> expected = Arrays.asList(
                new Job("send mail", 18),
                new Job("fix bug", 40),
                new Job("add task", 56)
        );
        jobs.sort(new JobAscByPriority());
        assertEquals(expected, jobs);
    }

    @Test
    public void whenDescSortByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("send mail", 18),
                new Job("add task", 56),
                new Job("fix bug", 40)
        );
        List<Job> expected = Arrays.asList(
                new Job("add task", 56),
                new Job("fix bug", 40),
                new Job("send mail", 18)
        );
        jobs.sort(new JobDescByPriority());
        assertEquals(expected, jobs);
    }

    @Test
    public void whenCompatorByNameAscAndPrority() {
        Comparator<Job> cmpNamePriority = new SortAscByNameJob().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("add task", 0),
                new Job("fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameEquelsAndAscPrority() {
        Comparator<Job> cmpNamePriority = new SortAscByNameJob().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("add task", 0),
                new Job("add task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameDescAndPrority() {
        Comparator<Job> cmpNamePriority = new SortDescByNameJob().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("add task", 0),
                new Job("fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByNameEquelsAndDescPrority() {
        Comparator<Job> cmpNamePriority = new SortDescByNameJob().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("fix bug", 0),
                new Job("fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}