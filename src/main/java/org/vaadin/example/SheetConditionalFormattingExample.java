package org.vaadin.example;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.spreadsheet.Spreadsheet;
import com.vaadin.flow.router.Route;
import org.apache.poi.ss.usermodel.ComparisonOperator;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellRangeAddress;

@Route
public class SheetConditionalFormattingExample extends VerticalLayout {

    public SheetConditionalFormattingExample() {
        this.setSizeFull();

        Spreadsheet spreadsheet = new Spreadsheet();
        spreadsheet.setSizeFull();

        add(spreadsheet);

        spreadsheet.createCell(0, 0, "-1");

        SheetConditionalFormatting sheetCF = spreadsheet.getActiveSheet().getSheetConditionalFormatting();
        ConditionalFormattingRule rule = sheetCF.createConditionalFormattingRule(ComparisonOperator.LT, "0");

        FontFormatting fontFmt = rule.createFontFormatting();
        fontFmt.setFontStyle(true, true);
        fontFmt.setFontColorIndex(IndexedColors.RED.index);

        ConditionalFormattingRule[] cfRules = new ConditionalFormattingRule[]{rule};

        CellRangeAddress[] regions = {CellRangeAddress.valueOf("A1:D10")};
        sheetCF.addConditionalFormatting(regions, cfRules);
    }
}
