package userController;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import UserControllerUtilities.DataDrivenUtility;

public class DataProviderClass {
	
	@DataProvider(name="PostData",indices= {0})
	public String[][] getData() throws IOException {
		
		String path="C:\\Users\\qapiapi04\\eclipse-workspace\\AssessmentFinal\\excelfile (1).xlsx";
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
	
	@DataProvider(name="UpdateData",indices= {1})
	public String[][] updateData() throws IOException {
		//String userData[][]= {{"userId","firstName","lastName","emailAddress"}};
		//return userData;
		
		String path="C:\\Users\\qapiapi04\\eclipse-workspace\\AssessmentFinal\\excelfile (1).xlsx";
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
	
	@DataProvider(name="postnewData",indices= {0})
	public String[][] postnewData() throws IOException {
		//String userData[][]= {{"userId","firstName","lastName","emailAddress"}};
		//return userData;
		
		String path="C:\\Users\\qapiapi04\\eclipse-workspace\\AssessmentFinal\\excelfilehil.xlsx";
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
