package li.controller;


import li.model.Shuju;
import li.model.Shuju2;
import li.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class DataImportController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/api/import")
    public String importData(@RequestParam("file") MultipartFile file) {
        List<Shuju> shujuList = excelService.readExcelData(file);
        excelService.saveShujuList(shujuList);
        return "导入成功";
    }
    @PostMapping("/api/import/shuju2")
    public String importShuju2Data(@RequestParam("file") MultipartFile file) {
        List<Shuju2> shuju2List = excelService.readExcelDataForShuju2(file);
        excelService.saveShuju2List(shuju2List);
        return "导入shuju2数据成功";
    }
}