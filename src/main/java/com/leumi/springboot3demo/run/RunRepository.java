package com.leumi.springboot3demo.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.leumi.springboot3demo.utils.ObjectTools;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
  private List<Run> runs = new ArrayList<>();

  List<Run> findAll() {
    return runs;
  }

  Optional<Run> findById(Integer id) {
    return runs.stream()
        .filter(run -> run.id() == id)
        .findFirst();
  }
  
  void create(Run run) {
    runs.add(run);
  }

  void update(Run run, Integer id) {
    Optional<Run> existingRun = findById(id);
    if (existingRun.isPresent()) {
      runs.set(runs.indexOf(existingRun.get()), run);
    } else {
      String[] newParams = { "id", id.toString() };
      ObjectTools.updateObject(run, newParams);
      runs.add(run);
    }
  }

  void delete(Integer id) {
    Optional<Run> existingRun = findById(id);
    if (existingRun.isPresent()) {
      runs.remove(runs.indexOf(existingRun.get()));
    } 
  }

  /* for testing we can construct a mock data after spring is already running */

  @PostConstruct
  private void init() {
    runs.add(new Run(1, "first run", LocalDateTime.now(), LocalDateTime.now().plus(2, ChronoUnit.HOURS), 20,
        Location.OUTDOOR));
    runs.add(new Run(2, "second run", LocalDateTime.now().plus(2,ChronoUnit.DAYS), 
        LocalDateTime.now().plus(2, ChronoUnit.DAYS).plus(2, ChronoUnit.HOURS),
        20,Location.INDOOR));
  }
}
