package cn.fishmaple.logsight.api;

import cn.fishmaple.logsight.service.setting.SettingFieldFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/logField")
public class LogFieldAPI {
    @Autowired
    SettingFieldFileService settingFieldFileService;

    @RequestMapping("page")
    public Map<String,Object> download(@RequestParam String sortType,@RequestParam int sortd,@RequestParam int p){
        Map<String,Object> map = new HashMap<>();
        map.put("logFields", settingFieldFileService.getPagesLogField(p,sortd,sortType,8));
        map.put("pages", settingFieldFileService.getLogfieldPages(8));
        return map;
    }

    @RequestMapping("{fieldId}/file")
    public Map<String,Object> fieldFile(@PathVariable Integer fieldId ,@RequestParam(required = false) Integer p,
                                        @RequestParam(required = false) String searchContent,@RequestParam(defaultValue = "id") String sortType,@RequestParam(defaultValue = "0") int sortd){
        Map<String,Object> map = new HashMap<>();

        map.put("files", settingFieldFileService.getPagedFile(fieldId,p,searchContent,sortd,sortType));
        map.put("count", settingFieldFileService.getFileCount(fieldId,searchContent));
        return map;
    }

}
