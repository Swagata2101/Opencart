package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	@DataProvider(name="Dataprovider")
	public String[][] getdata() throws IOException{
		String path=".\\testdata\\Dataprovider.xlsx";//taking xl file from testdata;
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for xlutilit
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String Dataprovider[][]=new String[totalrows][totalcols];//created for two dimension array which can store
		for(int i=1;i<=totalrows;i++) //1  //read thadata from xl storing in two dimensional array
		{
			for(int j=0;j<totalcols;j++)   //0 1 is rows j is col
			{
				Dataprovider[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
			
		}
		return Dataprovider;//returning two dimensional array
	}

}
