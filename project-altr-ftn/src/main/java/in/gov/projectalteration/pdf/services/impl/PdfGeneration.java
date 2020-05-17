package in.gov.projectalteration.pdf.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.RomanList;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;

import in.gov.projectalteration.common.Util;
import in.gov.projectalteration.common.services.impl.UserRestTemplateServices;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.model.ProjectDetailModel;
import in.gov.projectalteration.projectapp.dto.ProjectAppRegistrationModel;

@Service
public class PdfGeneration {

	private static final Logger logger = LogManager.getLogger(PdfGeneration.class);
	private static final String FILE_NAME = "src/main/resources/static/pdf/";

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
	private static Font smallNormal = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL);

	public static PdfPCell createPdfCell(Paragraph para, int i) {
		PdfPCell c0 = new PdfPCell(para);
		c0.setHorizontalAlignment(i);
		c0.setPaddingLeft(10);
		return c0;
	}

	public static PdfPCell createPdfCellByPhrase(Phrase ph, int i) {
		PdfPCell c0 = new PdfPCell(ph);
		c0.setHorizontalAlignment(i);
		c0.setPaddingLeft(10);

		return c0;
	}

	public static PdfPCell createCellByAlignBold(String str) {
		PdfPCell c0 = createPdfCellByPhrase(new Phrase(str, smallBold), 0);
		c0.setHorizontalAlignment(Element.ALIGN_CENTER);
		c0.setPaddingLeft(10);
		return c0;
	}

	public static PdfPCell createCellByAlignNormal(String str) {
		PdfPCell c0 = createPdfCellByPhrase(new Phrase(str, smallNormal), 0);
		c0.setHorizontalAlignment(Element.ALIGN_LEFT);
		c0.setPaddingLeft(10);
		return c0;
	}

	public static PdfPCell createCellByAlignRight(String str) {
		PdfPCell c0 = createPdfCellByPhrase(new Phrase(str, smallBold), 0);
		c0.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c0.setPaddingLeft(10);
		c0.setBorder(0);
		return c0;
	}

	/******************************************************************************************************************************
	 * generateWatermark
	 ******************************************************************************************************************************/
	// @Override
	public static PdfContentByte generateWatermark(PdfWriter writer, byte[] reraLogo) {
		logger.debug("generateWatermark start");
		PdfContentByte logoImage = null;
		try {
			PdfContentByte logo = writer.getDirectContentUnder();
			Image image = Image.getInstance(reraLogo);
			image.setAbsolutePosition(50f, 180f);
			image.scaleAbsolute(505, 480);
			logo.saveState();
			PdfGState state = new PdfGState();
			state.setFillOpacity(0.1f);
			logo.setGState(state);
			logo.addImage(image);
			logo.restoreState();
			logoImage = logo;
		} catch (Exception ex) {
			logger.debug("error");
			logger.debug(ex);
			throw new ResourceAccessException("error in watermark generation");
		}
		logger.debug("createlogo start");
		return logoImage;
	}

	/******************************************************************************************************************************
	 * genrateLogo
	 ******************************************************************************************************************************/
	public static Image genrateLogo(byte[] logoImage) throws BadElementException, MalformedURLException, IOException {
		Image image = Image.getInstance(logoImage);
		image.setAbsolutePosition(42f, 722f);
		image.scaleAbsolute(75, 75);
		return image;
	}

	/******************************************************************************************************************************
	 * genrateBarCode
	 ******************************************************************************************************************************/
	public static Image genrateBarCode(ProjectAlterationModel p) throws BadElementException {
		String qrCodeText = p.getProjectAltRegistrationNo();
		if (Optional.ofNullable(qrCodeText).isPresent())
			qrCodeText = qrCodeText == "" ? p.getProjectName() : qrCodeText + ",\n" + p.getPromoterName();
		else {
			qrCodeText = qrCodeText == "" ? p.getPromoterName() : qrCodeText;
		}
		qrCodeText = qrCodeText + ",\n" + p.getProjectAltRegistrationNo() + ",\n" + p.getPromoterName() + ",\n"
				+ p.getProcessName();

		BarcodeQRCode barcodeQRCode = new BarcodeQRCode(qrCodeText, 1000, 1000, null);
		Image codeQrImage = barcodeQRCode.getImage();
		codeQrImage.scaleAbsolute(50, 50);
		codeQrImage.setAlignment(Image.ALIGN_LEFT);
		return codeQrImage;
	}

	/******************************************************************************************************************************
	 * genrateProjectAlterationCertificatePdf
	 ******************************************************************************************************************************/
	public static void genrateProjectAlterationCertificatePdf(ProjectAlterationModel p, byte[] logoImage,
			HttpServletResponse response, String url) {
		logger.debug("genrateProjectAlterationCertificatePdf :start");
		Document document = new Document();
		try {

			logger.debug("try :Start");
			OutputStream out = response.getOutputStream();
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment;filename=" + "project-Alt-certificate.pdf");

			Font normalFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
			Font normalFont2 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK);
			Font normalFont3 = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD, BaseColor.BLACK);
			Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.RED);
			Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 9f, Font.BOLD, BaseColor.BLACK);
			Font smallNormalFont = new Font(Font.FontFamily.TIMES_ROMAN, 9f, Font.NORMAL, BaseColor.BLACK);
			Font smallFontRed = new Font(Font.FontFamily.TIMES_ROMAN, 9f, Font.BOLD, BaseColor.RED);

			document.setPageSize(PageSize.A4);
			document.setMargins(40, 40, 40, 40);

			PdfWriter writer = PdfWriter.getInstance(document, out);
			document.open();

			PdfContentByte watermark = generateWatermark(writer, logoImage);
			watermark.setColorStroke(BaseColor.BLACK);
			document.add(genrateLogo(logoImage));

			PdfContentByte contentByte = writer.getDirectContent();
			Rectangle rectangleBorder = new Rectangle(36, 36, 559, 806);

			rectangleBorder.setBorder(Rectangle.BOX);
			contentByte.setColorStroke(BaseColor.RED);
			rectangleBorder.setBorderWidth(2);
			contentByte.rectangle(rectangleBorder);

			Rectangle rectangleLine = new Rectangle(40, 720, 558, 720);
			rectangleLine.setBorder(Rectangle.ALIGN_BASELINE);
			contentByte.setColorStroke(BaseColor.BLACK);
			rectangleLine.setBorderWidth(1);
			contentByte.rectangle(rectangleLine);

			Paragraph emptyPra = new Paragraph();

			StringBuilder shearder = new StringBuilder();
			shearder.append("\n");
			shearder.append("Gujarat Real Estate Regulatory Authority (RERA)");
			shearder.append("\n");
			shearder.append("Government of Gujarat");
			shearder.append("\n");
			shearder.append("Website: gujrera.gujarat.gov.in, Email: inforera@gujarat.gov.in");
			Paragraph hearder = new Paragraph(shearder.toString(), headerFont);
			hearder.setAlignment(Element.ALIGN_CENTER);
			document.add(hearder);
			document.add(emptyPra);

			Rectangle rectangleRegNo = new Rectangle(60, 632, 550, 610);// (L,,width,)
			rectangleRegNo.setBorder(Rectangle.BOX);
			contentByte.setColorStroke(BaseColor.BLACK);
			rectangleRegNo.setBorderWidth(1);
			contentByte.rectangle(rectangleRegNo);

			Paragraph bodyTitle = new Paragraph("\n FORM - C" + "\n REGISTRATION CERTIFICATE OF PROJECT", smallFontRed);
			bodyTitle.add("\n");
			bodyTitle.setAlignment(Element.ALIGN_CENTER);
			document.add(emptyPra);
			document.add(emptyPra);
			document.add(bodyTitle);
			Paragraph bodyT2 = new Paragraph(
					"[The Gujarat Real Estate (Regulation and Development) (General) Rules, 2017 See Rule 6(1) \"said rules\"]",
					smallFont);
			bodyT2.add("\n");
			bodyT2.setAlignment(Element.ALIGN_CENTER);
			bodyT2.add(emptyPra);
			document.add(bodyT2);

			Paragraph body1 = new Paragraph(
					"1. This registration is granted under Section: - 5 of the Act to the following Project under project registration number "
							+ "(altered):-",
					smallNormalFont);
			body1.setIndentationLeft(10f);
			body1.setSpacingAfter(10f);
			document.add(body1);
			document.add(emptyPra);

			Paragraph projectRegNo = new Paragraph(p.getProjectAltAckNo(), smallBold);
			projectRegNo.setIndentationLeft(30f);
			projectRegNo.setSpacingBefore(5f);
			projectRegNo.setSpacingAfter(10f);
			document.add(projectRegNo);

			Rectangle rectanglePrjNameNDAdd = new Rectangle(60, 421, 550, 600);// (L,bottom,R,top)
			rectanglePrjNameNDAdd.setBorder(Rectangle.BOX);
			contentByte.setColorStroke(BaseColor.BLACK);
			rectanglePrjNameNDAdd.setBorderWidth(1);
			contentByte.rectangle(rectanglePrjNameNDAdd);

			Paragraph projectDetails = new Paragraph("Project Name & Address :-", normalFont2);
			projectDetails.setSpacingBefore(20f);
			projectDetails.setIndentationLeft(30f);
			document.add(projectDetails);

			StringBuilder bodyProjectAdd = new StringBuilder();
			bodyProjectAdd.append(p.getProjectDetailModel().getProjectName() + "\r\n");
			bodyProjectAdd.append(p.getProjectDetailModel().getProjectAddress());
			bodyProjectAdd.append("\n\n");

			Paragraph projectDetails2 = new Paragraph(bodyProjectAdd.toString(), normalFont3);
			projectDetails2.setIndentationLeft(30f);
			document.add(projectDetails2);

			String moje = p.getProjectDetailModel().getMoje() != null ? p.getProjectDetailModel().getMoje() : "";
			String distict = p.getProjectDetailModel().getDistName() != null ? p.getProjectDetailModel().getDistName()
					: "";
			String survayNo = p.getProjectDetailModel().getCitySurveyNo() != null
					? p.getProjectDetailModel().getCitySurveyNo()
					: "";
			String blockNo = p.getProjectDetailModel().getBlockNo() != null ? p.getProjectDetailModel().getBlockNo()
					: "";
			Double carpetArea = 0.0;
			if (p.getProjectDetailModel().getTotCarpetAreaForProjectUnderReg() != null)
				carpetArea = p.getProjectDetailModel().getTotCarpetAreaForProjectUnderReg();

			String remark = " Remarks:TP/Revenue Village: " + "MOJE:-" + moje + "," + "TA & DIST:- " + distict + ", "
					+ "FP/Survey No:C.S.NO :" + survayNo + " \r\n" + "Building Block No :-" + blockNo + ", "
					+ "Total Area of Land Under Registration (Sq Mtr):" + carpetArea + ". "
					+ "**Affidavit has been submitted\r\n"
					+ "for providing drainage & sewerage disposal system as per CGDCR/NBC before BU permission by promoter.";

			Paragraph premark = new Paragraph(remark, smallNormal);
			premark.setIndentationLeft(30f);
			document.add(premark);

			Paragraph projectDetails3 = new Paragraph("\n" + "Promoter Name & Address :-", normalFont2);
			projectDetails3.setIndentationLeft(30f);
			document.add(projectDetails3);

			StringBuilder bodyProjectAdd2 = new StringBuilder();
			bodyProjectAdd2.append(p.getPromoterName());
			bodyProjectAdd2.append(p.getProjectDetailModel().getProjectAddress());

			Paragraph projectDetails4 = new Paragraph(bodyProjectAdd2.toString(), normalFont3);
			projectDetails4.setIndentationLeft(30f);
			projectDetails4.setSpacingAfter(30f);
			document.add(projectDetails4);
			document.add(emptyPra);

			Paragraph p2 = new Paragraph("2. This registration is granted subject to the following conditions, namely:-",
					smallNormalFont);
			p2.setIndentationLeft(10f);
			p2.setSpacingBefore(20f);
			document.add(p2);
			StringBuilder bodyC3 = new StringBuilder();
			String startDt = Util.covertCalenderToStringDate(p.getProjectDetailModel().getStartDate());
			String endDt = Util.covertCalenderToStringDate(p.getProjectDetailModel().getCompletionDate());
			List roman = new RomanList();
			// (i)
			roman.add(new ListItem(
					"The promoter shall enter into an agreement for sale with the allottees as provided in 'Annexure A'",
					smallNormalFont));
			roman.add(new ListItem(
					"The promoter shall execute and register a conveyance deed in favour of the allottee or the association of the allottees, as the case may be of the apartment or the common areas in accordance with the section - 17.",
					smallNormalFont));

			roman.add(new ListItem(
					" The promoter shall deposit seventy percent of the amounts realised by the promoter in a separate account to be maintained in a schedule bank to cover the cost of construction and the land cost to be used only for that purpose in accordance with the sub-clause (D) of clause (l) of sub-section (2) of section- 4",
					smallNormalFont));
			roman.add(new ListItem(
					"The registration shall be valid  for a period of 1 Years, 11 Months, 25 Days commencing" + " from "
							+ startDt + " and ending with  " + endDt
							+ " unless renewed by the Real Estate Regulatory Authority in accordance with section 6 read with rule 7 of the Act. ",
					smallNormalFont));
			roman.add(new ListItem(
					" The promoter shall comply with the provisions of the Act and the rules and regulations made thereunder.",
					smallNormalFont));

			roman.add(new ListItem(
					"The promoter shall not contravene the provisions of any other law for the time being in force in the area where the project is being developed.",
					smallNormalFont));

			roman.add(new ListItem(
					" All advertisements for this project must mention RERA registration number and GujRERA website www.gujrera.gujarat.gov.in. The font size for the same should not be less than that of the contact details of the project.",
					smallNormalFont));

			roman.setIndentationLeft(30f);
			document.add(roman);

			bodyC3.append("\n");

			Paragraph pr3 = new Paragraph(
					"3. If the above mentioned conditions are not fulfilled by the promoter, the regulatory authority may take necessary action against the promoter including revoking the registration granted herein, in accordance with the Act and the rules and regulations made thereunder.",
					smallNormalFont);
			pr3.setIndentationLeft(10f);
			pr3.setSpacingBefore(5f);
			pr3.setSpacingAfter(5f);
			document.add(pr3);

			System.out.println("Project app details :" + url);
			ProjectAppRegistrationModel prj = UserRestTemplateServices
					.getProjectAppDetails(new ProjectAppRegistrationModel(), url + p.getProjectRegId());

			String oldprojectRegNo = prj.getProjectAckNo();
			String p4 = "4. With this your previous registration number:" + oldprojectRegNo + "stands no longer valid";
			Paragraph pr4 = new Paragraph(p4, smallNormalFont);
			pr4.setIndentationLeft(10f);
			document.add(pr4);
			document.add(emptyPra);
			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");

			Paragraph barcode = new Paragraph("\n Date:" + s.format(new Date()) + "\n Place:", smallBold);
			document.add(barcode);

			document.add(genrateBarCode(p));

			document.close();
			writer.close();
			logger.debug("Certificate generated..");

		} catch (FileNotFoundException | DocumentException e) {
			logger.debug("error");
			logger.debug(e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.debug("error");
			logger.debug(e);
			e.printStackTrace();
		}
		logger.debug("genrateProjectAlterationCertificatePdf :End");
	}

	/******************************************************************************************************************************
	 * saveProjectAltCertificatePdf on path
	 ******************************************************************************************************************************/
	public static void saveProjectAltCertificatePdf(ProjectAlterationModel p, byte[] logoImage, String url) {
		logger.debug("genrateProjectAlterationCertificatePdf :start");
		Document document = new Document();
		try {
			logger.debug("try :Start");

			// OutputStream out = response.getOutputStream();
			// response.setContentType("application/pdf");
			// response.setHeader("Content-Disposition", "attachment;filename=" +
			// "project-Alt-certificate.pdf");
			// PdfWriter writer = PdfWriter.getInstance(document, out);

			Font normalFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
			Font normalFont2 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK);
			Font normalFont3 = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD, BaseColor.BLACK);
			Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.RED);
			Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 9f, Font.BOLD, BaseColor.BLACK);
			Font smallNormalFont = new Font(Font.FontFamily.TIMES_ROMAN, 9f, Font.NORMAL, BaseColor.BLACK);
			Font smallFontRed = new Font(Font.FontFamily.TIMES_ROMAN, 9f, Font.BOLD, BaseColor.RED);

			// PdfWriter writer = PdfWriter.getInstance(document, new
			// FileOutputStream(f.getAbsolutePath()));
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(FILE_NAME + "projectAltCertificate.pdf"));
			document.setPageSize(PageSize.A4);
			document.setMargins(40, 40, 40, 40);
			document.open();

			PdfContentByte watermark = generateWatermark(writer, logoImage);
			watermark.setColorStroke(BaseColor.BLACK);
			document.add(genrateLogo(logoImage));

			PdfContentByte contentByte = writer.getDirectContent();
			Rectangle rectangleBorder = new Rectangle(36, 36, 559, 806);

			rectangleBorder.setBorder(Rectangle.BOX);
			contentByte.setColorStroke(BaseColor.RED);
			rectangleBorder.setBorderWidth(2);
			contentByte.rectangle(rectangleBorder);

			Rectangle rectangleLine = new Rectangle(40, 720, 558, 720);
			rectangleLine.setBorder(Rectangle.ALIGN_BASELINE);
			contentByte.setColorStroke(BaseColor.BLACK);
			rectangleLine.setBorderWidth(1);
			contentByte.rectangle(rectangleLine);

			Paragraph emptyPra = new Paragraph();

			StringBuilder shearder = new StringBuilder();
			shearder.append("\n");
			shearder.append("Gujarat Real Estate Regulatory Authority (RERA)");
			shearder.append("\n");
			shearder.append("Government of Gujarat");
			shearder.append("\n");
			shearder.append("Website: gujrera.gujarat.gov.in, Email: inforera@gujarat.gov.in");
			Paragraph hearder = new Paragraph(shearder.toString(), headerFont);
			hearder.setAlignment(Element.ALIGN_CENTER);
			document.add(hearder);
			document.add(emptyPra);

			Rectangle rectangleRegNo = new Rectangle(60, 632, 550, 610);// (L,,width,)
			rectangleRegNo.setBorder(Rectangle.BOX);
			contentByte.setColorStroke(BaseColor.BLACK);
			rectangleRegNo.setBorderWidth(1);
			contentByte.rectangle(rectangleRegNo);

			Paragraph bodyTitle = new Paragraph("\n FORM - C" + "\n REGISTRATION CERTIFICATE OF PROJECT", smallFontRed);
			bodyTitle.add("\n");
			bodyTitle.setAlignment(Element.ALIGN_CENTER);
			document.add(emptyPra);
			document.add(emptyPra);
			document.add(bodyTitle);
			Paragraph bodyT2 = new Paragraph(
					"[The Gujarat Real Estate (Regulation and Development) (General) Rules, 2017 See Rule 6(1) \"said rules\"]",
					smallFont);
			bodyT2.add("\n");
			bodyT2.setAlignment(Element.ALIGN_CENTER);
			bodyT2.add(emptyPra);
			document.add(bodyT2);

			Paragraph body1 = new Paragraph(
					"1. This registration is granted under Section: - 5 of the Act to the following Project under project registration number "
							+ "(altered):-",
					smallNormalFont);
			body1.setIndentationLeft(10f);
			body1.setSpacingAfter(10f);
			document.add(body1);
			document.add(emptyPra);

			Paragraph projectRegNo = new Paragraph(p.getProjectAltAckNo(), smallBold);
			projectRegNo.setIndentationLeft(30f);
			projectRegNo.setSpacingBefore(5f);
			projectRegNo.setSpacingAfter(10f);
			document.add(projectRegNo);

			Rectangle rectanglePrjNameNDAdd = new Rectangle(60, 421, 550, 600);// (L,bottom,R,top)
			rectanglePrjNameNDAdd.setBorder(Rectangle.BOX);
			contentByte.setColorStroke(BaseColor.BLACK);
			rectanglePrjNameNDAdd.setBorderWidth(1);
			contentByte.rectangle(rectanglePrjNameNDAdd);

			Paragraph projectDetails = new Paragraph("Project Name & Address :-", normalFont2);
			projectDetails.setSpacingBefore(20f);
			projectDetails.setIndentationLeft(30f);
			document.add(projectDetails);

			StringBuilder bodyProjectAdd = new StringBuilder();
			bodyProjectAdd.append(p.getProjectDetailModel().getProjectName() + "\r\n");
			bodyProjectAdd.append(p.getProjectDetailModel().getProjectAddress());
			bodyProjectAdd.append("\n\n");

			Paragraph projectDetails2 = new Paragraph(bodyProjectAdd.toString(), normalFont3);
			projectDetails2.setIndentationLeft(30f);
			document.add(projectDetails2);

			String moje = p.getProjectDetailModel().getMoje() != null ? p.getProjectDetailModel().getMoje() : "";
			String distict = p.getProjectDetailModel().getDistName() != null ? p.getProjectDetailModel().getDistName()
					: "";
			String survayNo = p.getProjectDetailModel().getCitySurveyNo() != null
					? p.getProjectDetailModel().getCitySurveyNo()
					: "";
			String blockNo = p.getProjectDetailModel().getBlockNo() != null ? p.getProjectDetailModel().getBlockNo()
					: "";
			Double carpetArea = 0.0;
			if (p.getProjectDetailModel().getTotCarpetAreaForProjectUnderReg() != null)
				carpetArea = p.getProjectDetailModel().getTotCarpetAreaForProjectUnderReg();

			String remark = " Remarks:TP/Revenue Village: " + "MOJE:-" + moje + "," + "TA & DIST:- " + distict + ", "
					+ "FP/Survey No:C.S.NO :" + survayNo + " \r\n" + "Building Block No :-" + blockNo + ", "
					+ "Total Area of Land Under Registration (Sq Mtr):" + carpetArea + ". "
					+ "**Affidavit has been submitted\r\n"
					+ "for providing drainage & sewerage disposal system as per CGDCR/NBC before BU permission by promoter.";

			Paragraph premark = new Paragraph(remark, smallNormal);
			premark.setIndentationLeft(30f);
			document.add(premark);

			Paragraph projectDetails3 = new Paragraph("\n" + "Promoter Name & Address :-", normalFont2);
			projectDetails3.setIndentationLeft(30f);
			document.add(projectDetails3);

			StringBuilder bodyProjectAdd2 = new StringBuilder();
			bodyProjectAdd2.append(p.getPromoterName());
			bodyProjectAdd2.append(p.getProjectDetailModel().getProjectAddress());

			Paragraph projectDetails4 = new Paragraph(bodyProjectAdd2.toString(), normalFont3);
			projectDetails4.setIndentationLeft(30f);
			projectDetails4.setSpacingAfter(30f);
			document.add(projectDetails4);
			document.add(emptyPra);

			Paragraph p2 = new Paragraph("2. This registration is granted subject to the following conditions, namely:-",
					smallNormalFont);
			p2.setIndentationLeft(10f);
			p2.setSpacingBefore(20f);
			document.add(p2);
			StringBuilder bodyC3 = new StringBuilder();
			String startDt = Util.covertCalenderToStringDate(p.getProjectDetailModel().getStartDate());
			String endDt = Util.covertCalenderToStringDate(p.getProjectDetailModel().getCompletionDate());
			List roman = new RomanList();
			// (i)
			roman.add(new ListItem(
					"The promoter shall enter into an agreement for sale with the allottees as provided in 'Annexure A'",
					smallNormalFont));
			roman.add(new ListItem(
					"The promoter shall execute and register a conveyance deed in favour of the allottee or the association of the allottees, as the case may be of the apartment or the common areas in accordance with the section - 17.",
					smallNormalFont));

			roman.add(new ListItem(
					" The promoter shall deposit seventy percent of the amounts realised by the promoter in a separate account to be maintained in a schedule bank to cover the cost of construction and the land cost to be used only for that purpose in accordance with the sub-clause (D) of clause (l) of sub-section (2) of section- 4",
					smallNormalFont));
			roman.add(new ListItem(
					"The registration shall be valid  for a period of 1 Years, 11 Months, 25 Days commencing" + " from "
							+ startDt + " and ending with  " + endDt
							+ " unless renewed by the Real Estate Regulatory Authority in accordance with section 6 read with rule 7 of the Act. ",
					smallNormalFont));
			roman.add(new ListItem(
					" The promoter shall comply with the provisions of the Act and the rules and regulations made thereunder.",
					smallNormalFont));

			roman.add(new ListItem(
					"The promoter shall not contravene the provisions of any other law for the time being in force in the area where the project is being developed.",
					smallNormalFont));

			roman.add(new ListItem(
					" All advertisements for this project must mention RERA registration number and GujRERA website www.gujrera.gujarat.gov.in. The font size for the same should not be less than that of the contact details of the project.",
					smallNormalFont));

			roman.setIndentationLeft(30f);
			document.add(roman);

			bodyC3.append("\n");

			Paragraph pr3 = new Paragraph(
					"3. If the above mentioned conditions are not fulfilled by the promoter, the regulatory authority may take necessary action against the promoter including revoking the registration granted herein, in accordance with the Act and the rules and regulations made thereunder.",
					smallNormalFont);
			pr3.setIndentationLeft(10f);
			pr3.setSpacingBefore(5f);
			pr3.setSpacingAfter(5f);
			document.add(pr3);

			System.out.println("Project app details :" + url);
			ProjectAppRegistrationModel prj = UserRestTemplateServices
					.getProjectAppDetails(new ProjectAppRegistrationModel(), url + p.getProjectRegId());

			String oldprojectRegNo = prj.getProjectAckNo();
			String p4 = "4. With this your previous registration number:" + oldprojectRegNo + "stands no longer valid";
			Paragraph pr4 = new Paragraph(p4, smallNormalFont);
			pr4.setIndentationLeft(10f);
			document.add(pr4);
			document.add(emptyPra);

			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
			Paragraph barcode = new Paragraph("\n Date:" + s.format(new Date()) + "\n Place:", smallBold);
			document.add(barcode);

			document.add(genrateBarCode(p));

			document.close();
			writer.close();
			logger.debug("Certificate generated..");

		} catch (FileNotFoundException | DocumentException e) {
			logger.debug("error");
			logger.debug(e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.debug("error");
			logger.debug(e);
			e.printStackTrace();
		}
		logger.debug("genrateProjectAlterationCertificatePdf :End");
	}

	/******************************************************************************************************************************
	 * fileCovertTobyteArray
	 ******************************************************************************************************************************/
	public static byte[] fileCovertTobyteArray(String path) throws IOException {
		File file = new File(path);
		byte[] bytesArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray); // read file into bytes[]
		fis.close();
		return bytesArray;
	}

	/******************************************************************************************************************************
	 * main method for testing
	 ******************************************************************************************************************************/
	public static void main(String[] args) {

		try {

			byte reraLogo[] = fileCovertTobyteArray(
					"E:/31-01-2020/rera-projectRegistration/rera-projectRegistration/src/main/resources/images/RERA_Certificate_Logo.jpg");
			ProjectAlterationModel p = new ProjectAlterationModel();
			ProjectDetailModel pd = new ProjectDetailModel();
			p.setProjectAltRegistrationNo("PR/GJ/ANAND/ANAND/Others/RAA06714/310120");
			p.setPromoterName(
					"Mr./Ms. Digvijaysinh Mahendrasinh Gohil Proprietor of Digvijay Construction son of Mr./Ms. Mahendrasinh Gohil");
			pd.setProjectName("AAditya Residenza");
			pd.setProjectAddress(
					"Near Polytechnical girls hostel, opp municipal garden, mota bazar, vv nagar, Anand, Anand, Gujarat");
			p.setProjectDetailModel(pd);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
