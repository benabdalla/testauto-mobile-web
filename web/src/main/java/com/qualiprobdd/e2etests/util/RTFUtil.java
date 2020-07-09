package com.qualiprobdd.e2etests.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

public class RTFUtil {
	public static String ReadRTFFile(String Filepath) throws FileNotFoundException, BadLocationException {
		String plainText = null;
		FileInputStream stream = new FileInputStream(Filepath);
		RTFEditorKit kit = new RTFEditorKit();
		Document doc = kit.createDefaultDocument();
		try {
			kit.read(stream, doc, 0);

			plainText = doc.getText(0, doc.getLength());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return plainText;
	}
}
