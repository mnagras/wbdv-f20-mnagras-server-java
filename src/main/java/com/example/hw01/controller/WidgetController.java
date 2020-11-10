package com.example.hw01.controller;

import com.example.hw01.models.Widget;
import com.example.hw01.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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

public class WidgetController {
  @Autowired
  WidgetService service;

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(@PathVariable("tid") String topicId) {
    return service.findWidgetsForTopic(topicId);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(@PathVariable("wid") Integer widgetId) {
    return service.findWidgetById(widgetId);
  }
  @PostMapping("/api/topics/{topicId}/widgets")
  public Widget createWidget(@PathVariable("topicId") String topicId, @RequestBody Widget widget) {
    widget.setTopicId(topicId);
    return service.createWidget(widget);
  }
  @DeleteMapping("/api/widgets/{wid}")
  public void deleteWidget(@PathVariable("wid") Integer widgetId) {
     service.deleteWidget(widgetId);
  }
  @PutMapping("/api/widgets/{wid}")
  public Widget updateWidget(@PathVariable("wid") Integer widgetId, @RequestBody Widget newWidget) {
    return service.updateWidget(widgetId, newWidget);
  }
}
