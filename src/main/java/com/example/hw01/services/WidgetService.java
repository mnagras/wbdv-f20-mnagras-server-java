package com.example.hw01.services;

import com.example.hw01.models.Module;
import com.example.hw01.models.Widget;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class WidgetService {
  List<Widget> widgetList = new ArrayList<Widget>();
  {
    widgetList.add(new Widget("widget1", "123", "HTML", 2, "Hello World",
        "/topics", 50, 20, 20, "css", "", "", "345"));
    widgetList.add(new Widget("widget2", "234", "YOU_TUBE", 1, "Hello World",
        "/topics", 50, 20, 20, "css", "", "", "345"));
    widgetList.add(new Widget("widget3", "456", "HEADER", 4, "Hello World",
        "/topics", 50, 20, 20, "css", "", "", "345"));
    widgetList.add(new Widget("widget4", "765", "HTML", 2, "Hello World",
        "/topics", 50, 20, 20, "css", "", "", "678"));
    widgetList.add(new Widget("widget5", "678", "YOU_TUBE", 1, "Hello World",
        "/topics", 50, 20, 20, "css", "", "", "678"));
    widgetList.add(new Widget("widget6", "987", "HEADER", 4, "Hello World",
        "/topics", 50, 20, 20, "css", "", "", "678"));
  }
  public List<Widget> findWidgetsForTopic(String tid) {
    List<Widget> widgetsForTopic = new ArrayList<Widget>();
    for(Widget w: widgetList) {
      if (w.getTopicId().equals(tid)) {
        widgetsForTopic.add(w);
      }
    }
    return widgetsForTopic;
  }

  public List<Widget> findAllWidgets() {
    return widgetList;
  }


  public Widget findWidgetById(String widgetId) {
    for(Widget w: widgetList) {
      if (w.getId().equals(widgetId)) {
        return w;
      }
    }
    return null;
  }

  public Widget createWidget(Widget widget) {
    String newId = new Date().toString();
    widget.setId(newId);
    widgetList.add(widget);
    return widget;
  }

  public Integer deleteWidget(String widgetId) {
    Widget u = null;
    for(Widget widget:widgetList) {
      if(widget.getId().equals(widgetId)) {
        u = widget;
        widgetList.remove(u);
        return 1;
      }
    }
    return 0;
  }

  public Integer updateWidget(String widgetId, Widget newWidget) {
    for (int i=0; i<widgetList.size(); i++) {
    Widget w = widgetList.get(i);
      if (w.getId().equals(widgetId)) {
        widgetList.remove(i);
        widgetList.add(i, newWidget);
        return 1;
      }
    }
    return 0;
  }
}
