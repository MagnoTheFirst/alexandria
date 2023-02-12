package com.example.alexandria.services;

import java.io.*;
import java.sql.SQLOutput;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

public class DocumentEncryption {

    File file;

    public DocumentEncryption() throws IOException {

    }

    public DocumentEncryption(String absolutPath) throws IOException {
        this.file = new File(absolutPath);
    }

    public void testNewFilePath(){
        System.out.println(this.file.getAbsolutePath());
        System.out.println(this.file.getPath());
        System.out.println(this.file.getParent());
    }

    public void encryptDoc(String ownerPassword, String userPassword) throws IOException {
        PDDocument doc = PDDocument.load(this.file);
        AccessPermission ap = new AccessPermission();
        StandardProtectionPolicy stpp = new StandardProtectionPolicy(ownerPassword, userPassword , ap);
        stpp.setEncryptionKeyLength(256);
        stpp.setPermissions(ap);
        doc.protect(stpp);
        doc.save(this.file.getParent() + "/encrypted"+this.file.getName());         // save the document
        doc.close();                        // close the document
    }


    public void test() throws IOException {
        System.out.println(file.hashCode());
        PDDocument doc = PDDocument.load(file);

        AccessPermission ap = new AccessPermission();

        StandardProtectionPolicy stpp = new StandardProtectionPolicy("32132132a1dsfadsf321adsf32a1dsf3a2d1fa3sdf21as3sdf" , "65as1df65as1df6a5d1fa3s5dg1as3dg51a3sdg51a3sdg51asd" , ap);
        stpp.setEncryptionKeyLength(256);
        stpp.setPermissions(ap);
        doc.protect(stpp);
        doc.save("C:/Users/aleja/Downloads/outputEnc.pdf");         // save the document
        doc.close();                        // close the document
    }

    public void reduceSize() throws IOException, DocumentException {
        PdfReader reader = new PdfReader(new FileInputStream("C:/Users/aleja/Downloads/output.pdf"));
        PdfReader.unethicalreading = true;
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("C:/Users/aleja/Downloads/outputComp1.pdf"));
        //PdfWriter writer = stamper.wr
        reader.removeFields();
        reader.removeUnusedObjects();

        int total = reader.getNumberOfPages() + 1;
        for ( int i=1; i<total; i++) {
            reader.setPageContent(i + 1, reader.getPageContent(i + 1));
        }
        try {

            stamper.setFullCompression();
            stamper.close();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
