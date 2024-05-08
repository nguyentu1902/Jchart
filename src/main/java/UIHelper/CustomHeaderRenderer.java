/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UIHelper;

/**
 *
 * @author User
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomHeaderRenderer extends DefaultTableCellRenderer {

    private Color backgroundColor;
    private Color textColor;
    private Font textFont;

    public CustomHeaderRenderer() {
    }

    public CustomHeaderRenderer(Color backgroundColor, Color textColor, Font textFont) {
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.textFont = textFont;
    }

    public CustomHeaderRenderer(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public CustomHeaderRenderer(Font textFont) {
        this.textFont = textFont;
    }

    public CustomHeaderRenderer(Color backgroundColor, Font textFont) {
        this.backgroundColor = backgroundColor;
        this.textFont = textFont;
    }

    public CustomHeaderRenderer(Color backgroundColor, Color textColor) {
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (table != null && table.getTableHeader() != null) {
            setBackground(backgroundColor);
            setForeground(textColor);
            setFont(textFont);
        }

        return this;
    }

    // Set background color
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    // Set text color
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    // Set font
    public void setTextFont(Font textFont) {
        this.textFont = textFont;
    }
}
