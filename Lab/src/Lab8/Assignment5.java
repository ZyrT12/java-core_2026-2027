package Lab8;

import Lab8.files.Birthday;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Assignment5 {
    public static void main(String[] args) {
        System.out.println("Задание 5. Доработка Excel-парсера");

        File file = new File("Lab/src/Lab8/files/birthdays.xlsx");
        try {
            if (!file.exists()) {
                createBirthdayExcel(file);
            }

            readExcelFile(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + file.getPath());
        } catch (InvalidFormatException e) {
            System.out.println("Неверный формат Excel-файла.");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка обработки Excel-файла: " + e.getMessage());
        }
    }

    private static void createBirthdayExcel(File file) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Birthdays");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Имя");
            header.createCell(1).setCellValue("Фамилия");
            header.createCell(2).setCellValue("Дата рождения");
            header.createCell(3).setCellValue("Возраст");
            header.createCell(4).setCellValue("Телефон");

            int rowIndex = 1;
            for (Birthday birthday : Birthday.getDefaultBirthdays()) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(birthday.getName());
                row.createCell(1).setCellValue(birthday.getSurname());
                row.createCell(2).setCellValue(birthday.getBirthDate());
                row.createCell(3).setCellValue(birthday.getAge());
                row.createCell(4).setCellValue(birthday.getPhone());
            }

            try (FileOutputStream outputStream = new FileOutputStream(file)) {
                workbook.write(outputStream);
            }
        }
    }

    private static void readExcelFile(File file) throws Exception {
        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
            Sheet sheet = workbook.getSheet("Birthdays");
            if (sheet == null) {
                System.out.println("Лист Birthdays отсутствует.");
                return;
            }

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    System.out.println(row.getCell(0).getStringCellValue() + " "
                            + row.getCell(1).getStringCellValue() + ", "
                            + row.getCell(2).getStringCellValue() + ", "
                            + (int) row.getCell(3).getNumericCellValue() + " лет, "
                            + row.getCell(4).getStringCellValue());
                }
            }
        }
    }
}
