package li.service;

import li.model.Shuju;
import li.model.Shuju2;
import li.repository.Shuju2Repository;
import li.repository.ShujuRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private ShujuRepository shujuRepository;

    public List<Shuju> readExcelData(MultipartFile file) {
        List<Shuju> shujuList = new ArrayList<>();
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // 跳过标题行
                Shuju shuju = new Shuju();
                shuju.setRoadName(row.getCell(1).getStringCellValue());
                shuju.setRoadLevel(row.getCell(5).getStringCellValue());
                // 假设Excel文件中的ID是自动生成的，不需要从文件中读取
                shujuList.add(shuju);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shujuList;
    }

    public void saveShujuList(List<Shuju> shujuList) {
        shujuRepository.saveAll(shujuList);
    }
    @Autowired
    private Shuju2Repository shuju2Repository;

    public List<Shuju2> readExcelDataForShuju2(MultipartFile file) {
        List<Shuju2> shuju2List = new ArrayList<>();
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue; // 跳过标题行
                }
                Shuju2 shuju2 = new Shuju2();
                shuju2.setDensity(row.getCell(2).getNumericCellValue());
                shuju2.setLength(row.getCell(3).getNumericCellValue());
                shuju2.setConnectedVillages((int) row.getCell(4).getNumericCellValue());
                shuju2.setRoadName(row.getCell(1).getStringCellValue());
                shuju2.setRoad_start(row.getCell(6).getStringCellValue());
                shuju2List.add(shuju2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shuju2List;
    }

    public void saveShuju2List(List<Shuju2> shuju2List) {
        shuju2Repository.saveAll(shuju2List);
    }
}
