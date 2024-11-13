package org.vaadin.example;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.spreadsheet.Spreadsheet;
import com.vaadin.flow.router.Route;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

@Route
public class DataFormatExample extends VerticalLayout {

    public DataFormatExample() {
        this.setSizeFull();

        Spreadsheet spreadsheet = new Spreadsheet();
        spreadsheet.setSizeFull();

        CellStyle cellStyle = spreadsheet.getWorkbook().createCellStyle();
        org.apache.poi.ss.usermodel.DataFormat dataFormat = spreadsheet.getWorkbook().createDataFormat();
        cellStyle.setDataFormat(dataFormat.getFormat("#,##0_);[Red](#,##0)"));

        Cell cell = spreadsheet.createCell(0, 0, "-1");
        cell.setCellStyle(cellStyle);

        add(spreadsheet);
    }
}
