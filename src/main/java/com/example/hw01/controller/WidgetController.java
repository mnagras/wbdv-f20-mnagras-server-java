package com.example.hw01.controller;

import com.example.hw01.models.Widget;
import com.example.hw01.services.WidgetService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin("http://localhost:3000")
@RequestMapping ("/api")
public class WidgetController {
  List<Widget> widgetList = new ArrayList<Widget>();
  WidgetService service = new WidgetService();

  @GetMapping("/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(@PathVariable("tid") String topicId) {
    return service.findWidgetsForTopic(topicId);
  }

  @GetMapping("/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/widgets/{wid}")
  public Widget findWidgetById(@PathVariable("wid") String widgetId) {
    return service.findWidgetById(widgetId);
  }
  @PostMapping("/widgets")
  public Widget createWidget(@RequestBody Widget widget) {
    return service.createWidget(widget);
  }
  @DeleteMapping("/widgets/{wid}")
  public Integer deleteWidget(int widgetId) {
    return null;
  }
  @PutMapping("/widgets/{wid}")
  public Integer updateWidget(int widgetId, Widget newWidget) {
    return null;
  }
}
