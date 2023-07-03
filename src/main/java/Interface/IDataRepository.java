package Interface;

import java.util.ArrayList;

public interface IDataRepository <T>
{
	void insertData(T modelInsert);
	
	void updateData(T modelUpdate);
	
	void deleteData(T modelDelete);
	
	ArrayList<T> getAllData();
	
	T getData(T model);
	
}
