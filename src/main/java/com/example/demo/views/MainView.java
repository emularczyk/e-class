package com.example.demo.views;

import com.example.demo.grade.Grade;
import com.example.demo.grade.GradeService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("E-class")
@Route("")
class MainView extends VerticalLayout {
    Grid<Grade> grid = new Grid<>(Grade.class);
    private GradeService gradeService;

    public MainView(GradeService gradeService) {
        this.gradeService = gradeService;
        addClassName("main-view");
        setSizeFull();

        configureGrid();
        
        add(grid);

        updateList();
    }

    private void updateList() {
        grid.setItems(gradeService.getAllGrades());
    }

    private void configureGrid() {
        grid.addClassName("grade-grid");
        grid.setSizeFull();
        grid.setColumns("gradeType", "gradeValue", "date", "weight");
        grid.getColumnByKey("gradeType").setHeader("Type");
        grid.getColumnByKey("gradeValue").setHeader("Value");
        grid.getColumnByKey("date").setHeader("Date");
        grid.getColumnByKey("weight").setHeader("Weight");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
}