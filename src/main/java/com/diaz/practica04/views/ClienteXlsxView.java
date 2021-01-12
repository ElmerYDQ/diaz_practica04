package com.diaz.practica04.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.diaz.practica04.entidades.Cliente;
import com.diaz.practica04.services.IClienteServiceJpa;

@Component("listar.xlsx")
public class ClienteXlsxView extends AbstractXlsxView {
	
	@Autowired
	private IClienteServiceJpa serviceJpa;

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment; filename=\"cliente_view.xlsx\"");
		List<Cliente> clientes = serviceJpa.findAll();
		Sheet sheet = workbook.createSheet("Cliente Spring");
		
		MessageSourceAccessor mensajes =  getMessageSourceAccessor();
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(mensajes.getMessage("text.clientes"));
		
		CellStyle theaderStyle = workbook.createCellStyle();
		theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
		theaderStyle.setBorderTop(BorderStyle.MEDIUM);
		theaderStyle.setBorderRight(BorderStyle.MEDIUM);
		theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
		theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
		theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		CellStyle tbodyStyle = workbook.createCellStyle();
		tbodyStyle.setBorderBottom(BorderStyle.THIN);
		tbodyStyle.setBorderTop(BorderStyle.THIN);
		tbodyStyle.setBorderRight(BorderStyle.THIN);
		tbodyStyle.setBorderLeft(BorderStyle.THIN);
		
		Row header = sheet.createRow(2);
		header.createCell(0).setCellValue(mensajes.getMessage("text.cliente.form.id"));
		header.createCell(1).setCellValue(mensajes.getMessage("text.cliente.form.apellido"));
		header.createCell(2).setCellValue(mensajes.getMessage("text.cliente.form.nombre"));
		header.createCell(3).setCellValue(mensajes.getMessage("text.cliente.form.correo"));
		header.createCell(4).setCellValue(mensajes.getMessage("text.cliente.form.telefono"));
		
		header.getCell(0).setCellStyle(theaderStyle);
		header.getCell(1).setCellStyle(theaderStyle);
		header.getCell(2).setCellStyle(theaderStyle);
		header.getCell(3).setCellStyle(theaderStyle);
		header.getCell(4).setCellStyle(theaderStyle);
		
		int rownum = 3;
		
		for(Cliente cliente: clientes) {
			Row fila = sheet.createRow(rownum ++);
			cell = fila.createCell(0);
			cell.setCellValue(cliente.getId());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(1);
			cell.setCellValue(cliente.getApellido());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(2);
			cell.setCellValue(cliente.getNombre());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(3);
			cell.setCellValue(cliente.getCorreo());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(4);
			cell.setCellValue(cliente.getTelefono());
			cell.setCellStyle(tbodyStyle);
		}
	
	}

}
