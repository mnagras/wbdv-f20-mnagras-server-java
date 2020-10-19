package com.example.hw01.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.example.hw01.models.Course;
import com.example.hw01.models.Module;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/{courseId}/modules")
public class ModuleController {
  static List<Module> modules = new ArrayList<Module>();
  static {
    modules.add(new Module((int) (new Date()).getTime(), "Module 1"));
    modules.add(new Module((int) (new Date()).getTime() + 1, "Module 2"));
    modules.add(new Module((int) (new Date()).getTime() + 2, "Module 3"));
    modules.add(new Module((int) (new Date()).getTime() + 3, "Module 4"));
  }



  @DeleteMapping("/{moduleId}")
  public List<Module> deleteModule(@PathVariable int moduleId) {
    Module u = null;
    for(Module module:modules) {
      if(module.getModuleId() == moduleId) {
        u = module;
        modules.remove(u);
        break;
      }
    }
    return modules;
  }

  @PutMapping
  public List<Module> updateModule(@RequestBody Module module) {
    for (int i=0; i<modules.size(); i++) {
      int moduleId = modules.get(i).getModuleId();
      if (module.getModuleId() == moduleId) {
        modules.remove(i);
        modules.add(i, module);
        //System.out.println("Updated module title:" + module.getTitle());
        break;
      }
    }
    return modules;
  }


  @GetMapping("/{moduleId}")
  public Module findModuleById(@PathVariable int moduleId) {
    Module u = null;
    for(Module module:modules) {
      if(module.getModuleId() == moduleId) {
        return module;
      }
    }
    return u;
  }
}




