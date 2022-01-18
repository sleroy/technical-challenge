package com.example.labs.model;

import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a example container of tasks that is used to fill the table. You may create another one to implement your "dynamic task
 * model"
 */
public class TodoDemoListModel extends AbstractTableModel {

    private final List<Task> tasks = new ArrayList<Task>();

    //TODO:: TO BE REMOVED
    {
        tasks.add(new Task("example1"));
        tasks.add(new Task("example2"));
        tasks.add(new Task("example3"));
        tasks.add(new Task("example4"));
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        Task t = tasks.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getCreatedAt().format(DateTimeFormatter.ISO_DATE_TIME);
            case 1:
                return t.getTaskName();
            case 2:
                return t.getStatus();
            default:
                return "Unsupported";
        }
    }

    @Override
    public String getColumnName(final int column) {
        switch (column) {
            case 0:
                return "Created at";
            case 1:
                return "Task";
            case 2:
                return "Status";
            default:
                return super.getColumnName(column);
        }
    }
}
