package com.udv.mysite.controller

import com.udv.mysite.dao.DepartmentDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import java.io.File
import java.sql.Connection
import java.sql.PreparedStatement
import java.util.*

@Controller
class IndexController {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

        @GetMapping("/welcome")
    fun welcome(@RequestParam("id") id: Int?): String {
        println("id: $id")
        return "welcome"
    }

    @GetMapping("/mysqlTest")
    @ResponseBody
    fun mysqlTest(@RequestParam("id") id: Int?):String {
        var title:String = "Name,CardNo,Descriot,CtfTp,CtfId,Gender,Birthday,Address,Zip,Dirty,District1,District2,District3,District4,District5,District6,FirstNm,LastNm,Duty,Mobile,Tel,Fax,EMail,Nation,Taste,Education,Company,CTel,CAddress,CZip,Family,Version,id";
        var insertSqlColum = "insert into order_table_nokey_id_string ("+title+") values ("
        var insertSqlValue = ""
        var titleList = title.split(",")

        for(n in 1..titleList.size){
            if(n == titleList.size){
                insertSqlValue+="?"
            }else{
                insertSqlValue+="?,"
            }
        }
//        println("insertSqlValue: $insertSqlValue")
        insertSqlColum = insertSqlColum+ insertSqlValue +")";
//        println("insertSqlColum: $insertSqlColum")
        var count = 0;
//        val folder:File = File("D:\\download\\BaiduNetdiskDownload\\2000W(csv格式)\\2000W")
        val folder:File = File("/root/2000w")
        var resultFile = File(folder.path + "/result.txt")
        var connection: Connection? = jdbcTemplate.dataSource?.getConnection()
        var prepareStatement: PreparedStatement? = connection?.prepareStatement(insertSqlColum)

        var listCsv = folder.listFiles()
        for (csvFile in listCsv) {
            csvFile.forEachLine{line ->
                var lineTemp = line.trim().toString();
                try {
                    if(lineTemp.indexOf("Name,CardNo,Descriot") === -1){
                        count++;
                        var splitValue: List<String> = lineTemp.split(",")
                        splitValue.forEachIndexed(){index, value ->
                            val sqlIndex = index+1
                            if(index ===32){
                                if(value.equals("")){
                                    prepareStatement?.setNull(sqlIndex, java.sql.Types.NULL);
                                }else{
                                    prepareStatement?.setString(sqlIndex, UUID.randomUUID().toString().replace("-",""));
                                }
                            }else{
                                if(value.equals("")){
                                    prepareStatement?.setNull(sqlIndex, java.sql.Types.NULL);
                                }else{
                                    prepareStatement?.setString(sqlIndex,value);
                                }
                            }
                        }
                        var startTime = System.currentTimeMillis()
                        prepareStatement?.execute();
                        var endTime = System.currentTimeMillis()
                        var costTime = (endTime - startTime).toString()
                        println("row number: $count, costTime: $costTime");
                        resultFile.appendText("$count:$costTime\r\n");
                    }
                }catch (e:Exception){
                    println(e)
                    println("lineTemp: $lineTemp")
                }
            }
        }
        return  "";
    }

}