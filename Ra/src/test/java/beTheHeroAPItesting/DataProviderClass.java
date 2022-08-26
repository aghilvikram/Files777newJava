package beTheHeroAPItesting;

import java.io.IOException;

import org.testng.annotations.DataProvider;



public class DataProviderClass {
	
	@DataProvider(name="PostData",indices= {0})
	public String[][] postData() throws IOException {
		
		String path="C:\\Users\\QQA0431\\eclipse-workspace\\Ra\\TestData.xlsx";
		DataDrivenUtility utility=new DataDrivenUtility(path);
	
		int rowCount = utility.getRowCount("Sheet1");
		
		int columnCount = utility.getCellCount("Sheet1", 1);
		
		String userData[][]=new String[rowCount][columnCount];
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<columnCount; j++) {
				userData[i-1][j]=utility.getcellData("Sheet1", i, j);
			}
		}
		return userData;
	}
	
	@DataProvider(name="updateData",indices= {1})
	public String[][] updateData() throws IOException {
		
		
		String path="C:\\Users\\QQA0431\\eclipse-workspace\\Ra\\TestData.xlsx";
		DataDrivenUtility utility=new DataDrivenUtility(path);
		int rowCount = utility.getRowCount("Sheet1");
		int columnCount = utility.getCellCount("Sheet1", 1);
		
		String userData[][]=new String[rowCount][columnCount];
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<columnCount; j++) {
				userData[i-1][j]=utility.getcellData("Sheet1", i, j);
			}
		}
		return userData;
	}
	
	@DataProvider(name="postCaseData",indices= {0})
	public String[][] postRegCaseData() throws IOException {
		
		String path="C:\\Users\\QQA0431\\eclipse-workspace\\Ra\\RegisterNewCase.xlsx";
		DataDrivenUtility utility=new DataDrivenUtility(path);
	
		int rowCount = utility.getRowCount("Sheet1");
		
		int columnCount = utility.getCellCount("Sheet1", 1);
		
		String userData[][]=new String[rowCount][columnCount];
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<columnCount; j++) {
				userData[i-1][j]=utility.getcellData("Sheet1", i, j);
			}
		}
		return userData;
	}
	
	@DataProvider(name="updateCaseData",indices= {1})
	public String[][] updateRegCaseData() throws IOException {
		
		
		String path="C:\\Users\\QQA0431\\eclipse-workspace\\Ra\\RegisterNewCase.xlsx";
		DataDrivenUtility utility=new DataDrivenUtility(path);
		int rowCount = utility.getRowCount("Sheet1");
		int columnCount = utility.getCellCount("Sheet1", 1);
		
		String userData[][]=new String[rowCount][columnCount];
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<columnCount; j++) {
				userData[i-1][j]=utility.getcellData("Sheet1", i, j);
			}
		}
		return userData;
	}
	

}
