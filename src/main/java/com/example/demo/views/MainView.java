package com.example.demo.views;

import com.example.demo.containers.SubjectGrades;
import com.example.demo.containers.SubjectGradesService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.bson.types.ObjectId;

@PageTitle("E-class")
@Route("")
class MainView extends VerticalLayout {
    Grid<SubjectGrades> table = new Grid<>(SubjectGrades.class);
    private SubjectGradesService subjectGradesService;

    public MainView(SubjectGradesService subjectGradesService) {
        this.subjectGradesService = subjectGradesService;
        addClassName("main-view");
        setSizeFull();

        ObjectId studentId = new ObjectId("65a564ddd4ddc470b4770e13"); // TODO: needs change
        H3 h3 = new H3("Student id = " + studentId);
        h3.getStyle().set("text-align", "center");
        add(h3);
        setAlignItems(Alignment.CENTER);

        createTable();
        add(table);

        updateList(studentId);
    }

    private void updateList(ObjectId studentId) {
        // todo in progress
        table.setItems(subjectGradesService.getAllSubjectGradesForStudent(studentId));
    }

    private void createTable() {
        table.addClassName("student-grades-table");
        table.setSizeFull();
        table.setColumns("subject", "gradeStringList", "average", "finalGrade");
        table.getColumnByKey("subject").setHeader("Subject");
        table.getColumnByKey("gradeStringList").setHeader("Grades");
        table.getColumnByKey("average").setHeader("Average");
        table.getColumnByKey("finalGrade").setHeader("Final grade");
        table.getColumns().forEach(col -> col.setAutoWidth(true));
    }

}