package com.leumi.springboot3demo.run;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.el.ELException;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RequestMapping("/api/runs")
@RestController
public class RunController {
  private final RunRepository runRepository;

  public RunController(RunRepository repo) {
    this.runRepository = repo;
  }

  @GetMapping("")
  List<Run> getAll() {

    return runRepository.findAll();
  }

  @GetMapping("/{id}")
  public Run findById(@PathVariable Integer id) {
    Optional<Run> run = runRepository.findById(id);
    if (run.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return run.get();
  }

  //post
  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  void create(@RequestBody Run run) {
      runRepository.create(run);
  }
  


  //put
  @PutMapping("/{id}")
void update(@PathVariable String id, @RequestBody Run run) {
    runRepository.update(run, Integer.valueOf(id));
}

  //delete
  @DeleteMapping("/{id}")
  void delete(@PathVariable String id) {
    runRepository.delete(Integer.valueOf(id));
  }
}
