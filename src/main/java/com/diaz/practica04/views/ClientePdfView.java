package com.diaz.practica04.views;

import java.awt.Color;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.diaz.practica04.entidades.Cliente;
import com.diaz.practica04.services.IClienteServiceJpa;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("listar")
public class ClientePdfView extends AbstractPdfView {

	@Autowired
    private MessageSource messageSource;
	
	@Autowired
    private LocaleResolver localeResolver;
	
	@Autowired
	private IClienteServiceJpa serviceJpa;
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Cliente> clientes = serviceJpa.findAll();
		
		Locale locale = localeResolver.resolveLocale(request);
		
		MessageSourceAccessor mensajes =  getMessageSourceAccessor();
		
		PdfPTable tabla = new PdfPTable(1);
		tabla.setSpacingAfter(20);
		
		PdfPCell cell = null;
		
		cell = new PdfPCell(new Phrase(messageSource.getMessage("text.clientes", null, locale)));
		cell.setBackgroundColor(new Color(184, 218, 255));
		cell.setPadding(8f);
		tabla.addCell(cell);
		
		document.add(tabla);
		
		PdfPTable tabla3 = new PdfPTable(5);
		tabla3.setWidths(new float [] {0.2f, 1, 1, 1, 1});
		tabla3.addCell(mensajes.getMessage("text.cliente.form.id"));
		tabla3.addCell(mensajes.getMessage("text.cliente.form.apellido"));
		tabla3.addCell(mensajes.getMessage("text.cliente.form.nombre"));
		tabla3.addCell(mensajes.getMessage("text.cliente.form.correo"));
		tabla3.addCell(mensajes.getMessage("text.cliente.form.telefono"));
		
		for(Cliente cliente: clientes) {
			tabla3.addCell(cliente.getId().toString());
			tabla3.addCell(cliente.getApellido());
			tabla3.addCell(cliente.getNombre());
			tabla3.addCell(cliente.getCorreo());
			tabla3.addCell(cliente.getTelefono());
		}
	    
	    document.add(tabla3);
		
	}

}
