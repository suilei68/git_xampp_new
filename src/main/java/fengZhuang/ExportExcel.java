package fengZhuang;

/**
 * Created by Administrator on 2016-11-14.
 *
 1、I/O流读取excel文件。
 2、创建工作簿workbook
 3、获取workbook中的sheet个数
 4、获取sheet中的row，
 5、获取row中的cell
 6、辨别cell中数据类型 
 7、解析出cell中数据
 8、接收cell的数据
 9、关闭I/O流
 */

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ExportExcel {
    /**
     * TODO getExcelData()
     * 
     * @author Administrator              
     * @dateTime 2016-11-15 10:37 
     * @param  
     * @return 
    */
    private String filePath="Excel/";
    private String fileName;
    private String sheetName;
    public ExportExcel(String fileName,String sheetName){
        this.fileName=fileName;
        this.sheetName=sheetName;
    }
    public Object[][] getExcelData() throws IOException {
        //POI去读取excle的数据
        //分为workbook，sheet，row，cell(根据你的row以及你需要拿数据的列)
        //创建文件I／O流
        FileInputStream fileIntputStream = null;
        try {
            fileIntputStream = new FileInputStream(filePath + fileName + ".xls");
        } catch (FileNotFoundException e) {
            System.out.println(System.getProperty("user.dir"));
            e.printStackTrace();
        }
        //创建工作薄
        //XSSF: 对应的是07以上的版本，或者说是后缀名为：.xlsx的文件
        //HSSF: 对应的是07一下的版本，或者说是后缀名为：.xls的文件
        Workbook workbook = new HSSFWorkbook(fileIntputStream);
        //获取具体操作的sheet
        Sheet sheet = workbook.getSheet(sheetName);
        //获取标题行
        Row tittlesRow = sheet.getRow(0);

        //获取sheet的行数
        int rowNum = sheet.getPhysicalNumberOfRows();
        //获取sheet的列数
        int colNum = tittlesRow.getPhysicalNumberOfCells();

        //定义HashMap的二维数组，多行1列的二维HashMap
        HashMap<String, String>[][] testdata = new HashMap[rowNum - 1][1];

        if (rowNum > 1) {
            for (int i = 0; i < rowNum - 1; i++) {
                //每一行的HashMap进行初始化，<String,String>
                testdata[i][0] = new HashMap<String, String>();
            }
        } else {
            System.out.println("excel中没有数据");
            return null;
        }


        Iterator<Cell> heads = tittlesRow.cellIterator();
        //列名数组，以及数组的长度
        String[] columnName = new String[(tittlesRow.getPhysicalNumberOfCells())];

        //通过迭代器的遍历，将列名的值存放入列名数组columnName
        int count = 0;
        while (heads.hasNext()) {
            Cell cell = heads.next();
            columnName[count] = cell.getStringCellValue().toString();
            count++;
        }

        //循环行数
        for (int i = 1; i < rowNum; i++) {
            //循环列数，依次将 <列名:value(第i行)>放入HashMap的二维数组
            for (int j = 0; j < colNum; j++) {
                String cellValue = sheet.getRow(i).getCell(j).toString();
                testdata[i - 1][0].put(columnName[j], cellValue);
            }
        }

        return testdata;
    }

    /**
     * 网上写的
     * 方法描述:  读取Excel 文件并进行解析
     * @param fileName  Excel 地址
     * @author
     */

//    public static void main(String[] args) {
//        Map<String,Object> map=readExcelCreateCategory("E://Xampp.xlsx");
//    }

    public static Map<String,Object> readExcelCreateCategory(String fileName){
        Map<String,Object> map=new HashMap<String, Object>();
        File file = new File(fileName);
        if(file!=null){
            try {
                InputStream input = new FileInputStream(file);  //建立输入流
                Workbook wb  = null;
                wb =new XSSFWorkbook(input);//后缀名为.xlsx文件，07以上版本
                //wb = new HSSFWorkbook(input);  // 后缀名为.xls文件，07以下版本
//	            System.out.println("表单数量："+wb.getNumberOfSheets());
                if(wb.getNumberOfSheets()>0){ //表单数 必须大于 0
//	            	System.out.println("表单名称"+wb.getSheetName(0));//获取第一个表单的 名称
                    Sheet sheet = wb.getSheetAt(0);     //获得第一个表单
                    Iterator<Row> rows = sheet.rowIterator(); //获得第一个表单的迭代器
                    while (rows.hasNext()) {
                        Row row = rows.next();  //获得行数据
//			            System.out.println("Row #" + row.getRowNum());  //获得行号从0开始
                        Iterator<Cell> cells = row.cellIterator();    //获得第一行的迭代器
                        while (cells.hasNext()) {
                            Cell cell = cells.next();
//			                System.out.print("Cell #" + cell.getColumnIndex()); //获取 列 数
                            Object obj=null;
                            switch (cell.getCellType()) {   //根据cell中的类型来输出数据
                                case HSSFCell.CELL_TYPE_NUMERIC:
                                    obj=cell.getNumericCellValue();
                                    break;
                                case HSSFCell.CELL_TYPE_STRING:
                                    obj=cell.getStringCellValue();
                                    break;
                                case HSSFCell.CELL_TYPE_BOOLEAN:
                                    obj=cell.getBooleanCellValue();
                                    break;
                                case HSSFCell.CELL_TYPE_FORMULA:
                                    obj=cell.getCellFormula();
                                    break;
                                default:
                                    obj="unsuported sell type";
                                    break;
                            }
                            System.out.println(obj.toString());
                        }
                    }
                }else{
                    map.put("status", "false");
                    map.put("info", "表单数不能为0！");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }
}
