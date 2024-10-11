import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Locale;

public class GeneratePDF {
    GeneratePDF(String CardNumber) {
        try {
            long currentBal = 0;
            // Database connection
            ConnToDB obj = new ConnToDB();
            ResultSet records = obj.st.executeQuery("SELECT date, type, amount FROM bank");

            String pdfPath = "E:/ATM_Simulation_System/Invoices/" + CardNumber + ".pdf";

            // Creating a PDF document
            PdfWriter writer = new PdfWriter(pdfPath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            String imagePath = "E:/ATM_Simulation_System/Application/src/Images/Melogo.png";
            ImageData imageData = ImageDataFactory.create(imagePath);
            Image image = new Image(imageData);
            image.scaleToFit(pdf.getDefaultPageSize().getWidth() - 300, pdf.getDefaultPageSize().getHeight() / 10);
            image.setHorizontalAlignment(HorizontalAlignment.RIGHT);

            Paragraph heading = new Paragraph("Transaction Receipt")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(20)
                    .setBold();
            document.add(heading);

            // Adding some space after the heading
            document.add(new Paragraph("\n\n"));

            // Creating a table with 3 columns (Date, Type, Amount)
            Table table = new Table(new UnitValue[] { UnitValue.createPercentValue(40), UnitValue.createPercentValue(25), UnitValue.createPercentValue(35) });
            table.addHeaderCell(new Cell().add(new Paragraph("Date")).setBold().setBorder(Border.NO_BORDER));
            table.addHeaderCell(new Cell().add(new Paragraph("Type")).setBold().setBorder(Border.NO_BORDER));
            table.addHeaderCell(new Cell().add(new Paragraph("Amount")).setBold().setBorder(Border.NO_BORDER));

            // Looping through the ResultSet and adding cells to the table
            while (records.next()) {
                String date = records.getString("date");
                String type = records.getString("type");
                long amount = records.getLong("amount");

                // Adding transaction details to the table
                table.addCell(new Cell().add(new Paragraph(date)));
                table.addCell(new Cell().add(new Paragraph(type)));
                table.addCell(new Cell().add(new Paragraph(formatInIndianNumberSystem(amount)+ "/-")));

                // Calculating current balance based on transaction type
                if (type.equalsIgnoreCase("Deposit")) {
                    currentBal += amount;
                } else if (type.equalsIgnoreCase("Withdrawal")) {
                    currentBal -= amount;
                }
            }

            // Adding the balance row at the end
            table.addCell(new Cell(1, 2).add(new Paragraph("Current Balance")).setBold());
            table.addCell(new Cell().add(new Paragraph(formatInIndianNumberSystem(currentBal)+ "/-")));

            document.add(table);
            document.add(image);
            document.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Utility method to format numbers in Indian number system
    private String formatInIndianNumberSystem(long amount) {
        NumberFormat indianFormat = NumberFormat.getInstance(new Locale("en", "IN"));
        return indianFormat.format(amount);
    }
}