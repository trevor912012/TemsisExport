package com.cht.tl.csv;


import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CustomColumnPositionStrategy<T> extends ColumnPositionMappingStrategy<T> {
    @Override
    public String[] generateHeader(T bean) throws CsvRequiredFieldEmptyException {
    	String[] header = super.generateHeader(bean);
        super.generateHeader(bean);
        return super.getColumnMapping();
    }
}