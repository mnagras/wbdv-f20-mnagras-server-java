package com.example.hw01.services;

import com.example.hw01.models.Widget;
import com.example.hw01.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
  @Autowired
  WidgetRepository widgetRepository;
  List<Widget> widgetList = new ArrayList<Widget>();
  {
    widgetList.add(new Widget("widget1", 123, "HTML", 2, "Hello World",
        "/topics", 50, 20, 20, "css", "", "", "345"));
    widgetList.add(new Widget("widget2", 234, "YOU_TUBE", 1, "Hello World",
        "/topics", 50, 20, 20, "css", "", "", "345"));
    widgetList.add(new Widget("widget3", 456, "HEADER", 4, "Hello World",
        "/topics", 50, 20, 20, "css", "", "", "345"));
    widgetList.add(new Widget("widget4", 765, "HTML", 2, "Hello World",
        "/topics", 50, 20, 20, "css", "", "", "678"));
    widgetList.add(new Widget("widget5", 678, "YOU_TUBE", 1, "Hello World",
        "/topics", 50, 20, 20, "css", "", "", "678"));
    widgetList.add(new Widget("widget6", 987, "HEADER", 4, "Hello World",
        "/topics", 50, 20, 20, "css", "", "", "678"));
  }
  public List<Widget> findWidgetsForTopic(String tid) {
    return widgetRepository.findWidgetsByTopic(tid);
    /*List<Widget> widgetsForTopic = new ArrayList<Widget>();
    for(Widget w: widgetList) {
      if (w.getTopicId().equals(tid)) {
        widgetsForTopic.add(w);
      }
    }

    widgetsForTopic.sort(Comparator.comparing(Widget::getWidgetOrder));

    return widgetsForTopic;

     */
  }

  public List<Widget> findAllWidgets() {
    return (List<Widget>) widgetRepository.findAll();
    // return widgetList;
  }


  public Widget findWidgetById(Integer widgetId) {
   return widgetRepository.findById(widgetId).get();
    /*
    for(Widget w: widgetList) {
      if (w.getId() == (widgetId)) {
        return w;
      }
    }
    return null;
    */

  }

  public Widget createWidget(Widget widget) {
    return widgetRepository.save(widget);
    /*
    Integer newId = (int) new Date().getTime();
    widget.setId(newId);
    widgetList.add(widget);
    return widget;

     */
  }

  public void deleteWidget(Integer widgetId) {
    widgetRepository.deleteById(widgetId);
    /*
    Widget u = null;
    for(Widget widget:widgetList) {
      if(widget.getId() == (widgetId)) {
        u = widget;
        widgetList.remove(u);
        return 1;
      }
    }
    return 0;
    */

  }

  public Widget updateWidget(Integer widgetId, Widget newWidget) {
    Widget widget = widgetRepository.findById(widgetId).get();
    widget.setName(newWidget.getName());
    return widgetRepository.save(newWidget);
    /*
    for (int i=0; i<widgetList.size(); i++) {
    Widget w = widgetList.get(i);
      if (w.getId() == (widgetId)) {
        widgetList.remove(i);
        widgetList.add(i, newWidget);
        return 1;
      }
    }
    return 0;

     */
  }
}
