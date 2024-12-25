package li.controller;
import li.model.Shuju;
import li.model.Shuju2;
import li.model.shuju3;
import li.repository.Shuju2Repository;
import li.repository.ShujuRepository;
import li.service.shujuService.ShujuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@RestController
@RequestMapping("/api")
public class ShujuController {

    @Autowired
    private ShujuService shujuService;
    @GetMapping("/shuju")
    public List<shuju3> getAllShujuData() {
        return shujuService.getAllShujuData();
    }
    @GetMapping("/shuju/search")
    public List<shuju3> searchShujuData(@RequestParam("query") String query) {
        return shujuService.searchShujuData(query);
    }
    // 新增删除路由
    @DeleteMapping("/shuju/{id}")
    public void deleteShujuData(@PathVariable("id") int id) {
        shujuService.deleteShujuData(id);
    }


    @GetMapping("/shuju/export")
    public ResponseEntity<InputStreamResource> exportShujuData() {
        List<shuju3> shujuData = shujuService.getAllShujuData();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Shuju");

        // 创建标题行
        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("id");
        titleRow.createCell(1).setCellValue("name");
        titleRow.createCell(2).setCellValue("density");
        titleRow.createCell(3).setCellValue("length");
        titleRow.createCell(4).setCellValue("connectedVillages");
        titleRow.createCell(5).setCellValue("level");
        titleRow.createCell(6).setCellValue("start");

        // 填充数据行
        int rowNum = 1;
        for (shuju3 data : shujuData) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(data.getId());
            row.createCell(1).setCellValue(data.getName());
            row.createCell(2).setCellValue(data.getDensity());
            row.createCell(3).setCellValue(data.getLength());
            row.createCell(4).setCellValue(data.getCount());
            row.createCell(5).setCellValue(data.getLevel());
            row.createCell(6).setCellValue(data.getStart());
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(bos.toByteArray()));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=shuju.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}


